package action;
/*
* 获取上传的书籍
* 利用 apche  上传jar包
* 在相应的上传页面的 form  表单中要添加 enctype="multipart/form-data" 这个属性
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
        ///处理中文乱码问题
        //System.out.println("访问成功");
//        response.setContentType("text/plain; charset=UTF-8");
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");

        try {
            // 创建磁盘文件工厂类
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            // 创建文件解析类，传入工厂类
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            // 解析 request 请求，返回 list 集合
            List <FileItem> fileItems = servletFileUpload.parseRequest(request);

            Map<String, String> map = new HashMap<>();

            Book book = new Book();
            String url = "";

            for(FileItem fileItem : fileItems){
                // 判断文件是普通项还是文件项
                if(fileItem.isFormField()){
                    // 普通表单项
                    // 获取表单 name 和 value 值
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");

                    System.out.println(name + "      " + value);
                    map.put(name, value);
                }else{
                    // 文件项
                    String name = fileItem.getName();
                    // 判断文件不为空
                    if(name != null && !"".equals(name)){
                        // 获取文件输入流
                        InputStream in = fileItem.getInputStream();
                        // 获取文件上传的绝对路径
                        //String path = request.getSession().getServletContext().getRealPath("/img");
                        //String path = this.getServletContext().getRealPath("/upload");
                        //path = path.substring()
                        String path = "D:\\Tomcat\\upload";
                        File file = new File(path);

                        System.out.println(file.getAbsolutePath());
                        String fileName = UploadUtil.getUUIDFileName(name);

                        System.out.println(fileName);
                        url = path + "\\" +  fileName;
                        System.out.println(url);
                        //获取输出流, 输出流的目的为 url.
                        OutputStream os = new FileOutputStream(url);
                        // 将获取上传输入流对接 输出流
                        int len = 0;
                        byte [] b = new byte[1024];

                        while((len = in.read(b)) != -1){
                            os.write(b, 0, len);
                        }

                        // 关闭输入、输出流
                        in.close();
                        os.close();
                    } // close if-else

                }
            }
            // 实例化 Book 类
            book.setPicture(url);
            book.setBookName(map.get("bookName"));
            book.setAuthor(map.get("author"));
            book.setPrice(map.get("price"));
            book.setPress(map.get("press"));
            book.setClassify(Integer.parseInt(map.get("classifyID")));
            book.setIntro(map.get("intro"));
            System.out.println(book);

            // 实例化 IOBookDao 向数据库写入数据
            IOBookDao ioBookDao = new IOBookDao();
            int ok =ioBookDao.storeBook(book);
            // 验证是否上传成功
            if(ok != -1){
                request.setAttribute("msg", "上传成功");
                System.out.println("上传成功");
                request.getRequestDispatcher("backIndex.jsp").forward(request,response);
            }else{
                request.setAttribute("msg", "上传失败");
                System.out.println("上传失败");
                request.getRequestDispatcher("backIndex.jsp").forward(request,response);
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    private void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }



}
