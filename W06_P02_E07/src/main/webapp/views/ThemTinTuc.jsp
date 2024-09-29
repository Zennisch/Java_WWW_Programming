<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-09-29
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
    request.getRequestDispatcher("/TinTuc?action=category").include(request, response);
%>
<div class="container mx-auto p-10">
    <h1 class="text-3xl font-bold mb-5 text-center">Tạo Tin tức Mới</h1>

    <form id="tinTucForm" action="TinTuc" method="POST" class="bg-white p-6 rounded-md shadow-md" onsubmit="return validateForm()">
        <div class="mb-4">
            <label for="maTinTuc" class="block text-gray-700 text-sm font-bold mb-2">Mã Tin tức:</label>
            <input type="text" id="maTinTuc" name="maTinTuc" required
                   class="border border-gray-300 p-2 w-full rounded-md">
        </div>

        <div class="mb-4">
            <label for="tieuDe" class="block text-gray-700 text-sm font-bold mb-2">Tiêu Đề:</label>
            <input type="text" id="tieuDe" name="tieuDe" required class="border border-gray-300 p-2 w-full rounded-md">
        </div>

        <div class="mb-4">
            <label for="noiDungTT" class="block text-gray-700 text-sm font-bold mb-2">Nội Dung Tin tức:</label>
            <textarea id="noiDungTT" name="noiDungTT" required rows="5"
                      class="border border-gray-300 p-2 w-full rounded-md"></textarea>
        </div>

        <div class="mb-4">
            <label for="lienKet" class="block text-gray-700 text-sm font-bold mb-2">Liên Kết:</label>
            <input type="url" id="lienKet" name="lienKet" required class="border border-gray-300 p-2 w-full rounded-md">
        </div>

        <div class="mb-4">
            <label for="danhMuc" class="block text-gray-700 text-sm font-bold mb-2">Danh Mục:</label>
            <select id="danhMuc" name="danhMuc" required class="border border-gray-300 p-2 w-full rounded-md">
                <option value="" disabled selected>Chọn danh mục</option>
                <c:set var="listDanhMuc" value="${requestScope.listDanhMuc}" scope="request"/>
                <c:forEach var="danhMuc" items="${listDanhMuc}">
                    <option value="${danhMuc.maDanhMuc}">${danhMuc.tenDanhMuc}</option>
                </c:forEach>
            </select>
        </div>

        <div class="flex justify-center">
            <input type="submit"
                   class="bg-blue-500 text-white px-4 py-2 rounded-md hover:bg-blue-700"
                   value="Tạo Tin tức">
        </div>
    </form>
</div>

<script>
    function validateForm() {
        const noiDungTT = document.getElementById("noiDungTT").value;
        const lienKet = document.getElementById("lienKet").value;

        if (noiDungTT.length > 1000) {
            alert("Nội dung không được quá 1000 ký tự.");
            return false;
        }

        const regex = /^http:\/\//;
        if (!regex.test(lienKet)) {
            alert("Liên kết phải bắt đầu bằng 'http://'.");
            return false;
        }

        return true;
    }
</script>