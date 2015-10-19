tutorApp.controller("RegistrationController",function($scope,$http){
$scope.user={};	
$scope.submitUserDetails=function(user){
	console.log("user",user);
	$http({
		url:'/tutorApp/submitUserDetails', 
		method: "post",
		params: {data: user}
	}).then(function(response){
		console.log("reponse",response);
		$scope.user={};
	});
};
  
	
});