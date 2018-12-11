<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/6 0006
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>log</title>
</head>
<body>

        <form action="/tlog" method="post">
            用户名<input type="text" name="username" /><br/>
            密码<input type="password" name="password"/><br/>
            <input type="submit" value="登陆" name="loginsubmit"/>
        </form>

</body>
</html>
