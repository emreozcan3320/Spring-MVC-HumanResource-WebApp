<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="search-container-ilanlar">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="content">
					<form method="" action="">
						<div class="row">
							<div class="col-md-6 col-sm-8">
								<div class="form-group">
									<input id="aranacakKelimeForm" class="form-control" type="text"
										placeholder="Yetkinlikler / İsim / Okul"> <i
										class="ti-time"></i>
								</div>
							</div>
							<div class="col-md-4 col-sm-4">
								<div class="dropdown-item">
									<label class="styled-select"> 
									<select
										style="height:100%;" class="dropdown-product selectpicker">
											<option>Tür Seçiniz</option>
											<option>İsim</option>
											<option>Soyad</option>
											<option>Teknik Yetenekler</option>
											<option>Üniversite</option>
											<option>Sertificalar</option>
											<option>Kurslar</option>
											<option>İlgi Alanları</option>
											<option>Bilinen Diller</option>
											<option>Ön Yazı</option>
											<option>Yayınlar</option>
											<option>Patentler</option>
									</select>
									</label>
								</div>
							</div>
							<div class="col-md-2 col-sm-6">
								<button style="width:100%;" onclick="search()" type="button" class="btn btn-search-icon">
									<i class="ti-search">Ara</i>
								</button>
							</div>
						</div>
					</form>
				</div>
				<!--  
				<div class="popular-jobs">
					<b>Popular Keywords: </b> <a href="#">Web Design</a> <a href="#">Manager</a>
					<a href="#">Programming</a>
				</div>
				-->
				
			</div>
		</div>
	</div>
</div>