<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-11-02
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="customers" type="java.util.List"--%>
<c:forEach items="${customers}" var="customer">
    <div>
        <p>${customer.id}</p>
        <p>${customer.firstName}</p>
        <p>${customer.lastName}</p>
        <p>${customer.email}</p>
    </div>
</c:forEach>
</body>
</html>
