package servlet.request;

//import com.sun.javafx.collections.MappingChange;

import entity.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "reqFormServlet")
public class reqFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        //获取各种标签的values
        // getAllParameters(request);


        //枚举form表单的name/value
        // EnumerationNameValues(request);

        //利用Map泛型
        // mapMethod(request);


        try {
            User usr = new User();

            System.out.println("before" + usr.getUserName());

            //用到一个jar,直接用一行实现mapMethod(request);
            BeanUtils.populate(usr, request.getParameterMap());

            System.out.println("before" + usr.getUserName());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void mapMethod(HttpServletRequest request) {
        User usr = new User();
        System.out.println("before" + usr);

        Map<String, String[]> map = request.getParameterMap();

        for (Map.Entry<String, String[]> m : map.entrySet()) {

            String name = m.getKey();
            String[] value = m.getValue();


            try {
                //创建属性描述器
                PropertyDescriptor pd = new PropertyDescriptor(name, User.class);
                //得到setter
                Method setter = pd.getWriteMethod();

                if (value.length == 1) {
                    setter.invoke(usr, value[0]);
                } else {
                    setter.invoke(usr, (Object) value);

                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        System.out.println("after" + usr);
    }


    private void EnumerationNameValues(HttpServletRequest request) {
        Enumeration e = request.getParameterNames();
        while (e.hasMoreElements()) {

            System.out.println(e.nextElement());
        }
    }

    private void getAllParameters(HttpServletRequest request) {
        String name = request.getParameter("userName");
        System.out.println(name);
        System.out.println("sdsd");

        String password = request.getParameter("password");
        String confirmcode = request.getParameter("confirmcode");

        String sex = request.getParameter("sex");
        String sel = request.getParameter("sel");

        String[] hobby = request.getParameterValues("hobby");


        System.out.println(confirmcode);
        System.out.println(name);
        System.out.println(password);
        System.out.println(sel);
        System.out.println(sex);

        for (int i = 0; hobby != null && i < hobby.length; i++) {
            System.out.println(hobby[i]);
        }
    }


}
