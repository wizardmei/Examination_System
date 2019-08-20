package com.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.system.po.Course;

public interface CourseMapper {

	public List<Course> showCourse();
	
	public List<Course> stu_showCourse(@Param("crs_class")String crs_class);
	
	public List<Course> pageCourse(@Param("start")Integer start,@Param("pagesize")Integer pagesize);
	
	public List<Course> stu_pageCourse(@Param("start")Integer start,@Param("pagesize")Integer pagesize,@Param("crs_name")String crs_name,@Param("crs_class")String crs_class);
	
	public List<Course> admin_pageCourse(@Param("start")Integer start,@Param("pagesize")Integer pagesize,@Param("crs_name")String crs_name);
	
	public void removeCourse(@Param("crs_id")Integer userid);
	
	public Course findById(@Param("crs_id")Integer userid);
		
	public void editCourse(@Param("crs_code")String crs_code,@Param("crs_name")String crs_name,@Param("crs_attribute")String crs_attribute,@Param("crs_credit")Integer crs_credit,@Param("crs_semester")String crs_semester,@Param("crs_time")String crs_time,@Param("crs_frequency")String crs_frequency,@Param("crs_class")String crs_class,@Param("crs_teacher")String crs_teacher,@Param("crs_address")String crs_address);
	
	public void addCourse(@Param("crs_code")String crs_code,@Param("crs_name")String crs_name,@Param("crs_attribute")String crs_attribute,@Param("crs_credit")Integer crs_credit,@Param("crs_semester")String crs_semester,@Param("crs_time")String crs_time,@Param("crs_frequency")String crs_frequency,@Param("crs_class")String crs_class,@Param("crs_teacher")String crs_teacher,@Param("crs_address")String crs_address);

	public List<Course> selectCourse(@Param("crs_name")String crs_name);
	
	public List<Course> stu_selectCourse(@Param("crs_name")String crs_name,@Param("crs_class")String crs_class);
	
	public List<Course> schedule_Card(@Param("crs_class")String crs_class,@Param("crs_semester")String crs_semester);
	
	public List<Course> showCrs_semester(@Param("crs_class")String crs_class);
}
