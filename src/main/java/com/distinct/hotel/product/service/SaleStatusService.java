package com.distinct.hotel.product.service;

import java.util.List;

import com.distinct.hotel.product.model.SaleStatus;
import com.distinct.hotel.product.vo.SetSaleStatusVO;

public interface SaleStatusService {

	// 根据房型id查找销售状态表
	List<SaleStatus> findSaleStatusList(int providerRoomId);

	int addSaleStatus(SetSaleStatusVO setSaleStatusVO);

	// created 2016-5-6
	// 更新上下架数据
	void updateSaleStatusRecord(SetSaleStatusVO saleStatusVO);

	// 根据房型id设置该房型所有日期都是上/下架
	void setBatchSaleStatusByRoomId(int providerRoomId, String status);

	// 房型上下架，包含发布规则平台上下架
	void setSaleStatusConsiderPublishRule(SetSaleStatusVO saleStatusVO);

	void setSaleStatus(SetSaleStatusVO saleStatusVO);

	List<SaleStatus> findSaleStatusByMarketIdNroomIdNproviderId(int roomId,  int marketId, int providerId);
 
	List<SaleStatus> findSaleStatusByMarketIdNroomIdNproviderIdNToday(int roomId,  int marketId, int providerId);
}
