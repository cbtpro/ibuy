package com.ibuy.www.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ibuy.www.domain.IGoodImages;
import com.ibuy.www.domain.IGoods;
import com.ibuy.www.domain.IImages;
import com.ibuy.www.repository.GoodsRepository;
import com.ibuy.www.repository.ImagesRepository;
import com.ibuy.www.services.IGoodsServices;
import com.ibuy.www.services.IImagesServices;

@Service("imagesServices")
public class ImagesServicesImpl implements IImagesServices {

	@Autowired
	ImagesRepository imagesRepository;

	@Override
	public IImages save(IImages image) {
		return imagesRepository.save(image);
	}

	@Override
	public void delete(IImages image) {
		imagesRepository.delete(image);
	}

	@Override
	public void update(IImages image) {
		imagesRepository.update(image.getGoodImages(), image.getGoodImagesUUID());
	}

	@Override
	public IImages findByUuid(String uuid) {
		return imagesRepository.findOne(uuid);
	}

	@Override
	public IGoodImages save(IGoodImages goodImages) {
		return goodImages;
	}
	
}
