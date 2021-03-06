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
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gfan.game.promotion.annotation.AnnotationHandler;
import com.gfan.game.promotion.common.Constants;
import com.gfan.game.promotion.factory.BeanFactory;
import com.gfan.game.promotion.quertz.FetchDataJob;
import com.gfan.game.promotion.utils.StringUtils;

/** 
 * Description: WebApplication Listener<br>
 * Create Date: 2016年10月18日 下午2:23:35
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class WebApplicationListener implements ServletContextListener{

	private Logger logger = LoggerFactory.getLogger(WebApplicationListener.class);
	
	private Scheduler scheduler = null;
	
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
		 sce.getServletContext().log("Destroy Webapplication ...");
		//关闭quartz scheduler
		if(scheduler != null){
			try {
				scheduler.shutdown();
			} catch (SchedulerException e) {
				logger.error("Scheduler shutdown failed.",e);
			}
		}
	}

	/**
	 * 初始化webapplication
	 * 1.初始化mybatis SqlSessionFactory
	 * 2.初始化带有@SingletonInit注解的Service类的SqlSessionFactory属性
	 * 3.注册定时任务
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
		
		//3.注册定时任务
		servletContext.log("Registring quertz scheduler.");
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
		} catch (SchedulerException e) {
			servletContext.log("Registy quertz scheduler failed.");
		}
		JobDetail jobDetail = JobBuilder.newJob(FetchDataJob.class).withIdentity("fetchDataJob", "groupOne").build();
		CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(Constants.CRON_SCHEDULER);
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("triggerOne").withSchedule(cronScheduleBuilder).build();
		try {
			scheduler.scheduleJob(jobDetail, trigger);
		} catch (SchedulerException e) {
			logger.error("Scheduler scheduleJob failed.",e);
		}
		
	}
}
