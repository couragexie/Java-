package Util;

import java.io.File;

public class Test {

    public static void main(String[] args) {

        String path = "D:\\Tomcat\\upload";

        File file = new File(path);

        System.out.println(file.getAbsolutePath());


    }

}
