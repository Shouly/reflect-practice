/** 
 * File Name:MathUtils.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.utils 
 * Create Date:2016年10月12日下午1:55:57 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.utils;

import java.math.BigDecimal;

/** 
 * Description: Math Utils<br>
 * Create Date: 2016年10月12日 下午1:55:57
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class MathUtils {

	/**
	 * double left 2 decimals
	 * @param source
	 * @return
	 * @version 1.0
	 */
	public static double left2Decimals(double source){
		return new BigDecimal(source).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static float left2Decimals2Float(double source){
		return new BigDecimal(source).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
	}
	
	public static double left2Decimals(float source){
		return new BigDecimal(source).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
