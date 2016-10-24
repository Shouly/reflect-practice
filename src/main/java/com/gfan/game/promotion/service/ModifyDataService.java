/** 
 * File Name:ModifyDataService.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.service 
 * Create Date:2016年10月19日上午10:59:41 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gfan.game.promotion.annotation.SingletonInit;
import com.gfan.game.promotion.dao.GameDataPoMapper;
import com.gfan.game.promotion.entity.po.GameDataPo;
import com.gfan.game.promotion.entity.vo.GameDataVO;
import com.gfan.game.promotion.utils.MathUtils;

/** 
 * Description: TODO<br>
 * Create Date: 2016年10月19日 上午10:59:41
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class ModifyDataService {

	private Logger logger = LoggerFactory.getLogger(ModifyDataService.class);
	
	@SingletonInit
	private SqlSessionFactory sessionFactory;
	
	public int insertOrUpdateBatch(){
		
		logger.info("Fetching game data...");
		
		long s = System.currentTimeMillis();
		
		//http get data
		List<Map<String, Object>> mapList = FetchDataService.fetchGameData();
		List<GameDataPo> poList = new ArrayList<>();
		
		//parse data
		for(Map<String, Object> map:mapList){
			GameDataVO vo = ReflectService.setFieldValueThatMatchKeyOfMap(map, GameDataVO.class);
			GameDataPo po = EntityService.gameDataVOToGameDataPo(vo);
			poList.add(po);
		}
		
		//db 
		SqlSession session = null;
		int i = 0;
		try {
			session = sessionFactory.openSession();
			GameDataPoMapper mapper = session.getMapper(GameDataPoMapper.class);
			i = mapper.insertOrUpdateBatch(poList);
			
			logger.info("DB updated suceess:"+i);
			
			session.commit();
			
		} catch (Exception e) {
			logger.error("DB insertOrUpdateBatch failed!",e);
		}finally{
			session.close();
		}
		
		long e = System.currentTimeMillis();
		
		if(logger.isDebugEnabled()){
			logger.debug("fetch game success. time costs[" + (e-s)/1000 + "s]");
		}
		
		return i;
	}
}
