<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-09-29
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="w-full max-w-lg">
    <h2 class="text-2xl font-bold mb-6">Thêm Giảng Viên Mới</h2>
    <form action="GiangVien" method="POST" class="bg-gray-100 p-6 rounded-lg shadow-md">
        <div class="mb-4">
            <label for="maGiangVien" class="block text-sm font-medium text-gray-700">Mã Giảng Viên</label>
            <input type="text" id="maGiangVien" name="maGiangVien" required class="mt-1 p-2 w-full border border-gray-300 rounded-md">
        </div>
        <div class="mb-4">
            <label for="tenGiangVien" class="block text-sm font-medium text-gray-700">Họ và Tên</label>
            <input type="text" id="tenGiangVien" name="tenGiangVien" required class="mt-1 p-2 w-full border border-gray-300 rounded-md">
        </div>
        <div class="mb-4">
            <label for="linhVucNghienCuu" class="block text-sm font-medium text-gray-700">Lĩnh Vực Nghiên Cứu</label>
            <input type="text" id="linhVucNghienCuu" name="linhVucNghienCuu" required class="mt-1 p-2 w-full border border-gray-300 rounded-md">
        </div>
        <div class="mb-4">
            <label for="soDienThoai" class="block text-sm font-medium text-gray-700">Số Điện Thoại</label>
            <input type="tel" id="soDienThoai" name="soDienThoai" required class="mt-1 p-2 w-full border border-gray-300 rounded-md">
        </div>
        <input type="submit"
               class="bg-blue-500 text-white px-4 py-2 rounded-lg hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-300"
               value="Thêm Giảng Viên" />
    </form>
</div>
