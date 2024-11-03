<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-11-03
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Tạo Đề Tài</title>
</head>
<body>
<div class="flex flex-col justify-start items-center py-4 gap-4">
    <jsp:include page="template-header.jsp"/>
    <jsp:include page="template-navigation.jsp"/>
    <h1 class="text-4xl font-bold">Thêm đề tài mới</h1>
    <%--@elvariable id="deTai" type="model.DeTai"--%>
    <form:form cssClass="w-[30%] py-4"
               action="create"
               method="post"
               modelAttribute="deTai"
               enctype="multipart/form-data">
        <div class="grid grid-cols-4 gap-4 items-center">
            <div class="col-span-2">
                <label for="tenDeTai"
                       class="font-bold text-right block">
                    Tên đề tài
                </label>
            </div>
            <div class="col-span-2">
                <form:input path="tenDeTai" id="tenDeTai"
                            class="w-full border border-2 border-black rounded-md px-4 py-2"/>
                <form:errors path="tenDeTai" cssClass="text-red-500"/>
            </div>
            <div class="col-span-2">
                <label for="nam"
                       class="font-bold text-right block">
                    Năm thực hiện
                </label>
            </div>
            <div class="col-span-2">

                <form:select path="nam" id="nam"
                             class="w-full border border-2 border-black rounded-md px-4 py-2">
                    <%--@elvariable id="listNam" type="java.util.List"--%>
                    <form:options items="${listNam}"/>
                </form:select>
                <form:errors path="nam" cssClass="text-red-500"/>
            </div>
            <div class="col-span-2">
                <label for="moTaDeTai"
                       class="font-bold text-right block">
                    Mô tả đề tài
                </label>
            </div>
            <div class="col-span-2">
                <form:textarea path="moTaDeTai" id="moTaDeTai"
                               class="w-full border border-2 border-black rounded-md px-4 py-2"/>
                <form:errors path="moTaDeTai" cssClass="text-red-500"/>
            </div>
            <div class="col-span-2">
                <label for="hinh"
                       class="font-bold text-right block">
                    Ảnh đề tài
                </label>
            </div>
            <div class="col-span-2">
                <input name="hinh" id="hinh" type="file" class="py-2"/>
            </div>
            <div class="col-span-2">
                <label for="tenGV"
                       class="font-bold text-right block">
                    Tên giảng viên
                </label>
            </div>
            <div class="col-span-2">
                <form:select path="giangVien.maGV" id="tenGV"
                             class="w-full border border-2 border-black rounded-md px-4 py-2">
                    <%--@elvariable id="listGiangVien" type="java.util.List"--%>
                    <form:options items="${listGiangVien}" itemValue="maGV" itemLabel="tenGV"/>
                </form:select>
            </div>
            <div class="col-span-4 flex justify-center items-center">
                <input type="submit" value="Tạo đề tài"
                       class="bg-blue-500 text-white font-bold px-[20px] py-2 rounded"/>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
