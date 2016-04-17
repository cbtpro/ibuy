package com.ibuy.www.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ibuy.www.domain.IGoods;
import com.ibuy.www.domain.IImages;

public interface IGoodsServices {
    void save(IGoods goods);
    void delete(IGoods goods);
    void update(IGoods goods);
    IGoods findById(String id);
    List<Object> findAllGoods();
    Iterable<IGoods> findAll();
    Iterable<IGoods> findAll(Pageable pageable);
    boolean saveGoods(IGoods goods, IImages images);
}
