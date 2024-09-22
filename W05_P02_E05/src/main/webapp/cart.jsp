<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-09-22
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IUH Bookstore</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<header class="bg-gray-200 py-4 px-6">
    <div class="container mx-auto flex items-center">
        <h1 class="text-3xl font-bold">IUH BOOKSTORE</h1>
        <nav class="ml-auto space-x-6">
            <a href="#" class="hover:underline">HOME</a>
            <a href="#" class="hover:underline">EXAMPLES</a>
            <a href="#" class="hover:underline">SERVICES</a>
            <a href="#" class="hover:underline">PRODUCTS</a>
            <a href="#" class="hover:underline">CONTACT</a>
        </nav>
    </div>
</header>
<main class="container mx-auto px-4 py-8">
    <div class="flex flex-wrap -mx-4">
        <aside class="w-full md:w-1/4 px-4">
            <div class="bg-gray-200 p-4 mb-4">
                <h3 class="text-xl font-bold mb-2">ABOUT US</h3>
                <p class="text-gray-700">About us information will be here..... <a href="#"
                                                                                   class="text-blue-500 hover:underline">Read
                    More</a></p>
            </div>
            <div class="bg-gray-200 p-4">
                <h3 class="text-xl font-bold mb-2">SEARCH SITE</h3>
                <input type="text"
                       class="w-full px-3 py-2 border border-gray-400 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
                       placeholder="Tìm kiếm sản phẩm...">
            </div>
        </aside>
        <div class="w-full md:w-3/4 px-4">
            <h2 class="text-2xl font-bold mb-4">YOUR SHOPPING CART</h2>
            <table class="w-full border-collapse table-auto">
                <thead>
                <tr class="bg-gray-200 text-gray-700">
                    <th class="px-4 py-2">Product ID</th>
                    <th class="px-4 py-2">Product name</th>
                    <th class="px-4 py-2">Price</th>
                    <th class="px-4 py-2">Qty</th>
                    <th class="px-4 py-2">Total</th>
                    <th class="px-4 py-2">Remove</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="cartItem" items="${sessionScope.cart}">
                    <tr class="border-b border-gray-300">
                        <td class="px-4 py-2">${cartItem.book.id}</td>
                        <td class="px-4 py-2">${cartItem.book.title}</td>
                        <td class="px-4 py-2">${cartItem.book.price}</td>
                        <td class="px-4 py-2">${cartItem.quantity}</td>
                        <td class="px-4 py-2">${cartItem.book.price * cartItem.quantity}</td>
                        <td class="px-4 py-2">
                            <a href="${pageContext.request.contextPath}/cart?action=remove&id=${cartItem.book.id}"
                               class="text-red-500 hover:underline">Remove</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
            <div class="flex justify-between mt-4">
                <button class="bg-orange-500 hover:bg-orange-700 text-white font-bold py-2 px-4 rounded">UPDATE CART
                </button>
                <button class="bg-orange-500 hover:bg-orange-700 text-white font-bold py-2 px-4 rounded">CHECKOUT
                </button>
            </div>
        </div>
    </div>
    <div class="mt-4">
        <a href="${pageContext.request.contextPath}/"
           class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Continue Shopping</a>
    </div>
    <div class="mt-4">
        <a href="${pageContext.request.contextPath}/cart?action=checkout"
           class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Checkout</a>
    </div>
</main>
<footer class="bg-gray-800 py-4 px-6 text-center text-white">
    <p>&copy; 2023 IUH Bookstore. All rights reserved.</p>
</footer>
</body>
</html>
