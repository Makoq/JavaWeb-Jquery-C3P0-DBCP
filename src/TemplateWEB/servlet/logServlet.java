package TemplateWEB.servlet;

import TemplateWEB.domain.Users;
import TemplateWEB.service.UserServiceImpl;
import TemplateWEB.serviceimpl.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "logServlet")
public class logServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        Users us=new Users();

        try {

            BeanUtils.populate(us,request.getParameterMap());


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //处理业务
        Users users=new Users();
        UserService userService=new UserServiceImpl();
        try {
            users=userService.login(us);

        } catch (Exception e) {
            e.printStackTrace();
        }


        //分发转向

        //request.getRequestDispatcher("home.jsp").forward(request,response);
        if(users!=null) {
            response.getWriter().write("登陆成功，欢迎："+request.getParameter("username")+"<br/>"+"1秒后跳转到主页！");

            response.setHeader("Refresh", "1;url=/home_page.html");
        }else{
            response.getWriter().write("用户名或密码有误，请重新登陆！");

            response.setHeader("Refresh", "1;url=log.jsp");
        }



    }
}
