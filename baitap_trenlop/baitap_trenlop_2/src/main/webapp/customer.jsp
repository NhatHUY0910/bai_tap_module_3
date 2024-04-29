<%@ page import="java.util.List" %>
<%@ page import="org.example.baitap_trenlop_2.Customer" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 25/04/2024
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

            <%

                List<Customer> customerList = new ArrayList<>();
                customerList.add(new Customer("Nhat", "Huy1", 20, "Sai Gon"));
                customerList.add(new Customer("Nhat", "Huy2", 21, "Sai Gon"));
                customerList.add(new Customer("Nhat", "Huy3", 22, "Sai Gon"));
                customerList.add(new Customer("Nhat", "Huy4", 23, "Sai Gon"));
                customerList.add(new Customer("Nhat", "Huy5", 24, "Sai Gon"));

                request.setAttribute("dskh", customerList);
            %>

<body>



</body>
</html>
