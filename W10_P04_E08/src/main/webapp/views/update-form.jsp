<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-11-02
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update Customer</title>
    <script src="${pageContext.request.contextPath}/scripts/tailwindcss.min.js"></script>
</head>
<body>
<div class="flex flex-col justify-center items-center w-full h-full gap-[24px]">
    <jsp:include page="template-header.jsp"/>
    <jsp:include page="template-navigation.jsp"/>
    <h1 class="text-center font-bold text-[30px]">Add Customer</h1>
    <%--@elvariable id="customer" type="model.Customer"--%>
    <form:form action="update" method="post" modelAttribute="customer">
        <table class="table table-auto border-collapse border-spacing-4 w-full">
            <form:hidden path="id"/>
            <tr>
                <td class="px-4 py-2">First Name</td>
                <td class="px-4 py-2">
                    <form:input path="firstName"
                                class="border border-gray-400 rounded w-full px-4 py-2"/>
                </td>
            </tr>
            <tr>
                <td class="px-4 py-2">Last Name</td>
                <td class="px-4 py-2">
                    <form:input path="lastName"
                                class="border border-gray-400 rounded w-full px-4 py-2"/>
                </td>
            </tr>
            <tr>
                <td class="px-4 py-2">Email</td>
                <td class="px-4 py-2">
                    <form:input path="email"
                                class="border border-gray-400 rounded w-full px-4 py-2"/>
                </td>
            </tr>
            <tr>
                <td class="text-center px-4 py-2" colspan="2">
                    <input type="submit"
                           class="text-green-500 font-bold rounded cursor-pointer"
                           value="Submit"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
