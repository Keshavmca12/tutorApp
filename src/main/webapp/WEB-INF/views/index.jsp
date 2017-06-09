<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html ng-app="loginApp">
<head>
<title>Tutor App</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<script src="loginResource/app.js"></script>
<script src="loginResource/registrationController.js"></script>
</head>
<body ng-controller="RegistrationController">
	<h3>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
	</h3>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>

				</button>
				<a class="navbar-brand" href="/">Tutor App</a>

			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/">Home</a></li>
					<li><a href="/Home/About">About</a></li>
					<li><a href="/Home/Contact">Contact</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container-fluid body-content">
		<div class="jumbotron">
			<h2>Login</h2>
			<form class="form-horizontal" name='loginForm'
		  action="<c:url value='/j_spring_security_check' />" method='POST'>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
					<div class="col-sm-10">
						<input type="text" name="name" class="form-control" id="inputEmail3"
							placeholder="Email">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword3"
							placeholder="Password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							<label> <input type="checkbox"> Remember me
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" value="sign in" class="btn btn-default"/>
					</div>
				</div>
			</form>
			<h2>New user register here</h2>
			<div ng-include="'loginResource/register.html'"></div>
		</div>
	</div>
	<footer class="navbar-fixed-bottom">
		<p>© 2015 -Tutor App</p>
	</footer>
</body>
</html>
