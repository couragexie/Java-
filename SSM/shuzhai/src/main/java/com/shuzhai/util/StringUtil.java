package com.shuzhai.util;

/**
 * @program: shuzhai
 * @description: 字符串处理
 * @author: Jay
 * @create: 2019-10-13 19:53
 **/

public class StringUtil {

    /**
     * @Author: jay
     * @Description: 判断字符串是否为空
     * @Date 2019/10/13 19:55
     **/
    public static boolean isEmpty(String str) {
        if (str != null && str.length() != 0)
            return false;
        return true;
    }


}
