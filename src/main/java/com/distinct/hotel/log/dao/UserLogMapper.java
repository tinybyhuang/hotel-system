package com.distinct.hotel.log.dao;

import com.distinct.hotel.log.model.UserLog;
import com.distinct.hotel.log.model.UserLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLogMapper {
    int countByExample(UserLogExample example);

    int deleteByExample(UserLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserLog record);

    int insertSelective(UserLog record);

    List<UserLog> selectByExampleWithBLOBs(UserLogExample example);

    List<UserLog> selectByExample(UserLogExample example);

    UserLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserLog record, @Param("example") UserLogExample example);

    int updateByExampleWithBLOBs(@Param("record") UserLog record, @Param("example") UserLogExample example);

    int updateByExample(@Param("record") UserLog record, @Param("example") UserLogExample example);

    int updateByPrimaryKeySelective(UserLog record);

    int updateByPrimaryKeyWithBLOBs(UserLog record);

    int updateByPrimaryKey(UserLog record);
}