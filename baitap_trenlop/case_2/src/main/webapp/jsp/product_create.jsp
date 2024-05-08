<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 05/05/2024
  Time: 9:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/product_create.css">
</head>
<body>

    <%@include file="/jsp/header.jsp"%>

    <div class="container my-5">
        <form action="${pageContext.request.contextPath}/products?action=create" method="post" class="form-group">
        <h1 class="text-center mb-4">Create New Product</h1>

            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" id="name" name="name" class="form-control" required><br>
            </div>

            <div class="mb-3">
                <label for="price" class="form-label">Price:</label>
                <input type="number" id="price" name="price" step="0.01" class="form-control" required><br>
            </div>

            <div class="mb-3">
                <label for="producer" class="form-label">Producer:</label>
                <input type="text" id="producer" name="producer" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="categories" class="form-label">Category:</label>
                <input type="text" id="categories" name="categories" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="shipper" class="form-label">Shipper:</label>
                <input type="text" id="shipper" name="shipper" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="image" class="form-label">Image:</label>
                <input type="text" id="image" name="image" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary">Create</button>

        </form>
        <a href="${pageContext.request.contextPath}/products?action=list" class="btn btn-secondary mt-3">Quay Lại Danh Sách</a>
    </div>

    <%@include file="/jsp/footer.jsp"%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
