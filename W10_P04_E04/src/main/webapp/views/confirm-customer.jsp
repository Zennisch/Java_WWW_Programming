<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-11-01
  Time: 2:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="flex flex-col justify-center items-center mx-auto w-full h-full gap-[50px]">
    <jsp:include page="template-header.jsp"/>
    <%--@elvariable id="customer" type="model.Customer"--%>
    <h1>Thank you for submitting the form! ${customer.firstName} ${customer.lastName}</h1>
    <h2>Free Passes: ${customer.freePasses}</h2>
    <h2>Postal Code: ${customer.postalCode}</h2>
    <h2>Course Code: ${customer.courseCode}</h2>
    <jsp:include page="template-footer.jsp"/>
</body>
</html>
