/** 
 * File Name:DispatcherServlet.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.servlets 
 * Create Date:2016年10月13日上午11:04:36 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * Description: dispatcher servlet<br>
 * Create Date: 2016年10月13日 上午11:04:36
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class DispatcherServlet extends HttpServlet{

	private static final long serialVersionUID = 7846233812893836510L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/html/show.jsp").forward(req, resp);
		
	}
}
