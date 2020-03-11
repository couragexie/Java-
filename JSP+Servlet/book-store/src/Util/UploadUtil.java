package Util;
import java.util.UUID;

/*
* 文件上传工具类
* 为文件分配唯一的文件名，防止重复导致的问题
* */
public class UploadUtil {

    public static String getUUIDFileName(String fileName){
        int index = fileName.lastIndexOf(".");
        String extension = fileName.substring(index);

        //UUID.randomUUID() 获取随机字符串， 加上 toString() 转换成字符,再将字符集中的“-” ，替换掉
        String uuidName = UUID.randomUUID().toString().replaceAll("-","") + extension;

        return uuidName;
    }

}
