/** 
 * File Name:ReflectTest.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.test 
 * Create Date:2016年10月20日上午11:44:32 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.test;

import org.junit.Test;

import com.gfan.game.promotion.factory.BeanFactory;
import com.gfan.game.promotion.service.ModifyDataService;

/** 
 * Description: TODO<br>
 * Create Date: 2016年10月20日 上午11:44:32
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class ReflectTest {

	@Test
	public void test(){
		ModifyDataService dataService = (ModifyDataService)BeanFactory.getInstance(ModifyDataService.class);
		dataService.insertOrUpdateBatch();
	}
}
