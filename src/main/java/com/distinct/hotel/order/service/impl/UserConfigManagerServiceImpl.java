package com.distinct.hotel.order.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.distinct.hotel.common.UserUtils;
import com.distinct.hotel.order.dao.UserConfigMapper;
import com.distinct.hotel.order.model.UserConfig;
import com.distinct.hotel.order.service.UserConfigManagerService;
import com.distinct.hotel.order.vo.MarketUserConfigVO;
import com.distinct.hotel.order.vo.ProviderUserConfigVO;

@Service
public class UserConfigManagerServiceImpl implements UserConfigManagerService {

	@Resource
	private UserConfigMapper userConfigMapper;

	@Override
	public void addUserConfigRecord(UserConfig userConfig) {
		userConfigMapper.insert(userConfig);
	}

	@Override
	public void deleteUserConfigRecord(UserConfig userConfig) {
		userConfigMapper.deleteByPrimaryKey(userConfig.getId());
	}

	@Override
	public void updateUserConfigRecord(UserConfig userConfig) {
		userConfigMapper.updateByPrimaryKey(userConfig);
	}

	@Override
	public List<UserConfig> findUserConfigRecordListByUserIdNConfigType(Integer configType) {
		return userConfigMapper.selectListByUserIdNConfigType(UserUtils.getCurrentUser().getId(), configType);
	}

	@Override
	public UserConfig findUserConfigRecordByUserIdNConfigTypeNConfigId(Integer configType, Integer configId) {
		return userConfigMapper.selectUserConfigByUserIdNConfigTypeNConfigId(UserUtils.getCurrentUser().getId(),
				configType, configId);
	}

	@Override
	public String addProviderUserConfigRecord(ProviderUserConfigVO providerUserConfigVO) {

		UserConfig userConfig = userConfigMapper.selectUserConfigByUserIdNConfigTypeNConfigId(
				UserUtils.getCurrentUser().getId(), providerUserConfigVO.getConfigType(),
				providerUserConfigVO.getProviderId());
		if (userConfig == null) {
			UserConfig newUserConfig = new UserConfig();
			newUserConfig.setConfigId(providerUserConfigVO.getProviderId());
			newUserConfig.setConfigType(providerUserConfigVO.getConfigType());
			newUserConfig.setCreated(new Date());
			newUserConfig.setModified(new Date());
			newUserConfig.setUserNo(providerUserConfigVO.getUserNo());
			newUserConfig.setUserPwd(providerUserConfigVO.getUserPwd());
			newUserConfig.setModUserId(UserUtils.getCurrentUser().getId());
			userConfigMapper.insert(newUserConfig);
			return "注册成功";
		} else {
			userConfig.setUserNo(providerUserConfigVO.getUserNo());
			userConfig.setUserPwd(providerUserConfigVO.getUserPwd());
			userConfig.setModified(new Date());
			userConfig.setModUserId(UserUtils.getCurrentUser().getId());
			userConfigMapper.updateByPrimaryKey(userConfig);
			return "修改成功";
		}
	}

	@Override
	public String addMarketUserConfigRecord(MarketUserConfigVO marketUserConfigVO) {
		UserConfig userConfig = userConfigMapper.selectUserConfigByUserIdNConfigTypeNConfigId(
				UserUtils.getCurrentUser().getId(), marketUserConfigVO.getConfigType(),
				marketUserConfigVO.getMarketId());
		if (userConfig == null) {
			UserConfig newUserConfig = new UserConfig();
			newUserConfig.setConfigId(marketUserConfigVO.getMarketId());
			newUserConfig.setConfigType(marketUserConfigVO.getConfigType());
			newUserConfig.setCreated(new Date());
			newUserConfig.setModified(new Date());
			newUserConfig.setUserNo(marketUserConfigVO.getUserNo());
			newUserConfig.setUserPwd(marketUserConfigVO.getUserPwd());
			newUserConfig.setModUserId(UserUtils.getCurrentUser().getId());
			userConfigMapper.insert(newUserConfig);
			return "注册成功";
		} else {
			userConfig.setUserNo(marketUserConfigVO.getUserNo());
			userConfig.setUserPwd(marketUserConfigVO.getUserPwd());
			userConfig.setModified(new Date());
			userConfig.setModUserId(UserUtils.getCurrentUser().getId());
			userConfigMapper.updateByPrimaryKey(userConfig);
			return "修改成功";
		}
	}

	@Override
	public List<Integer> findConfigProviderOrMarket(Integer configType) {
		List<UserConfig> userConfigList = userConfigMapper
				.selectListByUserIdNConfigType(UserUtils.getCurrentUser().getId(), configType);
		List<Integer> idList = new ArrayList<Integer>();
		if (userConfigList != null) {
			for (UserConfig userConfig : userConfigList) {
				Integer configId = userConfig.getConfigId();
				idList.add(configId);
			}
		}
		return idList;
	}

	@Override
	public void deleteUserConfigByUserIdNConfigTypeNConfigId(Integer configType, Integer configId) {
		UserConfig userConfig = userConfigMapper
				.selectUserConfigByUserIdNConfigTypeNConfigId(UserUtils.getCurrentUser().getId(), configType, configId);
		userConfigMapper.deleteByPrimaryKey(userConfig.getId());
	}

	@Override
	public void updateUserConfig(Integer configType, Integer configId, String userNo, String userPwd) {
		UserConfig userConfig = userConfigMapper
				.selectUserConfigByUserIdNConfigTypeNConfigId(UserUtils.getCurrentUser().getId(), configType, configId);
		if (userConfig != null) {
			userConfig.setUserNo(userNo);
			userConfig.setUserPwd(userPwd);
			userConfig.setModified(new Date());
			userConfig.setModUserId(UserUtils.getCurrentUser().getId());
			userConfigMapper.updateByPrimaryKey(userConfig);
		}
	}

}
