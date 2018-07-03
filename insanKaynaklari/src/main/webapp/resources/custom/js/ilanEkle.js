
function myFunctionOne(){
	document.getElementById('smallText').innerHTML = "Aktif";
	document.getElementById('myCheckTwo').checked =false;
}

function myFunctionTwo(){
	document.getElementById('smallText').innerHTML = "Pasif";
	document.getElementById('myCheckOne').checked = false;
}

function tarihDatepicker (stringDate){
	
	var array = stringDate.split('/');
	
	var yil= parseInt(array[2]);
	var ay= parseInt(array[0]);
	var gun= parseInt(array[1]);
	
	var yeniTarih = ay+"/"+gun+"/"+yil;
	
	return new Date(yeniTarih);
	
}

function ilanEkle(){
	var statuss;
	if(document.getElementById('smallText').innerHTML = "Aktif"){
		statuss = true;
	}else{
		statuss = false;
	}
	
	var param = {
			title : $("#title").val(),
			job_definition : $("#job_definition").val(),
			expertise : $("#expertise").val(),
			personal_qualities : $("#personal_qualities").val(),
			activation_date : tarihDatepicker($(".activation_date").val()),
			expiration_date : tarihDatepicker($(".expiration_date").val()),
			status : statuss
	}
	
	//console.log(param);
	console.log("expiration date -> "+tarihDatepicker($(".activation_date").val()));
	console.log("activation date -> "+tarihDatepicker($(".expiration_date").val()));
	//console.log(param.activation_date);
	
	var ser_data =JSON.stringify(param);
	
	$.ajax({
		type : "POST",
        contentType : 'application/json; charset=utf-8',
        dataType : 'json',
        data : ser_data,
		url:"ilanEkle",
		success:function(data){
			console.log(data); 
		},error:function(data){
			console.log(data);
		}
	}).then(window.history.back());
	//TODO: ajax postundan sonra ilan sayfasına yönlendirme
	//window.location = "/ilan";
}