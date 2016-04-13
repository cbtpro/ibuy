package com.ibuy.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ibuy.www.domain.IGoodImages;
import com.ibuy.www.domain.IImages;

public interface GoodImageRepository extends JpaRepository<IGoodImages, String> {

}
