<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-09-22
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">

<div class="max-w-4xl mx-auto p-4">
    <h1 class="text-center text-2xl font-bold mb-6 bg-teal-200 py-4">Cart</h1>
    <div class="overflow-x-auto">
        <table class="min-w-full bg-white border border-gray-300">
            <thead class="bg-teal-100">
            <tr>
                <th class="px-4 py-2 border">ID</th>
                <th class="px-4 py-2 border">Name</th>
                <th class="px-4 py-2 border">Image</th>
                <th class="px-4 py-2 border">Prices</th>
                <th class="px-4 py-2 border">Quantity</th>
                <th class="px-4 py-2 border">Subtotal</th>
                <th class="px-4 py-2 border">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="cartItem" items="${sessionScope.cart}">
                <tr>
                    <td class="px-4 py-2 border text-center">${cartItem.product.id}</td>
                    <td class="px-4 py-2 border text-center">${cartItem.product.name}</td>
                    <td class="px-4 py-2 border text-center">
                        <img src="${pageContext.request.contextPath}/resources/images/${cartItem.product.image}"
                             alt="${cartItem.product.name}" class="w-16 h-16">
                    </td>
                    <td class="px-4 py-2 border text-center">${cartItem.product.price}</td>
                    <td class="px-4 py-2 border text-center">${cartItem.quantity}</td>
                    <td class="px-4 py-2 border text-center">${cartItem.product.price * cartItem.quantity}</td>
                    <td class="px-4 py-2 border text-center text-red-600 cursor-pointer">
                        <a href="${pageContext.request.contextPath}/cart?action=remove&id=${cartItem.product.id}">Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="mt-4">
        <a href="${pageContext.request.contextPath}/"
           class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Continue Shopping</a>
    </div>
</div>
</body>
</html>

