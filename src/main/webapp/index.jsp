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
<script src="resources/login/app.js"></script>
<script src="resources/login/registrationController.js"></script>
</head>
<body ng-controller="RegistrationController">
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
					<li><a href="/tutorApp">Home</a></li>
					<li><a href="/Home/About">About</a></li>
					<li><a href="/Home/Contact">Contact</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container-fluid body-content">
		<div class="jumbotron">
			<h2>Login</h2>
			<form class="form-horizontal" action="/tutorApp/login"  method="post">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Username</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" 
							placeholder="Username" name="username"/>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" name="password"
							placeholder="Password" />
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
						<input type="submit" class="btn btn-default" value="Sign in"/>
					</div>
				</div>
			</form>
			<h2>New user register here</h2>
			<div ng-include="'resources/login/register.html'"></div>
		</div>
	</div>
	<footer class="navbar-fixed-bottom">
		<p>� 2015 -Tutor App</p>
	</footer>
</body>
</html>
