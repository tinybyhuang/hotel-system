package com.distinct.hotel.sale.service;

import java.util.List;

import com.distinct.hotel.common.page.PageBounds;
import com.distinct.hotel.common.page.PageResult;
import com.distinct.hotel.product.vo.HotelDetailVO;
import com.distinct.hotel.product.vo.HotelPurposeVO;
import com.distinct.hotel.sale.model.IncreaseRule;
import com.distinct.hotel.sale.model.SaleRule;
import com.distinct.hotel.sale.vo.CityNIncreaseRuleVO;
import com.distinct.hotel.sale.vo.SetIncreaseRuleVO;

public interface HotelNIncreaseService {

	// 20160510
	// 寻找HotelDetailVO和对应的IncreaseRule
	PageResult<HotelDetailVO> findHotelDetailNIncreaseRule(PageBounds pageBounds, int defaultProviderId,
			int saleRuleId);

	// 根据HotelPurposeVO寻找HotelDetailVO和对应的IncreaseRule
	PageResult<HotelDetailVO> findPurPoseHotelDetailNIncreaseRule(PageBounds pageBounds, HotelPurposeVO hotelPurposeVO);

	List<CityNIncreaseRuleVO> findIncreaseCity(int marketId, int providerId);

	// 返回成功失败字符串
	public String setIncreaseRule(SetIncreaseRuleVO SetIncreaseRuleVO);

	SaleRule findSaleRuleById(int id);

	IncreaseRule findIncreaseRuleByproviderIdNmarketIdNscopeTypeNscopeId(String scopeType, int scopeId, int marketId,
			int providerId);

	IncreaseRule findIncreaseRulePurpose(int cityId, int hotelId, int roomId, int providerId, int marketId);

	List<Integer> findIncreaseCityIdList(int marketId, int providerId);

	List<Integer> findNoIncreaseCityIdList(int marketId, int providerId);

	List<Integer> findAllCityId();
}
