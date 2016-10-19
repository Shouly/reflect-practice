/** 
 * File Name:AnnotationHandler.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.annotation 
 * Create Date:2016年10月18日下午8:40:49 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.annotation;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * Description: TODO<br>
 * Create Date: 2016年10月18日 下午8:40:49
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class AnnotationHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(AnnotationHandler.class);

	/**
	 * 给有SingletonInit注解的实例属性赋值(只满足有一个SingletonInit注解的属性)
	 * @param clazz 要赋值对象的class对象
	 * @param obj 要赋值的对象
	 * @param fieldValue 要赋的值
	 * @return
	 * @throws Exception
	 * @version 1.0
	 */
	public static <T> T singletonInitAnnotationProcessor(Class<?> clazz,T obj,T fieldValue){
		Field[] fields = clazz.getDeclaredFields();
		for(Field f:fields){
			SingletonInit annotation = f.getAnnotation(SingletonInit.class);
			if(annotation != null){
				f.setAccessible(true);
				try {
					f.set(obj, fieldValue);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					//do nothing...
					logger.error("Annotation processor error!",e);
				}
				break;
			}
		}
		return obj;
	}
}
