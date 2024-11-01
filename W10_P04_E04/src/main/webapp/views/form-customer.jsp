<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-10-31
  Time: 6:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="flex flex-col justify-center items-center mx-auto w-full h-full gap-[50px]">
    <jsp:include page="template-header.jsp"/>
    <%--@elvariable id="customer" type="model.Customer"--%>
    <form:form action="${pageContext.request.contextPath}/confirm-customer" method="post" modelAttribute="customer">
        <table class="table table-auto border-collapse border-spacing-4 w-full">
            <tbody>
            <tr>
                <td class="text-center px-4 py-4">
                    <label for="firstName">First Name:</label>
                </td>
                <td class="px-4 py-2">
                    <form:input path="firstName" id="firstName" class="border border-gray-400 rounded-md p-2"/>
                </td>
                <td>
                    <form:errors path="firstName" cssClass="text-red-500"/>
                </td>
            </tr>
            <tr>
                <td class="text-center px-4 py-4">
                    <label for="lastName">Last Name:</label>
                </td>
                <td class="px-4 py-2">
                    <form:input path="lastName" id="lastName" class="border border-gray-400 rounded-md p-2"/>
                </td>
                <td>
                    <form:errors path="lastName" cssClass="text-red-500"/>
                </td>
            </tr>
            <tr>
                <td class="text-center px-4 py-4">
                    <label for="freePasses">Free Passes:</label>
                </td>
                <td class="px-4 py-2">
                    <form:input path="freePasses" id="freePasses" class="border border-gray-400 rounded-md p-2"/>
                </td>
                <td>
                    <form:errors path="freePasses" cssClass="text-red-500"/>
                </td>
            </tr>
            <tr>
                <td class="text-center px-4 py-4">
                    <label for="postalCode">Postal Code:</label>
                </td>
                <td class="px-4 py-2">
                    <form:input path="postalCode" id="postalCode" class="border border-gray-400 rounded-md p-2"/>
                </td>
                <td>
                    <form:errors path="postalCode" cssClass="text-red-500"/>
                </td>
            </tr>
            <tr>
                <td class="text-center px-4 py-4">
                    <label for="courseCode">Course Code:</label>
                </td>
                <td class="px-4 py-2">
                    <form:input path="courseCode" id="courseCode" class="border border-gray-400 rounded-md p-2"/>
                </td>
                <td>
                    <form:errors path="courseCode" cssClass="text-red-500"/>
                </td>
            </tr>
            <tr>
                <td class="text-center px-4 py-4" colspan="3">
                    <input type="submit" value="Submit"
                           class="bg-blue-500 text-white px-4 py-2 rounded-md cursor-pointer w-[30%]"/>
                </td>
            </tr>
            </tbody>
        </table>
    </form:form>

    <jsp:include page="template-footer.jsp"/>
</div>
</body>
</html>
