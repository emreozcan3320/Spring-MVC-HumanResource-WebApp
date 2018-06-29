<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>İlan Ekleme Sayfası</h1>
	
	<!-- Special version of Bootstrap that only affects content wrapped in .bootstrap-iso -->
	<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
                $("#datepickerTwo").datepicker();
            });
        </script>

	<!-- Inline CSS based on choices in "Settings" tab -->
	<style>
		.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p,
		.bootstrap-iso form {
			font-family: Arial, Helvetica, sans-serif;
			color: black
		}

		.bootstrap-iso form button, .bootstrap-iso form button:hover {
			color: #ffffff !important;
		}

		.asteriskField {
			color: red;
		}
	</style>

	<!-- HTML Form (wrapped in a .bootstrap-iso div) -->
	<div class="bootstrap-iso">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6 col-sm-6 col-xs-12">
					
						<div class="form-group ">
							<label class="control-label " for="text1"> İlan Başlığı </label>
							<input class="form-control" id="title" name="title" type="text" />
						</div>
						<div class="form-group ">
							<label class="control-label " for="textarea2"> İş Tanımı
							</label>
							<textarea class="form-control" cols="40" id="job_definition"
								name="job_definition" rows="10"></textarea>
						</div>
						<div class="form-group ">
							<label class="control-label " for="textarea"> Uzmanlık
								Alanlarınız ( L&uuml;tfen "," ayırarak yazınız ) </label>
							<textarea class="form-control" cols="40" id="expertise"
								name="expertise" rows="10"></textarea>
						</div>
						<div class="form-group ">
							<label class="control-label " for="textarea1"> Aranan
								Kişisel &Ouml;zellikler ( L&uuml;tfen "," ayırarak yazınız ) </label>
							<textarea class="form-control" cols="40" id="personal_qualities"
								name="personal_qualities" rows="10"></textarea>
						</div>
						<div class="form-group ">
								<label for="datepicker">Activation Date</label>
                			<input class ="activation_date" type="text" name="selDate" id="datepicker">
						</div>
						<div class="form-group ">
							<label for="datepicker">Expiration Date</label>
                			<input class ="expiration_date" type="text" name="selDate" id="datepickerTwo">
						</div>
						<div class="form-group" id="div_status">
							<label class="control-label " for="status"> İlan Durumu </label>
							<div class=" ">
								<label class="checkbox-inline"> 
								<input id="myCheckOne" name="status" type="checkbox" value="1" onclick="myFunctionOne()"/> Aktif
								</label> 
								<label class="checkbox-inline"> 
								<input id="myCheckTwo" name="status" type="checkbox" value="0" onclick="myFunctionTwo()"/> Pasif
								</label>
								<small id="smallText" ></small>
							</div>
						</div>
						<div class="form-group">
							<div>
								<button class="btn btn-success ilanEkleButton" onclick="ilanEkle()">
									Kaydet</button>
							</div>
						</div>
					
				</div>
			</div>
		</div>
	</div>



	<a href="${contextPath}/">Anasayfa</a>
	<a href="${contextPath}/isveren/ilan">ilan Yönetimi</a>
	<a href="${contextPath}/isveren/adayInfo">Aday Bilgileri</a>
	<a href="${contextPath}/isveren/index">Panel</a>
	<a href="${contextPath}/isveren/login">Çıkıs</a>
	
	<!-- 
	<script type="text/javascript" src="resources/custom/js/jquery-min.js"></script>
	<script type="text/javascript" src="resources/custom/js/bootstrap.min.js"></script>
	 -->
	<script type="text/javascript" src="resources/custom/js/ilanEkle.js"></script>
</body>
</html>
