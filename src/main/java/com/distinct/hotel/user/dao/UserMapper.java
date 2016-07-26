package com.distinct.hotel.user.dao;

import com.distinct.hotel.user.model.User;
import com.distinct.hotel.user.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	int countByExample(UserExample example);

	int deleteByExample(UserExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);
    
    User selectByUAS(@Param("username")String username,@Param("pwd")String pwd);

	User selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	
	User getUserByAccount(@Param("account")String account);
		

   
}