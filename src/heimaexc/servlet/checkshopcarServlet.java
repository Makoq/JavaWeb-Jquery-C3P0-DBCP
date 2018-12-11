package heimaexc.servlet;

import heimaexc.entity.book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "checkshopcarServlet")
public class checkshopcarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");


        List<book> list = (List<book>) request.getSession().getAttribute("car");

        PrintWriter out = response.getWriter();
        if (list == null) {


            out.write("no shangping");

            response.setHeader("Refresh", "2;url=/shoppingcar");

            return;


        }


        // response.sendRedirect("/shoppingcar");

        out.write("shopping car have :");
        for (book b : list) {

            out.write(b.getName() + "<br/>");
        }


    }
}
;