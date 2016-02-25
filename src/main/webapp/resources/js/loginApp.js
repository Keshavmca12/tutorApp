var loginApp=angular.module("loginApp",[]);
loginApp.controller("loginCtrl",function($scope,$http){

	$scope.registerView=false;
	$scope.toggleView=function(){
		$scope.registerView=!$scope.registerView;
	};

});
loginApp.config(function($httpProvider) {// provider-injector
	// $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
	$httpProvider.interceptors.push("securityInterceptor");

});

loginApp.controller("RegistrationController",function($scope,$http){
	$scope.user={};	
	$scope.successfulMsg=" ";
	$scope.submitUserDetails=function(user){
		console.log("user",user);
		$http({
			url:'/tutorApp/submitUserDetails', 
			method: "POST",
			data: user
		}).then(function(response){
			console.log("reponse REGISTER USER",response);
			$scope.successfulMsg="you have registered successfully now you can login";
			$scope.user={};
		}, function(err) {
			console.log("error register USER",err);
		  }
		);/*.catch(function(data, status) {
			console.error('Gists error', response.status, response.data);
		});*/
	};

});
function b(a){return a?(a^Math.random()*16>>a/4).toString(16):([1e16]+1e16).replace(/[01]/g,b)};
loginApp.factory("securityInterceptor",  function($log,$q){
	return {
		'request': function(response) {
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			console.log("token : "+token+"    header :  "+header);
			if(response.method="POST"){
				console.log("response brfore  :   ",response);
				response.headers[header]=token;
				console.log("response after  :   ",response);
			}
			return response;
		},
		'responseError': function(rejection) {
			return $q.reject(rejection);
		},
		'response': function(response) {
			//console.log(response);
			if (typeof response.data === "string" && response.data.indexOf("loginPageId") > -1) {
				location.reload();
			}
			return response;
		}
	};
});
