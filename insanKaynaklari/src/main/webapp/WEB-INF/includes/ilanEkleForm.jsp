<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

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
								Alanları ( L&uuml;tfen "," ayırarak yazınız ) </label>
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
								<small style="visibility: hidden;" id="smallText" ></small>
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