<%@ page import="model.Person" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2024-09-15
  Time: 11:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<%
    Person person = new Person();
    person = (Person) request.getAttribute("person");
    String output = "First Name: " + person.getFirstName()
            + "<br>Last Name: " + person.getLastName()
            + "<br>Date of Birth: " + person.getDateOfBirth()
            + "<br>Email: " + person.getEmail()
            + "<br>Mobile: " + person.getMobile()
            + "<br>Gender: " + person.getGender()
            + "<br>Address: " + person.getAddress()
            + "<br>City: " + person.getCity()
            + "<br>State: " + person.getState()
            + "<br>City: " + person.getCity()
            + "<br>Pin Code: " + person.getPinCode()
            + "<br>Country: " + person.getCountry()
            + "<br>Hobbies: " + Arrays.toString(person.getHobbies())
            + "<br>Qualifications: " + Arrays.toString(person.getQualifications())
            + "<br>Course applies for: " + person.getApplies();
    response.getWriter().println(output);
%>
</body>
</html>
