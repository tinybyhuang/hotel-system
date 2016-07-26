package com.distinct.hotel.product.dao;

import com.distinct.hotel.product.model.SaleStatus;
import com.distinct.hotel.product.model.SaleStatusExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleStatusMapper {
	int countByExample(SaleStatusExample example);

	int deleteByExample(SaleStatusExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(SaleStatus record);

	int insertSelective(SaleStatus record);

	List<SaleStatus> selectByExample(SaleStatusExample example);

	SaleStatus selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") SaleStatus record, @Param("example") SaleStatusExample example);

	int updateByExample(@Param("record") SaleStatus record, @Param("example") SaleStatusExample example);

	int updateByPrimaryKeySelective(SaleStatus record);

	int updateByPrimaryKey(SaleStatus record);

	// 某个房型id下的销售状态
	List<SaleStatus> findSaleStatusListByRoomId(@Param("roomId") int roomId);

	// 返回某个房型最新的一条的id
	Integer returnMaxId(@Param("roomId") int roomId, @Param("saleDate") Date saleDate);

	// 根据房型id找相应的详细加幅记录,id最大的一条记录
	SaleStatus findSaleStatusByid(@Param("maxId") int maxId);

	// 2016-5-6
	// 寻找当日有没有执行详细上下架设置
	SaleStatus findSaleStatusByroomIdNproviderIdNsaleDateNsaleRuleId(@Param("roomId") Integer roomId,
			@Param("saleRuleId") Integer saleRuleId, @Param("providerId") Integer providerId,
			@Param("saleDate") Date saleDate);

	List<SaleStatus> findSaleStatusListByroomIdNproviderIdNsaleRuleId(@Param("roomId") Integer roomId,
			@Param("saleRuleId") Integer saleRuleId, @Param("providerId") Integer providerId);
	
	List<SaleStatus> findSaleStatusByroomIdNproviderIdNsaleDateNsaleRuleIdNAfterToday(@Param("roomId") Integer roomId,
			@Param("saleRuleId") Integer saleRuleId, @Param("providerId") Integer providerId,
			@Param("saleDate") Date today);
}