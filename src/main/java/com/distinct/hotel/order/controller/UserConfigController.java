package com.distinct.hotel.order.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.distinct.hotel.order.model.UserConfig;
import com.distinct.hotel.order.service.UserConfigManagerService;
import com.distinct.hotel.order.vo.MarketUserConfigVO;
import com.distinct.hotel.order.vo.ProviderUserConfigVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("userConfig")
public class UserConfigController {

	@Resource
	private UserConfigManagerService userConfigManagerService;

	@RequestMapping("/showProviderUserConfig")
	public String showProviderUserConfig(Model model) {
		// 供应商list configType为1代表供应商
		List<UserConfig> providerUserConfigList = userConfigManagerService
				.findUserConfigRecordListByUserIdNConfigType(1);
		// 如果有供应商有了配置，那在选择框内不需要在显示它
		List<Integer> configProviderIdList = userConfigManagerService.findConfigProviderOrMarket(1);
		model.addAttribute("providerUserConfigList", providerUserConfigList);
		model.addAttribute("configProviderIdList", configProviderIdList);
		return "order/view/provider-userConfig-page";
	}

	@RequestMapping("/showMarketUserConfig")
	public String showMarketUserConfig(Model model) {
		// 平台list configType为2代表平台
		List<UserConfig> marketUserConfigList = userConfigManagerService.findUserConfigRecordListByUserIdNConfigType(2);
		// 如果有平台有了配置，那在选择框内不需要在显示它
		List<Integer> configMarketIdList = userConfigManagerService.findConfigProviderOrMarket(2);
		model.addAttribute("marketUserConfigList", marketUserConfigList);
		model.addAttribute("configMarketIdList", configMarketIdList);
		return "order/view/market-userConfig-page";
	}

	@RequestMapping(value = "/addProviderUserConfig", method = RequestMethod.POST)
	public String addProviderUserConfig(Model model, ProviderUserConfigVO providerUserConfigVO) {
		userConfigManagerService.addProviderUserConfigRecord(providerUserConfigVO);
		// 供应商list 1
		List<UserConfig> providerUserConfigList = userConfigManagerService
				.findUserConfigRecordListByUserIdNConfigType(1);
		// 如果有供应商有了配置，那在选择框内不需要在显示它
		List<Integer> configProviderIdList = userConfigManagerService.findConfigProviderOrMarket(1);
		model.addAttribute("providerUserConfigList", providerUserConfigList);
		model.addAttribute("configProviderIdList", configProviderIdList);
		return "order/view/provider-userConfig-page";
	}

	@RequestMapping(value = "/addMarketUserConfig", method = RequestMethod.POST)
	public String addMarketUserConfig(Model model, MarketUserConfigVO marketUserConfigVO) {
		userConfigManagerService.addMarketUserConfigRecord(marketUserConfigVO);
		// 平台list configType为2代表平台
		List<UserConfig> marketUserConfigList = userConfigManagerService.findUserConfigRecordListByUserIdNConfigType(2);
		// 如果有平台有了配置，那在选择框内不需要在显示它
		List<Integer> configMarketIdList = userConfigManagerService.findConfigProviderOrMarket(2);
		model.addAttribute("marketUserConfigList", marketUserConfigList);
		model.addAttribute("configMarketIdList", configMarketIdList);
		return "order/view/market-userConfig-page";

	}

	@RequestMapping("/deleteProviderUserConfig")
	public String deleteProviderUserConfig(Model model, @RequestParam("providerId") int providerId) {
		userConfigManagerService.deleteUserConfigByUserIdNConfigTypeNConfigId(1, providerId);
		List<UserConfig> providerUserConfigList = userConfigManagerService
				.findUserConfigRecordListByUserIdNConfigType(1);
		// 如果有供应商有了配置，那在选择框内不需要在显示它
		List<Integer> configProviderIdList = userConfigManagerService.findConfigProviderOrMarket(1);
		model.addAttribute("providerUserConfigList", providerUserConfigList);
		model.addAttribute("configProviderIdList", configProviderIdList);
		return "order/view/provider-userConfig-page";

	}

	@RequestMapping("/deleteMarketUserConfig")
	public String deleteMarketUserConfig(Model model, @RequestParam("marketId") int marketId) {
		userConfigManagerService.deleteUserConfigByUserIdNConfigTypeNConfigId(2, marketId);
		// 平台list configType为2代表平台
		List<UserConfig> marketUserConfigList = userConfigManagerService.findUserConfigRecordListByUserIdNConfigType(2);
		// 如果有平台有了配置，那在选择框内不需要在显示它
		List<Integer> configMarketIdList = userConfigManagerService.findConfigProviderOrMarket(2);
		model.addAttribute("marketUserConfigList", marketUserConfigList);
		model.addAttribute("configMarketIdList", configMarketIdList);
		return "order/view/market-userConfig-page";

	}

	@RequestMapping(value = "/updateUserConfig", method = RequestMethod.POST)
	public String updateUserConfig(Model model, @RequestParam("configId") int configId,
			@RequestParam("configType") int configType, @RequestParam("userNo") String userNo,
			@RequestParam("userPwd") String userPwd) {

		// 供应商
		if (configType == 1) {
			userConfigManagerService.updateUserConfig(1, configId, userNo, userPwd);
			List<UserConfig> providerUserConfigList = userConfigManagerService
					.findUserConfigRecordListByUserIdNConfigType(1);
			// 如果有供应商有了配置，那在选择框内不需要在显示它
			List<Integer> configProviderIdList = userConfigManagerService.findConfigProviderOrMarket(1);
			model.addAttribute("providerUserConfigList", providerUserConfigList);
			model.addAttribute("configProviderIdList", configProviderIdList);
			return "order/view/provider-userConfig-page";
		}
		// 平台
		else if (configType == 2) {
			userConfigManagerService.updateUserConfig(2, configId, userNo, userPwd);
			// 平台list configType为2代表平台
			List<UserConfig> marketUserConfigList = userConfigManagerService
					.findUserConfigRecordListByUserIdNConfigType(2);
			// 如果有平台有了配置，那在选择框内不需要在显示它
			List<Integer> configMarketIdList = userConfigManagerService.findConfigProviderOrMarket(2);
			model.addAttribute("marketUserConfigList", marketUserConfigList);
			model.addAttribute("configMarketIdList", configMarketIdList);
			return "order/view/market-userConfig-page";
		} else
			return "order/view/provider-userConfig-page";
	}

	@RequestMapping(value = "/findUserConfig", method = RequestMethod.POST)
	@ResponseBody
	public String findUserConfig(Model model, @RequestParam("configId") int configId,
			@RequestParam("configType") int configType) {

		ObjectMapper objectMapper = new ObjectMapper();
		String userConfigJson = null;

		// 供应商
		if (configType == 1) {
			UserConfig userConfig = userConfigManagerService.findUserConfigRecordByUserIdNConfigTypeNConfigId(1,
					configId);
			try {
				userConfigJson = objectMapper.writeValueAsString(userConfig);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return userConfigJson;
		}
		// 平台
		else if (configType == 2) {
			UserConfig userConfig = userConfigManagerService.findUserConfigRecordByUserIdNConfigTypeNConfigId(2,
					configId);
			try {
				userConfigJson = objectMapper.writeValueAsString(userConfig);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return userConfigJson;
		}
		return userConfigJson;
	}

}
