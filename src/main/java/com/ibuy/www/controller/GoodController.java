package com.ibuy.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.ibuy.www.domain.GridTable;
import com.ibuy.www.domain.IGoods;
import com.ibuy.www.domain.IImages;
import com.ibuy.www.services.IGoodsServices;

@RestController
@RequestMapping(value = "/servlet", produces = { "application/json;charset=UTF-8" })
public class GoodController {
    
    @Autowired
    private IGoodsServices goodsServices;
    
//    @Autowired
//    private ImagesServicesImpl imagesServices;
    
    @RequestMapping(value = "goodsList")
    public String list(String _search, String nd, int rows,int page, String sidx, String sord) {
        Sort sort = new Sort("DESC".equalsIgnoreCase(sord)?Direction.DESC:Direction.ASC, sidx);
        Pageable pageable = new PageRequest(page-1<0?0:page-1, rows, sort);
        Page<IGoods> pages = (Page<IGoods>) goodsServices.findAll(pageable);
        List<IGoods> invheaders = pages.getContent();
        int size = pages.getSize();
        int totalPages = pages.getTotalPages();
        long totalRecords = pages.getTotalElements();
        Gson gson = new Gson();
        GridTable list = new GridTable();
        list.setRows(invheaders);
        list.setPage(page);
        list.setReords(totalRecords);
        list.setTotal(totalPages);
        return gson.toJson(list);
    }
    @RequestMapping(value = "editgood", method = RequestMethod.POST)
    public boolean editgood(String goodName, String imageSrc, String goodPrice, String goodDesc, String oper, String id) {
        IGoods good = new IGoods();
        good.setGoodName(goodName);
        float price = Float.parseFloat(goodPrice);
        good.setGoodPrice(price);
        good.setGoodDesc(goodDesc);
        IImages image = new IImages();
        image.setGoodImages(imageSrc);
        Boolean saveSuccess = goodsServices.saveGoods(good, image);
        Boolean ret = false;
        if(saveSuccess){
            ret = true;
        }
        return ret;
    }

}
