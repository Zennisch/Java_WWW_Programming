<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-09-29
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<table class="min-w-full bg-white">
    <thead class="bg-gray-200">
    <tr>
        <th class="py-2">Mã Giảng Viên</th>
        <th class="py-2">Họ và Tên</th>
        <th class="py-2">Lĩnh vực Nghiên Cứu</th>
        <th class="py-2">Số Điện Thoại</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="giangVien" items="${giangViens}">
        <tr>
            <td class="border px-4 py-2">${giangVien.maGV}</td>
            <td class="border px-4 py-2">${giangVien.tenGV}</td>
            <td class="border px-4 py-2">${giangVien.linhVucNghienCuu}</td>
            <td class="border px-4 py-2">${giangVien.soDienThoai}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
