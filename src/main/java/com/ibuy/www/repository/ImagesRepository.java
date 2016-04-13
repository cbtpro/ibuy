package com.ibuy.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ibuy.www.domain.IImages;

public interface ImagesRepository extends JpaRepository<IImages, String> {

	//@Transactional
    @Modifying
    @Query("update IImages img set img.goodImages=?0  where img.goodImagesUUID=?1")
	void update(String goodImages, String imageuuid);

}
