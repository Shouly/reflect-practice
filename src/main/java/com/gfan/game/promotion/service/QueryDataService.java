/** 
 * File Name:QueryDataService.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.service 
 * Create Date:2016年10月18日下午5:31:48 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gfan.game.promotion.annotation.SingletonInit;
import com.gfan.game.promotion.common.Constants;
import com.gfan.game.promotion.dao.GameDataPoMapper;
import com.gfan.game.promotion.entity.po.GameDataPo;
import com.gfan.game.promotion.entity.vo.GameDataVO;
import com.gfan.game.promotion.entity.vo.PageBean;
import com.gfan.game.promotion.utils.MathUtils;

/** 
 * Description: query data from db<br>
 * Create Date: 2016年10月18日 下午5:31:48
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class QueryDataService{
	
	private final Logger logger = LoggerFactory.getLogger(QueryDataService.class);
	
	@SingletonInit
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 分页查询gamedata
	 * @return
	 * @version 1.0
	 */
	public List<GameDataVO> queryGameDataByPaging(int pageNo){
		
		SqlSession session = sqlSessionFactory.openSession();
		GameDataPoMapper mapper = session.getMapper(GameDataPoMapper.class);
		
		List<GameDataPo> poList = mapper.selectDataByPaging(PageBean.getOffsetAccordCurrentPage(pageNo), Constants.PAGE_SIZE);
		
		session.close();
		return EntityService.gameDataPoToGameDataVO(poList);
	}
	
	/**
	 * count all data
	 * @return
	 * @version 1.0
	 */
	public int countAllData(){
		// ExecutorType.REUSE 代表这个执行器会复用预处理语句
		SqlSession session = sqlSessionFactory.openSession(ExecutorType.REUSE);
		GameDataPoMapper mapper = session.getMapper(GameDataPoMapper.class);
		int count = mapper.countById();
		
		session.close();
		return count;
	}
	
}
