/** 
 * File Name:BaseService.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.service 
 * Create Date:2016年10月18日下午8:35:05 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.service;

import org.apache.ibatis.session.SqlSessionFactory;

import com.gfan.game.promotion.annotation.SingletonInit;

/** 
 * Description: TODO<br>
 * Create Date: 2016年10月18日 下午8:35:05
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class BaseService {

	@SingletonInit
	protected SqlSessionFactory sqlSessionFactory;
	
}
