package com.ibuy.www.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ibuy.www.domain.IGoods;
import com.ibuy.www.vo.GoodVO;

public interface GoodsRepository extends PagingAndSortingRepository<IGoods, String> {

	@Query(value="select g.gooduuid,g.good_name,i.good_images,g.good_price,g.good_desc from (igoods g left join igood_images gi on g.gooduuid = gi.gooduuid) left join iimages i on gi.good_imagesuuid = i.good_imagesuuid", nativeQuery = true)
	List<Object> findAllGoods();
}
