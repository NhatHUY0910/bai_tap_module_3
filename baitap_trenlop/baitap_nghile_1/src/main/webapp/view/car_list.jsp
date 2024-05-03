<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 02/05/2024
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/car_list.css">
</head>
<body>

<h1>Danh Sách Xe</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Mã Xe</th>
        <th>Tên Xe</th>
        <th>Nhà Sản Xuất</th>
        <th>Giá</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="car" items="${cars}">
        <tr>
            <td>${car.id}</td>
            <td>${car.code}</td>
            <td>${car.name}</td>
            <td>${car.producer}</td>
            <td>${car.price}</td>
            <td><img src="img/${car.avatar}" width="100" height="100"></td>
            <td>
                <a href="${pageContext.request.contextPath}/cars?action=view&id=${car.id}">Xem</a>
                <a href="${pageContext.request.contextPath}/cars?action=update&id=${car.id}">Cập Nhật</a>
                <a href="${pageContext.request.contextPath}/cars?action=delete&id=${car.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
    <a href="${pageContext.request.contextPath}/cars?action=create">Thêm Mới Xe</a>
</body>
</html>
