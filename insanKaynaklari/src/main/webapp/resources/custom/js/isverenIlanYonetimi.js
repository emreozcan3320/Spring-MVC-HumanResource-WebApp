$(document).ready(function() {
	
	

	$.ajax({
		type : "POST",
		url : "ilan",
		success : function(data) {

			var list = "";
			
			$(data).each(function(i,val){
				
				list = list 
				+'<li>'+val.title+'</li>';
				
				console.log(val.title);
			});
			$("#list").html(list);
		},
		error : function(data) {
			console.log(data);
		}

	});
});