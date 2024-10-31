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
<div class="flex flex-col justify-center items-center mx-auto w-[50%] h-full gap-[50px]">
    <jsp:include page="template-header.jsp"/>
    <form>
        <table class="table table-auto table-fixed border-collapse border-spacing-4 w-full">
            <tbody>
            <tr>
                <td class="text-right px-4 py-4">
                    <label for="firstName">First Name:</label>
                </td>
                <td class="px-4 py-2">
                    <input type="text" name="firstName" id="firstName" class="border border-gray-400 rounded-md p-2"/>
                </td>
            </tr>
            <tr>
                <td class="text-right px-4 py-4">
                    <label for="lastName">Last Name:</label>
                </td>
                <td class="px-4 py-2">
                    <input type="text" name="lastName" id="lastName" class="border border-gray-400 rounded-md p-2"/>
                </td>
            </tr>
            <tr>
                <td class="text-right px-4 py-4">
                    <label>Country:</label>
                </td>
                <td>

                </td>
            </tr>
            <tr>
                <td class="text-right px-4 py-4">
                    <label>Favorite Language:</label>
                </td>
                <td>

                </td>
            </tr>
            <tr>
                <td class="text-right px-4 py-4">
                    <label>Operating Systems:</label>
                </td>
                <td>

                </td>
            </tr>
            <tr>
                <td class="text-center px-4 py-4" colspan="2">
                    <input type="submit" value="Submit" class="bg-blue-500 text-white px-4 py-2 rounded-md cursor-pointer"/>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
