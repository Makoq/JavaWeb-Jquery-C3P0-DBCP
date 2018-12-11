package servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "forwardServlet")
public class forwardServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String str = "sds";

        System.out.println("我告诉你谁有钱");
        //setAttribute把非表单数据添加到request
        request.setAttribute("s", str);

        //请求转发到receiveForwardServlet,转发不能跳转到其他对象，but重定向可以
        request.getRequestDispatcher("/receiveforward").forward(request, response);

        //请求包含,没有发生转发，是把两个资源当做一个资源使用，所以顺序也是先执行完本servlet后执行include的servlet
        request.getRequestDispatcher("/receiveforward").include(request, response);

        System.out.println("钱搞到了");
    }
}
