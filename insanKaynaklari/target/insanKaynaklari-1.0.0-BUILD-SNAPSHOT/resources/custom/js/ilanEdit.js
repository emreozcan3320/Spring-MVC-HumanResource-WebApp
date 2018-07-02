$(document).ready(function() {
	
	getOneJob();
});

function myFunctionOne(){
	document.getElementById('smallText').innerHTML = "Aktif";
	document.getElementById('myCheckTwo').checked =false;
}

function myFunctionTwo(){
	document.getElementById('smallText').innerHTML = "Pasif";
	document.getElementById('myCheckOne').checked = false;
}

function tarihDatepicker (Linuxtarih){
	
	var normalTarih = new Date(Linuxtarih) ;
	var yil= normalTarih.getFullYear();
	var ay= normalTarih.getMonth();
	var gun= normalTarih.getDay();
	
	var yeniTarih = ay+"/"+gun+"/"+yil;
	
	return yeniTarih;
	
}

function getOneJob(){
	$.ajax({
		type : "POST",
		url : "../ilanInfo",
		contentType:"html/text; charset-UTF8",
		data:$("#ilan_id").val()+"",
		success : function(data) {

			console.log(data);
			
			if(data.status==true){
				document.getElementById("myCheckOne").checked = true;
			}else{
				document.getElementById("myCheckTwo").checked = true;
			}
			
			$("#datepicker").val(tarihDatepicker(data.activation_date));
			$("#create_date").val(tarihDatepicker(data.create_date));
			$("#expertise").val(data.expertise);
			$("#datepickerTwo").val(tarihDatepicker(data.expiration_date));
			$("#job_definition").val(data.job_definition);
			$("#personal_qualities").val(data.personal_qualities);
			//$("#status").val(data.status);
			$("#title").val(data.title);
			
			console.log("okuduğu");
			console.log("activation_date -> "+new Date(tarihDatepicker(data.activation_date)));
			console.log("expiration date -> "+new Date(tarihDatepicker(data.create_date)));
			
			
		},
		error : function(data) {
			console.log(data);
		}

	});
}

function ilanUpdate(){
	var statuss;
	if(document.getElementById("myCheckOne").checked == true){
		//document.getElementById('myCheckTwo').checked =false;
		statuss = true;
	}else if(document.getElementById("myCheckTwo").checked == true){
		statuss = false;
	}
	
	var param = {
			id:$("#ilan_id").val()+"",	
			title : $("#title").val(),
			job_definition : $("#job_definition").val(),
			expertise : $("#expertise").val(),
			personal_qualities : $("#personal_qualities").val(),
			activation_date : new Date($(".activation_date").val()),
			expiration_date : new Date($(".expiration_date").val()),
			status : statuss
	}
	
	//console.log(param);

	console.log("yazdırdığı")
	console.log("activation_date -> "+new Date($(".activation_date").val()));
	console.log("expiration date -> "+new Date($(".expiration_date").val()));
	
	var ser_data =JSON.stringify(param);
	
	
	$.ajax({
		type : "POST",
        contentType : 'application/json; charset=utf-8',
        dataType : 'json',
        data : ser_data,
		url:"",
		success:function(data){
			console.log("success -->");
			//console.log(data);
		},error:function(data){
			console.log("error -->");
			//console.log(data);
		}
	});
	//TODO: ajax postundan sonra ilan sayfasına yönlendirme
	//window.location = "/ilan";
}
