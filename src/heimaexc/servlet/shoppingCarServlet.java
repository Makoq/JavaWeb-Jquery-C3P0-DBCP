package heimaexc.servlet;

import heimaexc.entity.DButil;
import heimaexc.entity.book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "shoppingCarServlet")
public class shoppingCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.write("有以下好书：<br/>");

        Map<String, book> bo = DButil.showAllBooks();
        for (Map.Entry<String, book> bok : bo.entrySet()) {

            out.print("<a href='/car?id=" + bok.getKey() + "' target='_blank'>" + bok.getValue().getName() + "</a>" + "<br/>");
        }

        out.print("<a href='/chk'>" + "check shopping car" + "</a>");


    }
}
