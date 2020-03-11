package com.manage.domain;

public class Student{

	private String sId;
	//private String account;
	private String password;
	private String name;
	
	public String getsId() {
		return sId;
	}
	public void setsId(String i) {
		this.sId = i;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", password=" + password + ", name=" + name + "]";
	}
	
}
