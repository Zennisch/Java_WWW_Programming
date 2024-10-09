<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-10-09
  Time: 12:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="listNhaCungCap" scope="request" value="${requestScope.listNhaCungCap}"/>

<h2 class="text-2xl font-semibold mb-6">Chức năng quản lý</h2>
<table class="w-full text-left">
    <thead>
    <tr class="border-b">
        <th class="py-2">Mã điện thoại</th>
        <th class="py-2">Tên điện thoại</th>
        <th class="py-2">Tên nhà sản xuất</th>
        <th class="py-2">Edit</th>
        <th class="py-2">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dienThoai" items="${requestScope.listDienThoai}">
        <tr>
            <td class="py-2">${dienThoai.maDienThoai}</td>
            <td class="py-2">${dienThoai.tenDienThoai}</td>
            <td class="py-2">${dienThoai.nhaCungCap.tenNhaCungCap}</td>
            <td class="py-2">
                <a href="#" class="text-blue-500 hover:underline">Edit</a>
            </td>
            <td class="py-2">
                <a href="#" class="text-red-500 hover:underline">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
