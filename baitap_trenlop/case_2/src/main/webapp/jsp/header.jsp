<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 07/05/2024
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>

<%--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css?v=<?php echo time(); ?>">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="products?action=list">Quản Lý Sản Phẩm</a>
        
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav navbar-nav-custom">
                
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/products?action=list">Danh Sách Sản Phẩm</a>
                </li>
                
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="sortDropdown" data-bs-toggle="dropdown" aria-expanded="false">Sắp Xếp</a>

                    <ul class="dropdown-menu" aria-labelledby="sortDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/products?action=sortByPriceAscending">Giá Tăng Dần</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/products?action=sortByPriceDescending">Giá Giảm Dần</a></li>
                    </ul>
                </li>


                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="listDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Danh Sách</a>

                    <ul class="dropdown-menu" aria-labelledby="listDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/products?action=showProductsWithProducers">Sản Phẩm & Nhà Sản Xuất</a></li>

                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/products?action=showProducersWithProducts">Nhà Sản Xuất & Sản Phẩm</a></li>

                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/products?action=showProductsWithCategoriesAndShippers">Sản Phẩm & Danh Mục & Người Giao Hàng</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>


