package com.distinct.hotel.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.distinct.hotel.common.UserUtils;
import com.distinct.hotel.user.service.UserService;

@Controller
public class LoginController {

	@Resource
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("pwd") String pwd, @RequestParam("username") String username,
			 HttpSession session,Model model) {
		/*@RequestParam("verifycode") String verifycode*/
		/*if (!(verifycode.equalsIgnoreCase(session.getAttribute("code").toString()))) {

			return "../login";
		}*/
		UsernamePasswordToken token = new UsernamePasswordToken(username, pwd);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (subject.isAuthenticated()) {
			token.clear();
		}
		model.addAttribute("user", UserUtils.getCurrentUser());
		return "../index";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginbypage() {
		return "../login";
	}

	@RequestMapping("/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/";
	}

}
