<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Your Account</title>

<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/font-awesome.css">
<link
	href="//fonts.googleapis.com/css?family=Niconne&amp;subset=latin-ext"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
	rel="stylesheet">
</head>
<body class="bg">
	<h1>
		<span>F</span>artilizer <span>S</span>tore <span>R</span>egistration
	</h1>
	<div class="main-content-agile">
		<div class="sub-main-w3">
			<form action="NewController" method="get">
			
			<div class="form-style-agile">
					<label> User Type</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <select
							name="user_type">
							<option value="null">Select</option>
							<option value="seller">Seller</option>
							<option value="buyer">Buyer</option>
						</select>
					</div>
				</div>
			
			<div class="form-style-agile">
					<label>Your Name</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <input
							placeholder="Your Name" name="name" type="text" required="">
					</div>
				</div>
								
				<div class="form-style-agile">
					<label>Shop Name</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <input
							placeholder="Shop Name" name="shop_name" type="text" required="">
					</div>
				</div>
				
				
				<div class="form-style-agile">
					<label>Address</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <input
							placeholder="Address" name="address" type="text" required="">
					</div>
				</div>
				<div class="form-style-agile">
					<label>Contact No</label>
					<div class="pom-agile">
						<span class="fa fa-user-o" aria-hidden="true"></span> <input
							placeholder="Contact No" name="contact" type="number" required="">
					</div>
				</div>
				<div class="form-style-agile">
					<label>Email</label>
					<div class="pom-agile">
						<span class="fa fa-envelope" aria-hidden="true"></span> <input
							placeholder="Email" name="email" type="email" required="">
					</div>
				</div>
				<div class="form-style-agile">
					<label>Password</label>
					<div class="pom-agile">
						<span class="fa fa-key" aria-hidden="true"></span> <input
							placeholder="Password" name="password" type="password"
							id="password1" required="">
					</div>
				</div>
				<div class="form-style-agile">
					<label>Confirm Password</label>
					<div class="pom-agile">
						<span class="fa fa-key" aria-hidden="true"></span> <input
							placeholder="Confirm Password" name="confirm_Password"
							type="password" id="password2" required="">
					</div>
				</div>
				<div class="sub-agile">
					<input type="checkbox" id="brand1" value=""> <label
						for="brand1" required=""> <span></span>I Accept to the Terms &
						Conditions
					</label>
				</div>				
				<input  name="page" value="register" hidden="true">
						<input type="submit" value="Register" > 
						
						
				<div class="">
					 <br /> <a href="index.jsp" id="brand2" type="submit"><label
						for="brand2"> <span></span>Go back and SignIn
					</label></a>
					<br/>
					<a href="forget.jsp" id="brand3" type="submit"><label
						for="brand3"> <span></span>Forget Email and Password 
					</label></a>
				</div>
			</form>
		</div>
		<div class="img-w3layouts">
			<img src="images/1.png" alt="">
		</div>
	</div>
	<div class="footer">
		<h2>
			&copy; 2018 Stylish Register Form. All rights reserved | Design by <a
				href="http://sowmitras.com">Company</a>
		</h2>
	</div>

	<script src="js/main.js"></script>
</body>
</html>