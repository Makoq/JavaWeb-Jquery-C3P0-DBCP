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
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

@WebServlet(name = "bookId=1Servlet")
public class bookId1Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");

        book b = DButil.getBooksById(id);


        out.print(b);


        String historyID = organize(id, request);
        //Cookie写回客户端
        Cookie ck = new Cookie("historyid", historyID);

        ck.setPath("/");
        ck.setMaxAge(Integer.MAX_VALUE);

        response.addCookie(ck);


    }

    private String organize(String id, HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            return id;
        }

        Cookie histroyBook = null;
        for (int i = 0; i < cookies.length; i++) {
            if ("historyid".equals(cookies[i].getName())) {
                histroyBook = cookies[i];
            }
        }

        if (histroyBook == null) {
            return id;
        }

        String vakue = histroyBook.getValue();
        String[] values = vakue.split("-");
        LinkedList<String> list = new LinkedList<String>(Arrays.asList(values));

        if (list.size() < 3) {

            if (list.contains(id)) {
                list.remove(id);
            }

        } else {
            if (list.contains(id)) {
                list.remove(id);
            } else {
                list.removeLast();
            }
        }
        list.addFirst(id);

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append("-");
            }
            sb.append(list.get(i));
        }

        return sb.toString();
    }


}
