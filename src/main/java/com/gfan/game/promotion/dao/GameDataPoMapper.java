package com.gfan.game.promotion.dao;

import java.util.List;

import com.gfan.game.promotion.entity.po.GameDataPo;

public interface GameDataPoMapper {
	
	int countById();
	
	int insertOrUpdateBatch(List<GameDataPo> list);
	
	List<GameDataPo> selectDataByPaging(int startLine,int pageSize);
}