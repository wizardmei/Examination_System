package com.system.po;


public class Student {
	
	private Integer userid;
	
	private String username;
	
	private String sex;
	
	private String birthyear;
	
	private String gradeyear;
	
	private String college;
	
	private String account;
	
	private String passwd;
	
	private String stu_class;

	public Student() {}
	
	
	
	public Student(Integer userid, String username, String sex, String birthyear, String gradeyear, String college,
			String account, String passwd, String stu_class) {
		super();
		this.userid = userid;
		this.username = username;
		this.sex = sex;
		this.birthyear = birthyear;
		this.gradeyear = gradeyear;
		this.college = college;
		this.account = account;
		this.passwd = passwd;
		this.stu_class = stu_class;
	}



	public String getBirthyear() {
		return birthyear;
	}



	public void setBirthyear(String birthyear) {
		this.birthyear = birthyear;
	}



	public String getGradeyear() {
		return gradeyear;
	}



	public void setGradeyear(String gradeyear) {
		this.gradeyear = gradeyear;
	}



	public String getStu_class() {
		return stu_class;
	}

	public void setStu_class(String stu_class) {
		this.stu_class = stu_class;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}	
	
}
