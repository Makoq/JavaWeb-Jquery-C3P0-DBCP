package servlet.request;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "getInPutStreamServlet")
public class getInPutStreamServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //流输入
        ServletInputStream sis = request.getInputStream();

        int len = 0;
        byte[] b = new byte[1024];

        while ((len = sis.read(b)) != -1) {
            System.out.println(new String(b, 0, len));

        }

        sis.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
