/** 
 * File Name:ChannelService.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.service 
 * Create Date:2016年10月19日下午4:36:56 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.service;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.gfan.game.promotion.annotation.SingletonInit;
import com.gfan.game.promotion.dao.ChannelPOMapper;
import com.gfan.game.promotion.entity.po.ChannelPO;

/** 
 * Description: 渠道service<br>
 * Create Date: 2016年10月19日 下午4:36:56
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class ChannelService {

	@SingletonInit
	private SqlSessionFactory sqlSessionFactory;
	
	public ChannelPO getChannelPOByChannelLevel(Byte channelLevel){
		
		SqlSession session = sqlSessionFactory.openSession(ExecutorType.REUSE);
		ChannelPOMapper mapper = session.getMapper(ChannelPOMapper.class);
		ChannelPO po = mapper.selectByChannelLevel(channelLevel);
		
		session.close();
		return po;
	}
	
	public ChannelPO getChannelPOByChannelId(String channelId){
		SqlSession session = sqlSessionFactory.openSession(ExecutorType.REUSE);
		ChannelPOMapper mapper = session.getMapper(ChannelPOMapper.class);
		ChannelPO po = mapper.selectByChannelId(channelId);
		
		session.close();
		return po;
	}
}
