package servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "sessionServlet")
public class sessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //获取客户端最后访问时间
        response.setContentType("text/html:charset=UTF-8");

        //获得客户端所有cookie
        Cookie[] cookies = request.getCookies();
        PrintWriter out = response.getWriter();

        for (int i = 0; i < cookies.length && cookies != null; i++) {

            if ("lastAccessTime".equals(cookies[i].getName())) {

                long l = Long.parseLong(cookies[i].getValue());

                out.write("you last access time :" + new Date(l).toLocaleString());

            }

        }

        //创建Cookie，并把信息返回客户端

        Cookie ck = new Cookie("lastAccessTime", System.currentTimeMillis() + "");

        ck.setMaxAge(60);

        //把cookie写回浏览器

        response.addCookie(ck);


    }
}
