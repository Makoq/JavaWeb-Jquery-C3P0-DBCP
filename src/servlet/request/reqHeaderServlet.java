package servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "reqHeaderServlet")
public class reqHeaderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //请求消息头方法

        //拿到客户端浏览器类型
        //String req=request.getHeader("User-Agent");
        //System.out.println(req);


        //请求头所有的name&value
        Enumeration name = request.getHeaderNames();

        while (name.hasMoreElements()) {
            String n = (String) name.nextElement();
            System.out.println(n + ":" + request.getHeader(n));

        }


    }
}
