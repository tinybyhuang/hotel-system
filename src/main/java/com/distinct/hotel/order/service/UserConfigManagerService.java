package com.distinct.hotel.order.service;

import java.util.List;

import com.distinct.hotel.order.model.UserConfig;
import com.distinct.hotel.order.vo.MarketUserConfigVO;
import com.distinct.hotel.order.vo.ProviderUserConfigVO;

public interface UserConfigManagerService {

	// 增
	public void addUserConfigRecord(UserConfig userConfig);

	// 删
	public void deleteUserConfigRecord(UserConfig userConfig);

	// 根据userId和配置类型（平台 或者供应商）查 集合
	List<UserConfig> findUserConfigRecordListByUserIdNConfigType(Integer configType);

	// 根据userId和配置类型（平台 或者供应商）和配置id查 唯一数据
	UserConfig findUserConfigRecordByUserIdNConfigTypeNConfigId(Integer configType, Integer configId);

	// 改
	public void updateUserConfigRecord(UserConfig userConfig);

	// 供应商增
	public String addProviderUserConfigRecord(ProviderUserConfigVO providerUserConfigVO);

	// 平台增
	public String addMarketUserConfigRecord(MarketUserConfigVO marketUserConfigVO);

	// 找出已经配置好的供应商或者平台
	List<Integer> findConfigProviderOrMarket(Integer configType);

	// 删
	public void deleteUserConfigByUserIdNConfigTypeNConfigId(Integer configType, Integer configId);

	// 改
	public void updateUserConfig(Integer configType, Integer configId, String userNo, String userPwd);

}
