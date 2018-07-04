$(document).ready(function() {
	getAllJobs();
	//setInterval(function(){ getJobs();},5000);
});

function tarih (Linuxtarih){
	
	var normalTarih = new Date(Linuxtarih) ;
	var yil= normalTarih.getFullYear();
	var ay= normalTarih.getMonth();
	var gun= normalTarih.getDay();
	
	var yeniTarih = gun+"/"+ay+"/"+yil;
	
	return yeniTarih;
	
}

function getAllJobs (){
	$.ajax({
		type : "POST",
		url : "ilanlar",
		success : function(data) {

			var ilan_list = "";
			var valStatus ="";
			
			$(data).each(function(i,val){
				
				if(val.status==true){
					valStatus ="Aktif";
				}else{
					valStatus ="Pasif";
					
				}
				
				ilan_list = ilan_list+ '<div class="col-md-12" ><div class="job-list" style="width:100%;">'+
						'<div class="thumb">'+
								'<a href="job-details.html"><img src="resources/theme1/img/jobs/img-1.jpg" alt=""></a>'+
						'</div>'+
						'<div class="job-list-content">'+
							'<h4>'+
								'<a href="job-details.html">'+val.title+'</a><spanclass="full-time">Full-Time</span>'+
							'</h4>'+
							'<p>'+val.job_definition+'</p>'+
							'<div class="job-tag">'+
								'<div class="pull-left">'+
									'<div class="meta-tag">'+
										'<span><a href="browse-categories.html"><i class="ti-brush"></i>Aranan Teknik Özellikler : '+val.expertise+'</a></span>'+
									'</div>'+
								'</div>'+
								'<div class="pull-right">'+
									'<a href="ilanlar/'+ val.id + '" class="btn btn-common btn-rm">Detaylar</a>'+
								'</div>'+
							'</div>'+
						'</div>'+
					'</div></div>';
				
				/*list = list 
				+'<tr class="hrefTable" ><td>'+val.title+'</td>'
                +'<td>'+val.job_definition+'</td>'
                +'<td>'+val.personal_qualities+'</td>'
                +'<td>'+val.expertise+'</td>'
                +'<td>'+tarih(val.create_date) +'</td>'
                +'<td>'+tarih(val.activation_date) +'</td>'
                +'<td>'+tarih(val.expiration_date) +'</td>'
                +'<td>'+valStatus+'</td>'
                +'<td><button class="btn btn-danger" value="'+val.id+'" onclick="deleteJob(\'' + val.id + '\')">Sil</button></td>'
                +'<td><button class="btn btn-info" onClick="gotoNode(\'' + val.id + '\')" >Ayrıntı</button></td></tr>';*/
				
				console.log(val);
			});
			$("#ilan_list").html(ilan_list);
		},
		error : function(data) {
			console.log(data);
		}

	});
}