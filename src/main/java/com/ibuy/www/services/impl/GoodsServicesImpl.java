package com.ibuy.www.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ibuy.www.domain.IGoods;
import com.ibuy.www.repository.GoodsRepository;
import com.ibuy.www.services.IGoodsServices;

@Service("goodsServices")
public class GoodsServicesImpl implements IGoodsServices {

	@Autowired
	GoodsRepository goodsRepository;
	
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

}
