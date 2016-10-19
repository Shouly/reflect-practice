/** 
 * File Name:QueryDataService.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.service 
 * Create Date:2016年10月18日下午5:31:48 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.service;

import org.apache.ibatis.session.SqlSession;

import com.gfan.game.promotion.entity.vo.GameDataDisplayVO;

/** 
 * Description: query data from db<br>
 * Create Date: 2016年10月18日 下午5:31:48
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class QueryDataService extends BaseService{
	
	public GameDataDisplayVO queryGameData(){
		System.out.println(sqlSessionFactory);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return null;
	}
}
