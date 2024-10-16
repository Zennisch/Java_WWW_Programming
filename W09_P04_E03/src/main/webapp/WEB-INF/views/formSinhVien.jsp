<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-10-16
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center h-screen">
<div class="w-full max-w-md bg-white p-8 rounded-lg shadow-md">
    <h2 class="text-2xl font-bold text-center mb-6 text-gray-800">Thông Tin Sinh Viên</h2>
    <form:form action="save" method="post" class="space-y-4">
        <div class="flex items-center justify-between">
            <label class="text-gray-700 font-semibold">First Name:</label>
            <form:input path="firstName" class="border border-gray-300 rounded-lg p-2 w-2/3 focus:outline-none focus:ring-2 focus:ring-blue-500" />
        </div>
        <div class="flex items-center justify-between">
            <label class="text-gray-700 font-semibold">Last Name:</label>
            <form:input path="lastName" class="border border-gray-300 rounded-lg p-2 w-2/3 focus:outline-none focus:ring-2 focus:ring-blue-500" />
        </div>
        <div class="flex items-center justify-between">
            <label class="text-gray-700 font-semibold">Average Mark:</label>
            <form:input path="averageMark" class="border border-gray-300 rounded-lg p-2 w-2/3 focus:outline-none focus:ring-2 focus:ring-blue-500" />
        </div>
        <div class="text-center">
            <input type="submit" value="Save" class="bg-blue-500 text-white px-4 py-2 rounded-lg hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-500"/>
        </div>
    </form:form>
</div>
</body>
</html>

