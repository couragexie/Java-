package com.manage.domain;

public class StudentInfo {
    private String sId;
    private String name;
    private String major;
    private int age;
    private String sex;
    private int class_;
    private String position;
    private String dormitory;
    private String phoneNum;
    private String email;

    @Override
    public String toString() {
        return "StudentInfo [sId=" + sId + ", name=" + name + ", major=" + major + ", age=" + age + ", sex=" + sex
                + ", class_=" + class_ + ", position=" + position + ", dormitory=" + dormitory + ", phoneNum="
                + phoneNum + ", email=" + email + "]";
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getClass_() {
        return class_;
    }

    public void setClass_(int class_) {
        this.class_ = class_;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
