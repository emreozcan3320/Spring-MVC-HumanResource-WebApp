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

function date(yil,ay,gun){
	
	var yil= parseInt(yil);
	var ay= parseInt(ay);
	var gun= parseInt(gun);
	
	var yeniTarih = ay+"/"+gun+"/"+yil;
	var jsDate = new Date(yeniTarih);
	var result = jsDate.getTime();
	
	return result;
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
			
			console.log("gelen linuxtime ::: "+data.activation_date);
			var activationDate = new Date(data.activation_date);
			var Adate = activationDate.toLocaleDateString();
			var a = Adate.split(".");
			
			$("#activation_yıl").val(a[2]);
			$("#activation_ay").val(a[1]);
			$("#activation_gun").val(a[0]);
			
			var exprtionDate = new Date(data.expiration_date);
			var Edate = exprtionDate.toLocaleDateString();
			var e = Edate.split(".");
			
			$("#expiration_yıl").val(e[2]);
			$("#expiration_ay").val(e[1]);
			$("#expiration_gun").val(e[0]);
			
			$("#create_date").val(new Date(data.create_date));
			$("#expertise").val(data.expertise);
			$("#job_definition").val(data.job_definition);
			$("#personal_qualities").val(data.personal_qualities);
			//$("#status").val(data.status);
			$("#title").val(data.title);
			
			console.log("okuduğu");
			console.log("activation_date -> "+activationDate);
			console.log("expiration date -> "+exprtionDate);
			
			
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
	var activation_yil = $("#activation_yıl").val();
	var activation_ay = $("#activation_ay").val();
	var activation_gun = $("#activation_gun").val();
	
	var activation_date = date(activation_yil,activation_ay,activation_gun);
	
	var expiration_yıl = $("#expiration_yıl").val();
	var expiration_ay = $("#expiration_ay").val();
	var expiration_gun = $("#expiration_gun").val();
	
	var expiration_date = date(expiration_yıl,expiration_ay,expiration_gun);
	
	var today_date = new Date();
	
	if(new Date(activation_date).toLocaleDateString() == new Date(today_date).toLocaleDateString() ){
		activation_date = today_date;
		activation_date = activation_date.getTime();
	}
	
	if(today_date > activation_date ){
		alert("Ilan Aktif olucaktır");
	}
	if(expiration_date < today_date ){
		alert("Ilan Pasif Olucaktır");
	}
	if(activation_date > expiration_date ){
		alert("Aktivasyon tarihi Expiration Tarihinden büyük olamaz");
	}
	
	if( activation_date < expiration_date ){
		var param = {
				id:$("#ilan_id").val()+"",	
				title : $("#title").val(),
				job_definition : $("#job_definition").val(),
				expertise : $("#expertise").val(),
				personal_qualities : $("#personal_qualities").val(),
				activation_date : activation_date,
				expiration_date : expiration_date ,
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
				getOneJob();
			},error:function(data){
				console.log("error -->");
				//console.log(data);
				getOneJob();
			}
		}).then(window.history.back());
	}
	
	//TODO: ajax postundan sonra ilan sayfasına yönlendirme
	//window.location = "/ilan";
}
