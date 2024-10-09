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
<%--    <!-- Item 1 -->--%>
<%--    <a href="#" class="bg-white p-4 rounded shadow-md flex flex-col items-start hover:bg-gray-100">--%>
<%--        <h2 class="text-lg font-semibold">iPhone 13</h2>--%>
<%--        <p>Năm sản xuất: 2021</p>--%>
<%--        <p>Cấu hình: 128GB, 4GB RAM</p>--%>
<%--        <p>Nhà cung cấp: Apple</p>--%>
<%--    </a>--%>
<%--    <!-- Item 2 -->--%>
<%--    <a href="#" class="bg-white p-4 rounded shadow-md flex flex-col items-start hover:bg-gray-100">--%>
<%--        <h2 class="text-lg font-semibold">Samsung Galaxy S21</h2>--%>
<%--        <p>Năm sản xuất: 2021</p>--%>
<%--        <p>Cấu hình: 256GB, 8GB RAM</p>--%>
<%--        <p>Nhà cung cấp: Samsung</p>--%>
<%--    </a>--%>
<%--    <!-- Item 3 -->--%>
<%--    <a href="#" class="bg-white p-4 rounded shadow-md flex flex-col items-start hover:bg-gray-100">--%>
<%--        <h2 class="text-lg font-semibold">Google Pixel 6</h2>--%>
<%--        <p>Năm sản xuất: 2021</p>--%>
<%--        <p>Cấu hình: 128GB, 6GB RAM</p>--%>
<%--        <p>Nhà cung cấp: Google</p>--%>
<%--    </a>--%>
<%--    <!-- Item 4 -->--%>
<%--    <a href="#" class="bg-white p-4 rounded shadow-md flex flex-col items-start hover:bg-gray-100">--%>
<%--        <h2 class="text-lg font-semibold">OnePlus 9</h2>--%>
<%--        <p>Năm sản xuất: 2021</p>--%>
<%--        <p>Cấu hình: 128GB, 8GB RAM</p>--%>
<%--        <p>Nhà cung cấp: OnePlus</p>--%>
<%--    </a>--%>
    <c:forEach var="dienThoai" items="${listDienThoai}">
        <a href="#" class="bg-white p-4 rounded shadow-md flex flex-col items-start hover:bg-gray-100">
            <h2 class="text-lg font-semibold">${dienThoai.tenDienThoai}</h2>
            <p>Năm sản xuất: ${dienThoai.namSanXuat}</p>
            <p>Cấu hình: ${dienThoai.cauHinh}</p>
            <p>Nhà cung cấp: ${dienThoai.nhaCungCap.tenNhaCungCap}</p>
        </a>
    </c:forEach>
</div>
