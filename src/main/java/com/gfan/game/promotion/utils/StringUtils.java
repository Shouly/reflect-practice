/** 
 * File Name:StringUtils.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.utils 
 * Create Date:2016年10月19日上午11:15:45 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * Description: String Utils<br>
 * Create Date: 2016年10月19日 上午11:15:45
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class StringUtils {

	/**
	 * 是否为空字符串
	 * @param source
	 * @return
	 * @version 1.0
	 */
	public static boolean isBlank(String source){
		if(source == null){
			return true;
		}
		if("".equals(source.trim())){
			return true;
		}
		return false;
	}
	
	/**
	 * 去除 空格 制表符 换行符 回车符
	 * @param source
	 * @return
	 * @version 1.0
	 */
	public static String replaceBlank(String source){
			String target = "";
	        if (source != null) {
	            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
	            Matcher m = p.matcher(source);
	            target = m.replaceAll("");
	        }
	        return target;
	}
}
