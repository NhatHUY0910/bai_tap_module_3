<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 02/05/2024
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập Nhật Xe</title>
</head>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/car_update.css">
</head>

</html>
<body>

        <h1>Cập Nhật Xe</h1>
        <form action="${pageContext.request.contextPath}/cars?action=update"  method="post">
            <input type="hidden" name="id" value="${car.id}">

            <label for="code">Mã xe:</label>
            <input type="text" id="code" name="code" value="${car.code}" required><br>

            <label for="name">Tên xe:</label>
            <input type="text" id="name" name="name" value="${car.name}" required><br>

            <label for="producer">Nhà sản xuất:</label>
            <input type="text" id="producer" name="producer" value="${car.producer}" required><br>

            <label for="price">Giá:</label>
            <input type="number" id="price" name="price" value="${car.price}" required><br>

            <label for="avatar">Ảnh:</label>
            <input type="text" id="avatar" name="avatar" value="${car.avatar}" required><br>

            <input type="submit" value="Cập nhật">
        </form>
        <a href="cars?action=cars">Quay lại danh sách</a>

</body>
</html>
