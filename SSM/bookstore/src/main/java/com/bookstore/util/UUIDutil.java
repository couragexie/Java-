package com.bookstore.util;

import java.util.UUID;

public class UUIDutil {

    public static String getUUID(String fileName) {
        int index = fileName.indexOf(".");
        String extension = fileName.substring(index);
        //System.out.println(extension);
        String newName = UUID.randomUUID().toString().replace("-", "") + extension;
        return newName;
    }

}
