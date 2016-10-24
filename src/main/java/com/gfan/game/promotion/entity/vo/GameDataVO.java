/** 
 * File Name:GameDataVO.java
 * Project Name:game-promotion-xiaomi  
 * Package Name:com.gfan.game.promotion.entity.vo 
 * Create Date:2016年10月9日上午11:45:09 
 * Copyright (c) 2016, Imopan.com All Rights Reserved. 
 */
package com.gfan.game.promotion.entity.vo;

import java.io.Serializable;

/** 
 * Description: TODO<br>
 * Create Date: 2016年10月9日 上午11:45:09
 * 
 * @author liangbing 
 * @version 1.0 
 */
public class GameDataVO implements Serializable{

	private static final long serialVersionUID = 1758612228187147660L;
	
	private String displayName;//游戏名称
	private String className;//所属小类名称
	private String icon;//图标url
	private String gameApk;//游戏APK安装文件下载地址,根据不同渠道拼接
	private int gameId;//游戏id
	private double apkSize;//游戏APK安装文件大小，单位Mb
	private String ratingScore;//游戏评分
	
	
	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * @return the gameApk
	 */
	public String getGameApk() {
		return gameApk;
	}
	/**
	 * @param gameApk the gameApk to set
	 */
	public void setGameApk(String gameApk) {
		this.gameApk = gameApk;
	}
	/**
	 * @return the gameId
	 */
	public int getGameId() {
		return gameId;
	}
	/**
	 * @param gameId the gameId to set
	 */
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	/**
	 * @return the apkSize
	 */
	public double getApkSize() {
		return apkSize;
	}
	/**
	 * @param apkSize the apkSize to set
	 */
	public void setApkSize(double apkSize) {
		this.apkSize = apkSize;
	}
	/**
	 * @return the ratingScore
	 */
	public String getRatingScore() {
		return ratingScore;
	}
	/**
	 * @param ratingScore the ratingScore to set
	 */
	public void setRatingScore(String ratingScore) {
		this.ratingScore = ratingScore;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GameDataVO [displayName=" + displayName + ", className="
				+ className + ", icon=" + icon + ", gameApk=" + gameApk
				+ ", gameId=" + gameId + ", apkSize=" + apkSize
				+ ", ratingScore=" + ratingScore + "]";
	}

}
