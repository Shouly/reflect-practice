/** 
 * File Name:BeanFactory.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.factory 
 * Create Date:2016年10月18日下午9:16:26 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.factory;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description: BeanFactory 用于生产单例实例<br>
 * Create Date: 2016年10月18日 下午6:16:26
 * 
 * @author liangbing
 * @version 1.0
 */
public class BeanFactory {
	
	private static final Logger logger = LoggerFactory.getLogger(BeanFactory.class);

	private static final Map<String, Object> instantsMap = new HashMap<String, Object>(16);

	/**
	 * 获取给定class的单例实例
	 * @param clazz
	 * @return
	 * @version 1.0
	 */
	public static Object getInstance(Class<?> clazz){

		String className = clazz.getName();
		Object obj = null;

		synchronized (instantsMap) {
			obj = instantsMap.get(className);
			if (obj == null) {
				try {
					Constructor<?> constructor = clazz.getDeclaredConstructor();
					constructor.setAccessible(true);
					obj = constructor.newInstance();
					instantsMap.put(className, obj);
				} catch (Exception e) {
					//do nothing...
					logger.error("Constructor newInstance error!",e);
				}
			}
		}

		return obj;
	}
	
	/**
	 * 获取给定class name的单例实例
	 * @param className
	 * @return
	 * @version 1.0
	 */
	public static Object getInstance(String className){
		Object obj = null;
		try {
			obj = getInstance(Class.forName(className));
		} catch (ClassNotFoundException e) {
			//do nothing...
			logger.error("this param className invalid! class not found.",e);
		}
		return obj;
	}
}
