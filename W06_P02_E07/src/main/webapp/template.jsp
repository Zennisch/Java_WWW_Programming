<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-09-29
  Time: 8:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>IUH News</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="flex flex-col min-h-screen bg-gradient-to-r from-green-400 to-blue-500">

<header class="flex flex-col md:flex-row items-center bg-white shadow-md">
    <div class="w-full md:w-1/2 flex items-center justify-center py-8">
        <h1 class="text-4xl font-bold text-blue-600">IUH NEWS</h1>
    </div>
    <div class="w-full md:w-1/2 flex items-center justify-center overflow-hidden py-4">
        <h1 class="text-4xl font-bold text-blue-600">NEWS FOR YOU</h1>
    </div>
</header>

<nav class="bg-blue-600">
    <ul class="flex flex-col md:flex-row justify-center space-y-2 md:space-y-0 md:space-x-6 py-4">
        <li>
            <a href="#" class="px-4 py-2 bg-white text-blue-600 rounded hover:bg-blue-100 transition duration-300">Danh
                sách tin tức</a>
        </li>
        <li>
            <a href="#" class="px-4 py-2 bg-white text-blue-600 rounded hover:bg-blue-100 transition duration-300">Thêm
                tin tức</a>
        </li>
        <li>
            <a href="#" class="px-4 py-2 bg-white text-blue-600 rounded hover:bg-blue-100 transition duration-300">Chức
                năng quản lý</a>
        </li>
    </ul>
</nav>

<main class="flex-grow flex items-center justify-center">
    <div class="w-11/12 h-72 bg-white bg-opacity-50 rounded-lg shadow-md">
        <jsp:include page="views/content.jsp" />
    </div>
</main>

<footer class="bg-blue-600 text-white py-4">
    <p class="text-center">Họ tên sinh viên - Mã sinh viên - Lớp</p>
</footer>

</body>
</html>