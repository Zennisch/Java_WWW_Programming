<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-09-22
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <%
        request.getRequestDispatcher("/Products").forward(request, response);
    %>
</body>
</html>
