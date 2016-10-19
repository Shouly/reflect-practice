/** 
 * File Name:ResponseVO.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.entity.vo 
 * Create Date:2016年10月19日下午5:28:38 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.entity.vo;

/** 
 * Description: responose vo<br>
 * Create Date: 2016年10月19日 下午5:28:38
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class ResponseVO {

	private int code;
	private String desc;
	private Object obj;
	
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
	/**
	 * @return the obj
	 */
	public Object getObj() {
		return obj;
	}
	/**
	 * @param obj the obj to set
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
}
