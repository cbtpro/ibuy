package com.ibuy.www.services;

import org.springframework.data.domain.Pageable;

import com.ibuy.www.domain.IGoods;

public interface IGoodsServices {
    void save(IGoods goods);
    void delete(IGoods goods);
    void update(IGoods goods);
    IGoods findById(String id);
    Iterable<IGoods> findAll();
    Iterable<IGoods> findAll(Pageable pageable);
}