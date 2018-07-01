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
				+'<tr class="hrefTable" onClick="gotoNode(\'' + val.id + '\')"><td>'+val.title+'</td>'
                +'<td>'+val.job_definition+'</td>'
                +'<td>'+val.personal_qualities+'</td>'
                +'<td>'+val.expertise+'</td>'
                +'<td>'+tarih(val.create_date) +'</td>'
                +'<td>'+tarih(val.activation_date) +'</td>'
                +'<td>'+tarih(val.expiration_date) +'</td>'
                +'<td>'+valStatus+'</td>'
                +'<td><button class="btn btn-danger" value="'+val.id+'">Delete</button></td>'
                +'<td><button class="btn btn-success" value="'+val.ik_uzmani_id+'">Edit</button></td></tr>';
				
				//console.log(val);
			});
			$("#list").html(list);
		},
		error : function(data) {
			console.log(data);
		}

	});
}
