<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-09-22
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.Product"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Table</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">

<div class="max-w-4xl mx-auto p-4">
    <h1 class="text-center text-2xl font-bold mb-6 bg-teal-200 py-4">Product</h1>
    <div class="overflow-x-auto">
        <table class="min-w-full bg-white border border-gray-300">
            <thead class="bg-teal-100">
            <tr>
                <th class="px-4 py-2 border">ID</th>
                <th class="px-4 py-2 border">Name</th>
                <th class="px-4 py-2 border">Image</th>
                <th class="px-4 py-2 border">Price</th>
                <th class="px-4 py-2 border">Action</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="products" scope="request" type="java.util.List<model.Product>"/>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td class="px-4 py-2 border text-center">${product.id}</td>
                    <td class="px-4 py-2 border text-center">${product.name}</td>
                    <td class="px-4 py-2 border text-center">
                        <img src="${pageContext.request.contextPath}/resources/images/${product.image}"
                             alt="${product.name}" class="w-16 h-16">
                    </td>
                    <td class="px-4 py-2 border text-center">${product.price}</td>
                    <td class="px-4 py-2 border text-center">
                        <a href="${pageContext.request.contextPath}/cart?action=buy&id=${product.id}"
                           class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Buy</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
