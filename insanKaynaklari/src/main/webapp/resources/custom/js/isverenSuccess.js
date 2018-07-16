
	$(document).ready(function () {
		
		var AuthLdapUserName = $("#username").val();
		
		userCheck(AuthLdapUserName);
	    // Handler for .ready() called.
		
	    window.setTimeout(function () {
	        location.href = "/insanKaynaklari/isveren/index";
	    }, 1000);
	});
	
	function userCheck(ldapUserName){
		console.log("useCheck e gelen username ::: "+ldapUserName);
		var param = {
				username:ldapUserName
		}
		
		var ser_data =JSON.stringify(param);
		
		$.ajax({
			type : "POST",
			url : "adayValidate",
			contentType:"html/text; charset-UTF8",
			data: ldapUserName,
			success : function(data) {

				console.log(data);
			},
			error : function(data) {
				console.log(data);
			}

		});
		
	}