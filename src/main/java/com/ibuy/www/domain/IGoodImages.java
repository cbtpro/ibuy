package com.ibuy.www.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class IGoodImages {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String uuid;
    private String goodUUID;
    private String goodImagesUUID;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getGoodUUID() {
		return goodUUID;
	}
	public void setGoodUUID(String goodUUID) {
		this.goodUUID = goodUUID;
	}
	public String getGoodImagesUUID() {
		return goodImagesUUID;
	}
	public void setGoodImagesUUID(String goodImagesUUID) {
		this.goodImagesUUID = goodImagesUUID;
	}
}
