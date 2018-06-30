$(document).ready(function() {
	
	getJobs();
	setInterval(function(){ getJobs();},3000);
});

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
				+'<tr><td>'+val.title+'</td>'
                +'<td>'+val.job_definition+'</td>'
                +'<td>'+val.personal_qualities+'</td>'
                +'<td>'+val.expertise+'</td>'
                +'<td>'+val.created_date+'</td>'
                +'<td>'+val.activation_date+'</td>'
                +'<td>'+val.expirarion_date+'</td>'
                +'<td>'+valStatus+'</td></tr>';
				
				console.log(val);
			});
			$("#list").html(list);
		},
		error : function(data) {
			console.log(data);
		}

	});
}