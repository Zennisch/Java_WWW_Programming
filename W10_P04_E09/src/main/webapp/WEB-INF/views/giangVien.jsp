<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-11-03
  Time: 12:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/resources/tailwindcss.min.js"></script>
</head>
<body>
<%--@elvariable id="listGiangVien" type="java.util.List"--%>
<div class="flex flex-col justify-start items-center py-4 gap-4">
    <jsp:include page="template-header.jsp"/>
    <jsp:include page="template-navigation.jsp"/>
    <table class="table table-auto border border-2 border-black w-[90%] shadow-xl rounded-xl">
        <thead>
        <tr class="text-center">
            <th class="border border-2 border-black bg-gray-300 py-2">Mã giảng viên</th>
            <th class="border border-2 border-black bg-gray-300 py-2">Tên giảng viên</th>
            <th class="border border-2 border-black bg-gray-300 py-2">Lĩnh Vực Nghiên Cứu</th>
            <th class="border border-2 border-black bg-gray-300 py-2">Số Điện Thoại</th>
            <th class="border border-2 border-black bg-gray-300 py-2">Email</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listGiangVien}" var="giangVien">
            <tr class="text-center">
                <td class="border border-2 border-black py-2">${giangVien.maGV}</td>
                <td class="border border-2 border-black py-2">${giangVien.tenGV}</td>
                <td class="border border-2 border-black py-2">${giangVien.linhVucNghienCuu}</td>
                <td class="border border-2 border-black py-2">${giangVien.dienThoai}</td>
                <td class="border border-2 border-black py-2">${giangVien.email}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
