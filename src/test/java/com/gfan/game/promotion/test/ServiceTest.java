/** 
 * File Name:ServiceTest.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.test 
 * Create Date:2016年10月12日下午5:26:59 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.gfan.game.promotion.entity.vo.GameDataVO;
import com.gfan.game.promotion.service.FetchDataService;
import com.gfan.game.promotion.service.ReflectService;

/** 
 * Description: TODO<br>
 * Create Date: 2016年10月12日 下午5:26:59
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class ServiceTest {

	@Test
	public void test(){
		List<Map<String, Object>> list = FetchDataService.fetchGameData();
		for(Map<String, Object> l:list){
		}
	}
}
