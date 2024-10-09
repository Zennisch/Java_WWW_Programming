<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-10-09
  Time: 3:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="listDienThoai" scope="request" value="${requestScope.listDienThoai}"/>
<div class="w-1/1 grid grid-cols-4 gap-6">
    <c:forEach var="dienThoai" items="${listDienThoai}">
        <a href="#" class="bg-white p-4 rounded shadow-md flex flex-col items-start hover:bg-gray-100">
            <h2 class="text-lg font-semibold">${dienThoai.tenDienThoai}</h2>
            <p>Năm sản xuất: ${dienThoai.namSanXuat}</p>
            <p>Cấu hình: ${dienThoai.cauHinh}</p>
            <p>Nhà cung cấp: ${dienThoai.nhaCungCap.tenNhaCungCap}</p>
        </a>
    </c:forEach>
</div>
