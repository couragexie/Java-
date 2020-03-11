package com.shuzhai.domain;

import java.math.BigDecimal;
import java.sql.Date;

public class UserInfo {
    private Integer id;
    private Integer userId;
    private String userName;
    private int age;
    private String sex;
    private Date birthday;   // 此处可能有bug
    private String intro;
    private String profileImg;
    private BigDecimal balance;
    private String region;
    private int collectionNum;
    private int followNum;
    private int fansNum;
    private int goodsNum;

    public UserInfo() {
    }

    public UserInfo(Integer userID, String userName , BigDecimal balance, String region, int collectionNum, int followNum, int fansNum, int goodsNum) {
        this.userId = userID;
        this.userName = userName;
        this.balance = balance;
        this.region = region;
        this.collectionNum = collectionNum;
        this.followNum = followNum;
        this.fansNum = fansNum;
        this.goodsNum = goodsNum;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", intro='" + intro + '\'' +
                ", profileImg='" + profileImg + '\'' +
                ", balance=" + balance +
                ", region='" + region + '\'' +
                ", collectionNum=" + collectionNum +
                ", followNum=" + followNum +
                ", fansNum=" + fansNum +
                ", goodsNum=" + goodsNum +
                '}';
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(int collectionNum) {
        this.collectionNum = collectionNum;
    }

    public int getFollowNum() {
        return followNum;
    }

    public void setFollowNum(int followNum) {
        this.followNum = followNum;
    }

    public int getFansNum() {
        return fansNum;
    }

    public void setFansNum(int fansNum) {
        this.fansNum = fansNum;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }
}
