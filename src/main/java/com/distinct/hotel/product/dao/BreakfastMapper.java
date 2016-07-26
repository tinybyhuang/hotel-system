package com.distinct.hotel.product.dao;

import com.distinct.hotel.product.model.Breakfast;
import com.distinct.hotel.product.model.BreakfastExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BreakfastMapper {
    int countByExample(BreakfastExample example);

    int deleteByExample(BreakfastExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Breakfast record);

    int insertSelective(Breakfast record);

    List<Breakfast> selectByExample(BreakfastExample example);

    Breakfast selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Breakfast record, @Param("example") BreakfastExample example);

    int updateByExample(@Param("record") Breakfast record, @Param("example") BreakfastExample example);

    int updateByPrimaryKeySelective(Breakfast record);

    int updateByPrimaryKey(Breakfast record);
}