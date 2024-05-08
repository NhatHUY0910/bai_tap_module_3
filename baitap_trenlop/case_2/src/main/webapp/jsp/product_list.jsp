<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 05/05/2024
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Danh Sách Sản Phẩm</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/product_list.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
        <%@include file="/jsp/header.jsp"%>
        <div class="container my-4">
            <h1>Danh Sách Sản Phẩm</h1>
            <a href="products?action=create" class="btn btn-primary mb-3">Thêm Sản Phẩm Mới</a>
            <table class="table table-striped">
                <thread>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Producer</th>
                        <th>Category</th>
                        <th>Shipper</th>
                        <th>Image</th>
                        <th></th>
                    </tr>
                </thread>
                <tbody>
                    <c:forEach items="${productList}" var="product">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.name}</td>
                            <td>${product.price}</td>
                            <td>${product.producer}</td>
                            <td>${product.categories}</td>
                            <td>${product.shipper}</td>
                            <td><img src="${product.image}" width="100" height="100"></td>
                            <td>
                                <div class="btn-group" role="group" aria-label="Action Buttons">
                                    <a href="${pageContext.request.contextPath}/products?action=view&id=${product.id}" class="btn btn-success me-2">Xem</a>
                                    <a href="${pageContext.request.contextPath}/products?action=update&id=${product.id}" class="btn btn-primary me-2">Cập Nhật</a>
                                    <a href="${pageContext.request.contextPath}/products?action=delete&id=${product.id}" class="btn btn-danger">Xóa</a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <%@include file="/jsp/footer.jsp"%>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>
</html>


