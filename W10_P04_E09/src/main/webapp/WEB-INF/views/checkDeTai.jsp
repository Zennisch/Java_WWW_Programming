<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-11-04
  Time: 1:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="flex flex-col justify-start items-center py-4 gap-4">
    <jsp:include page="template-header.jsp"/>
    <jsp:include page="template-navigation.jsp"/>
    <%--@elvariable id="deTai" type="model.DeTai"--%>
    <h3 class="text-2xl font-bold">Đề tài: ${deTai.tenDeTai} - ${deTai.nam}</h3>
    <h3 class="text-2xl font-bold">Giảng viên hướng dẫn: ${deTai.giangVien.tenGV}</h3>
    <img src="${deTai.urlHinh}" alt="Ảnh đề tài ${deTai.tenDeTai}" class="w-32 h-32 object-contain mx-auto">
    <h4 class="text-xl font-bold">Mô tả đề tài</h4>
    <p class="text-lg">
        ${deTai.moTaDeTai}
    </p>
</div>
</body>
</html>
