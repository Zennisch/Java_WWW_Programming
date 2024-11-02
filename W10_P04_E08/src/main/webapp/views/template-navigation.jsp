<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-11-02
  Time: 5:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${pageContext.request.contextPath}/scripts/tailwindcss.min.js"></script>
<nav class="flex flex-row justify-evenly items-center w-[75%] h-[64px] gap-[18px] rounded-xl">
    <a href="${pageContext.request.contextPath}/customer/"
       class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
        Customer List
    </a>
    <a href="${pageContext.request.contextPath}/customer/create-form"
       class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
        Add Customer
    </a>
</nav>
