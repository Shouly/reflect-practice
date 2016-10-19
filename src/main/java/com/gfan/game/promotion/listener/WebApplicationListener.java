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
import com.gfan.game.promotion.service.BaseService;

/** 
 * Description: TODO<br>
 * Create Date: 2016年10月18日 下午2:23:35
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class WebApplicationListener implements ServletContextListener{

	/* 
	 * 初始化mybatis的配置
	 * 
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		//构建 mybatis SqlSessionFactory
		servletContext.log("Initializing Mybatis SqlSessionFactory instance.");
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(Constants.MYBATIS_CONFIG_PATH);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		
		BaseService baseService = (BaseService)AnnotationHandler
				.singletonInitAnnotationProcessor(BaseService.class, BeanFactory.getInstance(BaseService.class), sqlSessionFactory);
		
		
		//servletContext 中存放 mybatis sqlSessionFactory
		//servletContext.setAttribute(Constants.MYBATIS_SQLSESSIONFACTORY_NAME_IN_SERVLET_CONTEXT, sqlSessionFactory);
		
		servletContext.log("Init Mybatis SqlSessionFactory instance success!");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		servletContext.log("Destoring Mybatis SqlSessionFactory instance.");
		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)servletContext
				.getAttribute(Constants.MYBATIS_SQLSESSIONFACTORY_NAME_IN_SERVLET_CONTEXT); 
		if(sqlSessionFactory != null){
			servletContext.removeAttribute(Constants.MYBATIS_SQLSESSIONFACTORY_NAME_IN_SERVLET_CONTEXT);
		}
		servletContext.log("Destoried Mybatis SqlSessionFactory instance.");
	}

}
