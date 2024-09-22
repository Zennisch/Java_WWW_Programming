<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-09-22
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.getRequestDispatcher("/Books").forward(request, response);
    %>
</body>
</html>
