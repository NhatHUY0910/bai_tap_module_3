<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 09/05/2024
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Sách Thư Viện</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/css/book_list.css" rel="stylesheet">
</head>
<body>

    <div class="container">
        <h1>Book List</h1>
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Description</th>
                <th>Quantity</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${books}" var="book">
            <tr>
                <td><${book.getId()}></td>
                <td><${book.getTitle()}></td>
                <td><${book.getAuthor()}></td>
                <td><${book.getDescription()}></td>
                <td><${book.getQuantity()}></td>
                <td>
                        <button class="btn btn-primary">Mượn sách</button>
                </td>>
            </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>
</html>
