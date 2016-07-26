package com.distinct.hotel.log.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.distinct.hotel.common.UserUtils;
import com.distinct.hotel.log.dao.UserLogMapper;
import com.distinct.hotel.log.model.UserLog;
import com.distinct.hotel.log.service.UserLogService;
import com.distinct.hotel.sale.vo.BaseRuleVO;

@Service
public class UserLogServiceImpl implements UserLogService {
@Resource
UserLogMapper userLogMapper;
@Resource
HttpServletRequest request;

String content = null;
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
	@Override
	public void insertSaleRuleUpdateUserLog(Integer saleRuleId,String status) {
		Date now = new Date();
		if(saleRuleId == 1){
			content = "携程";
		}else if (saleRuleId == 2){
			content = "去哪儿";
		}else if (saleRuleId == 3){
			content = "淘宝";
		}
		
		UserLog userLog = new UserLog();
		userLog.setUserId(UserUtils.getCurrentUser().getId());
		userLog.setCreated(now);
		userLog.setContent(content+"平台"+status);
		userLog.setModule("分销管理");
		userLogMapper.insertSelective(userLog);
	}
	@Override
	public void insertPublishRuleUpdateUserLog(Integer saleRuleId,Date beginDate, Date endDate, String status) {
		UserLog userLog = new UserLog();
		if(saleRuleId == 1){
			content = "携程";
		}else if (saleRuleId == 2){
			content = "去哪儿";
		}else if (saleRuleId == 3){
			content = "淘宝";
		}
		Date now = new Date();
		String begin = sdf.format(beginDate);
		String end = sdf.format(endDate);
		userLog.setUserId(UserUtils.getCurrentUser().getId());
		userLog.setCreated(now);
		userLog.setContent(content+"平台"+"在"+begin+"到"+end+"之间"+status);
		userLog.setModule("分销管理");
		userLogMapper.insertSelective(userLog);
		
	}
	@Override
	public void insertPublishRuleDeleteUserLog(Integer saleRuleId, Date beginDate, Date endDate, String status) {
		UserLog userLog = new UserLog();
		if(saleRuleId == 1){
			content = "携程";
		}else if (saleRuleId == 2){
			content = "去哪儿";
		}else if (saleRuleId == 3){
			content = "淘宝";
		}
		Date now = new Date();
		String begin = sdf.format(beginDate);
		String end = sdf.format(endDate);
		userLog.setUserId(UserUtils.getCurrentUser().getId());
		userLog.setCreated(now);
		userLog.setContent(content+"平台"+"删除在"+begin+"到"+end+"之间"+status+"的记录");
		userLog.setModule("分销管理");
		userLogMapper.insertSelective(userLog);
		
	}
	@Override
	public void insertPublishRuleInsertUserLog(Integer saleRuleId, Date beginDate, Date endDate, String status) {
		UserLog userLog = new UserLog();
		if(saleRuleId == 1){
			content = "携程";
		}else if (saleRuleId == 2){
			content = "去哪儿";
		}else if (saleRuleId == 3){
			content = "淘宝";
		}
		Date now = new Date();
		String begin = sdf.format(beginDate);
		String end = sdf.format(endDate);
		userLog.setUserId(UserUtils.getCurrentUser().getId());
		userLog.setCreated(now);
		userLog.setContent(content+"平台"+"增加在"+begin+"到"+end+"之间"+status+"的记录");
		userLog.setModule("分销管理");
		userLogMapper.insertSelective(userLog);
		
	}
	@Override
	public void insertFillterRuleInsertUserLog(Integer saleRuleId, Integer filterId, String filterType,
			Integer providerId) {
		UserLog userLog = new UserLog();
		if(saleRuleId == 1){
			content = "携程";
		}else if (saleRuleId == 2){
			content = "去哪儿";
		}else if (saleRuleId == 3){
			content = "淘宝";
		}
		Date now = new Date();
		userLog.setUserId(UserUtils.getCurrentUser().getId());
		userLog.setCreated(now);
		userLog.setContent(content+"平台"+"增加"+filterType+"其id为"+filterId+"的过滤记录");
		userLog.setModule("分销管理");
		userLog.setUserIp(request.getLocalAddr());
		userLogMapper.insertSelective(userLog);
	
	}
	@Override
	public void insertFillterRuleDeleteUserLog(Integer saleRuleId, Integer filterId, String filterType,
			Integer providerId) {
		UserLog userLog = new UserLog();
		if(saleRuleId == 1){
			content = "携程";
		}else if (saleRuleId == 2){
			content = "去哪儿";
		}else if (saleRuleId == 3){
			content = "淘宝";
		}
		Date now = new Date();
		userLog.setUserId(UserUtils.getCurrentUser().getId());
		userLog.setCreated(now);
		userLog.setContent(content+"平台"+"删除"+filterType+"其id为"+filterId+"的过滤记录");
		userLog.setModule("分销管理");
		userLogMapper.insertSelective(userLog);
		
	}
	@Override
	public void insertBaseRuleUpdateUserLog(BaseRuleVO baseRuleVO) {
		UserLog userLog = new UserLog();
	int	saleRuleId = baseRuleVO.getSaleRuleId();
		if(saleRuleId == 1){
			content = "携程";
		}else if (saleRuleId == 2){
			content = "去哪儿";
		}else if (saleRuleId == 3){
			content = "淘宝";
		}
		Date now = new Date();
		userLog.setUserId(UserUtils.getCurrentUser().getId());
		userLog.setCreated(now);
		userLog.setContent(content+"平台"+"修改"+"基础设置"+"的记录");
		userLog.setModule("分销管理");
		userLogMapper.insertSelective(userLog);
		
	}	
	
}
