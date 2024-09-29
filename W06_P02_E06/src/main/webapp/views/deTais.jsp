<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-09-29
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<table class="min-w-full bg-white">
    <thead class="bg-gray-200">
    <tr>
        <th class="py-2">Mã Đề Tài</th>
        <th class="py-2">Tên Đề Tài</th>
        <th class="py-2">Năm Đăng Ký</th>
        <th class="py-2">Mô Tả Đề Tài</th>
        <th class="py-2">Tên Giảng Viên Hướng Dẫn</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="deTai" items="${deTais}">
        <tr>
            <td class="border px-4 py-2">${deTai.maDT}</td>
            <td class="border px-4 py-2">${deTai.tenDT}</td>
            <td class="border px-4 py-2">${deTai.namDangKy}</td>
            <td class="border px-4 py-2">${deTai.moTaDeTai}</td>
            <td class="border px-4 py-2">${deTai.giangVien.tenGV}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
