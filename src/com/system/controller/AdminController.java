package com.system.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.system.mapper.CourseMapper;
import com.system.mapper.MoMCourseMapper;
import com.system.mapper.StudentMapper;
import com.system.mapper.TeacherMapper;
import com.system.mapper.UserLoginMapper;
import com.system.po.Course;
import com.system.po.Student;
import com.system.po.Teacher;
import com.system.po.UserLogin;
import com.system.poi.DownLoadMessage;


@Controller
public class AdminController {
	
	private List<Student> stu_list;
	
	private List<Course> crs_list;
	
	private List<Teacher> tcr_list;
	
	private String username;
	
	private Integer start=0;
	
	private final Integer pagesize=2;
	
	@Autowired
	private StudentMapper studentmapper;
	
	@Autowired
	private UserLoginMapper userloginmapper;
	
	@Autowired
	private MoMCourseMapper momcoursemapper;
	
	@Autowired
	private TeacherMapper teachermapper;
	
	@Autowired
	private CourseMapper coursemapper;
	
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>主界面<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/admin")
	public ModelAndView admin(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav;
		if(request.getParameter("username") != null && !"".equals(request.getParameter("username"))) {
			username = request.getParameter("username");
		}
		if(username != null) {
			mav = new ModelAndView("admin/admin");
			stu_list = studentmapper.showStudent();
			crs_list = coursemapper.showCourse();
			tcr_list = teachermapper.showTeacher();
			mav.addObject("username", username);
			mav.addObject("stu_num", stu_list.size());
			mav.addObject("crs_num", crs_list.size());
			mav.addObject("tcr_num", tcr_list.size());
		}else {
			mav = new ModelAndView("redirect:login");
		}
			return mav;
	}
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>学生管理<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/admin/showStudent")
	public ModelAndView showStudent(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("admin/showStudent");
		stu_list = studentmapper.showStudent();
		Integer pagenum = (int) Math.ceil((double)stu_list.size()/pagesize);
		List<Student> pageList = studentmapper.pageStudent(start, pagesize);
		if(request.getParameter("page") != null) {
			Integer newstart = start+pagesize*(Integer.parseInt(request.getParameter("page"))-1);
			Integer newpagesize = Integer.parseInt(request.getParameter("page"))*pagesize;
			pageList = studentmapper.pageStudent(newstart, newpagesize);
		}
		Integer page;
		if(request.getParameter("page") == null || Integer.parseInt(request.getParameter("page")) == 1) {
			page = 1;
		}else if (Integer.parseInt(request.getParameter("page")) == pagenum){
			page = pagenum;
		}else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		mav.addObject("page", page);
		mav.addObject("username", username);
		mav.addObject("pagenum", pagenum);
		mav.addObject("stu_list", pageList);
		mav.addObject("stu_num", stu_list.size());
		mav.addObject("crs_num", crs_list.size());
		mav.addObject("tcr_num", tcr_list.size());
		return username==null?new ModelAndView("redirect:/login"):mav;
	}
	
	
	@RequestMapping(value="/admin/removeStudent")
	public ModelAndView removeStudent(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("redirect:/admin/showStudent");
		Integer userid = Integer.parseInt(request.getParameter("id"));
		String account = studentmapper.findById(userid).getAccount();
		studentmapper.removeStudent(userid);
		userloginmapper.deleteUser(account);
		return username==null?new ModelAndView("redirect:/login"):mav;
	}
	
	@RequestMapping(value="/admin/editStudent",method= {RequestMethod.GET})
	public ModelAndView editStudent(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("admin/editStudent");
		mav.addObject("username", username);
		Student target = studentmapper.findById(Integer.parseInt(request.getParameter("id")));
		mav.addObject("target", target);
		mav.addObject("stu_num", stu_list.size());
		mav.addObject("crs_num", crs_list.size());
		mav.addObject("tcr_num", tcr_list.size());
		return username==null?new ModelAndView("redirect:/login"):mav;
	}
	@RequestMapping(value="/admin/editStudent",method= {RequestMethod.POST})
	public ModelAndView edit_Student(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("redirect:/admin/showStudent");
		String username = new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		Integer userid = Integer.parseInt(request.getParameter("userid"));
		String sex = new String(request.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");
		String birthyear = new String(request.getParameter("birthyear").getBytes("ISO-8859-1"),"UTF-8");
		String college = new String(request.getParameter("college").getBytes("ISO-8859-1"),"UTF-8");
		String gradeyear = new String(request.getParameter("gradeyear").getBytes("ISO-8859-1"),"UTF-8");
		String stu_class = new String(request.getParameter("stu_class").getBytes("ISO-8859-1"),"UTF-8");
		String account = new String(request.getParameter("account").getBytes(),"UTF-8");
		String passwd = new String(request.getParameter("passwd").getBytes("ISO-8859-1"),"UTF-8");
		studentmapper.editStudent(userid, username, sex, birthyear, gradeyear, college,stu_class,account, passwd);
		userloginmapper.resetPasswd(account, passwd);
		return username==null?new ModelAndView("redirect:/login"):mav;
	}
	
	@RequestMapping(value="/admin/addStudent",method= {RequestMethod.GET})
	public ModelAndView addStudent1(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("admin/addStudent");
		mav.addObject("username", username);
		mav.addObject("stu_num", stu_list.size());
		mav.addObject("crs_num", crs_list.size());
		mav.addObject("tcr_num", tcr_list.size());
		return mav;
	}
	
	@RequestMapping(value="/admin/addStudent",method= {RequestMethod.POST})
	public ModelAndView addStudent(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("redirect:/admin/showStudent");
		String username = new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		Integer userid = Integer.parseInt(request.getParameter("userid"));
		String sex = new String(request.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");
		String birthyear = new String(request.getParameter("birthyear").getBytes("ISO-8859-1"),"UTF-8");
		String college = new String(request.getParameter("college").getBytes("ISO-8859-1"),"UTF-8");
		String gradeyear = new String(request.getParameter("gradeyear").getBytes("ISO-8859-1"),"UTF-8");
		String stu_class = new String(request.getParameter("stu_class").getBytes("ISO-8859-1"),"UTF-8");
		String account = new String(request.getParameter("account").getBytes(),"UTF-8");
		String passwd = new String(request.getParameter("passwd").getBytes("ISO-8859-1"),"UTF-8");
		studentmapper.addStudent(userid, username, sex, birthyear, gradeyear, college, stu_class, account, passwd);
		userloginmapper.createUser(account, passwd, 2);
		return username==null?new ModelAndView("redirect:/login"):mav;
	}

	@RequestMapping(value="/admin/modelStudent")
	public void modelStudent(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String[] headers = {"学号","姓名","性别","出生年份","入学年份","学院","班级","学生账号","账号密码"};
		List<Student> ls = new ArrayList<Student>();
		Student model = new Student(123456,"张三","男","2000","2019","云计算系","大数据","zhangsan","123456"); 
		ls.add(model);
		DownLoadMessage<Student> downLoad = new DownLoadMessage<>(headers, ls, response);
		downLoad.download();
	}
	@RequestMapping(value="/admin/selectStudent",method= {RequestMethod.POST})
	public ModelAndView selectStudent(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("admin/showStudent");
		String username = new String(request.getParameter("findByName").getBytes("ISO-8859-1"),"UTF-8");
		List<Student> stus=studentmapper.selectStudent(username);
		Integer pagenum = (int) Math.ceil((double)stus.size()/pagesize);
		List<Student> pageList = studentmapper.stu_pageStudent(start, pagesize, username);
		if(request.getParameter("page") != null) {
			Integer newstart = start+pagesize*(Integer.parseInt(request.getParameter("page"))-1);
			Integer newpagesize = Integer.parseInt(request.getParameter("page"))*pagesize;
			pageList = studentmapper.stu_pageStudent(newstart, newpagesize, username);
		}
		Integer page;
		if(request.getParameter("page") == null || Integer.parseInt(request.getParameter("page")) == 1) {
			page = 1;
		}else if (Integer.parseInt(request.getParameter("page")) == pagenum){
			page = pagenum;
		}else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		mav.addObject("stu_list", pageList);
		mav.addObject("page", page);
		mav.addObject("username", username);
		mav.addObject("pagenum", pagenum);
		return mav;
	}
		
	@RequestMapping(value="/admin/downloadStudent")
	public void downloadStudent(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String[] headers = {"学号","姓名","性别","出生年份","入学年份","学院","班级","学生账号","账号密码"};
		DownLoadMessage<Student> downLoad = new DownLoadMessage<>(headers,stu_list,response);
		downLoad.download();
	}
	
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>修改密码<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/admin/resetPasswd",method= {RequestMethod.GET})
	public ModelAndView resetPasswd(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("admin/resetPasswd");
		UserLogin userLogin = userloginmapper.findByName(username);
		mav.addObject("stu_num", stu_list.size());
		mav.addObject("username", username);
		mav.addObject("crs_num", crs_list.size());
		mav.addObject("tcr_num", tcr_list.size());
		mav.addObject("oldpassword", userLogin.getPassword());
		return mav;
	}
	
	@RequestMapping(value="/admin/resetPasswd",method= {RequestMethod.POST})
	public ModelAndView resetPassword(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		userloginmapper.resetPasswd(username, new String(request.getParameter("newpassword").getBytes("ISO-8859-1"),"UTF-8"));
		return logout(request,response);
	}
	
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>账户密码重置<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/admin/userReset",method= {RequestMethod.GET})
	public ModelAndView userRest(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("admin/userReset");
		mav.addObject("username", username);
		mav.addObject("stu_num", stu_list.size());
		mav.addObject("crs_num", crs_list.size());
		mav.addObject("tcr_num", tcr_list.size());
		return mav;
	}
	@RequestMapping(value="/admin/userReset",method= {RequestMethod.POST})
	public ModelAndView userReset(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("admin/userReset");
		Integer userid = Integer.parseInt(request.getParameter("userid"));
		String user = new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		String passwd = new String(request.getParameter("passwd").getBytes("ISO-8859-1"),"UTF-8");
		Integer role = Integer.parseInt(request.getParameter("role"));
		if(userloginmapper.findUser(userid, user) != null) {
			userloginmapper.resetUser(userid, user, passwd, role);			
		}
		mav.addObject("username", username);
		mav.addObject("stu_num", stu_list.size());
		mav.addObject("crs_num", crs_list.size());
		mav.addObject("tcr_num", tcr_list.size());
		return mav;
	}
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>教师管理<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/admin/showTeacher")
	public ModelAndView showTeacher(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("admin/showTeacher");
		crs_list = coursemapper.showCourse();
		Integer pagenum = (int) Math.ceil((double)tcr_list.size()/pagesize);
		List<Teacher> pageList = teachermapper.pageCourse(start, pagesize);
		if(request.getParameter("page") != null) {
			Integer newstart = start+pagesize*(Integer.parseInt(request.getParameter("page"))-1);
			Integer newpagesize = Integer.parseInt(request.getParameter("page"))*pagesize;
			pageList = teachermapper.pageCourse(newstart, newpagesize);
		}
		Integer page;
		if(request.getParameter("page") == null || Integer.parseInt(request.getParameter("page")) == 1) {
			page = 1;
		}else if (Integer.parseInt(request.getParameter("page")) == pagenum){
			page = pagenum;
		}else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		mav.addObject("page", page);
		mav.addObject("username", username);
		mav.addObject("pagenum", pagenum);
		mav.addObject("crs_list", pageList);
		mav.addObject("stu_num", stu_list.size());
		mav.addObject("crs_num", crs_list.size());
		mav.addObject("tcr_num", tcr_list.size());
		return username==null?new ModelAndView("redirect:/login"):mav;
	}
	
	@RequestMapping(value="/admin/removeTeacher")
	public ModelAndView removeTeacher(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("redirect:/admin/showCourse");
		Integer tcr_id = Integer.parseInt(request.getParameter("id"));
		teachermapper.removeTeacher(tcr_id);
		return username==null?new ModelAndView("redirect:/login"):mav;
	}
	
	@RequestMapping(value="/admin/editTeacher",method= {RequestMethod.GET})
	public ModelAndView editTeacher(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("admin/editTeacher");
		mav.addObject("username", username);
		Teacher target = teachermapper.findById(Integer.parseInt(request.getParameter("id")));
		mav.addObject("target", target);
		mav.addObject("stu_num", stu_list.size());
		mav.addObject("crs_num", crs_list.size());
		mav.addObject("tcr_num", tcr_list.size());
		return username==null?new ModelAndView("redirect:/login"):mav;
	}
	@RequestMapping(value="/admin/editTeacher",method= {RequestMethod.POST})
	public ModelAndView edit_Teacher(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("redirect:/admin/showTeacher");
		return username==null?new ModelAndView("redirect:/login"):mav;
	}
	
	@RequestMapping(value="/admin/addTeacher",method= {RequestMethod.GET})
	public ModelAndView addTeacher1(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("admin/addCourse");
		mav.addObject("username", username);
		mav.addObject("stu_num", stu_list.size());
		mav.addObject("crs_num", crs_list.size());
		mav.addObject("tcr_num", tcr_list.size());
		return mav;
	}
	
	@RequestMapping(value="/admin/addTeacher",method= {RequestMethod.POST})
	public ModelAndView addTeacher(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("redirect:/admin/showCourse");
		return username==null?new ModelAndView("redirect:/login"):mav;
	}
	
	@RequestMapping(value="/admin/selectTeacher",method= {RequestMethod.POST})
	public ModelAndView selectTeacher(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("admin/showCourse");
		String course_name = new String(request.getParameter("findByName").getBytes("ISO-8859-1"),"UTF-8");
		List<Course> crs_list = coursemapper.selectCourse(course_name);
		Integer pagenum = (int) Math.ceil((double)crs_list.size()/pagesize);
		List<Course> pageList = coursemapper.admin_pageCourse(start, pagesize, course_name);
		if(request.getParameter("page") != null) {
			Integer newstart = start+pagesize*(Integer.parseInt(request.getParameter("page"))-1);
			Integer newpagesize = Integer.parseInt(request.getParameter("page"))*pagesize;
			pageList = coursemapper.admin_pageCourse(newstart, newpagesize, course_name);
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
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>课程管理<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/admin/showCourse")
	public ModelAndView showCourse(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("admin/showCourse");
		crs_list = coursemapper.showCourse();
		Integer pagenum = (int) Math.ceil((double)crs_list.size()/pagesize);
		List<Course> pageList = coursemapper.pageCourse(start, pagesize);
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
		mav.addObject("page", page);
		mav.addObject("username", username);
		mav.addObject("pagenum", pagenum);
		mav.addObject("crs_list", pageList);
		mav.addObject("stu_num", stu_list.size());
		mav.addObject("crs_num", crs_list.size());
		mav.addObject("tcr_num", tcr_list.size());
		return username==null?new ModelAndView("redirect:/login"):mav;
	}

	@RequestMapping(value="/admin/removeCourse")
	public ModelAndView removeCourse(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("redirect:/admin/showCourse");
		Integer crs_id = Integer.parseInt(request.getParameter("id"));
		coursemapper.removeCourse(crs_id);
		return username==null?new ModelAndView("redirect:/login"):mav;
	}
	
	@RequestMapping(value="/admin/editCourse",method= {RequestMethod.GET})
	public ModelAndView editCourse(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("admin/editCourse");
		mav.addObject("username", username);
		Course target = coursemapper.findById(Integer.parseInt(request.getParameter("id")));
		mav.addObject("target", target);
		mav.addObject("stu_num", stu_list.size());
		mav.addObject("crs_num", crs_list.size());
		mav.addObject("tcr_num", tcr_list.size());
		return username==null?new ModelAndView("redirect:/login"):mav;
	}
	@RequestMapping(value="/admin/editCourse",method= {RequestMethod.POST})
	public ModelAndView edit_Course(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("redirect:/admin/showCourse");
		String crs_code = new String(request.getParameter("crs_code").getBytes("ISO-8859-1"),"UTF-8");
		String crs_name = new String(request.getParameter("crs_name").getBytes("ISO-8859-1"),"UTF-8");
		String crs_teacher = new String(request.getParameter("crs_teacher").getBytes("ISO-8859-1"),"UTF-8");
		String crs_time = new String(request.getParameter("crs_time").getBytes("ISO-8859-1"),"UTF-8");
		String crs_frequency = new String(request.getParameter("crs_frequency").getBytes("ISO-8859-1"),"UTF-8");
		String crs_address = new String(request.getParameter("crs_address").getBytes("ISO-8859-1"),"UTF-8");
		String crs_class = new String(request.getParameter("crs_class").getBytes("ISO-8859-1"),"UTF-8");
		String crs_semester = new String(request.getParameter("crs_semester").getBytes("ISO-8859-1"),"UTF-8");
		String crs_attribute = new String(request.getParameter("crs_attribute").getBytes("ISO-8859-1"),"UTF-8");
		Integer crs_credit = Integer.parseInt(request.getParameter("crs_credit"));
		coursemapper.editCourse(crs_code, crs_name,crs_attribute,crs_credit,crs_semester, crs_time,crs_frequency, crs_class, crs_teacher, crs_address);
		return username==null?new ModelAndView("redirect:/login"):mav;
	}
	
	@RequestMapping(value="/admin/addCourse",method= {RequestMethod.GET})
	public ModelAndView addCourse1(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("admin/addCourse");
		List<Student> stu_class = studentmapper.showClasses();
		mav.addObject("stu_class",stu_class);
		mav.addObject("username", username);
		mav.addObject("stu_num", stu_list.size());
		mav.addObject("crs_num", crs_list.size());
		mav.addObject("tcr_num", tcr_list.size());
		return mav;
	}
	
	@RequestMapping(value="/admin/addCourse",method= {RequestMethod.POST})
	public ModelAndView addCourse(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("redirect:/admin/showCourse");
		String crs_name = new String(request.getParameter("crs_name").getBytes("ISO-8859-1"),"UTF-8");
		String crs_code = new String(request.getParameter("crs_code").getBytes("ISO-8859-1"),"UTF-8");
		String crs_time = new String(request.getParameter("crs_time").getBytes("ISO-8859-1"),"UTF-8");
		String crs_frequency = new String(request.getParameter("crs_frequency").getBytes("ISO-8859-1"),"UTF-8");
		String crs_class = new String(request.getParameter("crs_class").getBytes("ISO-8859-1"),"UTF-8");
		String crs_address = new String(request.getParameter("crs_address").getBytes("ISO-8859-1"),"UTF-8");
		String crs_teacher = new String(request.getParameter("crs_teacher").getBytes("ISO-8859-1"),"UTF-8");
		String crs_semester = new String(request.getParameter("crs_semester").getBytes("ISO-8859-1"),"UTF-8");
		String crs_attribute = new String(request.getParameter("crs_attribute").getBytes("ISO-8859-1"),"UTF-8");
		Integer crs_credit = Integer.parseInt(request.getParameter("crs_credit"));
		List<Student> stu_classes = studentmapper.findByStuClass(crs_class);
		for (Student student : stu_classes) {
			momcoursemapper.addInfo(student.getUserid(), crs_code, crs_attribute);
		}
		coursemapper.addCourse( crs_code, crs_name,crs_attribute,crs_credit,crs_semester, crs_time,crs_frequency, crs_class, crs_teacher, crs_address);
		return username==null?new ModelAndView("redirect:/login"):mav;
	}
	@RequestMapping(value="/admin/modelCourse")
	public void modelCourse(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String[] headers = {"课程代码","课程名","课程属性","课程学分","课程学期","课程时间","课程周次","课程班级","课程老师","课程地点","课程人数"};
		List<Course> ls = new ArrayList<Course>();
		Course model = new Course("CC123456","操作系统","必修",2,"2019-2020年第二学期","周一1、2节","12周次","大数据1班","张三","二教111",123); 
		ls.add(model);
		DownLoadMessage<Course> downLoad = new DownLoadMessage<>(headers, ls, response);
		downLoad.download();
	}
	@RequestMapping(value="/admin/selectCourse",method= {RequestMethod.POST})
	public ModelAndView selectCourse(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("admin/showCourse");
		String course_name = new String(request.getParameter("findByName").getBytes("ISO-8859-1"),"UTF-8");
		List<Course> crs_list = coursemapper.selectCourse(course_name);
		Integer pagenum = (int) Math.ceil((double)crs_list.size()/pagesize);
		List<Course> pageList = coursemapper.admin_pageCourse(start, pagesize, course_name);
		if(request.getParameter("page") != null) {
			Integer newstart = start+pagesize*(Integer.parseInt(request.getParameter("page"))-1);
			Integer newpagesize = Integer.parseInt(request.getParameter("page"))*pagesize;
			pageList = coursemapper.admin_pageCourse(newstart, newpagesize, course_name);
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
	
	@RequestMapping(value="/admin/downloadCourse")
	public void downloadCourse(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String[] headers = {"课程ID","课程代码","课程名称","课程属性","课程学分","课程学期","课程时间","课程周次","课程班级","课程老师","课程地址"};
		DownLoadMessage<Course> download = new DownLoadMessage<>(headers, crs_list, response);
		download.download();
	}
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>添加选课<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/admin/ElectiveCourse",method= {RequestMethod.GET})
	public ModelAndView electiveCourse1(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("admin/ElectiveCourse");
		mav.addObject("username", username);
		mav.addObject("stu_num", stu_list.size());
		mav.addObject("crs_num", crs_list.size());
		mav.addObject("tcr_num", tcr_list.size());
		return mav;
	}
	@RequestMapping(value="/admin/ElectiveCourse",method= {RequestMethod.POST})
	public ModelAndView electiveCourse(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("redirect:/admin/ElectiveCourse");
		String crs_name = new String(request.getParameter("crs_name").getBytes("ISO-8859-1"),"UTF-8");
		String crs_code = new String(request.getParameter("crs_code").getBytes("ISO-8859-1"),"UTF-8");
		String crs_time = new String(request.getParameter("crs_time").getBytes("ISO-8859-1"),"UTF-8");
		String crs_frequency = new String(request.getParameter("crs_frequency").getBytes("ISO-8859-1"),"UTF-8");
		Integer crs_num = Integer.parseInt(request.getParameter("crs_num"));
		String crs_address = new String(request.getParameter("crs_address").getBytes("ISO-8859-1"),"UTF-8");
		String crs_teacher = new String(request.getParameter("crs_teacher").getBytes("ISO-8859-1"),"UTF-8");
		String crs_semester = new String(request.getParameter("crs_semester").getBytes("ISO-8859-1"),"UTF-8");
		String crs_attribute = new String(request.getParameter("crs_attribute").getBytes("ISO-8859-1"),"UTF-8");
		Integer crs_credit = Integer.parseInt(request.getParameter("crs_credit"));
		coursemapper.addElecctiveCourse( crs_code, crs_name,crs_attribute,crs_credit,crs_semester, crs_time,crs_frequency, crs_num, crs_teacher, crs_address);
		return username==null?new ModelAndView("redirect:/login"):mav;
	}
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>导入信息<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/admin/uploadMessage",method = {RequestMethod.GET})
	public ModelAndView uploadMessage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("admin/uploadMessage");
		mav.addObject("username",username);
		mav.addObject("stu_num", stu_list.size());
		mav.addObject("trc_num",tcr_list.size());
		return mav;
	}
	@RequestMapping(value="/admin/uploadMessage",method = {RequestMethod.POST})
	public ModelAndView uploadMessage1(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("redirect:/admin/uploadMessage");
		return mav;
	}
	/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>登出<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
	@RequestMapping(value="/admin/logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("redirect:/login");
		username = null;
		return mav;
	}
	
}
