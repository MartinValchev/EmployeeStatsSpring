<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="./pages/css/bootstrap.min.css" />
<link href="./pages/css/stylesheet-main.css" rel="stylesheet">
<script src="./pages/js/jquery-3.2.1.js"></script>
<script src="./pages/js/popper.min.js"></script>
<script src="./pages/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h2 class="pageHeading">Login Employees Application</h2>
		</div>
		<nav id="navigation_bar" class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" onclick="window.location.href ='login.html'" href="#">Employee Login Page</a>
			</div>
			<ul class="nav navbar-nav" id="mainMenu">
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li></ul>
			<ul class="nav navbar-nav navbar-right">
				<li></li>
				<li></li>
			</ul>
		</div>
	</nav>
		<div   id="login_Container" class="container">	
			<div class="panel panel-default">
				<div class="panel-body">
					
					<p>In order to access Employees resources please log
						in</p>
				</div>
			</div>
			<div class="panel panel-default">
			<br/>
			<form name="login" method="POST" class="loginForm"
				action="http://localhost:8080/EmployeeStatsWeb/webapi/login">
				<div class="form-group">
					<label class="control-label col-sm-2" for="user_name">Username:</label>
					<input class="username" type="text" name="username" id="user_name" />
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="pass_word">Password:</label><input
						class="password" type="password" id="pass_word" name="password" />
				</div>
				<input id="login-btn" class="btn btn-success" type="submit"
					value="Submit">
			</form>
			</div>
		</div>
	</div>
</body>
</html>