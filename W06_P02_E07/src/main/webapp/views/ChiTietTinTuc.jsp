<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-09-29
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="tinTuc" value="${requestScope.tinTuc}" scope="request"/>
<div class="container mx-auto p-10">
    <h1 class="text-3xl font-bold mb-5 text-center">Chi tiết Tin tức</h1>

    <c:if test="${not empty tinTuc}">
        <div class="bg-white p-6 rounded-md shadow-md">
            <h2 class="text-2xl font-semibold text-indigo-600 text-center mb-4">${tinTuc.tieuDe}</h2>
            <div class="text-gray-700 text-lg">
                <p>${tinTuc.noiDungTT}</p>
            </div>
        </div>
    </c:if>

    <c:if test="${empty tinTuc}">
        <p class="text-gray-500 text-lg text-center">Không có thông tin chi tiết về tin tức này.</p>
    </c:if>
</div>
