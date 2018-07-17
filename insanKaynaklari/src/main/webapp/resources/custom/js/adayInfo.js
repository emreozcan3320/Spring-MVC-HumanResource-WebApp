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
			headers: { 'islem': 'add' },
			url : "../../adayKaraListe",
			contentType:"application/json",
			data:ser_data,
			success : function(data) {
				window.location.reload();
				console.log(data);
			},
			error : function(data) {
				window.location.reload();
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
	var adayId = $("#adayId").val();
	var hrId = $("#hrId").val();
	
	var param={
			aday_id : adayId,
			hr_id : hrId,
			reason : null
	}
	
	var ser_data =JSON.stringify(param);
	
	$.ajax({
		type : "POST",
		headers: { 'islem': 'remove' },
		url : "../../adayKaraListe",
		contentType:"application/json",
		data:ser_data,
		success : function(data) {
			window.location.reload();
			console.log(data);
		},
		error : function(data) {
			window.location.reload();
			console.log(data);
		}

	});
	
	
}

function basvuruKabul(){
	var adayId = $("#adayId").val();
	var jobId= $("#jobId").val();
	var basvuruId= $("#basvuruId").val();
	
	var param={
			jobaday_id : basvuruId,
			aday_id : adayId,
			basvuru_statusu : "red",
			job_id : jobId
	}
	
	var ser_data =JSON.stringify(param);
	
	$.ajax({
		type : "POST",
		headers: { 'islem': 'kabul' },
		url : "../../adayBasvuruIslem",
		contentType:"application/json",
		data:ser_data,
		success : function(data) {
			window.location.reload();
			console.log(data);
		},
		error : function(data) {
			window.location.reload();
			console.log(data);
		}

	});
	
}

function basvuruRed(){
	var adayId = $("#adayId").val();
	var jobId= $("#jobId").val();
	var basvuruId= $("#basvuruId").val();
	
	var param={
			jobaday_id : basvuruId,
			aday_id : adayId,
			basvuru_statusu : "red",
			job_id : jobId
	}
	
	var ser_data =JSON.stringify(param);
	
	$.ajax({
		type : "POST",
		headers: { 'islem': 'red' },
		url : "../../adayBasvuruIslem",
		contentType:"application/json",
		data:ser_data,
		success : function(data) {
			window.location.reload();
			console.log(data);
		},
		error : function(data) {
			window.location.reload();
			console.log(data);
		}

	});
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