/** 
 * File Name:InitServlet.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.servlets 
 * Create Date:2016年10月26日上午10:25:52 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gfan.game.promotion.factory.BeanFactory;
import com.gfan.game.promotion.service.ModifyDataService;

/** 
 * Description: TODO<br>
 * Create Date: 2016年10月26日 上午10:25:52
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class InitServlet extends HttpServlet{

	
	private static final long serialVersionUID = 6215323584896872856L;
	
	private Logger logger = LoggerFactory.getLogger(InitServlet.class);
	
	ModifyDataService modifyDataService = (ModifyDataService)BeanFactory.getInstance(ModifyDataService.class);
	
	/**
	 * 执行init方法
	 */
	public void init() throws ServletException {
		logger.info("InitServlet init()执行，初始化下载小米数据。");
		modifyDataService.insertOrUpdateBatch();
		logger.info("InitServlet init() 完成初始化！");
	}
}
