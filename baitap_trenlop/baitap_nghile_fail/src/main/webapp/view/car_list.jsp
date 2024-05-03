<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh Sách Xe</title>
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
<%--                <th>Hành động</th>--%>
            </tr>
            <c:forEach var="car" item="${cars}">
                <tr>
                    <td>${car.id}</td>
                    <td>${car.code}</td>
                    <td>${car.name}</td>
                    <td>${car.producer}</td>
                    <td>${car.price}</td>
                    <td><img src="${car.avatar}" width="100" height="100"></td>
                    <td>
                        <a href="car?action=view&id=${car.id}">Xem</a>
                        <a href="car?action=update&id=${car.id}">Cập Nhật</a>
                        <a href="car?action=delete&id=${car.id}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="car?action=create">Thêm Mới Xe</a>
</body>
</html>

