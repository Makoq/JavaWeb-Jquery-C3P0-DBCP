<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: K550JK
  Date: 2018/10/13
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<%-- 获得当前时间
    <%
       Date date=new Date();
       out.write(date.toLocaleString());
     %>
--%>

<form action="doLogin.jsp" method="post">

    用户名： <input type="text" name="userName"/><br/>
    密码： <input type="password" name="passWord"/><br/>
    <input type="submit" name="submit" value="登录"/><br/>

</form>


</body>
</html>
