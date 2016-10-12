/** 
 * File Name:EncodingFilter.java
 * Project Name:game-promotion-xiaomi-web  
 * Package Name:com.gfan.game.promotion.filter 
 * Create Date:2016年10月12日下午3:06:38 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/** 
 * Description: encode filter<br>
 * Create Date: 2016年10月12日 下午3:06:38
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class EncodingFilter implements Filter{

	private static String ENCODER = "UTF-8";
	
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String encoder = filterConfig.getInitParameter("encoder");
		if(encoder != null){
			ENCODER = encoder;
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding(ENCODER);
		response.setCharacterEncoding(ENCODER);
		
		chain.doFilter(request, response);
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
