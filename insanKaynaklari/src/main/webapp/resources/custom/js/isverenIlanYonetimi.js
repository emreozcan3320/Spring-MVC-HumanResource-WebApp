$(document).ready(function() {
	
	getJobs();
	//setInterval(function(){ getJobs();},5000);
});

function gotoNode(string){
	//console.log(string);
	//document.location.href = "/insanKaynaklari/isveren/ilan/"+string;
	window.location.href = '/insanKaynaklari/isveren/ilan/'+string;
	//window.location = "/insanKaynaklari/isveren/ilan";
}

function deleteJob (string){
	if (confirm('Bu ilanı silmek istediğinizden eminmisiniz ?')) {
		var param = {
				id:string
		}
		
		//console.log(param);
		var ser_data =JSON.stringify(param);
		var success = false;
		var error = false;
		
		$.ajax({
			type : "POST",
	        contentType : 'application/json; charset=utf-8',
	        dataType : 'json',
	        data : ser_data,
			url:"ilanDelete",
			success:function(data){
				console.log("success -->");
				//console.log(data);
				success = true;
			},error:function(data){
				
				console.log("fonksiyon sonu");
				console.log(data);
			}
		}).then(location.reload());
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

function getJobs (){
	$.ajax({
		type : "POST",
		url : "ilan",
		success : function(data) {

			var list = "";
			var valStatus ="";
			
			$(data).each(function(i,val){
				
				if(val.status==true){
					valStatus ="Aktif";
				}else{
					valStatus ="Pasif";
					
				}
				
				
				list = list 
				+'<tr class="hrefTable" ><td>'+val.title+'</td>'
                +'<td>'+val.job_definition+'</td>'
                +'<td>'+val.personal_qualities+'</td>'
                +'<td>'+val.expertise+'</td>'
                +'<td>'+tarih(val.create_date) +'</td>'
                +'<td>'+tarih(val.activation_date) +'</td>'
                +'<td>'+tarih(val.expiration_date) +'</td>'
                +'<td>'+valStatus+'</td>'
                +'<td><button class="btn btn-danger" value="'+val.id+'" onclick="deleteJob(\'' + val.id + '\')">Sil</button></td>'
                +'<td><button class="btn btn-info" onClick="gotoNode(\'' + val.id + '\')" >Ayrıntı</button></td></tr>';
				
				//console.log(val);
			});
			$("#list").html(list);
		},
		error : function(data) {
			console.log(data);
		}

	});
}
