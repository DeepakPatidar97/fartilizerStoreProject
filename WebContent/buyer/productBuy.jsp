<%@page import="com.webportal.Product"%>
<%@page import="com.webportal.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Now Page</title>
</head>
<body>
<h1>Buy Now</h1>
<%
		/* List<User> tempUser = (List<User>) request.getAttribute("name"); */
		List<Product> tempProduct = (List<Product>) request.getAttribute("product_list");
	%>
	<%-- <%
		if (tempUser != null) {
			for (User tempuser : tempUser) {
	%>
	<label>name = <%=tempuser.getName_reg()%></label>
	<label>shop_name = <%=tempuser.getShop_name_reg()%></label>
	<%
		}
		}
	%> --%>
	<%
		if (tempProduct != null) {
			for (Product tempproduct : tempProduct) {
	%>
	<label>id  = <%=tempproduct.getId()%></label><br>
	<label>product Name = <%=tempproduct.getProduct_name()%></label><br>
	<label>product Company = <%=tempproduct.getProduct_company()%></label><br>
	<label>Price = <%=tempproduct.getProduct_price()%></label><br>


	<%
		}
		}
	%>
<h2>not able</h2>
</body>
</html>