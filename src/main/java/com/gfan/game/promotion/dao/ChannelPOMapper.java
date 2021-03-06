package com.gfan.game.promotion.dao;

import com.gfan.game.promotion.entity.po.ChannelPO;
import com.gfan.game.promotion.entity.po.ChannelPOExample;
import java.util.List;

public interface ChannelPOMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table game_data_channel_xiaomi
	 * @mbggenerated
	 */
	int countByExample(ChannelPOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table game_data_channel_xiaomi
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table game_data_channel_xiaomi
	 * @mbggenerated
	 */
	int insert(ChannelPO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table game_data_channel_xiaomi
	 * @mbggenerated
	 */
	int insertSelective(ChannelPO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table game_data_channel_xiaomi
	 * @mbggenerated
	 */
	List<ChannelPO> selectByExample(ChannelPOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table game_data_channel_xiaomi
	 * @mbggenerated
	 */
	ChannelPO selectByPrimaryKey(Integer id);
	
	ChannelPO selectByChannelLevel(Byte channelLevel);
	
	ChannelPO selectByChannelId(String channelId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table game_data_channel_xiaomi
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(ChannelPO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table game_data_channel_xiaomi
	 * @mbggenerated
	 */
	int updateByPrimaryKey(ChannelPO record);
}