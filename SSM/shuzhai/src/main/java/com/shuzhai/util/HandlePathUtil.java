package com.shuzhai.util;

import java.io.File;

/**
 * @program: shuzhai
 * @description: handle the files path
 * @author: Jay
 * @create: 2019-10-05 11:52
 **/

public class HandlePathUtil {

    /**
     *
     * @Author: jay
     * @Description:  处理用户上传图片的路径
     * fileClass:
     *      0:存放 user 图片
     *      1:存放 book 图片
     * @Date 2019/10/13 17:08
     **/
    public static String handlePicPath(String fileName, int fileClass){
        String uUIDFileName = UUIDUtil.getUUIDFileName(fileName);
        String storePath = "/usr/local/tomcat/imgs/" + fileClassify(fileClass);
        //File file = new File(storePath);
        return  storePath + "/" + uUIDFileName;
    }
    // 处理用户上传文件夹分类
    private static String fileClassify(int classify){
        String folder = "";
        switch(classify){
            case 0: folder = "users"; break;
            case 1: folder =  "books"; break;
        }
        return folder;
    }


    /**
     *
     * @Author: jay
     * @Description: 处理图片的访问显示路径，将图片的存储路径修改为用户的访问显示的图片 URL
     *
     * @Date 2019/10/13 17:09
     **/
    public static String storePathTransformUrl(String storePath){
        if(StringUtil.isEmpty(storePath))
            return storePath;
        String  sub = "/img";
        String subUrl = storePath.substring(storePath.indexOf(sub));
        System.out.println("subUrl：" + subUrl);
        String url = "http://49.234.200.228:8080" + subUrl;
        return url;
    }

    public static String getPicNameFromPath(String storePath){
        int index = storePath.lastIndexOf("/");
        String picName = storePath.substring(index + 1);
        System.out.println("文件名：" + picName);
        return picName;
    }


}
