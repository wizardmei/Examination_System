package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import com.system.mapper.UserLoginMapper;
//import com.system.po.UserLogin;
@Controller
public class LoginController {
	
//	@Autowired
//	private UserLoginMapper userLoginMapper;

	@RequestMapping(value="/login",method= {RequestMethod.GET})
	public ModelAndView loginget(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		ModelAndView mav=new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(value="/login",method= {RequestMethod.POST})
	public ModelAndView loginpost(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
		if(subject.hasRole("admin")) {
			mav = new ModelAndView("redirect:admin");
		}else if(subject.hasRole("teacher")) {
			mav = new ModelAndView("redirect:teacher");
		}else if(subject.hasRole("redirect:student")) {
			mav = new ModelAndView("redirect:student");
		}
		mav.addObject("username",username);
		return mav;
//		UserLogin userLogin = userLoginMapper.selectByUserName(username,password);
//		if(userLogin == null) {
//			return mav;
//		}else {
//			if(userLogin.getRole() == 0) {
//				mav = new ModelAndView("redirect:admin");
//			}else if(userLogin.getRole() == 1) {
//				mav = new ModelAndView("redirect:teacher");
//			}else if(userLogin.getRole() == 2) {
//				mav = new ModelAndView("redirect:student");
//			}
//			mav.addObject("username", username);
//			return mav;
//		}
	}
	
}
