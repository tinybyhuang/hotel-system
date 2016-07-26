package com.distinct.hotel.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import com.distinct.hotel.common.utils.SpringUtils;
import com.distinct.hotel.user.model.User;
import com.distinct.hotel.user.service.UserService;

public class UserUtils {
	
	public static User getCurrentUser(){
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		
		User user = (User)session.getAttribute("currentUser");
		if(null != user){
			return user;
		}
		String account = (String)subject.getPrincipal();
		UserService userService = SpringUtils.getBean("userService");
		user = userService.getUserByAccount(account);
		if(null != user){
			session.setAttribute("currentUser", user);
		}
		return user;
	}
	

}
