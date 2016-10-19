/** 
 * File Name:PageVO.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.entity.vo 
 * Create Date:2016年10月19日下午3:23:26 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.entity.vo;

import java.io.Serializable;

/** 
 * Description: TODO<br>
 * Create Date: 2016年10月19日 下午3:23:26
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class PageVO implements Serializable{

	private static final long serialVersionUID = 5576223323873359266L;
	
	private int pageNo;
	private int totalSize;
	
	
	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}
	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	/**
	 * @return the totalSize
	 */
	public int getTotalSize() {
		return totalSize;
	}
	/**
	 * @param totalSize the totalSize to set
	 */
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	
	
}
