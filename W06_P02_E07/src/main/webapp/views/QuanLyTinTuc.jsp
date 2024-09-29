<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-09-29
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<div class="container mx-auto p-10">
    <script>
        function confirmDelete() {
            return confirm("Bạn có chắc chắn muốn xóa tin tức này không?");
        }
    </script>
    <h1 class="text-3xl font-bold mb-5 text-center">Quản Lý Tin Tức</h1>

    <table class="min-w-full bg-white border border-gray-300 rounded-md shadow-md">
        <thead>
        <tr class="bg-blue-600 text-white">
            <th class="py-2 px-4 border-b">Mã Tin Tức</th>
            <th class="py-2 px-4 border-b">Tiêu đề</th>
            <th class="py-2 px-4 border-b">Tên Danh Mục</th>
            <th class="py-2 px-4 border-b">Người Quản Lý</th>
            <th class="py-2 px-4 border-b">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="listTinTucControl" value="${requestScope.listTinTucControl}" scope="request"/>
        <c:forEach var="tinTuc" items="${listTinTucControl}">
            <tr class="hover:bg-gray-100">
                <td class="py-2 px-4 border-b text-center">${tinTuc.maTinTuc}</td>
                <td class="py-2 px-4 border-b text-center">${tinTuc.tieuDe}</td>
                <td class="py-2 px-4 border-b text-center">${tinTuc.danhMuc.tenDanhMuc}</td>
                <td class="py-2 px-4 border-b text-center">${tinTuc.danhMuc.nguoiQuanLy}</td>
                <td class="py-2 px-4 border-b text-center">
                    <a href="TinTuc?action=remove&id=${tinTuc.maTinTuc}"
                       onclick="return confirmDelete()"
                       class="text-red-500 hover:underline">Xóa Tin
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
