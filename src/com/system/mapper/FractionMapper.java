package com.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.system.po.Fraction;


public interface FractionMapper {

	public List<Fraction> showMark(@Param("userid")Integer userid);
	
	public List<Fraction> selectMark(@Param("userid")Integer userid,@Param("crs_name")String crs_name);
	
	public List<Fraction> pageMark(@Param("start")Integer start,@Param("pagesize")Integer pagesize,@Param("userid")Integer userid);
	
	public List<Fraction> pageselectMark(@Param("start")Integer start,@Param("pagesize")Integer pagesize,@Param("userid")Integer userid,@Param("crs_name")String crs_name);
	
	public Fraction isEmpty(@Param("userid")Integer userid,@Param("crs_code")String crs_code);
}
