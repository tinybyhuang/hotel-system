package com.distinct.hotel.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.distinct.hotel.common.page.PageBounds;
import com.distinct.hotel.common.page.PageList;
import com.distinct.hotel.common.page.PageResult;
import com.distinct.hotel.product.dao.HotelMapper;
import com.distinct.hotel.product.model.Hotel;
import com.distinct.hotel.product.service.FilterHotelService;
import com.distinct.hotel.product.vo.FilterHotelVO;
import com.distinct.hotel.sale.service.FilterRuleService;

@Service
public class FilterHotelServiceImpl implements FilterHotelService {
	@Resource
	HotelMapper hotelMapper;
	@Resource
	FilterRuleService filterRuleService;

	@Override
	public List<Hotel> selectedByHotelId(List<Integer> hotelIdList) {

		return hotelMapper.selectByHotelId(hotelIdList);
	}

	@Override
	public List<Hotel> selectWithoutFilterHotelId(List<Integer> hotelIdList) {
		return hotelMapper.selectWithoutFilterHotelId(hotelIdList);
	}

	@Override
	public List<Hotel> filterByCityIdAndHotelId(List<Integer> hotelIdList, List<Integer> cityIdList) {
		return hotelMapper.filterByCityIdAndHotelId(hotelIdList, cityIdList);
	}

	@Override
	public PageResult<Hotel> filterPageByCityIdListAndHotelIdList(PageBounds pageBounds, List<Integer> hotelIdList,
			List<Integer> cityIdList) {
		PageList<Hotel> hotelList = hotelMapper.filterPageByCityIdAndHotelId(pageBounds, hotelIdList, cityIdList);
		
		return new PageResult<Hotel>(hotelList);
	}

	@Override
	public PageResult<Hotel> forIncreaseRuleHotel(PageBounds pageBounds) {
		PageList<Hotel> hotels = hotelMapper.findAll(pageBounds);
		hotels.getPaginator();
		return new PageResult<Hotel>(hotels);
	}

	@Override
	public PageResult<Hotel> filterPageByHotelIdList(PageBounds pageBounds, List<Integer> hotelIdList) {
		PageList<Hotel> hotelList = hotelMapper.filterPageByHotelIdList(pageBounds, hotelIdList);
		return  new PageResult<Hotel>(hotelList);
	}

	@Override
	public PageResult<Hotel> filterPageByCitylIdList(PageBounds pageBounds, List<Integer> cityIdList) {
		PageList<Hotel> hotelList = hotelMapper.filterPageByCitylIdList(pageBounds, cityIdList);
		return  new PageResult<Hotel>(hotelList);
	}

	@Override
	public PageResult<Hotel> findInCityId(PageBounds pageBounds, Integer cityId) {
		PageList<Hotel> hotelList = hotelMapper.findInCityId(pageBounds, cityId);
		return new PageResult<Hotel>(hotelList);
	}

	@Override
	public PageResult<Hotel> filterPageByCityIdListAndHotelIdListWithCityId(PageBounds pageBounds,List<Integer> hotelIdList, List<Integer> cityIdList, Integer cityId) {
PageList<Hotel> hotelList = hotelMapper.filterPageByCityIdListAndHotelIdListWithCityId(pageBounds, hotelIdList, cityIdList,cityId);
		
		return new PageResult<Hotel>(hotelList);

}

	@Override
	public PageResult<Hotel> filterPageByHotelIdListWithCityId(PageBounds pageBounds, List<Integer> hotelIdList,
			Integer cityId) {
PageList<Hotel> hotelList = hotelMapper.filterPageByHotelIdListWithCityId(pageBounds, hotelIdList,cityId);
		
		return new PageResult<Hotel>(hotelList);
	}

	@Override
	public PageResult<Hotel> filterPageByCitylIdListWithCityId(PageBounds pageBounds, List<Integer> cityIdList,
			Integer cityId) {
PageList<Hotel> hotelList = hotelMapper.filterPageByCitylIdListWithCityId(pageBounds, cityIdList,cityId);
		
		return new PageResult<Hotel>(hotelList);
	}

	@Override
	public PageResult<FilterHotelVO> filterFindAll(PageBounds pageBounds,List<Integer> hotelIdList) {
		PageList<Hotel> hotels = hotelMapper.findAll(pageBounds);
		PageList<FilterHotelVO> filter = new PageList<FilterHotelVO>();
		filter.setPage(hotels.getPaginator());
		for(Hotel hotel :hotels){
			FilterHotelVO filterHotelVO = new FilterHotelVO();
			filterHotelVO.setHotel(hotel);
			if(hotelIdList.size() != 0){
			if(hotelIdList.contains(hotel.getProviderHotelId())){
				filterHotelVO.setStatus("filt");
			}
			}
			filter.add(filterHotelVO);
		}
		return new PageResult<FilterHotelVO>(filter);
	}

	@Override
	public PageResult<FilterHotelVO> filterFindByCityId(PageBounds pageBounds, List<Integer> hotelIdList, Integer cityId) {
		PageList<Hotel> hotelList = hotelMapper.findInCityId(pageBounds, cityId);
		PageList<FilterHotelVO> filter = new PageList<FilterHotelVO>();
		filter.setPage(hotelList.getPaginator());
		for(Hotel hotel:hotelList){
			FilterHotelVO filt = new FilterHotelVO();
			filt.setHotel(hotel);
			if(hotelIdList.size() != 0){
			if(hotelIdList.contains(hotel.getProviderHotelId())){
				filt.setStatus("filt");
			}
			}
			filter.add(filt);
		}
		return new PageResult<FilterHotelVO>(filter);
	}

	@Override
	public List<Hotel> selectedByCityId(List<Integer> cityIdList) {
		return hotelMapper.selectedByCityId(cityIdList);
	}
	}
