$(document).ready(function() {
	
	console.log("ilanDetaylari");
	
        
	//getOneAday();
});

function basvur(ilan_id,user_id){
	
	console.log("ilan_id ::" + ilan_id);
	console.log("user_id ::" + user_id);
	
	var param={
			aday_id : user_id,
			job_id : ilan_id
	}
	
	var ser_data =JSON.stringify(param);
	
	$.ajax({
		type : "POST",
		url : "../aday/basvur",
		contentType:"application/json",
		data:ser_data,
		success : function(data) {

			console.log(data);
		},
		error : function(data) {
			console.log(data);
		}

	});
}