<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-09-29
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý giảng viên và đề tài</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
<div class="max-w-5xl mx-auto my-10">
    <header class="text-center mb-8">
        <h1 class="text-4xl font-bold text-blue-600">Quản lý giảng viên và đề tài</h1>
    </header>

    <nav class="flex justify-center space-x-8 mb-10">
        <a href="#danh-sach-giang-vien"
           class="bg-blue-500 text-white px-6 py-3 rounded-lg hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-300">Danh
            sách giảng viên</a>
        <a href="#danh-sach-de-tai"
           class="bg-green-500 text-white px-6 py-3 rounded-lg hover:bg-green-600 focus:outline-none focus:ring-2 focus:ring-green-300">Danh
            sách đề tài</a>
        <a href="#them-giang-vien"
           class="bg-yellow-500 text-white px-6 py-3 rounded-lg hover:bg-yellow-600 focus:outline-none focus:ring-2 focus:ring-yellow-300">Thêm
            giảng viên</a>
        <a href="#them-de-tai"
           class="bg-red-500 text-white px-6 py-3 rounded-lg hover:bg-red-600 focus:outline-none focus:ring-2 focus:ring-red-300">Thêm
            đề tài</a>
    </nav>

    <section id="content-area" class="bg-white p-10 rounded-lg shadow-lg h-80 flex items-center justify-center">
        <p class="text-gray-500 text-lg">Vui lòng chọn một mục từ thanh điều hướng.</p>
    </section>
</div>

</body>
</html>