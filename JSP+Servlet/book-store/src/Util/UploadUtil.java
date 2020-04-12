package Util;

import java.util.UUID;

/*
 * �ļ��ϴ�������
 * Ϊ�ļ�����Ψһ���ļ�������ֹ�ظ����µ�����
 * */
public class UploadUtil {

    public static String getUUIDFileName(String fileName) {
        int index = fileName.lastIndexOf(".");
        String extension = fileName.substring(index);

        //UUID.randomUUID() ��ȡ����ַ����� ���� toString() ת�����ַ�,�ٽ��ַ����еġ�-�� ���滻��
        String uuidName = UUID.randomUUID().toString().replaceAll("-", "") + extension;

        return uuidName;
    }

}
