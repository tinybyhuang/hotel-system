package com.distinct.hotel.sale.service;

import java.util.List;

import com.distinct.hotel.sale.model.HotelRemark;
import com.distinct.hotel.sale.vo.HotelRemarkVO;

public interface HotelRemarkService {
  public void insertHotelRemark(HotelRemarkVO hotelRemarkVO);
  public void deleteHotelRemarkById(Integer id);
  public List<HotelRemark> selectedListBySaleRuleId(Integer salerRuleId);
  public void updateHotelRemark(HotelRemarkVO hotelRemarkVO);
  public HotelRemark selectedByHotelIdAndSaleRuleId(Integer hotelId,Integer salerRuleId); 
  public void insertHotelRemarkInit(Integer hotelId,Integer providerId,Integer salerRuleId);
  public void deleteHotelRemarkByHotelIdAndSaleRuleIdAP(Integer hotelId,Integer saleRuleId,Integer providerId);
}
