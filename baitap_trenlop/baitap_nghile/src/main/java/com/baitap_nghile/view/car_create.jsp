<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Mới Xe</title>
</head>
<body>
    <h1>Thêm mới xe</h1>
    <form action="car?action=create" method="post">
        <label for="code">Mã xe:</label>
        <input type="text" id="code" name="code" required><br>

        <label for="name">Tên xe:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="producer">Nhà sản xuất:</label>
        <input type="text" id="producer" name="producer" required><br>

        <label for="price">Giá:</label>
        <input type="number" id="price" name="price" required><br>

        <label for="avatar">Ảnh:</label>
        <input type="text" id="avatar" name="avatar" required><br>

        <input type="submit" value="Thêm mới">
    </form>
    <a href="car?action=list">Quay lại danh sách</a>
</body>
</html>

