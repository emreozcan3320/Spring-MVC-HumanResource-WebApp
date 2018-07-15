<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
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
				<li class="nav-item"><a href="" data-target="#edit"
					data-toggle="tab" class="nav-link">Edit</a></li>
			</ul>
			<div class="tab-content py-4">
				<div class="tab-pane active" id="profile">
					<h5 class="mb-3">${aday.name} ${aday.surname}</h5>
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
								<a href="#" class="badge badge-dark badge-pill"><c:out value="${skill}" /></a>
							</c:forEach>
							<hr>
							<span class="badge badge-primary"><i class="fa fa-user"></i>
								900 Followers</span> <span class="badge badge-success"><i
								class="fa fa-cog"></i> 43 Forks</span> <span class="badge badge-danger"><i
								class="fa fa-eye"></i> 245 Views</span>
						</div>
						<div class="col-md-12">
							<h5 class="mt-2">
								<span class="fa fa-clock-o ion-clock float-right"></span> Alınan Kurslar
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
					<div class="alert alert-info alert-dismissable">
						<a class="panel-close close" data-dismiss="alert">×</a> This is an
						<strong>.alert</strong>. Use this to show important messages to
						the user.
					</div>
					<table class="table table-hover table-striped">
						<tbody>
							<tr>
								<td><span class="float-right font-weight-bold">3 hrs
										ago</span> Here is your a link to the latest summary report from
									the..</td>
							</tr>
							<tr>
								<td><span class="float-right font-weight-bold">Yesterday</span>
									There has been a request on your account since that was..</td>
							</tr>
							<tr>
								<td><span class="float-right font-weight-bold">9/10</span>
									Porttitor vitae ultrices quis, dapibus id dolor. Morbi
									venenatis lacinia rhoncus.</td>
							</tr>
							<tr>
								<td><span class="float-right font-weight-bold">9/4</span>
									Vestibulum tincidunt ullamcorper eros eget luctus.</td>
							</tr>
							<tr>
								<td><span class="float-right font-weight-bold">9/4</span>
									Maxamillion ais the fix for tibulum tincidunt ullamcorper eros.
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="tab-pane" id="edit">
					<form role="form">
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">First
								name</label>
							<div class="col-lg-9">
								<input class="form-control" type="text" value="Jane">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Last
								name</label>
							<div class="col-lg-9">
								<input class="form-control" type="text" value="Bishop">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Email</label>
							<div class="col-lg-9">
								<input class="form-control" type="email" value="email@gmail.com">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Company</label>
							<div class="col-lg-9">
								<input class="form-control" type="text" value="">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Website</label>
							<div class="col-lg-9">
								<input class="form-control" type="url" value="">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Address</label>
							<div class="col-lg-9">
								<input class="form-control" type="text" value=""
									placeholder="Street">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label"></label>
							<div class="col-lg-6">
								<input class="form-control" type="text" value=""
									placeholder="City">
							</div>
							<div class="col-lg-3">
								<input class="form-control" type="text" value=""
									placeholder="State">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Time
								Zone</label>
							<div class="col-lg-9">
								<select id="user_time_zone" class="form-control" size="0">
									<option value="Hawaii">(GMT-10:00) Hawaii</option>
									<option value="Alaska">(GMT-09:00) Alaska</option>
									<option value="Pacific Time (US &amp; Canada)">(GMT-08:00)
										Pacific Time (US &amp; Canada)</option>
									<option value="Arizona">(GMT-07:00) Arizona</option>
									<option value="Mountain Time (US &amp; Canada)">(GMT-07:00)
										Mountain Time (US &amp; Canada)</option>
									<option value="Central Time (US &amp; Canada)"
										selected="selected">(GMT-06:00) Central Time (US
										&amp; Canada)</option>
									<option value="Eastern Time (US &amp; Canada)">(GMT-05:00)
										Eastern Time (US &amp; Canada)</option>
									<option value="Indiana (East)">(GMT-05:00) Indiana
										(East)</option>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Username</label>
							<div class="col-lg-9">
								<input class="form-control" type="text" value="janeuser">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Password</label>
							<div class="col-lg-9">
								<input class="form-control" type="password" value="11111122333">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label">Confirm
								password</label>
							<div class="col-lg-9">
								<input class="form-control" type="password" value="11111122333">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-lg-3 col-form-label form-control-label"></label>
							<div class="col-lg-9">
								<input type="reset" class="btn btn-secondary" value="Cancel">
								<input type="button" class="btn btn-primary"
									value="Save Changes">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-lg-4 order-lg-1 text-center">
			<img src="${aday.profilPicUrl}" height="300" width="300"
				class="mx-auto img-fluid img-circle d-block" alt="avatar">
				<br>
				<c:if test="${aday.karaListe == true}">	
					<button type="button" class="btn btn-success">Kara Listeden Çıkar</button>
				</c:if>
				<c:if test="${aday.karaListe == false}">	
					<button type="button" class="btn btn-danger">Kara Listeye Ekle</button>
				</c:if>
		</div>
	</div>
	<!-- /.row -->

</div>
<!-- Page Content END-->