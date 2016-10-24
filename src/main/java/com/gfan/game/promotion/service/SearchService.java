/** 
 * File Name:SearchService.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.service 
 * Create Date:2016年10月24日上午10:42:24 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.gfan.game.promotion.annotation.SingletonInit;
import com.gfan.game.promotion.common.Constants;
import com.gfan.game.promotion.dao.GameDataPoMapper;
import com.gfan.game.promotion.entity.po.GameDataPo;
import com.gfan.game.promotion.entity.vo.GameDataVO;
import com.gfan.game.promotion.entity.vo.PageBean;

/** 
 * Description: TODO<br>
 * Create Date: 2016年10月24日 上午10:42:24
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class SearchService {
	
	@SingletonInit
	private SqlSessionFactory sqlSessionFactory;

	public List<GameDataVO> search(String searchContent,int pageNo){
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		GameDataPoMapper mapper = sqlSession.getMapper(GameDataPoMapper.class);
		List<GameDataPo> poList = mapper.selectBySearchContent(searchContent,PageBean.getOffsetAccordCurrentPage(pageNo), Constants.PAGE_SIZE);
		sqlSession.close();
		
		return EntityService.gameDataPoToGameDataVO(poList);
	}
	
	public int countBySearchContent(String searchContent){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		GameDataPoMapper mapper = sqlSession.getMapper(GameDataPoMapper.class);
		int count = mapper.countBySearchContent(searchContent);
		sqlSession.close();
		
		return count;
	}
}
