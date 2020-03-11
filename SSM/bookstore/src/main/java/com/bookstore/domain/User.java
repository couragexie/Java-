package com.bookstore.domain;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;
// 需要实现 implements Serializable 接口 才能被 jdbcTemplate 实现整个对象插入
public class User  {
    private Integer id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    private String telephone;
    

	public User(){}

    public User(String username, String password, String telephone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", telephone=" + telephone
				+ "]";
	}
}
