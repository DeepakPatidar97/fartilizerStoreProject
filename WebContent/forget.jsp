<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Your Account</title>

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
		<span>W</span>eb <span>P</span>ortal
	</h1>

	<div class="main-content-agile">
		<div class="sub-main-w3">
			<form action="NewController" method="get">
				<div class="form-style-agil">
					<label>Select anyone</label> <select class="pom-agile" name="filled" >
						<option value="email_reg"><label> <span></span>Email
							</label></option>
						<option value="contact_reg"><label> <span></span>Contact
							</label></option>
					</select>

				</div>

				<div class="form-style-agile">
					<label>Email/Contact</label>
					<div class="pom-agile">
						<span class="fa fa-envelope" aria-hidden="true"></span> <input
							placeholder="Email/Contact" name="user_id" type="text"
							required="">
					</div>
				</div>

				<div class="form-style-agile">
					<label>New Password</label>
					<div class="pom-agile">
						<span class="fa fa-envelope" aria-hidden="true"></span> <input
							placeholder="New Password" name="password" type="password"
							required="" id="password1">
					</div>
				</div>

				<div class="form-style-agile">
					<label>Confirm Password</label>
					<div class="pom-agile">
						<span class="fa fa-envelope" aria-hidden="true"></span> <input
							placeholder="Confirm Password" name="confirm_Password"
							type="password" required="" id="password2">
					</div>
				</div>
				<input  name="page" value="forget" hidden="true">
						<input type="submit" value="Forget" > 
						
				<div class="">
					<a href="<%=request.getContextPath() %>/Controller?page=register" id="brand1" type="submit"><label
						for="brand1"> <span></span>Create New Account
					</label></a> <br /> <a href="index.jsp" id="brand1" type="submit"><label
						for="brand1"> <span></span>Go back and SignIn
					</label></a>
				</div>
				<br />

			</form>
		</div>
	</div>
</body>
</html>