<%@ page import="com.kadiremreozcan.entity.HrStaffs" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- Page Content -->
<div class="container">

	<div class="row my-2">
		<div class="col-lg-8 order-lg-2">
			<ul class="nav nav-tabs">
				<li class="nav-item"><a href="" data-target="#profile"
					data-toggle="tab" class="nav-link active">Profil</a></li>
				<li class="nav-item"><a href="" data-target="#messages"
					data-toggle="tab" class="nav-link">Başvurduğu İlanlar</a></li>
			</ul>
			<div class="tab-content py-4">
				<div class="tab-pane active" id="profile">
					<input type="hidden" id="adayId" value="${aday.id}">
					<% HrStaffs hrCurrent = (HrStaffs) session.getAttribute("hrSession");
						Long hrId = hrCurrent.getId();
					%>
					<input type="hidden" id="hrId" value="<%=hrId %>"/>
					<h5 class="mb-3">${aday.name}${aday.surname}</h5>
					<hr>
					<div class="row">
						<div class="col-md-6">
							<h6>E-mail</h6>
							<p>${aday.email}</p>
							<h6>Hakkında</h6>
							<p>${aday.headline}</p>
							<h6>Hobileri</h6>
							<p>${aday.interests}</p>

						</div>
						<div class="col-md-6">
							<h6>Okulu</h6>
							<p>${aday.educations}</p>
							<hr>
							<h6>Bilinen Diller</h6>
							<p>${aday.languages}</p>
							<hr>
							<h6>Yetenekler</h6>
							<c:forEach var="skill" items="${adaySkills}">
								<a href="#" class="badge badge-dark badge-pill"><c:out
										value="${skill}" /></a>
							</c:forEach>
							<hr>
							<span class="badge badge-primary"><i class="fa fa-user"></i>
								900 Followers</span> <span class="badge badge-success"><i
								class="fa fa-cog"></i> 43 Forks</span> <span class="badge badge-danger"><i
								class="fa fa-eye"></i> 245 Views</span>
						</div>
						<div class="col-md-12">
							<h5 class="mt-2">
								<span class="fa fa-clock-o ion-clock float-right"></span> Alınan
								Kurslar
							</h5>
							<table class="table table-sm table-hover table-striped">
								<tbody>
									<c:forEach var="course" items="${adayCourses}">
										<tr>
											<td><c:out value="${course}" /></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
					<!--/row-->
				</div>
				<div class="tab-pane" id="messages">
					<!--  <div class="alert alert-info alert-dismissable">
						<a class="panel-close close" data-dismiss="alert">×</a> This is an
						<strong>.alert</strong>. Use this to show important messages to
						the user.
					</div> -->
					<table class="table table-hover table-striped">
						<tbody>
							<c:forEach items="${basvuru_tag}" var="tag">
								${tag}
							</c:forEach>

						</tbody>
					</table>
				</div>
				
			</div>
		</div>
		<div class="col-lg-4 order-lg-1 text-center">
			<img src="${aday.profilPicUrl}" height="300" width="300"
				class="mx-auto img-fluid img-circle d-block" alt="avatar"> <br>
				
			<c:if test="${aday.karaListe == true}">
				<button id = "opener" type="button" class="btn btn-success"
					onclick="removeFromBlackList()")>Kara Listeden Çıkar</button>
			</c:if>
			<c:if test="${aday.karaListe == false}">
				<button id = "opener" type="button" class="btn btn-danger"
					onclick="addBlackListButton()">Kara Listeye Ekle</button>
			</c:if>
			
			
			<hr>
			
			<strong>${basvuru_durumu}</strong>
			
			<hr>
			<c:if test="${basvuru_durumu == 'red'}">
				<div class="alert alert-danger" role="alert">
  					<strong>Red Edildi</strong>
				</div>
			</c:if>
			<c:if test="${basvuru_durumu == 'kabul'}">
				<div class="alert alert-success" role="alert">
  					<strong>Kabul Edildi</strong>
				</div>
			</c:if>
			<c:if test="${basvuru_durumu == 'beklemede'}">
				<button type="button" class="btn btn-success" onclick="basvuruKabul()">Kabul Et</button>
				<button type="button" class="btn btn-danger" onclick="basvuruRed()">Reddet</button>
			</c:if>
			
			
			
		<div id="dialog" title="Ekleme Sebebinizi Giriniz">
			<input type="text" name="sebep" id="sebep">
			<button type="button" class="btn btn-secondary dialog-btn" onclick="addBlackList()">Kaydet</button>
		</div>

		</div>
	</div>
	<!-- /.row -->

</div>
<!-- Page Content END-->