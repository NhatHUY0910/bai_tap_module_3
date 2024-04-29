<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông Tin Xe</title>
</head>
<body>
        <h1>Thông tin xe</h1>
        <p>ID: ${car.id}</p>
        <p>Mã xe: ${car.code}</p>
        <p>Tên xe: ${car.name}</p>
        <p>Nhà sản xuất: ${car.producer}</p>
        <p>Giá: ${car.price}</p>
        <p>Ảnh: <img src="${car.avatar}" width="200" height="200"></p>
        <a href="car?action=list">Quay lại danh sách</a>
</body>
</html>

