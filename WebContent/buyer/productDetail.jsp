<%@page import="com.webportal.Product"%>
<%@page import="com.webportal.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>product Details</title>
</head>


<body>
	<h1>Product Detail</h1>
	<%
		List<User> tempUser = (List<User>) request.getAttribute("name");
		List<Product> tempProduct = (List<Product>) request.getAttribute("product_list");
	%>
	<%
		if (tempUser != null) {
			for (User tempuser : tempUser) {
	%>
	<label>name = <%=tempuser.getName_reg()%></label>
	<label>shop_name = <%=tempuser.getShop_name_reg()%></label>
	<%
		}
		}
	%>
	<%
		if (tempProduct != null) {
			for (Product tempproduct : tempProduct) {
	%>
	<label>id  = <%=tempproduct.getId()%></label><br>
	<label>product Name = <%=tempproduct.getProduct_name()%></label><br>
	<label>product Company = <%=tempproduct.getProduct_company()%></label><br>
	<label>Price = <%=tempproduct.getProduct_price()%></label><br>
	<label>Duration = <%=tempproduct.getProduct_duration()%></label><br>
	<label>expairy = <%=tempproduct.getProduct_expairy()%></label><br>
	<label>product_type = <%=tempproduct.getProduct_type()%></label><br>
	<label>product_veriety = <%=tempproduct.getProduct_variety()%></label><br>


	<%
		}
		}
	%>

</body>
</html>