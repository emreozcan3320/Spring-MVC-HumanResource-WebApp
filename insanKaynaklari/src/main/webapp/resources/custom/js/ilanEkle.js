
function myFunctionOne(){
	document.getElementById('smallText').innerHTML = true;
	document.getElementById('myCheckTwo').checked =false;
}

function myFunctionTwo(){
	document.getElementById('smallText').innerHTML = false;
	document.getElementById('myCheckOne').checked = true;
}

function ilanEkle(){
	var statuss;
	if(document.getElementById('smallText').innerHTML = true){
		statuss = true;
	}else{
		statuss = false;
	}
	
	var param = {
			title : $("#title").val(),
			job_definition : $("#job_definition").val(),
			expertise : $("#expertise").val(),
			personal_qualities : $("#personal_qualities").val(),
			activation_date : new Date("06/29/2018"),
			expiration_date : new Date($(".expiration_date").val()),
			status : statuss
	}
	
	console.log(param);
	//console.log($(".expiration_date").val());
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
	});
}