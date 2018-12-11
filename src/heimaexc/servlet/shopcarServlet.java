package heimaexc.servlet;

import heimaexc.entity.DButil;
import heimaexc.entity.book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "addcar")
public class shopcarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        //get book by id
        String id = request.getParameter("id");

        book bk = DButil.getBooksById(id);

        //from session get list

        HttpSession session = request.getSession();

        List<book> list = (List<book>) session.getAttribute("car");

        if (list == null) {

            list = new ArrayList<>();

        }
        list.add(bk);
        session.setAttribute("car", list);

        out.write("buy successful");

        response.setHeader("Refresh", "3;url=/shoppingcar");

    }
}
