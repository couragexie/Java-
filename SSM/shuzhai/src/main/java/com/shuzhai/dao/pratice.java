package com.shuzhai.dao;

/**
 * @program: shuzhai
 * @description: 源码学习测试
 * @author: Jay
 * @create: 2020-02-22 16:31
 **/

public class pratice {

    public static void main(String[] args) {

        String str1 = "helloWorld";
        String str2 = "helloWorld";

        String str3 = "h,e,ll,o";
        String[] ss = str3.split(",");


        Integer.parseInt(str1);
        // for(String s1 : ss )
        //System.out.println(s1);
        System.out.println(String.join("*", str1, str2));

    }


}
