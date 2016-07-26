package com.distinct.hotel.product.service;

import java.util.List;

import com.distinct.hotel.common.page.PageBounds;
import com.distinct.hotel.common.page.PageResult;
import com.distinct.hotel.product.model.Hotel;
import com.distinct.hotel.product.vo.FilterHotelVO;

public interface FilterHotelService {
public List<Hotel> selectedByHotelId(List<Integer> hotelIdList);
public List<Hotel> selectedByCityId(List<Integer> cityIdList);
public List<Hotel> selectWithoutFilterHotelId(List<Integer> hotelIdList);
public List<Hotel> filterByCityIdAndHotelId(List<Integer> hotelIdList,List<Integer> cityIdList);
public PageResult<Hotel> filterPageByCityIdListAndHotelIdList(PageBounds pageBounds,List<Integer> hotelIdList,List<Integer> cityIdList);
public PageResult<Hotel> forIncreaseRuleHotel(PageBounds pageBounds);
public PageResult<Hotel> filterPageByHotelIdList(PageBounds pageBounds,List<Integer> hotelIdList);
public PageResult<Hotel> filterPageByCitylIdList(PageBounds pageBounds,List<Integer> cityIdList);
public PageResult<Hotel> findInCityId(PageBounds pageBounds,Integer cityId);
public PageResult<Hotel> filterPageByCityIdListAndHotelIdListWithCityId(PageBounds pageBounds, List<Integer> hotelIdList,
		List<Integer> cityIdList, Integer cityId);
public PageResult<Hotel> filterPageByHotelIdListWithCityId(PageBounds pageBounds, List<Integer> hotelIdList,
		Integer cityId);
public PageResult<Hotel> filterPageByCitylIdListWithCityId(PageBounds pageBounds, List<Integer> cityIdList, Integer cityId);
public PageResult<FilterHotelVO> filterFindAll(PageBounds pageBounds,List<Integer> hotelIdList);
public PageResult<FilterHotelVO> filterFindByCityId(PageBounds pageBounds,List<Integer> hotelIdList,Integer cityId);
}
