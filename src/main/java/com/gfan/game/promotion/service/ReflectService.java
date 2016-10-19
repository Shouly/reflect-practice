/** 
 * File Name:ReflectUtils.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.utils 
 * Create Date:2016年10月9日上午11:56:43 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gfan.game.promotion.entity.vo.GameDataDisplayVO;

/**
 * Description: reflect utils<br>
 * Create Date: 2016年10月9日 上午11:56:43
 * 
 * @author liangbing
 * @version 1.0
 */
public class ReflectService {

	private static final Logger logger = LoggerFactory.getLogger(ReflectService.class);
	
	//非boolean类型字段的setter 方法前缀 set
	private static final String SETTER_METHOD_NAME_PREFIX = "set";
	
	/**
	 * 从map中获取key为GameDataDisplayVO class的字段名的value
	 * 并且执行setter方法给GameDataDisplayVO实例的字段赋值
	 * 
	 * @param map
	 * @param clazz
	 * @param vo
	 * @return GameDataDisplayVO 实例
	 * @version 1.0
	 */
	public static GameDataDisplayVO setFieldValueThatMatchKeyOfMap(Map<String, Object> map,
			Class<GameDataDisplayVO> clazz) {
		
		GameDataDisplayVO vo = new GameDataDisplayVO();
		Method[] methods = clazz.getMethods();
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			String fieldName = field.getName();
			Object value = map.get(fieldName);
			for (Method method : methods) {
				String methodName = method.getName();
				//只比较set方法
				if(methodName.startsWith(SETTER_METHOD_NAME_PREFIX)){
					if (methodName.equals(getSetMethodNameByFieldName(fieldName))) {
						try {
							method.invoke(vo, value);
						} catch (Exception e) {
							logger.error("Reflect method execute invoke error!",e);
						}
						break;
					}
				}
			}
		}

		return vo;
	}

	/**
	 * 给定的字符串转为set开头并且首字母大写的字符串
	 * 	eg: age--->setAge
	 * @param fieldName
	 * @return
	 * @version 1.0
	 */
	private static String getSetMethodNameByFieldName(String fieldName) {
		char[] charArray = fieldName.toCharArray();
		char firstChar = charArray[0];
		char firstCharUpperCase = Character.toUpperCase(firstChar);
		charArray[0] = firstCharUpperCase;
		return SETTER_METHOD_NAME_PREFIX + new String(charArray);
	}

}
