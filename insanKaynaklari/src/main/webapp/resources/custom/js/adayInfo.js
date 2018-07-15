$(document).ready(function() {
	
	console.log("hello world");
});

function getOneAday(){
	$.ajax({
		type : "POST",
		url : "./adayInfo",
		contentType:"html/text; charset-UTF8",
		data:$("#aday_id").val()+"",
		success : function(data) {

			console.log(data);
			/*
			$("#activation_date").html(tarih (data.activation_date));
			$("#create_date").html(tarih (data.create_date));
			$("#expertise").html(data.expertise);
			$("#expiration_date").html(tarih (data.expiration_date));
			$("#job_definition").html(data.job_definition);
			$("#personal_qualities").html(data.personal_qualities);
			$("#status").html(data.status);
			$("#title").html(data.title);*/
		},
		error : function(data) {
			console.log(data);
		}

	});
}