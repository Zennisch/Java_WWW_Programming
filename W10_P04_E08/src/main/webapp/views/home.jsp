<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-11-02
  Time: 1:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/scripts/tailwindcss.min.js"></script>
</head>
<body>
<div class="flex flex-col justify-center items-center w-full h-full gap-[24px]">
    <jsp:include page="template-header.jsp"/>
    <jsp:include page="template-navigation.jsp"/>
</div>
</body>
</html>
