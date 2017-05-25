var loginApp=angular.module("loginApp",[]);
loginApp.config(function($httpProvider) {
	$httpProvider.interceptors.push(function() {
		return {

			'response': function(response) {
				// same as above
				var responseStr = JSON.stringify(response);
//				console.log("Response as it is: "+response.data);
				if(responseStr.indexOf('SESSIONTIMEOUTDIVINVALIDSESSION') > -1){
					//alert(responseStr);
					window.location.href = "/tutorApp/invalidSession";
				}
				return response;
			}
		};
	});


});

