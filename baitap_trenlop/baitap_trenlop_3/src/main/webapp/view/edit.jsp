<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 02/05/2024
  Time: 11:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Edit User</title>
</head>
<body>

        <h2>Edit User</h2>
        <form method="post" action="UserServlet?action=edit">
            <input type="hidden" name="id" value="${user.id}">

            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${user.name}" required><br><br>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${user.email}" required><br><br>

            <label for="country">Country:</label>
            <input type="text" id="country" name="country" value="${user.country}" required><br><br>

            <input type="submit" value="Save">
        </form>

</body>
</html>


