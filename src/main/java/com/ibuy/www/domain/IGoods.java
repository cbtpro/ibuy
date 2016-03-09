package com.ibuy.www.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;


@Entity
public class IGoods implements Persistable<String>{
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String goodUUID;
	private float goodPrice;
	private String goodName;
	private String goodDesc;
	public String getGoodUUID() {
		return goodUUID;
	}
	public void setGoodUUID(String goodUUID) {
		this.goodUUID = goodUUID;
	}
	public float getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(float goodPrice) {
		this.goodPrice = goodPrice;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public String getGoodDesc() {
		return goodDesc;
	}
	public void setGoodDesc(String goodDesc) {
		this.goodDesc = goodDesc;
	}
	@Override
	public String getId() {
		return goodUUID;
	}
	@Override
	public boolean isNew() {
		return this.goodUUID == null;
	}
	
}
