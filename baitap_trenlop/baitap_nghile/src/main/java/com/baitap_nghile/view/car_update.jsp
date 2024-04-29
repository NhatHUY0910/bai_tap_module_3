<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập Nhật Xe</title>
</head>
<body>
<h1>Cập Nhật Xe</h1>
<form action="car?action=update" method="post">
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
<a href="car?action=list">Quay lại danh sách</a>
</body>
</html>