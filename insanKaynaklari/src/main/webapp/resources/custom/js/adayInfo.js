$(document).ready(function() {
	
	console.log("hello world");
	
	$("#dialog").dialog({
	    autoOpen: false
	});
        
	//getOneAday();
});

function addBlackListButton(){
	console.log("kara listeye eklendi");
	 $( "#dialog" ).dialog( "open" );
}

function addBlackList(){

	var sebep = $("#sebep").val();
	
	if(sebep == "")	{
		alert("Lütfen Bir Sebep Giriniz")
	}else{
		var adayId = $("#adayId").val();
		var hrId = $("#hrId").val();
		
		var param={
				aday_id : adayId,
				hr_id : hrId,
				reason : sebep
		}
		
		var ser_data =JSON.stringify(param);
		
		$.ajax({
			type : "POST",
			url : "../adayKaraListe",
			contentType:"application/json",
			data:ser_data,
			success : function(data) {

				console.log(data);
			},
			error : function(data) {
				console.log(data);
			}

		});
		
		//////////////////
		console.log(sebep);
		console.log("adayId :: "+adayId);
		console.log("hrId :: "+hrId);
		//////////////////
		
		$( "#dialog" ).dialog( "close" );
	}
	
}

function removeFromBlackList(){
	console.log("kara listeden çıkartıldı");
}

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