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
	alert("delete buttonuna basıldı :: "+ string);
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
				+'<tr class="hrefTable"><td>'+val.title+'</td>'
                +'<td onClick="gotoNode(\'' + val.id + '\')">'+val.job_definition+'</td>'
                +'<td onClick="gotoNode(\'' + val.id + '\')">'+val.personal_qualities+'</td>'
                +'<td onClick="gotoNode(\'' + val.id + '\')">'+val.expertise+'</td>'
                +'<td onClick="gotoNode(\'' + val.id + '\')">'+tarih(val.create_date) +'</td>'
                +'<td onClick="gotoNode(\'' + val.id + '\')">'+tarih(val.activation_date) +'</td>'
                +'<td onClick="gotoNode(\'' + val.id + '\')">'+tarih(val.expiration_date) +'</td>'
                +'<td onClick="gotoNode(\'' + val.id + '\')">'+valStatus+'</td>'
                +'<td><button class="btn btn-danger" value="'+val.id+'" onClick="gotoNode(\'' + val.id + '\')">Delete</button></td>'
                +'<td><button class="btn btn-success" onclick="deleteJob(\'' + val.id + '\')">Edit</button></td></tr>';
				
				//console.log(val);
			});
			$("#list").html(list);
		},
		error : function(data) {
			console.log(data);
		}

	});
}
