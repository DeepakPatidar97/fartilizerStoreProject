<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<span>F</span>artilizer <span>S</span>tore
	</h1>

	<div class="main-content-agile">
		<div class="sub-main-w3">
			<form action="NewController" method="get">
				<div class="form-style-agile">
					<label>Email</label>
					<div class="pom-agile"  value="email">
						<span class="fa fa-envelope" aria-hidden="true"></span> <input
							placeholder="Email" name="email" type="email" required="">
					</div>
				</div>
				<div class="form-style-agile">
					<label>Password</label>
					<div class="pom-agile" value="password">
						<span class="fa fa-key" aria-hidden="true"></span> <input
							placeholder="Password" name="password" type="password"
							id="password1" required="">
					</div>
				</div>

					
						<input  name="page" value="login" hidden="true">
						<input type="submit" value="Login" > 
				
				<div class="">
					<a href="register.jsp"><label> <span></span>Create New Account
					</label></a>
					<br/>
					<a href="forget.jsp" id="brand1" type="submit"><label
						for="brand1"> <span></span>Forget Email and Password 
					</label></a>
				</div><br/>
				
			</form>
		</div>
	</div>
</body>
</html>