/** 
 * File Name:GameDataDisplayVO.java
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
public class GameDataDisplayVO implements Serializable{

	private static final long serialVersionUID = 1758612228187147660L;
	
	private String displayName;//游戏名称
	private String className;//所属小类名称
	private String icon;//图标url
	private String gameApk;//游戏APK安装文件下载地址,根据不同渠道拼接
	private int appId;//小米平台id
	private double apkSize;//游戏APK安装文件大小，单位Mb
	
	
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
	 * @return the appId
	 */
	public int getAppId() {
		return appId;
	}
	/**
	 * @param appId the appId to set
	 */
	public void setAppId(int appId) {
		this.appId = appId;
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
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GameDataDisplayVO [displayName=" + displayName + ", className="
				+ className + ", appId=" + appId + ", icon=" + icon
				+ ", apkSize=" + apkSize + ", gameApk=" + gameApk + "]";
	}
	
}
