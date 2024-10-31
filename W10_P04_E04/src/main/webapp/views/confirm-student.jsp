<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-11-01
  Time: 2:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="flex flex-col justify-center items-center mx-auto w-full h-full gap-[50px]">
    <jsp:include page="template-header.jsp"/>
    <%--@elvariable id="student" type="model.Student"--%>
    <h1>Thank you for submitting the form! ${student.firstName} ${student.lastName}</h1>
    <h2>Country: ${student.country}</h2>
    <h2>Favorite Language: ${student.favoriteLanguage}</h2>
    <h2>Operating Systems:
        <c:forEach var="operatingSystem" items="${student.operatingSystems}">
            ${operatingSystem} /
        </c:forEach>
    </h2>
    <jsp:include page="template-footer.jsp"/>
</div>
</body>
</html>
