package jquery跨域;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "KuaYuServlet")
public class KuaYuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //application/json;charset:utf-8
        response.setContentType("text/html;charset=utf-8");
            //获得请求参数
        String callback=request.getParameter("callback");
            //生成json
        String jsonStr="{\"success\";\"用户操作成功\",\"info\";\"提示信息\"}";
            //通过tomcat1执行showdata
        response.getWriter().print(callback+"("+jsonStr+")");

    }
}
