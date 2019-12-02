package com.system.po;

public class Course {

	private Integer crs_id;
	
	private String crs_code;
	
	private String crs_name;
	
	private String crs_time;
	
	private String crs_class;
	
	private String crs_frequency;
	
	private String crs_teacher;
	
	private String crs_address;
	
	private String crs_semester;
	
	private String crs_attribute;
	
	private Integer crs_credit;
	
	private Integer crs_num;
	
	public Course() {
		
	}

	public Course( String crs_code, String crs_name,String crs_attribute,
			Integer crs_credit, String crs_semester, String crs_time, String crs_frequency,String crs_class,
			 String crs_teacher, String crs_address, 
			 Integer crs_num) {
		this.crs_code = crs_code;
		this.crs_name = crs_name;
		this.crs_time = crs_time;
		this.crs_class = crs_class;
		this.crs_frequency = crs_frequency;
		this.crs_teacher = crs_teacher;
		this.crs_address = crs_address;
		this.crs_semester = crs_semester;
		this.crs_attribute = crs_attribute;
		this.crs_credit = crs_credit;
		this.crs_num = crs_num;
	}

	public Integer getCrs_num() {
		return crs_num;
	}

	public void setCrs_num(Integer crs_num) {
		this.crs_num = crs_num;
	}

	public String getCrs_attribute() {
		return crs_attribute;
	}

	public void setCrs_attribute(String crs_attribute) {
		this.crs_attribute = crs_attribute;
	}


	public Integer getCrs_credit() {
		return crs_credit;
	}

	public void setCrs_credit(Integer crs_credit) {
		this.crs_credit = crs_credit;
	}

	public String getCrs_frequency() {
		return crs_frequency;
	}

	public void setCrs_frequency(String crs_frequency) {
		this.crs_frequency = crs_frequency;
	}

	public String getCrs_semester() {
		return crs_semester;
	}

	public void setCrs_semester(String crs_semester) {
		this.crs_semester = crs_semester;
	}

	public Integer getCrs_id() {
		return crs_id;
	}

	public void setCrs_id(Integer crs_id) {
		this.crs_id = crs_id;
	}

	public String getCrs_code() {
		return crs_code;
	}

	public void setCrs_code(String crs_code) {
		this.crs_code = crs_code;
	}

	public String getCrs_name() {
		return crs_name;
	}

	public void setCrs_name(String crs_name) {
		this.crs_name = crs_name;
	}

	public String getCrs_time() {
		return crs_time;
	}

	public void setCrs_time(String crs_time) {
		this.crs_time = crs_time;
	}

	public String getCrs_class() {
		return crs_class;
	}

	public void setCrs_class(String crs_class) {
		this.crs_class = crs_class;
	}

	public String getCrs_teacher() {
		return crs_teacher;
	}

	public void setCrs_teacher(String crs_teacher) {
		this.crs_teacher = crs_teacher;
	}

	public String getCrs_address() {
		return crs_address;
	}

	public void setCrs_address(String crs_address) {
		this.crs_address = crs_address;
	}
	
}
