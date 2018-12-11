package servlet.response;

import cn.dsna.util.images.ValidateCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * @author K550JK
 */
public class cfmServlet extends javax.servlet.http.HttpServlet {


    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        /* System.out.println("wo lai le");*/
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache", "no-cache");
        response.setHeader("expire", "0");

        ValidateCode vc = new ValidateCode(110, 25, 4, 9);
        //拿到生成的验证码

        String code = vc.getCode();

        HttpSession se = request.getSession();

        se.setAttribute("confirmcode", code);

        vc.write(response.getOutputStream());


    }


}
