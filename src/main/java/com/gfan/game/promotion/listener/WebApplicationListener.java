/** 
 * File Name:WebApplicationListener.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.listener 
 * Create Date:2016年10月18日下午2:23:35 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.listener;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gfan.game.promotion.annotation.AnnotationHandler;
import com.gfan.game.promotion.common.Constants;
import com.gfan.game.promotion.factory.BeanFactory;
import com.gfan.game.promotion.utils.StringUtils;

/** 
 * Description: TODO<br>
 * Create Date: 2016年10月18日 下午2:23:35
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class WebApplicationListener implements ServletContextListener{

	/* 
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		initWebApplication(sce);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	/**
	 * 初始化webapplication
	 * 1.初始化mybatis SqlSessionFactory
	 * 2.初始化带有\@SingletonInit注解的Service类的SqlSessionFactory属性
	 * 
	 */
	private void initWebApplication(ServletContextEvent sce){
		ServletContext servletContext = sce.getServletContext();
		
		//1.初始化 mybatis SqlSessionFactory
		servletContext.log("Initializing Mybatis SqlSessionFactory instance.");
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(Constants.MYBATIS_CONFIG_PATH);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		//2.初始化带有@SingletonInit注解Service类的属性
		String classNameArray = servletContext.getInitParameter("classNameContainsSingletonInitAnnotation");
		//处理字符串中的blank自符
		classNameArray = StringUtils.replaceBlank(classNameArray);
		
		String[] nameArray = classNameArray.split(",");
		
		for(String name:nameArray){
			servletContext.log("Initializing ["+name+"] field contains @SingletonInit.");
			//获取实例
			Object obj = BeanFactory.getInstance(name);
			Class<?> clazz = null;
			try {
				clazz = Class.forName(name);
			} catch (ClassNotFoundException e) {
				servletContext.log("Init ["+name+"] field contains @SingletonInit error, invalid className class not found.");
			}
			AnnotationHandler.singletonInitAnnotationProcessor(clazz, obj, sqlSessionFactory);
		}
		
	}
}
