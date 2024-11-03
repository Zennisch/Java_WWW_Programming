<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-11-03
  Time: 12:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="listDeTai" type="java.util.List"--%>
<div class="flex flex-col justify-start items-center py-4 gap-4">
    <jsp:include page="template-header.jsp"/>
    <jsp:include page="template-navigation.jsp"/>
    <div class="w-full px-4">
        <table class="table table-auto border border-2 border-black w-full shadow-xl rounded-xl">
            <thead>
            <tr class="text-center">
                <th class="border border-2 border-black bg-gray-300 py-2">Mã đề tài</th>
                <th class="border border-2 border-black bg-gray-300 py-2">Tên đề tài</th>
                <th class="border border-2 border-black bg-gray-300 py-2">Năm thực hiện</th>
                <th class="border border-2 border-black bg-gray-300 py-2">Mô tả đề tài</th>
                <th class="border border-2 border-black bg-gray-300 py-2">Ảnh đề tài</th>
                <th class="border border-2 border-black bg-gray-300 py-2">Tên giảng viên</th>
                <th class="border border-2 border-black bg-gray-300 py-2">Chức năng</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listDeTai}" var="deTai">
                <c:url var="urlCheck" value="/DeTai/check">
                    <c:param name="maDeTai" value="${deTai.maDeTai}"/>
                </c:url>
                <c:url var="urlUpdate" value="/DeTai/update">
                    <c:param name="maDeTai" value="${deTai.maDeTai}"/>
                </c:url>
                <c:url var="urlDelete" value="/DeTai/delete">
                    <c:param name="maDeTai" value="${deTai.maDeTai}"/>
                </c:url>
                <tr class="text-center">
                    <td class="border border-2 border-black py-2">${deTai.maDeTai}</td>
                    <td class="border border-2 border-black py-2">${deTai.tenDeTai}</td>
                    <td class="border border-2 border-black py-2">${deTai.nam}</td>
                    <td class="border border-2 border-black py-2">${deTai.moTaDeTai}</td>
                    <td class="border border-2 border-black py-2">
                        <img src="${deTai.urlHinh}" alt="Ảnh đề tài ${deTai.tenDeTai}"
                             class="w-32 h-32 object-contain mx-auto">
                    </td>
                    <td class="border border-2 border-black py-2">${deTai.giangVien.tenGV}</td>
                    <td class="border border-2 border-black py-2">
                        <div class="flex flex-col justify-center items-center">
                            <a href="${urlCheck}"
                               class="bg-blue-500 text-white font-bold px-[20px] py-1 rounded">
                                Xem
                            </a>
                            <br>
                            <a href="${urlUpdate}"
                               class="bg-yellow-500 text-white font-bold px-[20px] py-1 rounded">
                                Sửa
                            </a>
                            <br>
                            <a href="${urlDelete}"
                               onclick="return confirm('Bạn có chắc chắn muốn xóa không?\nXóa sẽ không thể khôi phục.')"
                               class="bg-red-500 text-white font-bold px-[20px] py-1 rounded">
                                Xóa
                            </a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
