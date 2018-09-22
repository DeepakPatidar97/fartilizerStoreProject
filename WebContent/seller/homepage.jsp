<!DOCTYPE html>
<%@page import="com.webportal.Product"%>
<%@page import="com.webportal.User"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/font-awesome.css">
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
				<c:url var="updateLink" value="NewController">
					<c:param name="page" value="updatePage" />
					<c:param name="id" value="<%=tempproduct.getId()%>" />
					<c:param name="product_name"
						value="<%=tempproduct.getProduct_name()%>" />
				</c:url>
				<c:url var="deleteLink" value="NewController">
					<c:param name="page" value="delete" />
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
				<td><a href="${updateLink}">Update</a> | <a
					href="${deleteLink}"
					onclick="if (!(confirm('Are you sure you want to delete this Product?'))) return false">
						Delete</a></td>
			</tr>

			<%
				}
				}
			%>
		</tbody>

	</table>

	<button id="myBtn">NEW PRODUCT</button>

	<!-- The Modal -->
	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">
			<span class="close">&times;</span>

			<p>
			<form action="NewController" method="get">
				<div class="form-style-agile">
					<label>Product Name</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <input
							placeholder="Product Name" name="product_name" type="text">
					</div>
				</div>

				<div class="form-style-agile">
					<label>Product Company</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <input
							placeholder="Product Company" name="product_company" type="text">
					</div>
				</div>

				<div class="form-style-agile">
					<label>Product Expiry Date</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <input
							placeholder="Product Expiry Date" name="product_expairy"
							type="text">
					</div>
				</div>

				<div class="form-style-agile">
					<label>Product Price</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <input
							placeholder="Product Price" name="product_price" type="text">
					</div>
				</div>

				<div class="form-style-agile">
					<label> Product Quantity</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <input
							placeholder="Product Quantity" name="product_quantity"
							type="text">
					</div>
				</div>

				<div class="form-style-agile">
					<label>Product Duration</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <input
							placeholder="Product Duration" name="product_duration"
							type="text">
					</div>
				</div>

				<div class="form-style-agile">
					<label>Product Variety</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <input
							placeholder="Product Variety" name="product_variety" type="text">
					</div>
				</div>

				<div class="form-style-agile">
					<label> Product Type</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <select
							name="product_type">
							<option value="null">select</option>
							<option value="organic">Organic</option>
							<option value="inorganic">Inorganic</option>
							<option value="machine">Machine</option>
						</select>
					</div>
				</div>

				<input name="page" value="addProduct" hidden="true"> <input
					type="submit" value="Add product">
			</form>


		</div>

	</div>

	<script>
		// Get the modal
		var modal = document.getElementById('myModal');

		// Get the button that opens the modal
		var btn = document.getElementById("myBtn");

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];

		// When the user clicks the button, open the modal 
		btn.onclick = function() {
			modal.style.display = "block";
		}

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
			modal.style.display = "none";
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>


</body>
</html>
