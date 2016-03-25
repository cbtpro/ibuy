package com.ibuy.www.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ibuy.www.domain.IGoods;

public interface GoodsRepository extends PagingAndSortingRepository<IGoods, String> {

}
