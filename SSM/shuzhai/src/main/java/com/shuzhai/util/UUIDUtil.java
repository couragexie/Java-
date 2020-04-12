package com.shuzhai.util;

import java.util.UUID;

public class UUIDUtil {

    public static String getUUIDFileName(String fileName) {
        int index = fileName.lastIndexOf(".");
        String extension = fileName.substring(index);
        String uUIDFileName = UUID.randomUUID().toString().replace("-", "")
                + extension;
        return uUIDFileName;
    }


}
