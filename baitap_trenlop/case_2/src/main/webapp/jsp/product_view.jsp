<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 06/05/2024
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/product_view.css">

</head>
<body>

        <div class="container my-5">
                <h1 class="text-center mb-4">Thông Tin Sản Phẩm</h1>
                <div class="row">
                        <div class="col-md-6">
                            <img src="${view.image}" class="img-fluid mb-3" alt="${view.name}">
                        </div>
                        <div class="col-md-6">
                                <p><strong>ID:</strong> ${view.id}</p>
                                <p><strong>Name:</strong> ${view.name}</p>
                                <p><strong>Price:</strong> ${view.price}</p>
                                <p><strong>Producer:</strong> ${view.producer}</p>
                                <p><strong>Categories:</strong> ${view.categories}</p>
                                <p><strong>Shipper:</strong> ${view.shipper}</p>
                        </div>
                </div>
                <a href="${pageContext.request.contextPath}/products?action=list" class="btn btn-primary">Quay lại danh sách</a>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
