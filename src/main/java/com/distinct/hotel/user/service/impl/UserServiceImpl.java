
package com.distinct.hotel.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.distinct.hotel.user.dao.RoleMapper;
import com.distinct.hotel.user.dao.UserMapper;
import com.distinct.hotel.user.model.Role;
import com.distinct.hotel.user.model.User;
import com.distinct.hotel.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	@Resource
	private RoleMapper roleMapper;

	@Override
	public boolean getUser(String username, String pwd) {
		User user = userMapper.selectByUAS(username, pwd);
		if (user != null) {
			return true;
		} else
			return false;

	}

	@Override
	public int addUser(User user) {

		return userMapper.insert(user);
	}

	@Override
	public User getUserByAccount(String account) {
		
		return userMapper.getUserByAccount(account);
	}

	@Override
	public List<Role> getRoleByAccount(String account) {
		return roleMapper.getRoleByAccount(account);
	}

}
