package com.manage.domain;

public class Teacher {
	private String tid;
	private String name;
	private String password;
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", name=" + name + ", password=" + password + "]";
	}
	
}
