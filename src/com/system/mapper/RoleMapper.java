package com.system.mapper;

import org.apache.ibatis.annotations.Param;

import com.system.po.Role;

public interface RoleMapper {
	public Role findById(@Param("id")Integer id);
}
