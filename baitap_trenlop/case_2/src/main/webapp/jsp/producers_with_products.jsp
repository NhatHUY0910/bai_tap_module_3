<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 06/05/2024
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/producers_with_products.css">
</head>
<body>

    <div class="container my-5">
        <h1 class="text-center mb-4">Producers with Products</h1>
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>Producer Name</th>
                <th>Producer Address</th>
                <th>Producer Country</th>
                <th>Product Name</th>
                <th>Price</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="producer" items="${productList}">
                    <tr>
                        <td>${producer.producerName}</td>
                        <td>${producer.producerAddress}</td>
                        <td>${producer.producerCountry}</td>
                        <td>${producer.productName}</td>
                        <td>${producer.price}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="${pageContext.request.contextPath}/products?action=list" class="btn btn-primary">Quay lại danh sách</a>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>
