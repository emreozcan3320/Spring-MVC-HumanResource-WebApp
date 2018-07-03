$(document).ready(function() {
	
	getOneJob();
});

function Edit(){
	var ilan_id = $("#ilan_id").val();
	window.location.href = '/insanKaynaklari/isveren/ilanEdit/'+ilan_id;
	//window.location = "/ilanEdit/"+ilan_id;
}

function deleteJob (string){
	if (confirm(string+ ' Id li ilanı silmek istediğinizden eminmisiniz ?')) {
		var param = {
				id:string
		}
		
		//console.log(param);
		var ser_data =JSON.stringify(param);
		
		$.ajax({
			type : "POST",
	        contentType : 'application/json; charset=utf-8',
	        dataType : 'json',
	        data : ser_data,
			url:"../ilanDelete",
			success:function(data){
				console.log("success -->");
				//console.log(data);
			},error:function(data){
				
				console.log("fonksiyon sonu");
				console.log(data);
			}
		}).then(window.history.back());
		
		
		//TODO: ajax postundan sonra ilan sayfasına yönlendirme
		//window.location = "/ilan";
		
		//window.location.reload(true);
		//history.go(0);
		//window.location.href = window.location.href;
		//bject.reload(forcedReload);
	} else {
	    // Do nothing!
	}
	
	
}

function tarih (Linuxtarih){
	
	var normalTarih = new Date(Linuxtarih) ;
	var yil= normalTarih.getFullYear();
	var ay= normalTarih.getMonth();
	var gun= normalTarih.getDay();
	
	var yeniTarih = gun+"/"+ay+"/"+yil;
	
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
			$("#activation_date").html(tarih (data.activation_date));
			$("#create_date").html(tarih (data.create_date));
			$("#expertise").html(data.expertise);
			$("#expiration_date").html(tarih (data.expiration_date));
			$("#job_definition").html(data.job_definition);
			$("#personal_qualities").html(data.personal_qualities);
			$("#status").html(data.status);
			$("#title").html(data.title);
		},
		error : function(data) {
			console.log(data);
		}

	});
}