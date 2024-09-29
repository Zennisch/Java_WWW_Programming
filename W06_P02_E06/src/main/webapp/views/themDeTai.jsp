<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-09-29
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<div class="w-full max-w-lg">
    <h2 class="text-2xl font-bold mb-6">Thêm Đề Tài Mới</h2>
    <form action="DeTai" method="POST" class="bg-gray-100 p-6 rounded-lg shadow-md">

        <div class="mb-4">
            <label for="maDeTai" class="block text-gray-700">Mã Đề Tài:</label>
            <input type="text" id="maDeTai" name="maDeTai" required
                   class="border border-gray-300 rounded-lg px-4 py-2 w-full"/>
        </div>
        <div class="mb-4">
            <label for="tenDeTai" class="block text-gray-700">Tên Đề Tài:</label>
            <input type="text" id="tenDeTai" name="tenDeTai" required
                   class="border border-gray-300 rounded-lg px-4 py-2 w-full"/>
        </div>
        <div class="mb-4">
            <label for="namDangKy" class="block text-gray-700">Năm Đăng Ký:</label>
            <select id="namDangKy" name="namDangKy" required class="border border-gray-300 rounded-lg px-4 py-2 w-full">
                <option value="">Chọn Năm</option>
                <c:forEach var="year" begin="2000" end="2024">
                    <option value="${year}">${year}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-4">
            <label for="moTa" class="block text-gray-700">Mô Tả Đề Tài:</label>
            <textarea id="moTa" name="moTa" required class="border border-gray-300 rounded-lg px-4 py-2 w-full"
                      rows="4"></textarea>
        </div>
        <div class="mb-4">
            <label for="giangVien" class="block text-gray-700">Giảng Viên Hướng Dẫn:</label>
            <select id="giangVien" name="giangVien" required class="border border-gray-300 rounded-lg px-4 py-2 w-full">
                <option value="">Chọn Giảng Viên</option>
                <c:forEach var="giangVien" items="${giangViens}">
                    <option value="${giangVien.maGiangVien}">${giangVien.tenGV}</option>
                </c:forEach>
            </select>
        </div>
        <input type="submit"
               class="bg-blue-500 text-white px-6 py-3 rounded-lg hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-300"
               value="Thêm Đề Tài"/>
    </form>
</div>
