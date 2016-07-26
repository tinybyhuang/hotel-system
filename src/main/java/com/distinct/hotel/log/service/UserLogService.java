package com.distinct.hotel.log.service;

import java.util.Date;

import com.distinct.hotel.sale.vo.BaseRuleVO;

public interface UserLogService {
public void insertSaleRuleUpdateUserLog(Integer saleRuleId,String status);
public void insertPublishRuleUpdateUserLog(Integer saleRuleId,Date beginDate,Date endDate,String status);
public void insertPublishRuleDeleteUserLog(Integer saleRuleId,Date beginDate,Date endDate,String status);
public void insertPublishRuleInsertUserLog(Integer saleRuleId,Date beginDate,Date endDate,String status);
public void insertFillterRuleInsertUserLog(Integer saleRuleId,Integer filterId,String filterType,Integer providerId);
public void insertFillterRuleDeleteUserLog(Integer saleRuleId,Integer filterId,String filterType,Integer providerId);
public void insertBaseRuleUpdateUserLog(BaseRuleVO baseRuleVO);
}
