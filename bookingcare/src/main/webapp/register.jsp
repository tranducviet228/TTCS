
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Log in with your credentials</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body>
	<div class="text-center">
		<h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
	</div>
	<form class="user" action="/register" method="post">
		<div class="form-group row">
			<div class="col-sm-6 mb-3 mb-sm-0">
				<input type="text" class="form-control form-control-user"
					id="exampleFirstName" name="username" placeholder="Name" required>
			</div>

		</div>
		<div class="form-group">
			<input type="email" class="form-control form-control-user"
				id="exampleInputEmail" name="email" placeholder="Email Address"
				required>
		</div>
		<div class="form-group">
			<input type="text" class="form-control form-control-user"
				id="exampleInputEmail" name="phone" placeholder="Phone" required>
		</div>
		<div class="form-group">
			<input type="hidden" class="form-control form-control-user"
				id="exampleInputEmail" value="ROLE_MEMBER" name="role">
		</div>
		<div class="form-group row">
			<div class="col-sm-6 mb-3 mb-sm-0">
				<input type="password" class="form-control form-control-user"
					id="exampleInputPassword" placeholder="Password" name="password"
					required>
			</div>
			<div class="col-sm-6">
				<input type="password" class="form-control form-control-user"
					id="exampleRepeatPassword" placeholder="Repeat Password" required>
			</div>
		</div>
		<button type="submit" class="btn btn-primary btn-user btn-block"
			value="Register">Register</button>

		<hr>

		<!-- /container -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>