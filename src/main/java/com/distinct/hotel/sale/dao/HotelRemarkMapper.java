package com.distinct.hotel.sale.dao;

import com.distinct.hotel.sale.model.HotelRemark;
import com.distinct.hotel.sale.model.HotelRemarkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HotelRemarkMapper {
    int countByExample(HotelRemarkExample example);

    int deleteByExample(HotelRemarkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HotelRemark record);

    int insertSelective(HotelRemark record);

    List<HotelRemark> selectByExample(HotelRemarkExample example);

    HotelRemark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HotelRemark record, @Param("example") HotelRemarkExample example);

    int updateByExample(@Param("record") HotelRemark record, @Param("example") HotelRemarkExample example);

    int updateByPrimaryKeySelective(HotelRemark record);

    int updateByPrimaryKey(HotelRemark record);
    List<HotelRemark> selectedListBySaleRuleId(Integer saleRuleId);
    HotelRemark selectedByHotelIdAndSaleRuleId(@Param("hotelId")Integer hotelId,@Param("saleRuleId") Integer saleRuleId);

	void deleteHotelRemarkByHotelIdAndSaleRuleIdAP(@Param("hotelId")Integer hotelId,@Param("saleRuleId") Integer saleRuleId,@Param("providerId")Integer providerId);

}