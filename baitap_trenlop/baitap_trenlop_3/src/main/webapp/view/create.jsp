<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 26/04/2024
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<center>
    <h1>User Management</h1>
    <h2>
        <a href="users?action=users">List All Users</a>
    </h2>
</center>

<div align="center">
    <form method="post">

        <table border="1" cellpadding="5">
            <cation>
                <h2>Add New User</h2>
            </cation>
            <tr>
                <th>User Name: </th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    <input type="text" name="name"  id="email" size="45"/>
                </td>
            </tr>

        </table>
    </form>
</div>

</body>
</html>
