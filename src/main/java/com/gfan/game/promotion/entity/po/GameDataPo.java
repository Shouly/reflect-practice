package com.gfan.game.promotion.entity.po;

import java.io.Serializable;
import java.util.Date;

public class GameDataPo implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column game_data_xiaomi.id
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column game_data_xiaomi.appId
	 * @mbggenerated
	 */
	private Integer appid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column game_data_xiaomi.game_name
	 * @mbggenerated
	 */
	private String gameName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column game_data_xiaomi.class_name
	 * @mbggenerated
	 */
	private String className;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column game_data_xiaomi.icon_url
	 * @mbggenerated
	 */
	private String iconUrl;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column game_data_xiaomi.apk_url
	 * @mbggenerated
	 */
	private String apkUrl;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column game_data_xiaomi.apkSize
	 * @mbggenerated
	 */
	private Float apksize;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column game_data_xiaomi.rating_score
	 * @mbggenerated
	 */
	private String ratingScore;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column game_data_xiaomi.update_time
	 * @mbggenerated
	 */
	private Date updateTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table game_data_xiaomi
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column game_data_xiaomi.id
	 * @return  the value of game_data_xiaomi.id
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column game_data_xiaomi.id
	 * @param id  the value for game_data_xiaomi.id
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column game_data_xiaomi.appId
	 * @return  the value of game_data_xiaomi.appId
	 * @mbggenerated
	 */
	public Integer getAppid() {
		return appid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column game_data_xiaomi.appId
	 * @param appid  the value for game_data_xiaomi.appId
	 * @mbggenerated
	 */
	public void setAppid(Integer appid) {
		this.appid = appid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column game_data_xiaomi.game_name
	 * @return  the value of game_data_xiaomi.game_name
	 * @mbggenerated
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column game_data_xiaomi.game_name
	 * @param gameName  the value for game_data_xiaomi.game_name
	 * @mbggenerated
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName == null ? null : gameName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column game_data_xiaomi.class_name
	 * @return  the value of game_data_xiaomi.class_name
	 * @mbggenerated
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column game_data_xiaomi.class_name
	 * @param className  the value for game_data_xiaomi.class_name
	 * @mbggenerated
	 */
	public void setClassName(String className) {
		this.className = className == null ? null : className.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column game_data_xiaomi.icon_url
	 * @return  the value of game_data_xiaomi.icon_url
	 * @mbggenerated
	 */
	public String getIconUrl() {
		return iconUrl;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column game_data_xiaomi.icon_url
	 * @param iconUrl  the value for game_data_xiaomi.icon_url
	 * @mbggenerated
	 */
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl == null ? null : iconUrl.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column game_data_xiaomi.apk_url
	 * @return  the value of game_data_xiaomi.apk_url
	 * @mbggenerated
	 */
	public String getApkUrl() {
		return apkUrl;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column game_data_xiaomi.apk_url
	 * @param apkUrl  the value for game_data_xiaomi.apk_url
	 * @mbggenerated
	 */
	public void setApkUrl(String apkUrl) {
		this.apkUrl = apkUrl == null ? null : apkUrl.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column game_data_xiaomi.apkSize
	 * @return  the value of game_data_xiaomi.apkSize
	 * @mbggenerated
	 */
	public Float getApksize() {
		return apksize;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column game_data_xiaomi.apkSize
	 * @param apksize  the value for game_data_xiaomi.apkSize
	 * @mbggenerated
	 */
	public void setApksize(Float apksize) {
		this.apksize = apksize;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column game_data_xiaomi.rating_score
	 * @return  the value of game_data_xiaomi.rating_score
	 * @mbggenerated
	 */
	public String getRatingScore() {
		return ratingScore;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column game_data_xiaomi.rating_score
	 * @param ratingScore  the value for game_data_xiaomi.rating_score
	 * @mbggenerated
	 */
	public void setRatingScore(String ratingScore) {
		this.ratingScore = ratingScore == null ? null : ratingScore.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column game_data_xiaomi.update_time
	 * @return  the value of game_data_xiaomi.update_time
	 * @mbggenerated
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column game_data_xiaomi.update_time
	 * @param updateTime  the value for game_data_xiaomi.update_time
	 * @mbggenerated
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}