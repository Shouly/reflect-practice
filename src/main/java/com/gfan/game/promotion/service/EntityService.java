/** 
 * File Name:EntityService.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.service 
 * Create Date:2016年10月24日上午10:55:17 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gfan.game.promotion.entity.po.GameDataPo;
import com.gfan.game.promotion.entity.vo.GameDataVO;
import com.gfan.game.promotion.utils.MathUtils;

/** 
 * Description: TODO<br>
 * Create Date: 2016年10月24日 上午10:55:17
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class EntityService {

	/**
	 * GameDataPo to GameDataVO
	 * @param poList
	 * @return
	 * @version 1.0
	 */
	public static List<GameDataVO> gameDataPoToGameDataVO(List<GameDataPo> poList){
		List<GameDataVO> voList = new ArrayList<>();
		if(poList != null && poList.size() > 0){
			for(GameDataPo po:poList){
				
				GameDataVO vo = new GameDataVO();
				
				vo.setApkSize(MathUtils.left2Decimals(po.getApksize()));
				vo.setGameId(po.getAppid());
				vo.setClassName(po.getClassName());
				vo.setDisplayName(po.getGameName());
				vo.setGameApk(po.getApkUrl());
				vo.setIcon(po.getIconUrl());
				vo.setRatingScore(po.getRatingScore());
				
				voList.add(vo);
			}
		}
		return voList;
	}
	

	/**
	 * GameDataVO to GameDataPo
	 * @param vo
	 * @return
	 * @version 1.0
	 */
	public static GameDataPo gameDataVOToGameDataPo(GameDataVO vo){
		GameDataPo po = new GameDataPo();
		
		//apk size 单位byte转为M
		po.setApksize(MathUtils.left2Decimals2Float(vo.getApkSize()/1024/1024));
		
		po.setApkUrl(vo.getGameApk());
		po.setAppid(vo.getGameId());
		po.setClassName(vo.getClassName());
		po.setGameName(vo.getDisplayName());
		po.setIconUrl(vo.getIcon());
		po.setUpdateTime(new Date());
		po.setRatingScore(vo.getRatingScore());
		
		return po;
	}
}
