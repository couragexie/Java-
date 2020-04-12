package com.shuzhai.domain;

import org.hibernate.validator.constraints.NotEmpty;

import java.sql.Timestamp;

public class User {
    @NotEmpty
    private Integer userID;
    private String telephone;
    private String password;
    private String email;
    private Timestamp registerTime;

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", registerTime=" + registerTime +
                '}';
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
