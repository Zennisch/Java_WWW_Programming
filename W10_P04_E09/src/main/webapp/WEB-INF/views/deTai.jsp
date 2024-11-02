<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-11-03
  Time: 12:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="listDeTai" type="java.util.List"--%>
<c:forEach var="deTai" items="${listDeTai}">
    <p>${deTai.maDeTai}</p>
    <p>${deTai.tenDeTai}</p>
    <img src="${deTai.urlHinh}" alt="Không có hình ảnh"/>
</c:forEach>
</body>
</html>
