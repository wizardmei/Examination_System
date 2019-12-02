package com.system.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.system.mapper.CourseMapper;
import com.system.mapper.FractionMapper;
import com.system.mapper.MoMCourseMapper;
import com.system.mapper.StudentMapper;
import com.system.mapper.UserLoginMapper;
import com.system.po.Course;
import com.system.po.Fraction;
import com.system.po.MoMCourse;
import com.system.po.Student;
import com.system.po.UserLogin;
import com.system.poi.DownLoadMessage;

@Controller
public class StudentController {
	
	private Integer start=0;
	
	private Integer pagesize=2;
	
	private Student own;
	
	private String username;
	
	@Autowired
	private FractionMapper fractionmapper;
	
	@Autowired
	private MoMCourseMapper momcoursemapper;
	
	@Autowired
	private UserLoginMapper userloginmapper;
	
	@Autowired
	private StudentMapper studentmapper;
	
	@Autowired
	private CourseMapper coursemapper;
	
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>主界面<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/student")
	public ModelAndView student(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("student/student");
		if(request.getParameter("username") != null && !"".equals(request.getParameter("username"))) {
			own = studentmapper.findById(Integer.parseInt(request.getParameter("username")));
			username = own.getUsername();
		}
		if(username != null) {
			mav.addObject("username", username);
		}else {
			mav = new ModelAndView("redirect:login");
		}
		return mav;
	}
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>课程表<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/student/Schedule_Card",method= {RequestMethod.GET})
	public ModelAndView schedule_Card1(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("student/selectSchedule_Card");
		List<Course> semesters = coursemapper.showCrs_semester(own.getStu_class());
		mav.addObject("username", username);
		mav.addObject("semesters", semesters);
		return mav;
	}
	@RequestMapping(value="/student/Schedule_Card",method= {RequestMethod.POST})
	public ModelAndView schedule_Card(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("student/Schedule_Card");
		String crs_semester = new String(request.getParameter("crs_semester").getBytes("ISO-8859-1"),"UTF-8");
		List<Course> schedule_card = coursemapper.schedule_Card(own.getStu_class(), crs_semester);
		for (Course course : schedule_card) {
			String[] crs_times = course.getCrs_time().split("<>");
			for(String crs_time:crs_times) {
//				Pattern pattern = Pattern.compile("周一第1、2节|周一第3、4节|周一第5、6节|周一第7、8节|周一第9、10节|周二第1、2节|周二第3、4节|周二第5、6节|周二第7、8节|周二第9、10节|周三第1、2节|周三第3、4节|周三第5、6节|周三第7、8节|周三第9、10节|周四第1、2节|周四第3、4节|周四第5、6节|周四第7、8节|周四第9、10节|周五第1、2节|周五第3、4节|周五第5、6节|周五第7、8节|周五第9、10节");
//				Matcher matcher = pattern.matcher(crs_time);
				if(crs_time.equals("周一第1、2节")) {
					mav.addObject("monday12", course);
				}else  if(crs_time.equals("周一第3、4节")) {
					mav.addObject("monday34", course);
				}else  if(crs_time.equals("周一第5、6节")) {
					mav.addObject("monday56", course);
				}else  if(crs_time.equals("周一第7、8节")) {
					mav.addObject("monday78", course);
				}else  if(crs_time.equals("周一第9、10节")) {
					mav.addObject("monday910", course);
				}else  if(crs_time.equals("周二第1、2节")) {
					mav.addObject("tuesday12", course);
				}else  if(crs_time.equals("周二第3、4节")) {
					mav.addObject("tuesday34", course);
				}else  if(crs_time.equals("周二第5、6节")) {
					mav.addObject("tuesday56", course);
				}else  if(crs_time.equals("周二第7、8节")) {
					mav.addObject("tuesday78", course);
				}else  if(crs_time.equals("周二第9、10节")) {
					mav.addObject("tuesday910", course);
				}else  if(crs_time.equals("周三第1、2节")) {
					mav.addObject("wednesday12", course);
				}else  if(crs_time.equals("周三第3、4节")) {
					mav.addObject("wednesday34", course);
				}else  if(crs_time.equals("周三第5、6节")) {
					mav.addObject("wednesday56", course);
				}else  if(crs_time.equals("周三第7、8节")) {
					mav.addObject("wednesday78", course);
				}else  if(crs_time.equals("周三第9、10节")) {
					mav.addObject("wednesday910", course);
				}else  if(crs_time.equals("周四第1、2节")) {
					mav.addObject("thursday12", course);
				}else  if(crs_time.equals("周四第3、4节")) {
					mav.addObject("thursday34", course);
				}else  if(crs_time.equals("周四第5、6节")) {
					mav.addObject("thursday56", course);
				}else  if(crs_time.equals("周四第7、8节")) {
					mav.addObject("thursday78", course);
				}else  if(crs_time.equals("周四第9、10节")) {
					mav.addObject("thursday910", course);
				}else  if(crs_time.equals("周五第1、2节")) {
					mav.addObject("friday12", course);
				}else  if(crs_time.equals("周五第3、4节")) {
					mav.addObject("friday34", course);
				}else  if(crs_time.equals("周五第5、6节")) {
					mav.addObject("friday56", course);
				}else  if(crs_time.equals("周五第7、8节")) {
					mav.addObject("friday78", course);
				}else  if(crs_time.equals("周五第9、10节")) {
					mav.addObject("friday910", course);
				}
			}
			List<Course> semesters = coursemapper.showCrs_semester(own.getStu_class());
			mav.addObject("username", username);
			mav.addObject("semesters", semesters);
		}
		return mav;
	}
	
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>修改密码<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/student/resetPasswd",method= {RequestMethod.GET})
	public ModelAndView resetPasswd(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("student/resetPasswd");
		UserLogin userLogin = userloginmapper.findByName(own.getUserid().toString());
		mav.addObject("username", username);
		mav.addObject("oldpassword", userLogin.getPassword());
		return mav;
	}
	
	@RequestMapping(value="/student/resetPasswd",method= {RequestMethod.POST})
	public ModelAndView resetPassword(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		userloginmapper.resetPasswd(own.getUserid().toString(), new String(request.getParameter("newpassword").getBytes("ISO-8859-1"),"UTF-8"));
		return logout(request,response);
	}
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>课程信息<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/student/stu_showCourse")
	public ModelAndView showCourse(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("student/stu_showCourse");
		List<Course> crs_list = coursemapper.stu_showCourse1(own.getUserid());
		Integer pagenum = (int) Math.ceil((double)crs_list.size()/pagesize);
		List<Course> pageList = coursemapper.stu_pageCourse1(own.getUserid(), start, pagesize);
		if(request.getParameter("page") != null) {
			Integer newstart = start+pagesize*(Integer.parseInt(request.getParameter("page"))-1);
			Integer newpagesize = Integer.parseInt(request.getParameter("page"))*pagesize;
			pageList = coursemapper.pageCourse(newstart, newpagesize);
		}
		Integer page;
		if(request.getParameter("page") == null || Integer.parseInt(request.getParameter("page")) == 1) {
			page = 1;
		}else if (Integer.parseInt(request.getParameter("page")) == pagenum){
			page = pagenum;
		}else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		mav.addObject("crs_list", pageList);
		mav.addObject("username", username);
		mav.addObject("page", page);
		mav.addObject("pagenum", pagenum);
		return mav;
	}
	
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>课程成绩<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/student/showMark")
	public ModelAndView showMark(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("student/showMark");
		List<Fraction> frac_list = fractionmapper.showMark(own.getUserid());
		Integer pagenum = (int) Math.ceil((double)frac_list.size()/pagesize);
		List<Fraction> pageList = fractionmapper.pageMark(start, pagesize,own.getUserid());
		if(request.getParameter("page") != null) {
			Integer newstart = start+pagesize*(Integer.parseInt(request.getParameter("page"))-1);
			Integer newpagesize = Integer.parseInt(request.getParameter("page"))*pagesize;
			pageList = fractionmapper.pageMark(newstart, newpagesize,own.getUserid());;
		}
		Integer page;
		if(request.getParameter("page") == null || Integer.parseInt(request.getParameter("page")) == 1) {
			page = 1;
		}else if (Integer.parseInt(request.getParameter("page")) == pagenum){
			page = pagenum;
		}else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		mav.addObject("frac_list", pageList);
		mav.addObject("page", page);
		mav.addObject("username", username);
		mav.addObject("pagenum", pagenum);
		return mav;
	}
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>查找课程<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/student/selectCourse",method= {RequestMethod.POST})
	public ModelAndView selectCourse(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("student/showCourse");
		String course_name = new String(request.getParameter("findByName").getBytes("ISO-8859-1"),"UTF-8");
		List<Course> crs_list = coursemapper.stu_selectCourse(course_name,own.getStu_class());
		Integer pagenum = (int) Math.ceil((double)crs_list.size()/pagesize);
		List<Course> pageList = coursemapper.stu_pageCourse(start, pagesize, course_name,own.getUserid());
		if(request.getParameter("page") != null) {
			Integer newstart = start+pagesize*(Integer.parseInt(request.getParameter("page"))-1);
			Integer newpagesize = Integer.parseInt(request.getParameter("page"))*pagesize;
			pageList = coursemapper.stu_pageCourse(newstart, newpagesize, course_name,own.getUserid());
		}
		Integer page;
		if(request.getParameter("page") == null || Integer.parseInt(request.getParameter("page")) == 1) {
			page = 1;
		}else if (Integer.parseInt(request.getParameter("page")) == pagenum){
			page = pagenum;
		}else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		mav.addObject("crs_list", pageList);
		mav.addObject("page", page);
		mav.addObject("username", username);
		mav.addObject("pagenum", pagenum);
		return mav;
	}
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>查找课程成绩<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/student/selectMark",method= {RequestMethod.POST})
	public ModelAndView selectMark(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("student/showMark");
		String course_name = new String(request.getParameter("findByName").getBytes("ISO-8859-1"),"UTF-8");
		List<Fraction> frac_list = fractionmapper.selectMark( own.getUserid(), course_name);
		Integer pagenum = (int) Math.ceil((double)frac_list.size()/pagesize);
		List<Fraction> pageList = fractionmapper.pageselectMark(start, pagesize, own.getUserid(), course_name);
		if(request.getParameter("page") != null) {
			Integer newstart = start+pagesize*(Integer.parseInt(request.getParameter("page"))-1);
			Integer newpagesize = Integer.parseInt(request.getParameter("page"))*pagesize;
			pageList = fractionmapper.pageselectMark(newstart, newpagesize, own.getUserid(), course_name);
		}
		Integer page;
		if(request.getParameter("page") == null || Integer.parseInt(request.getParameter("page")) == 1) {
			page = 1;
		}else if (Integer.parseInt(request.getParameter("page")) == pagenum){
			page = pagenum;
		}else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		mav.addObject("frac_list", pageList);
		mav.addObject("page", page);
		mav.addObject("username", username);
		mav.addObject("pagenum", pagenum);
		return mav;
	}
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>下载课程信息<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/downloadMark")
	public void downloadMark(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String[] headers = {"课程代码","课程名称","课程属性","课程学分","课程成绩"};
		List<Fraction> crs_list = fractionmapper.showMark(own.getUserid());
		DownLoadMessage<Fraction> download = new DownLoadMessage<>(headers, crs_list, response);
		download.download();
	}
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>下载课程信息<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/student/downloadCourse")
	public void downloadCourse(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String[] headers = {"课程ID","课程代码","课程名称","课程属性","课程学分","课程学期","课程时间","课程周次","课程班级","课程老师","课程地址"};
		List<Course> crs_list = coursemapper.stu_showCourse(own.getStu_class());
		DownLoadMessage<Course> download = new DownLoadMessage<>(headers, crs_list, response);
		download.download();
	}
	
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>个人信息<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/student/showUserInfo")
	public ModelAndView showUserInfo(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("student/showUserInfo");
		mav.addObject("own", own);
		mav.addObject("username",username);
		return mav;
	}
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>选择课程<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/student/showElectiveCourse")
	public ModelAndView chooseCourse(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("student/showElectiveCourse");
		Integer userid = own.getUserid();
		String crs_attribute = "选修";
		
		List<MoMCourse> momlist = momcoursemapper.electivecourses(userid, crs_attribute);
		for (MoMCourse moMCourse : momlist) {
			if(fractionmapper.isEmpty(userid,moMCourse.getCrs_code()) == null) {
				mav = new ModelAndView("student/showElectiveCourse1");
			}
		}
		
		List<Course> crs_list = coursemapper.showElectiveCourse();
		Integer pagenum = (int) Math.ceil((double)crs_list.size()/pagesize);
		List<Course> pageList = coursemapper.pageElectiveCourse(start, pagesize);
		if(request.getParameter("page") != null) {
			Integer newstart = start+pagesize*(Integer.parseInt(request.getParameter("page"))-1);
			Integer newpagesize = Integer.parseInt(request.getParameter("page"))*pagesize;
			pageList = coursemapper.pageElectiveCourse(newstart, newpagesize);
		}
		Integer page;
		if(request.getParameter("page") == null || Integer.parseInt(request.getParameter("page")) == 1) {
			page = 1;
		}else if (Integer.parseInt(request.getParameter("page")) == pagenum){
			page = pagenum;
		}else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		mav.addObject("pagenum",pagenum);
		mav.addObject("page", page);
		mav.addObject("crs_list",pageList);
		mav.addObject("username",username);
		return mav;
	}
	
	@RequestMapping(value="/student/addElectiveCourse")
	public ModelAndView electiveCourse(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("redirect:showElectiveCourse");
		String crs_code = new String(request.getParameter("crs_code").getBytes("ISO-8859-1"),"UTF-8");
		String crs_attribute = "选修";
		Integer userid = own.getUserid();
		momcoursemapper.addInfo(userid, crs_code,crs_attribute);
		return mav;
	}
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>登出<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/student/logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("redirect:/login");
		username = null;
		return mav;
	}
}
