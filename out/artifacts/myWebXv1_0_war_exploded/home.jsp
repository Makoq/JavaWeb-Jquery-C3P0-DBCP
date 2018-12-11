<%--
  Created by IntelliJ IDEA.
  User: K550JK
  Date: 2018/10/29
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"  %>

<%@ taglib prefix="c" uri="http://java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
欢迎你：<%
    String na = request.getParameter("username");
    out.write(na);
%>
</body>
</html>
