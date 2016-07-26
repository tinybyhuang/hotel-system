package com.distinct.hotel.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.distinct.hotel.user.model.User;
import com.distinct.hotel.user.service.UserService;

@Controller
public class RegistUserController {
	
	private static final String success = "success";
	private static final String failure = "failure";

	
	@Resource
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage() {
		return "../register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestParam("username") String username, @RequestParam("pwd") String password,
			@RequestParam("phone") String phone, @RequestParam("company") String company,
			@RequestParam("remark") String remark, @RequestParam("verifycode") String verifycode, Model model,
			HttpSession session) {

		if ((verifycode.equalsIgnoreCase(session.getAttribute("code").toString()))) {
			User user = new User();
			user.setCompany(company);
			user.setPhone(phone);
			user.setUsername(username);
			user.setPwd(password);
			if (remark != null) {
				user.setRemark(remark);
			}
			userService.addUser(user);
			return "../login";
		} else {
			return "../register";
		}
	}
	
//	@RequestMapping(value = "/ajax", method = RequestMethod.POST)
//	public void validateUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		List<String> l = userService.getUserName();
//		System.out.println(l);
//		String username = request.getParameter("username");
//        System.out.println(username);
//		for (String a : l) {
//			if (username.equals(a)) {
//				response.getWriter().print("1");
//				
//			} 
//			/*else {
//				response.getWriter().print("0");		}*/
//		}
//	}
	@RequestMapping(value = "/checkUser", method = RequestMethod.POST)
	@ResponseBody
	public String checkUser(String username){
		
		if(StringUtils.isNotBlank(username)){
			
			User user = userService.getUserByAccount(username);
			if(null == user){
				return success;
			}
		}
		
		return failure;
	}
	
}
