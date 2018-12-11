package TemplateWEB.servlet;

import TemplateWEB.domain.Users;
import TemplateWEB.service.UserServiceImpl;
import TemplateWEB.serviceimpl.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@WebServlet(name = "regServlet")
public class regServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        Users users=new Users();
        //获取表单
        try {

           //ConvertUtils.register(new DateLocaleConverter(),Date.class);//封装成本地格式的date
            BeanUtils.populate(users,request.getParameterMap());


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //处理业务
        UserService userService=new UserServiceImpl();
        try {
            userService.register(users);

        } catch (Exception e) {
            e.printStackTrace();
        }


        //分发转向

        response.getWriter().write("注册成功，1秒后跳转到主页！");
        response.setHeader("Refresh","1;url=/home_page.html");

    }
}
