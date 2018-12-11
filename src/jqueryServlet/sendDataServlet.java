package jqueryServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "sendDataServlet")
public class sendDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8"); //text/html

        String method=request.getMethod();
        System.out.println(method);

        //获得表单数据
        String us=request.getParameter("username");
        String pwd=request.getParameter("password");

        //响应数据
        String jsondata="{\"message\":\"成功了\"}";

        response.getWriter().write(jsondata);

        System.out.println(us);
        System.out.println(pwd);



    }
}
