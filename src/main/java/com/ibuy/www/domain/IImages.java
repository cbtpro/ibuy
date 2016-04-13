package com.ibuy.www.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

@Entity
public class IImages implements Persistable<String>{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String goodImagesUUID;
	private String goodImages;
	public String getGoodImagesUUID() {
		return goodImagesUUID;
	}
	public void setGoodImagesUUID(String goodImagesUUID) {
		this.goodImagesUUID = goodImagesUUID;
	}
	public String getGoodImages() {
		return goodImages;
	}
	public void setGoodImages(String goodImages) {
		this.goodImages = goodImages;
	}
	@Override
	public String getId() {
		return goodImagesUUID;
	}
	@Override
	public boolean isNew() {
		return goodImagesUUID == null;
	}
}
