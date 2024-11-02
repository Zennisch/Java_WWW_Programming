<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-10-16
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách sinh viên</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="flex items-center justify-center h-screen bg-gray-100">
<div class="text-center">
    <h1 class="text-3xl font-bold mb-6">Danh sách sinh viên</h1>
    <div class="overflow-x-auto">
        <table class="min-w-full table-auto bg-white shadow-md rounded-lg">
            <thead class="bg-blue-500 text-white">
            <tr>
                <th class="px-4 py-2">ID</th>
                <th class="px-4 py-2">First Name</th>
                <th class="px-4 py-2">Last Name</th>
                <th class="px-4 py-2">Avarage Mark</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="sinhVien" items="${list}">
                <tr>
                    <td class="border px-4 py-2">${sinhVien.id }</td>
                    <td class="border px-4 py-2">${sinhVien.firstName }</td>
                    <td class="border px-4 py-2">${sinhVien.lastName }</td>
                    <td class="border px-4 py-2">${sinhVien.averageMark }</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
