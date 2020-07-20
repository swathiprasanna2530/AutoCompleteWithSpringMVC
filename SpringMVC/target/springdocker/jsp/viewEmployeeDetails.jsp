<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
   <table border="1" cellpadding="5">
        <tr>
            <th>Employee ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Hired Date</th>
            <th>E-mail</th>
            <th>Address</th>
            <th>Phone</th>
        </tr>
        <tr>
            <td>${employeeId}</td>
            <td>${firstName}</td>
            <td>${lastName}</td>
            <td>${hiredDate}</td>
            <td>${email}</td>
            <td>${address}</td>
            <td>${phone}</td>
        </tr>
    </table>
    </body>

</html>