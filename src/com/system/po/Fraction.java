package com.system.po;

public class Fraction {

	private Integer userid;
	
	private String crs_code;
	
	private String crs_name;
	
	private Integer crs_credit;

	private String crs_attribute;
	
	private Integer mark;

	public String getCrs_name() {
		return crs_name;
	}

	public void setCrs_name(String crs_name) {
		this.crs_name = crs_name;
	}

	public Integer getCrs_credit() {
		return crs_credit;
	}

	public void setCrs_credit(Integer crs_credit) {
		this.crs_credit = crs_credit;
	}

	public String getCrs_attribute() {
		return crs_attribute;
	}

	public void setCrs_attribute(String crs_attribute) {
		this.crs_attribute = crs_attribute;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getCrs_code() {
		return crs_code;
	}

	public void setCrs_code(String crs_code) {
		this.crs_code = crs_code;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}
	
	
	
}
