package servlet.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "refreshServlet")
public class refreshServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*response.setHeader("refresh", "1");一秒钟刷新一次
        Random r=new Random();
        response.getOutputStream().write(r.nextInt());*/

        response.setContentType("text/html;UTF-8");
        response.getWriter().write("3 second jump!");
        response.setHeader("refresh", "3;url=home_page.html");

    }
}
