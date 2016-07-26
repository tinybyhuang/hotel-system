package com.distinct.hotel.order.dao;

import com.distinct.hotel.order.model.UserConfig;
import com.distinct.hotel.order.model.UserConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserConfigMapper {
	int countByExample(UserConfigExample example);

	int deleteByExample(UserConfigExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(UserConfig record);

	int insertSelective(UserConfig record);

	List<UserConfig> selectByExample(UserConfigExample example);

	UserConfig selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") UserConfig record, @Param("example") UserConfigExample example);

	int updateByExample(@Param("record") UserConfig record, @Param("example") UserConfigExample example);

	int updateByPrimaryKeySelective(UserConfig record);

	int updateByPrimaryKey(UserConfig record);

	List<UserConfig> selectListByUserIdNConfigType(@Param("userId") Integer userId,
			@Param("configType") Integer configType);

	UserConfig selectUserConfigByUserIdNConfigTypeNConfigId(@Param("userId") Integer userId,
			@Param("configType") Integer configType, @Param("configId") Integer configId);
}