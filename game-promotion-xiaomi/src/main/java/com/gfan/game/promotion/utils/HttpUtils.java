/** 
 * File Name:HttpUtils.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.utils 
 * Create Date:2016年10月8日下午5:24:41 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * Description: Http Request Utils<br>
 * Create Date: 2016年10月8日 下午5:24:41
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class HttpUtils {

	private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);
	
	public final static String get(String urlStr){
		URL url;
		URLConnection connection;
		InputStream in = null;
		InputStreamReader inReader = null;
		BufferedReader reader = null;
		StringBuilder builder = new StringBuilder();
		try {
			url = new URL(urlStr);
			connection = url.openConnection();
			HttpURLConnection httpConnection = (HttpURLConnection)connection;
			
			if(httpConnection.getResponseCode() > 300){
				logger.error("Http response code > 300.");
				throw new RuntimeException("http request failed... [response code="+httpConnection.getResponseCode()+"]");
			}
			
			in = httpConnection.getInputStream();
			inReader = new InputStreamReader(in);
			reader = new BufferedReader(inReader);
			
			String temp = null;
			while((temp = reader.readLine()) != null){
				builder.append(temp);
			}
			
		} catch (MalformedURLException e) {
			logger.error("Http request url string invalid...",e);
		} catch (IOException e) {
			logger.error("Http server requested is not avaliable...",e);
		}finally{
			try {
				close(reader,inReader,in);
			} catch (Exception e) {
				logger.error("Closing io resources failed...",e);
			}
		}
		return builder.toString();
	}
	
	// close io resources
	private static void close(BufferedReader reader,InputStreamReader inReader,InputStream in)throws Exception{
		if(reader != null){
			reader.close();
		}
		if(inReader != null){
			inReader.close();
		}
		if(in != null){
			in.close();
		}
	}
}
