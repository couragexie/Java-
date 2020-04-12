package action.filter;
/*
 * ���������ַ���
 * ��Ҫ�� web.xml ������Ӧ�Ĳ���
 * */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

public class EncodingFilter implements Filter {

    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //System.out.println("��������");
        // ���������ַ�
        request.setCharacterEncoding("UTF-8");
        // ���ݸ���һ����������
        response.setCharacterEncoding("UTF-8");
        //response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(request, response);
        // ������Ӧ�ַ���������� servlet ����
        response.setContentType("text/html;charset=UTF-8");
    }

    public void init(FilterConfig config) throws ServletException {
//        if(config.getInitParameter("newCharSet") != null){
//            setNewCharSet(config.getInitParameter("newCharSet"));
//        }else
//            setNewCharSet("UTF-8");

    }

}
