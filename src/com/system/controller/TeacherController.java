package com.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.system.mapper.TeacherMapper;
import com.system.po.Teacher;

@Controller
public class TeacherController {
	
	@Autowired
	private TeacherMapper teacherMapper;
	
	private Teacher own;
	
	private String username;
	 
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>主界面<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/teacher")
	public ModelAndView teacher(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("teacher/teacher");
		if(request.getParameter("username") != null && "".equals(request.getParameter("username"))) {
			own = teacherMapper.findByUsername(username);
			username = own.getUsername();
		}
		if(username != null) {
			mav.addObject("username", username);
		}else {
			mav = new ModelAndView("redirect:login");
		}
		return mav;
	}
	
}
