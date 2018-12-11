package servlet.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "represpServlet")
public class represpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //region 响应编码
        System.out.println("doge");/*当访问时控制台输出dogs*/

        //高速客户端用什么编码解析response
        response.setContentType("text/html;charset=UTF-8");

        //响应编码字符流

        PrintWriter out = response.getWriter();
        out.write("你好");

        //响应编码字节流
        //ServletOutputStream oso=resp.getOutputStream();
        //oso.write("你好鸭".getBytes());
        //endregion

        //region 文件下载

         /*
         //通过路径获取文件
             String path=this.getServletContext().getRealPath("images/sky.jpg");
             FileInputStream inp=new FileInputStream(path);

         //创建字节输出流
             ServletOutputStream outp=resp.getOutputStream();

         //得到要下载的文件
             String filename=path.substring(path.lastIndexOf("\\")+1);
         //告知客户端要下载的文件名
             resp.setHeader("content-disposition","attachment;filename="+filename );
             resp.setHeader("content-type","image/jpeg" );

         //输出操作
             int len=1;
             byte[] b=new byte[1024];
             while(1 != (len = inp.read(b))){
                 outp.write(b,0,len);
             }

             */

        //endregion


    }
}
