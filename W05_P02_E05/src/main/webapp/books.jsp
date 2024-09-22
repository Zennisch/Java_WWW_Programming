<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-09-22
  Time: 8:35 PM
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
<body class="font-sans">
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

<main class="container mx-auto py-8 grid grid-cols-3 gap-6">
    <aside class="col-span-1">
        <div class="bg-white p-6 rounded shadow">
            <h2 class="text-xl font-bold mb-4">ABOUT US</h2>
            <p>About us information will be here..... <a href="#" class="text-blue-500 hover:underline">Read More >></a>
            </p>
        </div>

        <div class="bg-white p-6 rounded shadow mt-6">
            <h2 class="text-xl font-bold mb-4">SEARCH SITE</h2>
            <input type="text"
                   class="w-full px-4 py-2 border rounded focus:outline-none focus:ring focus:border-blue-300"
                   placeholder="Search...">
        </div>

        <div class="bg-white p-6 rounded shadow mt-6">
            <h2 class="text-xl font-bold mb-4">Shopping cart (4)</h2>
        </div>
    </aside>

    <section class="col-span-2 grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
<%--        <div class="bg-white p-6 rounded shadow">--%>
<%--            <img src="book1.jpg" alt="Book Title" class="w-full h-auto mb-4">--%>
<%--            <h3 class="text-lg font-semibold">Số tay viết văn - Tác giả: Tô Hoài</h3>--%>
<%--            <p class="text-gray-600">Price: 99000</p>--%>
<%--            <p class="text-gray-600">Quantity: 10</p>--%>
<%--            <a href="#" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mt-4">Add to--%>
<%--                cart</a>--%>
<%--        </div>--%>
        <jsp:useBean id="books" scope="request" type="java.util.List<model.Book>"/>
        <c:forEach var="book" items="${books}">
            <div class="bg-white p-6 rounded shadow">
                <img src="${pageContext.request.contextPath}/resources/images/${book.image}"
                     alt="${book.title}" class="w-full h-auto mb-4">
                <h3 class="text-lg font-semibold">${book.title}</h3>
                <p class="text-gray-600">Price: ${book.price}</p>
                <p class="text-gray-600">Quantity: ${book.quantity}</p>
                <a href="${pageContext.request.contextPath}/cart?action=buy&id=${book.id}"
                   class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mt-4">Add to
                    cart</a>
            </div>
        </c:forEach>
    </section>
</main>

<footer class="bg-gray-800 py-4 px-6 text-center text-white">
    <p>&copy; 2023 IUH Bookstore. All rights reserved.</p>
</footer>
</body>
</html>
