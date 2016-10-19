/** 
 * File Name:ChannelLevelEnum.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.entity.bo 
 * Create Date:2016年10月19日下午4:48:43 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.entity.bo;

/** 
 * Description: TODO<br>
 * Create Date: 2016年10月19日 下午4:48:43
 * 
 * @author liangbing 
 * @version 1.0 
 */
public enum ChannelLevelEnum {

	CHANNEL_FIR(new Integer(1).byteValue(),"一级渠道"),
	CHANNEL_SEC(new Integer(2).byteValue(),"二级渠道");
	
	private ChannelLevelEnum(Byte level,String name){
		this.level = level;
		this.name = name;
	}
	
	private Byte level;
	private String name;
	
	/**
	 * @return the level
	 */
	public Byte getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(Byte level) {
		this.level = level;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
