/** 
 * File Name:InitConfig.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.common 
 * Create Date:2016年10月8日下午6:02:17 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * Description: 常量<br>
 * Create Date: 2016年10月8日 下午6:02:17
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class Constants {
	
	private static final Logger logger = LoggerFactory.getLogger(Constants.class); 
	
	public static String URL_FETCH_GAME_DATA;
	public static String URL_DOWNLOAD_GAME_PREFIX;
	public static int FETCH_DATA_SIZE;
	
	//mybatis config
	public static final String MYBATIS_SQLSESSIONFACTORY_NAME_IN_SERVLET_CONTEXT = "sqlSessionFactory"; 
	public static final String MYBATIS_CONFIG_PATH = "mybatis/mybatis-config.xml";
	
	//load properties and init fields values
	static {
		
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
		
		Properties properties = new Properties();
		
		try {
			properties.load(in);
		} catch (IOException e) {
			logger.error("load config.properties failed ...",e);
		}
		
		Iterator<Object> iterator = properties.keySet().iterator();
		
		while(iterator.hasNext()){
			
			Object key = iterator.next();
			
			if(key.equals("SERVER_URL_XIAOMI_GAME")){
				URL_FETCH_GAME_DATA = properties.get(key).toString();
			}
			
			if(key.equals("DOWNLOAD_URL_PREFIX_XIAOMI_GAME")){
				URL_DOWNLOAD_GAME_PREFIX = properties.get(key).toString();
			}
			
			if(key.equals("PAGE_SIZE")){
				FETCH_DATA_SIZE = Integer.parseInt(properties.get(key).toString());
			}
		}
	}
	
}
