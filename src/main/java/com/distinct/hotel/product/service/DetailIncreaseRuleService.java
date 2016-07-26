package com.distinct.hotel.product.service;

import java.util.Date;


import com.distinct.hotel.common.page.PageBounds;
import com.distinct.hotel.common.page.PageResult;
import com.distinct.hotel.product.model.DetailIncreaseRule;
import com.distinct.hotel.product.vo.SetDetailIncreaseRuleVO;

public interface DetailIncreaseRuleService {

	// 改 根据id区域update 每次都修改
	void updateDetailIncreaseRule(SetDetailIncreaseRuleVO detailIncreaseRuleVO);

	// 增
	void addDetailIncreaseRule(SetDetailIncreaseRuleVO detailIncreaseRuleVO);

	// 查
	PageResult<DetailIncreaseRule> selectDetailIncreaseRule(PageBounds pageBounds);

	// 删
	void deleteDetailIncreaseRule();

	// 设置用哪一条
	void detailIncreaseRuleApplication(int theRuleId);

	DetailIncreaseRule findDetailIncreaseRuleByMarketIdNroomIdNsaleDateNproviderId(int roomId, Date saleDate, int marketId, int providerId);
}
