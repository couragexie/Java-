package com.shuzhai.util;

import java.io.File;

/**
 * @program: shuzhai
 * @description: 处理文件类
 * @author: Jay
 * @create: 2019-10-18 12:58
 **/

public class HandleFileUtil {

    /**
     *
     * @Author: jay
     * @Description: 删除文件操作
     * @Date 2019/10/18 12:59
     **/
    public static boolean deleteFileByStorePath(String storePath){
        if(storePath == null)
            return false;

        File file = new File(storePath);
        boolean flag = file.exists();
        System.out.println(file.getAbsolutePath());
        if(!flag)
            return false;
        file.delete();
        System.out.println("删除成功!!!");
        return true;
    }

}
