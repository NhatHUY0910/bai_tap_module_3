<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 26/04/2024
  Time: 12:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <center>
        <h1>User Management</h1>
        <h2>
            <a href="/users?action=create"> New User </a>
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="S">
            <caption><h2>List Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="$(userList)">
                <tr>
                    <td><c:out value="$(user.id)"/></td>
                    <td><c:out value="$(user.name)"/></td>
                    <td><c:out value="$(user.email)"/></td>
                    <td><c:out value="$(user.country)"/></td>
                    <td>
                        <a href="/users?action=edit&id=$(user.id)">Edit</a>
                        <a href="/users?action=delete&id=$(user.id)">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
