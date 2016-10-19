/** 
 * File Name:DBProcessorJob.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.quertz 
 * Create Date:2016年10月19日下午9:49:11 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.quertz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gfan.game.promotion.factory.BeanFactory;
import com.gfan.game.promotion.service.ModifyDataService;

/** 
 * Description: fetch game data job<br>
 * Create Date: 2016年10月19日 下午9:49:11
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class FetchDataJob implements Job{
	
	private Logger logger = LoggerFactory.getLogger(FetchDataJob.class);
	
	private ModifyDataService modifydataService = (ModifyDataService)BeanFactory.getInstance(ModifyDataService.class);
	
	/* 
	 * executor
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("Starting fetch data job...");
		modifydataService.insertOrUpdateBatch();
		logger.info("Fetch data job done.");
	}

}
