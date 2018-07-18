
function myFunctionOne(){
	document.getElementById('smallText').innerHTML = "Aktif";
	document.getElementById('myCheckTwo').checked =false;
}

function myFunctionTwo(){
	document.getElementById('smallText').innerHTML = "Pasif";
	document.getElementById('myCheckOne').checked = false;
}

/*function tarihDatepicker (stringDate){
	
	var array = stringDate.split('/');
	
	var yil= parseInt(array[2]);
	var ay= parseInt(array[0]);
	var gun= parseInt(array[1]);
	
	var yeniTarih = ay+"/"+gun+"/"+yil;
	
	return new Date(yeniTarih);
	
}*/

function date(yil,ay,gun){
	
	var yil= parseInt(yil);
	var ay= parseInt(ay);
	var gun= parseInt(gun);
	
	var yeniTarih = ay+"/"+gun+"/"+yil;
	var jsDate = new Date(yeniTarih);
	var result = jsDate.getTime();
	
	return result;
}

function ilanEkle(){
	var statuss;
	if(document.getElementById('smallText').innerHTML = "Aktif"){
		statuss = true;
	}else{
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
	
	if(expiration_date < activation_date ){
		alert("Expiration Tarihi Aktivasyon Tarihinden Küçük Olamaz");
	}
	if(expiration_date < today_date ){
		alert("Expiration Tarihi Günün Tarihinden Küçük Olamaz");
	}
	if(today_date < activation_date ){
		alert("Lütfen aktivasyon zamanını güncel tarihten büyük seçin");
	}
	
	if( activation_date < expiration_date && activation_date <= today_date && today_date <= expiration_date ){
		var param = {
				title : $("#title").val(),
				job_definition : $("#job_definition").val(),
				expertise : $("#expertise").val(),
				personal_qualities : $("#personal_qualities").val(),
				activation_date : activation_date,
				expiration_date : expiration_date ,
				status : statuss
		}
		
		//console.log(param);
		console.log("expiration date -> "+activation_date);
		console.log("activation date -> "+expiration_date);
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
	}
	
	
	//.then(window.history.back())
	//TODO: ajax postundan sonra ilan sayfasına yönlendirme
	//window.location = "/ilan";
}