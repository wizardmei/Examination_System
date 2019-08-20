package com.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.system.po.Student;

public interface StudentMapper {

	public List<Student> showStudent();	
	
	public List<Student> pageStudent(@Param("start")Integer start,@Param("pagesize")Integer pagesize);
	
	public void removeStudent(@Param("userid")Integer userid);
	
	public Student findById(@Param("userid")Integer userid);
		
	public void editStudent(@Param("userid")Integer userid,@Param("username")String username,@Param("sex")String sex,@Param("birthyear")String birthyear,@Param("gradeyear")String gradeyear,@Param("college")String college,@Param("stu_class")String stu_class,@Param("account")String account,@Param("passwd")String passwd);
	
	public void addStudent(@Param("userid")Integer userid,@Param("username")String username,@Param("sex")String sex,@Param("birthyear")String birthyear,@Param("gradeyear")String gradeyear,@Param("college")String college,@Param("stu_class")String stu_class,@Param("account")String account,@Param("passwd")String passwd);

	public List<Student> selectStudent(@Param("username")String username);
	
	public List<Student> stu_pageStudent(@Param("start")Integer start,@Param("pagesize")Integer pagesize,@Param("username")String username);
	
}
