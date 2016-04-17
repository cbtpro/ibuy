package com.ibuy.www.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibuy.www.domain.IGoodImages;
import com.ibuy.www.domain.IGoods;
import com.ibuy.www.domain.IImages;
import com.ibuy.www.repository.GoodImageRepository;
import com.ibuy.www.repository.GoodsRepository;
import com.ibuy.www.repository.ImagesRepository;
import com.ibuy.www.services.IGoodsServices;

@Service("goodsServices")
public class GoodsServicesImpl implements IGoodsServices {

	@Autowired
	GoodsRepository goodsRepository;

//	@Autowired
//	ImagesServicesImpl imagesServicesImpl;
	
	@Autowired
	ImagesRepository imagesRepository;
	
	@Autowired
	GoodImageRepository goodImageRepository;
	
	@Override
	public void save(IGoods goods) {
		goodsRepository.save(goods);
	}

	@Override
	public void delete(IGoods goods) {
		goodsRepository.delete(goods);
	}

	@Override
	public void update(IGoods goods) {
		goodsRepository.save(goods);
	}

	@Override
	public IGoods findById(String id) {
		return goodsRepository.findOne(id);
	}

	@Override
	public Iterable<IGoods> findAll() {
		return goodsRepository.findAll();
	}

	@Override
	public Iterable<IGoods> findAll(Pageable pageable) {
		return goodsRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public boolean saveGoods(IGoods goods, IImages images) {
        IImages newImage = imagesRepository.save(images);
        IGoods newGood = goodsRepository.save(goods);
        IGoodImages goodImage = new IGoodImages();
        goodImage.setGoodUUID(newGood.getGoodUUID());
        goodImage.setGoodImagesUUID(newImage.getGoodImagesUUID());
        IGoodImages newGoodImage = goodImageRepository.save(goodImage);
		return newGoodImage==null?false:true;
	}

	@Override
	public List<Object> findAllGoods() {
		return goodsRepository.findAllGoods();
	}

}
