<%--
  Created by IntelliJ IDEA.
  User: K550JK
  Date: 2018/10/29
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //获取表单数据
    String name = request.getParameter("userName");

    String password = request.getParameter("passWord");


    //处理业务逻辑
    if ("tom".equals(name) && "123".equals(password)) {
        request.getRequestDispatcher("home.jsp").forward(request, response);

    } else {
        response.sendRedirect("index.jsp");

    }

    //分发转向

%>

</body>
</html>
