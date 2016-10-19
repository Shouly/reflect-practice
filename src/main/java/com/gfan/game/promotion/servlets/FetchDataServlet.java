/** 
 * File Name:ShowGameDataServlet.java
 * Project Name:game-promotion-xiaomi-web  
 * Package Name:com.gfan.game.promotion.servlets 
 * Create Date:2016年10月12日下午3:20:59 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.servlets;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: show game data servlet<br>
 * Create Date: 2016年10月12日 下午3:20:59
 * 
 * @author liangbing
 * @version 1.0
 */
public class FetchDataServlet extends HttpServlet {

	private static final long serialVersionUID = 8933041492677262839L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//渠道
		String channel = req.getParameter("channel");
		if(channel == null || channel.equals("")){
			
		}
		
		//输出json 数据
		OutputStream out = resp.getOutputStream();
		out.write(new String("Hello World!").getBytes("UTF-8"));
		out.flush();
		out.close();
	}
}
