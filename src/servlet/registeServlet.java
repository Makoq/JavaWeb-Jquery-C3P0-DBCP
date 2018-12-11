package servlet;

import com.mongodb.MongoClient;
import connection.MongoDBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "registeServlet")
public class registeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=gb2312");

        MongoDBConnection con = new MongoDBConnection();
        con.mongoDBJDBC();

        String reguser = request.getParameter("reguserName");
        String regpaw = request.getParameter("regpassword");
        String regconfirm = request.getParameter("regconfirmcode");

        org.bson.Document reginfo = new org.bson.Document("userName", reguser).append("password", regpaw);


        //get confirmcode by session
        HttpSession cfmsession = request.getSession();
        String cfmcode = (String) cfmsession.getAttribute("confirmcode");


        if (regconfirm.equals(cfmcode)) {

            con.addLoginfo(reginfo);
            response.getWriter().write("注册成功");
            response.setHeader("refresh", "3;url=login_page.html");

        } else {

            response.getWriter().write("confirm code wrong!please check your confirm code!");
            response.setHeader("refresh", "3;url=registe.html");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
