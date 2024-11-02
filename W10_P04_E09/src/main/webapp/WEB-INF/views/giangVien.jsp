<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-11-03
  Time: 12:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="listGiangVien" type="java.util.List"--%>
<c:forEach var="giangVien" items="${listGiangVien}">
    <p>${giangVien.maGV}</p>
    <p>${giangVien.tenGV}</p>
</c:forEach>
</body>
</html>
