<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Nhap Thong Tin</a>

        <form action="info" method="post">

          <label for="name">Tên:</label>
          <input type="text" id="name" name="name" required><br><br>

          <label for="birthYear">Năm sinh:</label>
          <input type="number" id="birthYear" name="birthYear" required><br><br>

          <input type="submit" value="Gửi">
        </form>

</body>
</html>