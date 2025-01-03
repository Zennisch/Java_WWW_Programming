<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-11-02
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Customer List</title>
    <script src="${pageContext.request.contextPath}/scripts/tailwindcss.min.js"></script>
</head>
<body>
<div class="flex flex-col justify-center items-center w-full h-full gap-[24px]">
    <jsp:include page="template-header.jsp"/>
    <jsp:include page="template-navigation.jsp"/>

    <h1 class="text-center font-bold text-[30px]">Customer List</h1>
    <table class="table table-auto w-[75%] border border-collapse border-black">
        <thead>
        <tr class="text-center">
            <th class="border border-black">ID</th>
            <th class="border border-black">First Name</th>
            <th class="border border-black">Last Name</th>
            <th class="border border-black">Email</th>
            <th class="border border-black">Actions</th>
        </tr>
        </thead>
        <tbody>
        <%--@elvariable id="customers" type="java.util.List"--%>
        <c:forEach items="${customers}" var="customer">
            <c:url var="updateUrl" value="${pageContext.request.contextPath}/customer/update-form">
                <c:param name="id" value="${customer.id}"/>
            </c:url>
            <c:url var="deleteUrl" value="${pageContext.request.contextPath}/customer/delete">
                <c:param name="id" value="${customer.id}"/>
            </c:url>
            <tr class="text-center">
                <td class="border border-black">${customer.id}</td>
                <td class="border border-black">${customer.firstName}</td>
                <td class="border border-black">${customer.lastName}</td>
                <td class="border border-black">${customer.email}</td>
                <td class="border border-black">
                    <a href="${updateUrl}"
                       class="text-yellow-500 font-bold rounded">
                        Update
                    </a>
                    <br>
                    <a href="${deleteUrl}"
                       class="text-red-500 font-bold rounded"
                       onclick="return confirm('' +
                        'Are you sure you want to delete this customer?\n' +
                        'This action cannot be undone.')">
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
