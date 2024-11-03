<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-11-04
  Time: 3:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Thêm Giảng Viên</title>
</head>
<body>
<div class="flex flex-col justify-start items-center py-4 gap-4">
    <jsp:include page="template-header.jsp"/>
    <jsp:include page="template-navigation.jsp"/>
    <h1 class="text-4xl font-bold">Thêm giảng viên mới</h1>
    <%--@elvariable id="giangVien" type="model.GiangVien"--%>
    <form:form cssClass="w-[30%] py-4"
               action="create"
               method="post"
               modelAttribute="giangVien">
        <div class="grid grid-cols-4 gap-4 items-center">
            <div class="col-span-2">
                <label for="tenGV"
                       class="font-bold text-right block">
                    Tên giảng viên
                </label>
            </div>
            <div class="col-span-2">
                <form:input path="tenGV" id="tenGV"
                            class="w-full border border-2 border-black rounded-md px-4 py-2"/>
                <form:errors path="tenGV" cssClass="text-red-500"/>
            </div>
            <div class="col-span-2">
                <label for="linhVucNghienCuu"
                       class="font-bold text-right block">
                    Lĩnh vực nghiên cứu
                </label>
            </div>
            <div class="col-span-2">
                <form:input path="linhVucNghienCuu" id="linhVucNghienCuu"
                            class="w-full border border-2 border-black rounded-md px-4 py-2"/>
                <form:errors path="linhVucNghienCuu" cssClass="text-red-500"/>
            </div>
            <div class="col-span-2">
                <label for="dienThoai"
                       class="font-bold text-right block">
                    Số điện thoại
                </label>
            </div>
            <div class="col-span-2">
                <form:input path="dienThoai" id="dienThoai"
                            class="w-full border border-2 border-black rounded-md px-4 py-2"/>
                <form:errors path="dienThoai" cssClass="text-red-500"/>
            </div>
            <div class="col-span-2">
                <label for="email"
                       class="font-bold text-right block">
                    Email
                </label>
            </div>
            <div class="col-span-2">
                <form:input path="email" id="email"
                            class="w-full border border-2 border-black rounded-md px-4 py-2"/>
                <form:errors path="email" cssClass="text-red-500"/>
            </div>
            <div class="col-span-4 flex justify-center items-center">
                <input type="submit" value="Thêm giảng viên"
                       class="bg-blue-500 text-white font-bold px-[20px] py-2 rounded cursor-pointer"/>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
