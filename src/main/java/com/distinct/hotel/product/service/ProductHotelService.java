package com.distinct.hotel.product.service;

import java.util.List;

import com.distinct.hotel.common.page.PageBounds;
import com.distinct.hotel.common.page.PageResult;
import com.distinct.hotel.product.model.Hotel;
import com.distinct.hotel.product.vo.HotelDetailVO;
import com.distinct.hotel.product.vo.HotelPriceVO;
import com.distinct.hotel.product.vo.HotelPurposeVO;
import com.distinct.hotel.product.vo.PriceNDateVO;
import com.distinct.hotel.product.vo.SetDetailIncreaseRuleVO;

public interface ProductHotelService {

	// 只寻找Hotel数据
	PageResult<Hotel> findAll(PageBounds pageBounds);

	// 只寻找HotelDetailVO
	PageResult<HotelDetailVO> findDetail(PageBounds pageBounds);

	HotelDetailVO findPrice(int providerHotelId);

	// 根据HotelPurposeVO需找HotelDetailVO
	PageResult<HotelDetailVO> findPurposeDetail(PageBounds pageBounds, HotelPurposeVO search);

	// 根据房型id找到出售时间以及当天价钱的列表，如果有加幅或者上下架设置会显示出来
	List<PriceNDateVO> findPriceAndSaleDate(int providerRoomId);

	// 2016-05-06
	// 根据房型id以及平台id找到出售时间以及当天价钱的列表，如果有加幅或者上下架设置会显示出来
	List<PriceNDateVO> findPriceDetailAndSaleStatus(Integer providerRoomId, Integer marketId, Integer providerId);

	// 传一个参数改价进来返回一个新的列表
	List<PriceNDateVO> setNewPrice(SetDetailIncreaseRuleVO setDetailIncreaseRuleVO);

	// 根据userId和平台id
	List<Integer> findSaleRuleByUserIdNMarketId();

	// 判断是否有详细加幅，在有的基础上修改
	void setDetailIncreaseRule(SetDetailIncreaseRuleVO detailIncreaseRuleVO);

	// 20160509
	// marketId、providerId、roomId、hotelId、cityId in hotelPriceVO
	List<PriceNDateVO> requirePriceDetailAndSaleStatus(HotelPriceVO hotelPriceVO);

}
