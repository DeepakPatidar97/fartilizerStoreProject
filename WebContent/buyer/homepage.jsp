<!DOCTYPE html>
<%@page import="com.webportal.Product"%>
<%@page import="com.webportal.User"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../../css/main.css">
<link rel="stylesheet" href="../css/style.css" type="text/css"
	media="all" />
<link rel="stylesheet" href="../css/font-awesome.css">
<title>Home Page</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
</head>
<body>
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
	<button type="button"
		onclick="window.location.href='index.jsp'; return false;"
		style="float: right;">Logout</button>
	<table class="table table-borderless table-dark">
		<thead>
			<tr>
				<th scope="col">product id</th>
				<th scope="col">product Name</th>
				<th scope="col">Product_company</th>
				<th scope="col">Product_type</th>
				<th scope="col">Product_duration</th>
			</tr>
		</thead>
		<tbody>
			<%
				if (tempProduct != null) {
					for (Product tempproduct : tempProduct) {
			%>
			<c:forEach var="tempuser" items="${product_list}">
				<c:url var="addLink" value="NewController">
					<c:param name="page" value="buyPage" />
					<c:param name="id" value="<%=tempproduct.getId()%>" />
					<c:param name="product_name"
						value="<%=tempproduct.getProduct_name()%>" />
				</c:url>
			
				<c:url var="infoLink" value="NewController">
					<c:param name="page" value="buyerProductDetail" />
					<c:param name="id" value="<%=tempproduct.getId()%>" />
					<c:param name="product_name"
						value="<%=tempproduct.getProduct_name()%>" />
				</c:url>
				
			</c:forEach>
			<tr>
				<td><%=tempproduct.getId()%></td>
				<td><%=tempproduct.getProduct_name()%></td>
				<td><%=tempproduct.getProduct_company()%></td>
				<td><%=tempproduct.getProduct_type()%></td>
				<td><%=tempproduct.getProduct_duration()%></td>
				<td><a href="${addLink}">Buy Now</a>|
				<td><a href="${infoLink}">Click More...</a>
			</tr>

			<%
				} 
				}
			%>
		</tbody>

	</table>

</body>
</html>
