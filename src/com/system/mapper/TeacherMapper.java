package com.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.system.po.Teacher;

public interface TeacherMapper {

	public List<Teacher> showTeacher();
	
	public Teacher findByUsername(@Param("username")String username);
	
	public List<Teacher> pageCourse(@Param("start")Integer start,@Param("pagesize")Integer pagesize);

	public void removeTeacher(@Param("tcr_id")Integer userid);
	
	public Teacher findById(@Param("tcr_id")Integer userid);


}
