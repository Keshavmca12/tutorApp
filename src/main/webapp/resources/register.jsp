<div ng-controller="RegistrationController">
	<form  name="userForm">
		<div class="form-group">
			<label>Name</label> <input type="text" name="name"
				class="form-control" placeholder="name" ng-model="user.name">
		</div>
		<div class="form-group">
			<label>Email address</label> <input type="email" class="form-control"
				name="email" ng-model="user.email" placeholder="Email">
		</div>
		<div class="form-group">
			<label>Password</label> <input type="password" class="form-control"
				name="password" ng-model="user.password" placeholder="Password">
		</div>
		<div class="form-group">
			<label>Mobile no.</label> <input type="number" class="form-control"
				name="mobileNo" ng-model="user.mobileNo" placeholder="mobile no">
		</div>
		<div class="form-group">
			<label>Register AS</label> <select id="role" class="form-control"
				ng-model="user.userType">
				<option ng-selected="true" value="-1">Select your role</option>
				<option value="1">Teacher</option>
				<option value="2">Student</option>
			</select>
		</div>
		<label class="radio-inline"> <input type="radio"
			name="sexOption" value="1" ng-model="user.sex"> Male
		</label> <label class="radio-inline"> <input type="radio"
			name="sexOption" value="2" ng-model="user.sex"> Female
		</label> <label class="radio-inline"> <input type="radio"
			name="sexOption" value="3" ng-model="user.sex"> other
		</label>
		<div class="checkbox">
			<label> <input type="checkbox" name="termsAgreement">Terms
				and condition
			</label>
		</div>
		<%-- <sec:csrfInput />
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> --%>
		<button type="submit" class="btn btn-primary"
			ng-click="submitUserDetails(user)">Submit</button>
			
			<div class="msg" ng-if="successfulMsg!=' '">{{successfulMsg}}</div>
		<h2>
			Existing User
			<span class="underline-clickable" ng-click="toggleView()">Login</span>
		</h2>
	</form>
</div>