package com.distinct.hotel.product.dao;

import com.distinct.hotel.product.model.Bed;
import com.distinct.hotel.product.model.BedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BedMapper {
    int countByExample(BedExample example);

    int deleteByExample(BedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bed record);

    int insertSelective(Bed record);

    List<Bed> selectByExample(BedExample example);

    Bed selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bed record, @Param("example") BedExample example);

    int updateByExample(@Param("record") Bed record, @Param("example") BedExample example);

    int updateByPrimaryKeySelective(Bed record);

    int updateByPrimaryKey(Bed record);
    
    Bed selectByRoomBedType(@Param("roomBedType")Integer roomBedType);
}