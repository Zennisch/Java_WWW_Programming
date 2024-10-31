<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-10-31
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/scripts/tailwindcss.min.js"></script>
</head>
<body>
<div class="flex flex-col justify-center items-center mx-auto w-[50%] h-full gap-[50px]">
    <h1 class="text-[20px] font-bold text-center">
        Spring MVC Demo - Home Page
    </h1>
    <nav class="flex flex-row justify-center items-center w-full gap-4">
        <a href="${pageContext.request.contextPath}/hello" class="bg-blue-500 text-white px-4 py-2 rounded-md">
            Plain Hello World
        </a>
        <a href="${pageContext.request.contextPath}/form-student" class="bg-blue-500 text-white px-4 py-2 rounded-md">
            Form Student
        </a>
        <a href="${pageContext.request.contextPath}/form-customer" class="bg-blue-500 text-white px-4 py-2 rounded-md">
            Form Customer
        </a>
    </nav>
</div>
</body>
</html>
