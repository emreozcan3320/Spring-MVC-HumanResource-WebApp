$(document).ready(function() {
});

function search(){
	
	var aday_list = "";
	var parametre = $(".selectpicker option:selected").val();
	
	switch(parametre) {
    case "İsim":
        parametre = "name"
        break;
    case "Soyad":
        parametre = "surname"
        break;
    case "Teknik Yetenekle":
        parametre = "skills"
        break;
    case "Üniversite":
        parametre = "educations"
        break;
    case "Sertificalar":
        parametre = "certifications"
        break;
    case "Kurslar":
        parametre = "courses"
        break;
    case "İlgi Alanları":
        parametre = "interests"
        break;
    case "Bilinen Diller":
        parametre = "languages"
        break;
    case "Ön Yazı":
        parametre = "headline"
        break;
    case "Yayınlar":
        parametre = "publications"
        break;
    case "Patentler":
        parametre = "patents"
        break;
    default:
        parametre = "Tür Seçiniz"
}
	
	var aranacakKelime = $("#aranacakKelimeForm").val();
	
	if(parametre=="Tür Seçiniz" && aranacakKelime == ""){
		console.log("lütfen bir değer giriniz");
	}
	if(parametre!="Tür Seçiniz" && aranacakKelime == ""){
		console.log("lütfen bir değer giriniz");
	}
	
	if(parametre=="Tür Seçiniz" && aranacakKelime != ""){
		
		console.log("üçünücü");

		$.ajax({
			type : 'GET',
			"url" : "http://localhost:8983/solr/insanKaynaklari/select?q="+aranacakKelime,
			contentType : 'application/json; charset=utf-8',
			success : function(response) {
				var root = response.response.docs;
				console.log(root);
				// //////////////////////////////////
				for (var i = 0; i < root.length; i++) {
					if (root[i] != null) {
						//console.log(root[i]);
						aday_list = aday_list 
						+'<tr><td>'+root[i].name+'</td>'
		                +'<td>'+root[i].surname+'</td>'
		                +'<td>'+root[i].personal_qualities+'</td>'
		                +'<td>'+root[i].educations+'</td>'
		                +'<td>'+root[i].certifications+'</td>'
		                +'<td>'+root[i].courses+'</td>'
		                +'<td>'+root[i].interests+'</td>'
		                +'<td>'+root[i].languages+'</td>'
		                +'<td>'+root[i].headline+'</td>'
		                +'<td>'+root[i].publications+'</td>'
		                +'<td>'+root[i].patents+'</td></tr>';
					}
				}
				
				$("#list").html(aday_list);
				
				// /////////////////////////////////

			}
		});
	}
	
	if(parametre!="Tür Seçiniz" && aranacakKelime != ""){
		
		console.log("dördüncü");
		
		
		$.ajax({
			type : 'GET',
			url : "http://localhost:8983/solr/insanKaynaklari/select?q="+parametre+":"+aranacakKelime,
			contentType : 'application/json; charset=utf-8',
			success : function(response) {
				var root = response.response.docs;
				console.log(root);
				// //////////////////////////////////
				for (var i = 0; i < root.length; i++) {
					if (root[i] != null) {
						//console.log(root[i]);
						aday_list = aday_list 
						+'<tr><td>'+root[i].name+'</td>'
		                +'<td>'+root[i].surname+'</td>'
		                +'<td>'+root[i].personal_qualities+'</td>'
		                +'<td>'+root[i].educations+'</td>'
		                +'<td>'+root[i].certifications+'</td>'
		                +'<td>'+root[i].courses+'</td>'
		                +'<td>'+root[i].interests+'</td>'
		                +'<td>'+root[i].languages+'</td>'
		                +'<td>'+root[i].headline+'</td>'
		                +'<td>'+root[i].publications+'</td>'
		                +'<td>'+root[i].patents+'</td></tr>';
					}
				}
				
				$("#list").html(aday_list);
				// /////////////////////////////////

			}
		});
	}
	
	

		
	
}