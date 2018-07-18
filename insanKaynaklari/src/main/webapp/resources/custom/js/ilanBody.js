$(document).ready(function() {
	var ilanId = $("#ilan_id").val();
	mostUsedFiveWordInJob(ilanId);
	
	setTimeout(function(){ StringPopularityInAday(); }, 1000);
	
	setTimeout(function(){ getBasvuranBilgisi(); }, 4000);
	
	
	
	
	
	
	getOneJob();
	
	$("#myInput").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $(".myTable tr").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
});

//Get the modal
var modal = document.getElementById('myModal');

//Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

//When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

//When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}



function mostUsedFiveWordInJob(job_id){
	
	var getExperticeUrl = "http://localhost:8983/solr/jobs/select?fl=id,expertise,job_definition,title&q=id:"+job_id;
	
	
	
	$.ajax({
		type : 'GET',
		"url" : getExperticeUrl,
		contentType : 'application/json; charset=utf-8',
		success : function(response) {
			var root = response.response.docs;
			//console.log(root);
			var str = root[0].expertise[0]+root[0].job_definition[0]+root[0].title[0];
			//console.log(str);
			
			var wordCounts = { };
			str.replace(/[^a-zA-Z ]/g, "");
			var words = str.split(" ");
			//console.log(words);

			for(var i = 0; i < words.length; i++){
				//wordCounts["_" + words[i]] = (wordCounts["_" + words[i]] || 0) + 1;
				word = words[i];
				wordCounts[word] = wordCounts[word] || 0;
				wordCounts[word]++;
				
				}
			  
			var wordsMap = wordCounts;
			var finalWordsArray = [];
			
			  finalWordsArray = Object.keys(wordsMap).map(function (key) {
			    return {
			      name: key,
			      total: wordsMap[key]
			    };
			  });

			  finalWordsArray.sort(function (a, b) {
			    return b.total - a.total;
			  });

			  
			
			  //console.log(finalWordsArray);
			 //console.log('The word "' + finalWordsArray[0].name + '" appears the most in the file ' +
			    //finalWordsArray[0].total + ' times');
			  var mostUsedFiveArray = [];
			  
			  mostUsedFiveArray[0]= finalWordsArray[0].name;
			  mostUsedFiveArray[1]= finalWordsArray[1].name;
			  mostUsedFiveArray[2]= finalWordsArray[2].name;
			  
			  //StringPopularityInAday(mostUsedFiveArray) ;
			  
			  var string = mostUsedFiveArray[0]+","+mostUsedFiveArray[1]+","+mostUsedFiveArray[2]+"";
			  $("#kelimeArray").val(string);
			
		}
		
	});
	
}


function StringPopularityInAday(){
	
	var string = $("#kelimeArray").val();
	
	var words = string.split(",");
	
	console.log(words);
	//var getPopularityResult = "http://localhost:8983/solr/insanKaynaklari/select?fl=id,score&q="+kelime;
	

		$.ajax({
			type : 'GET',
			"url" : "http://localhost:8983/solr/insanKaynaklari/select?fl=id,score,name,surname&q="+words[0]+"&"+words[1]+"&"+words[2],
			contentType : 'application/json; charset=utf-8',
			success : function(response) {
				var root = response.response.docs;
				
				console.log("::: getPopularityResult :::");
				if(root.length <= 0){
					console.log("uyuşan yok");
				}else{
					console.log(root);
					var myJSON = JSON.stringify(root);
					$("#uyusanAdaArray").val(myJSON);
				}
				//var str = root[0].expertise[0]+root[0].job_definition[0]+root[0].title[0];
				
			},
			error : function (response){
				console.log(data);
			}
			
		});
		
	
	
	
}


function getBasvuranBilgisi(){
	
	var ilan_uzmanlik = $("#uzmanlik").val();
	
	
	
	$.ajax({
		type : "POST",
		url : "../ilanBavuran",
		contentType:"html/text; charset-UTF8",
		data:$("#ilan_id").val()+"",
		success : function(data) {

			console.log(data);
			var list = "";
			var job_id= $("#hrId").val();
			
			
			var stringJson = $("#uyusanAdaArray").val();
			console.log("::: string json :::");
			console.log(typeof stringJson);
			
			if( stringJson == "anlamadim" ){
				var userIdArray = ["a"];
				
			
			}else{
				var adayJson = JSON.parse(stringJson);
				console.log("::: enson nokta:::");
				console.log(adayJson);
				
				var userIdArray = [];
				
				for (var key in adayJson) {
			        console.log(adayJson[key].id);
			        userIdArray.push(adayJson[key].id);
				
			}
			}
			
			
			
			
			for (var i = 0; i < data.length; i++) {
			    //console.log(data[i][9]+" "+data[i][13]);
				console.log("solrId :: "+userIdArray);
				var aday_id = data[i][0];
				console.log("db_Id :: " + aday_id);
				if(userIdArray.includes(aday_id)){
					
					list = list + "<tr><td><div class='alert alert-success'><strong>Önerilen</strong><a href='/insanKaynaklari/isveren/adayInfo/"+data[i][0]+"/"+job_id+"'>"+data[i][9]+" "+data[i][13] +"</a></div></td><td>"+data[i][22]+"</td></tr>"
	
				}else{
					list = list + "<tr><td><a href='/insanKaynaklari/isveren/adayInfo/"+data[i][0]+"/"+job_id+"'>"+data[i][9]+" "+data[i][13] +"</a></td><td>"+data[i][22]+"</td></tr>"

				}
			    
			}
			
			$("#basvuranlar").html(list);
			$("#basvuranSayisi").html(data.length);
			$("#basvuranSayisiBadge").html(data.length);
		},
		error : function(data) {
			console.log(data);
		}

	});
}
//When the user clicks on the button, open the modal 
function basvuranBilgisiDialogBox(){
	modal.style.display = "block";
	console.log("basvuran bilgisine basıldı");
}

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