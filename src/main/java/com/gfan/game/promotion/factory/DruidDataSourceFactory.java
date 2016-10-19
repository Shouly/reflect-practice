/** 
 * File Name:DruidDataSourceFactory.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.factory 
 * Create Date:2016年10月13日下午6:42:47 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.factory;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import com.alibaba.druid.pool.DruidDataSource;

/** 
 * Description: mybatis整合 druid<br>
 * Create Date: 2016年10月13日 下午6:42:47
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class DruidDataSourceFactory extends UnpooledDataSourceFactory{

	public DruidDataSourceFactory(){
		this.dataSource = new DruidDataSource();
	}
}
