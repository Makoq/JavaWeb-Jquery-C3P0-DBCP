package heimaexc.servlet;

import heimaexc.entity.DButil;
import heimaexc.entity.book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

@WebServlet(name = "showAllBooksServlet")
public class showAllBooksServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        Map<String, book> ob = DButil.showAllBooks();

        out.write("本站有以下好书:<br/>");
        out.write(request.getContextPath());

        for (Map.Entry<String, book> bok : ob.entrySet()) {


            //out.writ：+< rf'bokid?id="+bok.getKey()+"'target='blank'>"+bok.getValue().getName()+"</a>"+"<br/>");

            out.write("书号：" + bok.getValue().getId() + "书名：" + "<a href='/bokid?id=" + bok.getKey() + "' target='_blank'>" + bok.getValue().getName() + "</a>" + "<br/>");


        }

        out.write("<hr/>最近的浏览书籍:<br/>");

        Cookie[] coks = request.getCookies();

        for (int i = 0; i < coks.length && coks != null; i++) {
            if ("historyid".equals(coks[i].getName())) {
                String sr = coks[i].getValue();

                String[] sf = sr.split("-");

                for (int j = 0; j < sf.length; j++) {
                    book bk2 = DButil.getBooksById(sf[j]);

                    out.write(bk2.getName() + "<br/>");

                }

            }
        }


    }
}
