<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-09-29
  Time: 9:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="listTinTuc" value="${requestScope.listTinTuc}" scope="request"/>
<div class="container mx-auto">
    <h1 class="text-3xl font-bold mb-5">Danh sách Tin tức</h1>

    <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
        <c:forEach var="tinTuc" items="${listTinTuc}">
            <div class="bg-white p-4 rounded-md shadow-md mb-4">
                <h2 class="text-xl font-semibold text-indigo-600">${tinTuc.tieuDe}</h2>
<%--                <a href="${tinTuc.lienKet}" class="text-blue-500 hover:underline">Đọc thêm</a>--%>
                <a href="${pageContext.request.contextPath}/TinTuc?action=detail&id=${tinTuc.maTinTuc}" class="text-blue-500 hover:underline">Đọc thêm</a>
                <p class="text-sm text-gray-500">Danh mục: ${tinTuc.danhMuc.tenDanhMuc}</p>
            </div>
        </c:forEach>
    </div>
</div>

