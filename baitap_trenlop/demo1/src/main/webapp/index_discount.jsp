<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 24/04/2024
  Time: 10:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Discount Calculator</title>
</head>
<body>

        <h1>Product Discount Calculator</h1>
        <form action="discount" method="post">
            <label for="productDesciption">Product Description</label>
            <input type="text" id="productDesciption" name="productDesciption" required><br>

            <label for="listPrice">List Price</label>
            <input type="number" id="listPrice" name="listPrice" min="0" step="0.01" readonly><br>

            <input type="submit" value="Calculate Discount">
        </form>

</body>
</html>
