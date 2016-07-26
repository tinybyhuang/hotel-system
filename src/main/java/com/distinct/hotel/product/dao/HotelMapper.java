package com.distinct.hotel.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.distinct.hotel.common.page.PageBounds;
import com.distinct.hotel.common.page.PageList;
import com.distinct.hotel.product.model.Hotel;
import com.distinct.hotel.product.model.HotelExample;
import com.distinct.hotel.product.vo.HotelPurposeVO;

public interface HotelMapper {
	int countByExample(HotelExample example);

	int deleteByExample(HotelExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Hotel record);

	int insertSelective(Hotel record);

	List<Hotel> selectByExampleWithBLOBs(HotelExample example);

	List<Hotel> selectByExample(HotelExample example);

	Hotel selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Hotel record, @Param("example") HotelExample example);

	int updateByExampleWithBLOBs(@Param("record") Hotel record, @Param("example") HotelExample example);

	int updateByExample(@Param("record") Hotel record, @Param("example") HotelExample example);

	int updateByPrimaryKeySelective(Hotel record);

	int updateByPrimaryKeyWithBLOBs(Hotel record);

	int updateByPrimaryKey(Hotel record);

	int updateByPrimaryKey1(Hotel record);

	List<Integer> getHotelIds();

	void deleteHotels(@Param("hotelIds") List<Integer> hotelIds);

	// 把t_hotel表数据拿出来
	List<Hotel> getAllHotel();

	// 获取数据总数目
	int getDataNumber();

	// limit取数据
	List<Hotel> getHotelByCurrentPage(@Param("currentPage") int currentPage, @Param("dataSize") int dataSize);

	PageList<Hotel> findAll(PageBounds pageBounds); // 读取所有

	List<String> selectByHotelName();

	PageList<Hotel> findPurpose(PageBounds pageBounds, HotelPurposeVO search);

	Hotel selectByProviderHotelId(@Param("hotelId") Integer hotelId);

	List<Hotel> selectByHotelId(@Param("hotelIdList") List<Integer> hotelIdList);

	List<Hotel> selectWithoutFilterHotelId(@Param("hotelIdList") List<Integer> hotelIdList);

	List<Hotel> filterByCityIdAndHotelId(@Param("hotelIdList") List<Integer> hotelIdList,@Param("cityIdList") List<Integer> cityIdList);

	PageList<Hotel> filterPageByCityIdAndHotelId(PageBounds pageBounds,@Param("hotelIdList") List<Integer> hotelIdList,@Param("cityIdList") List<Integer> cityIdList);

	PageList<Hotel> filterPageByCitylIdList(PageBounds pageBounds,@Param("cityIdList") List<Integer> cityIdList);

	PageList<Hotel> filterPageByHotelIdList(PageBounds pageBounds,@Param("hotelIdList") List<Integer> hotelIdList);

	PageList<Hotel> findInCityId(PageBounds pageBounds, Integer cityId);

	PageList<Hotel> filterPageByCityIdListAndHotelIdListWithCityId(PageBounds pageBounds,@Param("hotelIdList") List<Integer> hotelIdList,@Param("cityIdList") List<Integer> cityIdList,@Param("cityId") Integer cityId);

	PageList<Hotel> filterPageByHotelIdListWithCityId(PageBounds pageBounds,@Param("hotelIdList") List<Integer> hotelIdList,@Param("cityId") Integer cityId);

	PageList<Hotel> filterPageByCitylIdListWithCityId(PageBounds pageBounds,@Param("cityIdList") List<Integer> cityIdList,@Param("cityId") Integer cityId);

	List<Hotel> selectedByCityId(@Param("cityIdList") List<Integer> cityIdList);



}
