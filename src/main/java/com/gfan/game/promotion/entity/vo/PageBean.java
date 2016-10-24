/** 
 * File Name:PageVO.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.entity.vo 
 * Create Date:2016年10月19日下午3:23:26 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.entity.vo;

import java.io.Serializable;

import com.gfan.game.promotion.common.Constants;

/** 
 * Description: TODO<br>
 * Create Date: 2016年10月19日 下午3:23:26
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class PageBean implements Serializable{

	private static final long serialVersionUID = 5576223323873359266L;
	
	private int currentPageNo;//当前页码
	private int pageSize = Constants.PAGE_SIZE;//每页的大小
	private int pageNoCount;//总页码数
	private int totalCount;//数据总数
	
	//计算页码总数
	public int initTotalPageNo(){
		if(totalCount == 0){
			return 0;
		}
		if(totalCount < pageSize){
			return 1;
		}
		int count = totalCount / pageSize;
		if(totalCount % pageSize != 0){
			count = count + 1;
		}
		return count;
	}
	
	/**
	 * 根据页数获取limit startLine
	 * @param currentPage
	 * @return
	 * @version 1.0
	 */
	public static int getOffsetAccordCurrentPage(int pageNo){
		int offset = 0;
		if(pageNo > 1){
			offset = (pageNo-1) * Constants.PAGE_SIZE;
		}
		return offset;
	}
	
	/**
	 * @return the currentPageNo
	 */
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	/**
	 * @param currentPageNo the currentPageNo to set
	 */
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return the pageNoCount
	 */
	public int getPageNoCount() {
		return pageNoCount;
	}
	/**
	 * @param pageNoCount the pageNoCount to set
	 */
	public void setPageNoCount(int pageNoCount) {
		this.pageNoCount = pageNoCount;
	}
	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}
	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
}
