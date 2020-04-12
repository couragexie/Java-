package action;
/*
 * ��ȡ�ϴ����鼮
 * ���� apche  �ϴ�jar��
 * ����Ӧ���ϴ�ҳ��� form  ����Ҫ��� enctype="multipart/form-data" �������
 * */


import Dao.IOBookDao;
import Domain.Book;
import Util.UploadUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/StoreBookServlet")
public class StoreBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ///����������������
        //System.out.println("���ʳɹ�");
//        response.setContentType("text/plain; charset=UTF-8");
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");

        try {
            // ���������ļ�������
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            // �����ļ������࣬���빤����
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            // ���� request ���󣬷��� list ����
            List<FileItem> fileItems = servletFileUpload.parseRequest(request);

            Map<String, String> map = new HashMap<>();

            Book book = new Book();
            String url = "";

            for (FileItem fileItem : fileItems) {
                // �ж��ļ�����ͨ����ļ���
                if (fileItem.isFormField()) {
                    // ��ͨ����
                    // ��ȡ�� name �� value ֵ
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");

                    System.out.println(name + "      " + value);
                    map.put(name, value);
                } else {
                    // �ļ���
                    String name = fileItem.getName();
                    // �ж��ļ���Ϊ��
                    if (name != null && !"".equals(name)) {
                        // ��ȡ�ļ�������
                        InputStream in = fileItem.getInputStream();
                        // ��ȡ�ļ��ϴ��ľ���·��
                        //String path = request.getSession().getServletContext().getRealPath("/img");
                        //String path = this.getServletContext().getRealPath("/upload");
                        //path = path.substring()
                        String path = "D:\\Tomcat\\upload";
                        File file = new File(path);

                        System.out.println(file.getAbsolutePath());
                        String fileName = UploadUtil.getUUIDFileName(name);

                        System.out.println(fileName);
                        url = path + "\\" + fileName;
                        System.out.println(url);
                        //��ȡ�����, �������Ŀ��Ϊ url.
                        OutputStream os = new FileOutputStream(url);
                        // ����ȡ�ϴ��������Խ� �����
                        int len = 0;
                        byte[] b = new byte[1024];

                        while ((len = in.read(b)) != -1) {
                            os.write(b, 0, len);
                        }

                        // �ر����롢�����
                        in.close();
                        os.close();
                    } // close if-else

                }
            }
            // ʵ���� Book ��
            book.setPicture(url);
            book.setBookName(map.get("bookName"));
            book.setAuthor(map.get("author"));
            book.setPrice(map.get("price"));
            book.setPress(map.get("press"));
            book.setClassify(Integer.parseInt(map.get("classifyID")));
            book.setIntro(map.get("intro"));
            System.out.println(book);

            // ʵ���� IOBookDao �����ݿ�д������
            IOBookDao ioBookDao = new IOBookDao();
            int ok = ioBookDao.storeBook(book);
            // ��֤�Ƿ��ϴ��ɹ�
            if (ok != -1) {
                request.setAttribute("msg", "�ϴ��ɹ�");
                System.out.println("�ϴ��ɹ�");
                request.getRequestDispatcher("backIndex.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "�ϴ�ʧ��");
                System.out.println("�ϴ�ʧ��");
                request.getRequestDispatcher("backIndex.jsp").forward(request, response);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    private void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


}
