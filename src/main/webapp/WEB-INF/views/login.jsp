<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html ng-app="loginApp">
<head>
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<title>Tutor App</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<!-- <script src="resources/js/app.js"></script>
<script src="resources/js/appController.js"></script>
<script src="resources/js/registrationController.js"></script> -->
<script src="resources/js/loginApp.js"></script>
<style type="text/css">
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

.underline-clickable {
	text-decoration: underline;
	cursor: pointer;
	color: blue;
}
</style>
</head>
<body ng-controller="loginCtrl">
<div ng-if="!registerView">
	<h3 >
		<h2>Login with Username and Password</h2>

		<h2>
			<c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>
		</h2>

	</h3>
</div>
	<div class="container-fluid body-content">
		<div class="jumbotron" ng-if="!registerView">
			<h2>Login</h2>
			<form class="form-horizontal" name='loginForm'
				action="/tutorApp/j_spring_security_check" method='POST'>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
					<div class="col-sm-10">
						<input type="text" name="userName" class="form-control"
							id="inputEmail3" placeholder="Email">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword3"
							name="password" placeholder="Password">
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
						<input type="submit" class="btn btn-primary" value="sign in"
							class="btn btn-default" />
					</div>
				</div>
				<sec:csrfInput />
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
			<h2>
				New user register here <span class="underline-clickable"
					ng-click="toggleView()">Register</span>
			</h2>

		</div>
		<div ng-if="registerView">
			<h2>Register</h2>
			<div class="slide-animate" ng-include="'resources/register.jsp'"></div>
		</div>
	</div>
	<footer class="navbar-fixed-bottom">
		<p>© 2015 -Tutor App</p>
	</footer>
</body>
</html>
