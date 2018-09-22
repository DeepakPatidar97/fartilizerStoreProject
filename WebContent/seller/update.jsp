<!DOCTYPE html>
<%@page import="com.webportal.Product"%>
<%@page import="java.util.List"%>
<html>

<head>
	<title>Update Product</title>

	<link type="text/css" rel="stylesheet" href="/css/style.css">
	<link type="text/css" rel="stylesheet" href="/css/add-student-style.css">	
</head>

<body>
	
	<%
	List<Product> tempProduct = (List<Product>) request.getAttribute("tempProduct_list");
	%>
	<div id="wrapper">
		<div id="header">
			<h2>The Great Indian Farmer</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update Product</h3>
		
		
			<%
				for (Product tempproduct : tempProduct) {
			%>
			<form action="NewController" method="GET">
		
				<input value ="<%= tempproduct.getId() %>" name="id" type="hidden">
					
				
				<div class="form-style-agile">
					<label>Product Name</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <input
							value ="<%= tempproduct.getProduct_name() %>" name="product_name" type="text">
					</div>
				</div>

				<div class="form-style-agile">
					<label>Product Company</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <input
							value="<%= tempproduct.getProduct_company() %>" name="product_company" type="text">
					</div>
				</div>

				<div class="form-style-agile">
					<label>Product Expiry Date</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <input
							value="<%= tempproduct.getProduct_expairy() %>" name="product_expairy"
							type="text">
					</div>
				</div>

				<div class="form-style-agile">
					<label>Product Price</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <input
							value="<%= tempproduct.getProduct_price() %>" name="product_price" type="text">
					</div>
				</div>

				<div class="form-style-agile">
					<label> Product Quantity</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <input
							value="<%= tempproduct.getProduct_quantity() %>" name="product_quantity"
							type="text">
					</div>
				</div>

				<div class="form-style-agile">
					<label>Product Duration</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <input
							value="<%= tempproduct.getProduct_duration() %>" name="product_duration"
							type="text">
					</div>
				</div>

				<div class="form-style-agile">
					<label>Product Variety</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <input
							value="<%= tempproduct.getProduct_variety() %>" name="product_variety" type="text">
					</div>
				</div>
				<div class="form-style-agile">
					<label> Product Type</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <select
							name="product_type">
							<option value="<%= tempproduct.getProduct_type() %>"></option>
							<option value="organic">Organic</option>
							<option value="inorganic">Inorganic</option>
							<option value="machine">Machine</option>
						</select>
					</div>
				</div>

				<input name="page" value="update" hidden="true"> <input
					type="submit" value="UPDATE">
			</form>
			<%
				}
			%>
		
		
		<div style="clear: both;"></div>
		
		<!-- <p>
			<a href="Controller">Back to List</a>
		</p> -->
	</div>
</body>

</html>
