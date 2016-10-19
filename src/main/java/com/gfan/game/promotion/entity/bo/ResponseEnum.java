/** 
 * File Name:ResponseEnum.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.entity.bo 
 * Create Date:2016年10月19日下午5:24:38 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.entity.bo;

/** 
 * Description: TODO<br>
 * Create Date: 2016年10月19日 下午5:24:38
 * 
 * @author liangbing 
 * @version 1.0 
 */
public enum ResponseEnum {

	SUCCESS(2000,"success"),
	CHANNEL_NOT_EXITS(5000,"该渠道信息不存在！");
	
	private ResponseEnum(int code,String desc){
		
		this.code = code;
		this.desc = desc;
	}
	
	private int code;
	private String desc;
	
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
