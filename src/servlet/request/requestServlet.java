package servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestServlet")
public class requestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //请求消息行方法

        //获取请求方式GET/POST
        System.out.println(request.getMethod());

        //获取完整地址，eg:localhost:8081/req
        System.out.println(request.getRequestURL());

        //获取localhost:8081后的路径地址
        System.out.println(request.getRequestURI());

        //获取请求参数，eg:url?name=username&password=123456
        System.out.println(request.getQueryString());

        //获取项目名。eg:/myWebXv1.0
        System.out.println(request.getContextPath());


    }
}
