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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.gfan.game.promotion.common.Constants;
import com.gfan.game.promotion.entity.bo.ChannelLevelEnum;
import com.gfan.game.promotion.entity.bo.ResponseEnum;
import com.gfan.game.promotion.entity.po.ChannelPO;
import com.gfan.game.promotion.entity.vo.GameDataVO;
import com.gfan.game.promotion.entity.vo.PageBean;
import com.gfan.game.promotion.entity.vo.ResponseVO;
import com.gfan.game.promotion.factory.BeanFactory;
import com.gfan.game.promotion.service.ChannelService;
import com.gfan.game.promotion.service.QueryDataService;
import com.gfan.game.promotion.service.SearchService;
import com.gfan.game.promotion.utils.StringUtils;

/**
 * Description: show game data servlet<br>
 * Create Date: 2016年10月12日 下午3:20:59
 * 
 * @author liangbing
 * @version 1.0
 */
public class FetchDataServlet extends HttpServlet {

	private static final long serialVersionUID = 8933041492677262839L;

	private Logger logger = LoggerFactory.getLogger(FetchDataServlet.class);
	
	private QueryDataService queryDataService = (QueryDataService)BeanFactory.getInstance(QueryDataService.class);
	private SearchService searchService = (SearchService)BeanFactory.getInstance(SearchService.class);
	private ChannelService channelService = (ChannelService)BeanFactory.getInstance(ChannelService.class);
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(logger.isDebugEnabled()){
			logger.debug("FetchDataServlet doPost...");
		}
		//json格式输出
		resp.setContentType("application/json;charset=utf-8");
		OutputStream out = resp.getOutputStream();
		ResponseVO responseVO = new ResponseVO();
		Map<String, Object> objMap = new HashMap<String, Object>(16);
		
		//渠道
		String channelId = req.getParameter("channelId");
		//分页页码
		String pageNoStr = req.getParameter("pageNo");
		//搜索内容
		String searchContent = req.getParameter("searchContent");
		
		int pageNo = 1;
		if(!StringUtils.isBlank(pageNoStr)){
			pageNo = Integer.parseInt(pageNoStr);
		}
		
		//channel参数为空时，取一级渠道
		if(StringUtils.isBlank(channelId)){
			channelId = channelService.getChannelPOByChannelLevel(ChannelLevelEnum.CHANNEL_FIR_CLASS.getLevel()).getChannelId();
		}
		//channel参数不为空时，判断是否存在该渠道
		ChannelPO po = channelService.getChannelPOByChannelId(channelId);
		//请求的渠道不存在
		if(po == null){
			responseVO.setCode(ResponseEnum.CHANNEL_NOT_EXITS.getCode());
			responseVO.setDesc(ResponseEnum.CHANNEL_NOT_EXITS.getDesc());
			
			out.write(JSONObject.toJSONString(responseVO).getBytes("UTF-8"));
			out.flush();
			out.close();
			return;
		}
		
		//渠道存在，拼接渠道的下载参数
		//查询数据
		List<GameDataVO> voList = null;
		//数据总数
		int totalCount = 0; 
		//搜索 case
		if(!StringUtils.isBlank(searchContent)){
			//数据为搜索数据
			voList = searchService.search(searchContent,pageNo);
			totalCount = searchService.countBySearchContent(searchContent);
		}else {
			voList = queryDataService.queryGameDataByPaging(pageNo);
			totalCount = queryDataService.countAllData();
		}
		//拼接下载url为渠道的下载地址,
		if(voList != null && voList.size() > 0){
			for(GameDataVO vo:voList){
				vo.setGameApk(Constants.URL_DOWNLOAD_GAME_PREFIX + "app_id=" + vo.getGameId() + "&channel=" + channelId);
			}
		}
		
		//组装page vo分页信息
		PageBean pageVO = new PageBean();
		pageVO.setCurrentPageNo(pageNo);
		pageVO.setTotalCount(totalCount);
		pageVO.setPageNoCount(pageVO.initTotalPageNo());
		
		objMap.put("dataVo", voList);
		objMap.put("pageVo", pageVO);
		
		responseVO.setCode(ResponseEnum.SUCCESS.getCode());
		responseVO.setDesc(ResponseEnum.SUCCESS.getDesc());
		responseVO.setObj(objMap);
		
		String json = JSONObject.toJSONString(responseVO);
		
		//response out
		out.write(json.getBytes("UTF-8"));
		out.flush();
		out.close();
	}
	
}
