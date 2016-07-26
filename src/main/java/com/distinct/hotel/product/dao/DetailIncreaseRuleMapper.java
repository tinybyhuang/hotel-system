package com.distinct.hotel.product.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.distinct.hotel.common.page.PageBounds;
import com.distinct.hotel.common.page.PageList;
import com.distinct.hotel.product.model.DetailIncreaseRule;
import com.distinct.hotel.product.model.DetailIncreaseRuleExample;

public interface DetailIncreaseRuleMapper {
	int countByExample(DetailIncreaseRuleExample example);

	int deleteByExample(DetailIncreaseRuleExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(DetailIncreaseRule record);

	int insertSelective(DetailIncreaseRule record);

	List<DetailIncreaseRule> selectByExample(DetailIncreaseRuleExample example);

	DetailIncreaseRule selectByPrimaryKey(Integer id);

	List<String> selectBySaleRuleId(Integer saleRuleId);

	int updateByExampleSelective(@Param("record") DetailIncreaseRule record,
			@Param("example") DetailIncreaseRuleExample example);

	int updateByExample(@Param("record") DetailIncreaseRule record,
			@Param("example") DetailIncreaseRuleExample example);

	int updateByPrimaryKeySelective(DetailIncreaseRule record);

	int updateByPrimaryKey(DetailIncreaseRule record);

	PageList<DetailIncreaseRule> findAll(PageBounds pageBounds);

	// 返回某个房型最新的一条的id
	Integer returnMaxId(@Param("roomId") int roomId, @Param("saleDate") Date saleDate);

	// 根据房型id找相应的详细加幅记录,id最大的一条记录
	/*
	 * DetailIncreaseRule findDetailIncreaseRuleByroomId(@Param("maxId") int
	 * maxId, @Param("roomId") int roomId,
	 * 
	 * @Param("saleDate") Date saleDate);
	 */
	DetailIncreaseRule findDetailIncreaseRuleByid(@Param("maxId") int maxId);

	DetailIncreaseRule findDetailIncreaseRuleBySaleRuleIdNId(@Param("maxId") int maxId,
			@Param("saleRuleId") int saleRuleId);

	// 根据房型id,saleruleid,日期,供应商id找相应的详细加幅记录
	DetailIncreaseRule findDetailIncreaseRuleBySaleRuleIdNroomIdNsaleDateNproviderId(@Param("roomId") Integer roomId,
			@Param("saleDate") Date saleDate, @Param("saleRuleId") Integer saleRuleId,
			@Param("providerId") Integer providerId);
}