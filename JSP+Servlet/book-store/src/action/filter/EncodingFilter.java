package action.filter;
/*
* 过滤中文字符集
* 需要在 web.xml 配置相应的操作
* */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

public class EncodingFilter implements Filter {

    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //System.out.println("经过过滤");
        // 处理请求字符
        request.setCharacterEncoding("UTF-8");
        // 传递给下一个过滤器，
        response.setCharacterEncoding("UTF-8");
        //response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(request, response);
        // 处理响应字符集，若相关 servlet 已有
        response.setContentType("text/html;charset=UTF-8");
    }

    public void init(FilterConfig config) throws ServletException {
//        if(config.getInitParameter("newCharSet") != null){
//            setNewCharSet(config.getInitParameter("newCharSet"));
//        }else
//            setNewCharSet("UTF-8");

    }

}
