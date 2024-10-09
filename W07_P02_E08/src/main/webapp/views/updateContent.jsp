<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-10-09
  Time: 12:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="dienThoai" scope="request" value="${requestScope.dienThoai}"/>
<c:set var="listNhaCungCap" scope="request" value="${requestScope.listNhaCungCap}"/>

<h2 class="text-2xl font-semibold mb-6">Cập nhật sản phẩm</h2>
<form action="${pageContext.request.contextPath}/DienThoai?action=update"
      method="post"
      class="space-y-4">

    <!-- Mã điện thoại ẩn-->
    <input type="hidden" name="maDienThoai" value="${dienThoai.maDienThoai}">

    <!-- Thêm điện thoại -->
    <div>
        <label for="tenDienThoai" class="block text-lg font-medium">Thêm điện thoại:</label>
        <input type="text" id="tenDienThoai" name="tenDienThoai" class="w-full p-2 border border-gray-300 rounded mt-2"
               placeholder="Nhập tên điện thoại" value="${dienThoai.tenDienThoai}">
    </div>

    <!-- Năm sản xuất -->
    <div>
        <label for="namSanXuat" class="block text-lg font-medium">Năm sản xuất:</label>
        <select id="namSanXuat" name="namSanXuat" class="w-full p-2 border border-gray-300 rounded mt-2">
            <option value="" disabled selected>Chọn năm sản xuất</option>
        </select>
    </div>

    <!-- Cấu hình -->
    <div>
        <label for="cauHinh" class="block text-lg font-medium">Cấu hình:</label>
        <input type="text" id="cauHinh" name="cauHinh" class="w-full p-2 border border-gray-300 rounded mt-2"
               placeholder="Nhập cấu hình (VD: 128GB, 8GB RAM)" value="${dienThoai.cauHinh}">
    </div>

    <!-- Nhà sản xuất -->
    <div>
        <label for="nhaCungCap" class="block text-lg font-medium">Nhà sản xuất:</label>
        <select id="nhaCungCap" name="nhaCungCap" class="w-full p-2 border border-gray-300 rounded mt-2">
            <option value="" disabled selected>Chọn nhà sản xuất</option>
            <c:forEach var="nhaCungCap" items="${listNhaCungCap}">
                <option value="${nhaCungCap.maNhaCungCap}" ${dienThoai.nhaCungCap.maNhaCungCap == nhaCungCap.maNhaCungCap ? 'selected' : ''}>
                        ${nhaCungCap.tenNhaCungCap}
                </option>
            </c:forEach>
        </select>
    </div>

    <!-- Submit button -->
    <div>
        <button type="submit" class="w-full bg-blue-500 text-white p-2 rounded mt-4 hover:bg-blue-600">Cập nhật sản phẩm
        </button>
    </div>
</form>

<script>
    const selectedYear = ${dienThoai.namSanXuat};
    const year = document.getElementById('namSanXuat');
    for (let i = 2024; i >= 2010; i--) {
        const option = document.createElement('option');
        option.value = i.toString();
        option.innerHTML = i.toString();

        if (selectedYear.toString() === i.toString()) {
            option.selected = true;
        }

        year.appendChild(option);
    }
</script>
