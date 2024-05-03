<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 02/05/2024
  Time: 8:28 PM
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
        <title>Document</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/car_view.css">
</head>

<body>

        <h1>Thông tin xe</h1>
        <p>ID: ${view.id}</p>
        <p>Mã xe: ${view.code}</p>
        <p>Tên xe: ${view.name}</p>
        <p>Nhà sản xuất: ${view.producer}</p>
        <p>Giá: ${view.price}</p>
        <p>Ảnh: <img src="${view.avatar}" width="200" height="200"></p>

        <a href="${pageContext.request.contextPath}/cars?action=cars">Quay lại danh sách</a>

</body>
</html>
