package servlet;

import connection.MongoDBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");

        //获得表单数据
        String name = request.getParameter("userName");
        String pwd = request.getParameter("password");
        String cfm = request.getParameter("confirmcode");
        String remember = request.getParameter("remember");

        org.bson.Document logininfo = new org.bson.Document("userName", name).append("password", pwd);


        //get confirmcode by session
        HttpSession cfmsession = request.getSession();
        String cfmcode = (String) cfmsession.getAttribute("confirmcode");


        Cookie ck = new Cookie("userame", name);


        //处理业务逻辑
        //connect to db
        MongoDBConnection con = new MongoDBConnection();
        con.mongoDBJDBC();

        //分发转向
        if (!con.checkinfo(logininfo)) {
            response.getWriter().write("password or username is wrong 3 second jump!");
            response.setHeader("refresh", "3;url=login_page.html");

        } else {
            if (!cfm.equals(cfmcode)) {
                response.getWriter().write("confirm code is wrong 3 second jump!");
                response.setHeader("refresh", "3;url=login_page.html");
            } else {

                /*if (remember!=null){
                    ck.setPath("/");
                    ck.setMaxAge(Integer.MAX_VALUE);
                }else{
                    ck.setMaxAge(0);
                }
                response.addCookie(ck);*/

                response.getWriter().write("登录成功!!:" + name);
                response.setHeader("refresh", "1;url=home_page.html");
            }
        }

        /*    System.out.println(name);*/
        /*System.out.println(pwd);
        System.out.println(cfm);*/

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
