package com.shuzhai.service.Imp;

import org.junit.Test;

/**
 * @program: shuzhai
 * @description: 其他测试
 * @author: Jay
 * @create: 2019-10-13 16:36
 **/

public class OtherTest {

    @Test
    public void test(){
        String str = "/usr/local/tomcat/imgs/books";
        String sub = "/imgs";
        System.out.println(str.indexOf(sub));
        System.out.println(str.substring(str.indexOf(sub)));

    }


}
