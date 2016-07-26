package com.distinct.hotel.product.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.distinct.hotel.product.model.RoomPrice;
import com.distinct.hotel.product.model.RoomPriceExample;

public interface RoomPriceMapper {
	int countByExample(RoomPriceExample example);

	int deleteByExample(RoomPriceExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(RoomPrice record);

	int insertSelective(RoomPrice record);

	List<RoomPrice> selectByExample(RoomPriceExample example);

	RoomPrice selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") RoomPrice record, @Param("example") RoomPriceExample example);

	int updateByExample(@Param("record") RoomPrice record, @Param("example") RoomPriceExample example);

	int updateByPrimaryKeySelective(RoomPrice record);

	int updateByPrimaryKey(RoomPrice record);

	List<RoomPrice> findRoomPriceByDate();

	RoomPrice findRoomPriceBysaleDateNRoomId(@Param("saleDate") Date saleDate, @Param("roomId") int roomId);

	List<RoomPrice> findRoomPriceByRoomId(@Param("roomId") int roomId);

	// 两个日期查找
	List<RoomPrice> findRoomPriceByAnyDate(@Param("saleDate") Date saleDate, @Param("nextDate") Date nextDate,
			@Param("roomId") int roomId);

	// 2016-5-6
	// 根据providerId 以及房型id 查找两个日期内的数据
	List<RoomPrice> findRoomPriceBetweenTwoDateByProviderIdNRoomId(@Param("saleDate") Date saleDate,
			@Param("nextDate") Date nextDate, @Param("roomId") int roomId, @Param("providerId") int providerId);

	List<RoomPrice> findRoomPriceByDateAndRoomId(@Param("nextDate") Date nextDate, @Param("roomId") int roomId);

	RoomPrice findRoomPriceBysaleDateNRoomIdNProviderId(@Param("saleDate") Date saleDate, @Param("roomId") int roomId,
			@Param("providerId") int providerId);

}