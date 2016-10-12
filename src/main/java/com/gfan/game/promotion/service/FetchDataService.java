/** 
 * File Name:FetchDataService.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.service 
 * Create Date:2016年10月9日上午10:58:01 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.gfan.game.promotion.common.Constants;
import com.gfan.game.promotion.utils.HttpUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/** 
 * Description: fetch data service impl<br>
 * Create Date: 2016年10月9日 上午10:58:01
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class FetchDataService {

	private static final Logger logger = LoggerFactory.getLogger(FetchDataService.class);
	
	/**
	 * fetch game data (http get) and parse json to List<Map<String, Object>>
	 * @return
	 * @version 1.0
	 */
	public static List<Map<String, Object>> fetchGameData(){
		//http get 
		String json = HttpUtils.get(Constants.URL_FETCH_GAME_DATA + Constants.FETCH_DATA_SIZE);
		
		//解析大约 4M 的json字符串 fastJson 比 gson 耗时要少的多
		List<Map<String, Object>> list = parseJsonStrByFastJson(json);
		
		return list;
	}
	
	/**
	 * gson 方式解析
	 * @param json
	 * @return
	 * @version 1.0
	 */
	@Deprecated
	private static List<Map<String, Object>> parseJsonStrByGson(String json){
		
		Gson gson = new Gson();
		Type typeOfAll = new TypeToken<Map<String, Object>>(){}.getType();
		Map<String, Object> map = gson.fromJson(json, typeOfAll);
		
		Double errCode = (Double)map.get("errCode");
		//errCode != 200
		if(!errCode.equals(new Double(200))){
			logger.info("Fetched data wrong errCode... [errCode="+errCode+"]");
			return null;
		}
		
		Object object = map.get("gameList");
		if(object == null){
			return null;
		}
		String gameListJosn = gson.toJson(object);
		
		Type typeOfGameList = new TypeToken<List<Map<String, Object>>>(){}.getType();
		List<Map<String, Object>> gameList = gson.fromJson(gameListJosn, typeOfGameList);
		return gameList;
	}
	
	/**
	 * fastJson 方式解析
	 * @param json
	 * @return
	 * @version 1.0
	 */
	private static List<Map<String, Object>> parseJsonStrByFastJson(String json){
		
		Map<String, Object> map = JSON.parseObject(json, new TypeReference<Map<String, Object>>(){});
		Object errCode = map.get("errCode");
		if(!errCode.equals(200)){
			logger.info("Fetched data wrong errCode... [errCode="+errCode+"]");
			return null;
		}
		
		Object object = map.get("gameList");
		if(object == null){
			return null;
		}
		return JSON.parseObject(JSON.toJSONString(object), new TypeReference<List<Map<String, Object>>>(){});
	}
	
}
