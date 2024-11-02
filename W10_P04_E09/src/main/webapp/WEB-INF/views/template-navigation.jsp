<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-11-03
  Time: 4:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<script src="${pageContext.request.contextPath}/resources/tailwindcss.min.js"></script>
<nav class="flex flex-row justify-center items-center py-4 bg-gray-100 w-full gap-4">
    <a href="${pageContext.request.contextPath}/GiangVien/"
       class="text-black font-bold text-[18px] cursor-pointer px-4 bg-gray-300 hover:bg-gray-400 rounded-lg">
        Danh Sách Giảng Viên
    </a>
    <a href="${pageContext.request.contextPath}/DeTai/form-create"
       class="text-black font-bold text-[18px] cursor-pointer px-4 bg-gray-300 hover:bg-gray-400 rounded-lg">
        Thêm Đề Tài
    </a>
    <a href="${pageContext.request.contextPath}/DeTai/"
       class="text-black font-bold text-[18px] cursor-pointer px-4 bg-gray-300 hover:bg-gray-400 rounded-lg">
        Quản Lý Đề Tài
    </a>
</nav>
