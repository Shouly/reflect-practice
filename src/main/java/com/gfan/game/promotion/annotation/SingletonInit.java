/** 
 * File Name:Init.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.annotation 
 * Create Date:2016年10月18日下午6:03:46 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * Description: 单例注解<br>
 * Create Date: 2016年10月18日 下午6:03:46
 * 
 * @author liangbing 
 * @version 1.0 
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SingletonInit {

//	boolean required() default true;
}
