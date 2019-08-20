package com.system.mapper;

import org.apache.ibatis.annotations.Param;

import com.system.po.UserLogin;

public interface UserLoginMapper {
	public UserLogin selectByUserName(@Param("username")String username,@Param("password")String password) ;
	
	public UserLogin findByName(@Param("username")String username);
	
	public UserLogin findUser(@Param("userid")Integer userid,@Param("username")String username);
	
	public void resetUser(@Param("userid")Integer userid,@Param("username")String username,@Param("passwd")String passwd,@Param("role")Integer role);
	
	public void resetPasswd(@Param("username")String username,@Param("newpasswd")String newpasswd);
	
	public void createUser(@Param("username")String username,@Param(value="passwd")String passwd,@Param("role")Integer role);
	
	public void deleteUser(@Param("username")String account);
}
