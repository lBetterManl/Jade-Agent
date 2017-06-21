<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/6/20
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Jade Gateway</title>
  </head>
  <body>
  我想要
  <form action="myGatewayServlet" method="get">
    <input type="text" name="param1"/><br>
    <input type="hidden" name="action" value="sendmsg"/><br>
    <input type="submit" value="发送消息"/>
  </form>
  </body>
</html>
