<%--
  Created by IntelliJ IDEA.
  User: fabrianivan
  Date: 1/8/2021
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

    <title>Department Management Screen</title>
</head>
<body>
<div align="center">
    <h1>Department List</h1>
    <table border="1">
        <th>Name</th>
        <th>Location</th>
        <th>#</th>
        <c:forEach var="department" items="${listDepartment}">
            <tr>
                <td>${department.name}</td>
                <td>${department.location}</td>
                <td>
                    <a href="editDepartment?id=${department.id}">Edit</a>
                    <a href="deleteDepartment?id=${department.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <h4>New department register <a href="newDepartment">here</a> </h4>
    </table>
</div>
</body>
</html>
