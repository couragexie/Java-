package com.jay.sell.util;

import java.util.Random;

/**
 * @program: sell
 * @description: 生成唯一id工具
 * @author: Jay
 * @create: 2020-03-18 21:44
 **/

public class GenerateUniqueIdUtils {

    /*时间 + 随机数*/
    public static String generateUniqueIdOfOrder() {
        Random random = new Random();
        return System.currentTimeMillis() + String.valueOf(random.nextInt(9000000) + 1000000);
    }

}
