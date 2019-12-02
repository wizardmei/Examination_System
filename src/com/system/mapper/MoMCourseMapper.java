package com.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.system.po.MoMCourse;

public interface MoMCourseMapper {

	public void addInfo(@Param("userid")Integer userid,@Param("crs_code")String crs_code,@Param("crs_attribute")String crs_attribute);
	
	public List<MoMCourse> electivecourses(@Param("userid")Integer userid,@Param("crs_attribute")String crs_attribute); 
	
}
