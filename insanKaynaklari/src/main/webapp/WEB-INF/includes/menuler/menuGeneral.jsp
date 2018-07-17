<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="container">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#navbar">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand logo" href="${contextPath}/"><img
			src="resources/theme1/img/logo.png" alt=""></a>
	</div>

	<div class="collapse navbar-collapse" id="navbar">
		<!-- Start Navigation List -->
		<ul class="nav navbar-nav">
			<li><a class="active" href="${contextPath}/"> Anasayfa</a></li>

			<li><a href="${contextPath}/ilanlar"> İş İlanları</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right float-right">
			<li class="left"><a href="${contextPath}/isveren/login"><i
					class="ti-pencil-alt"></i>İnsan Kaynakları</a></li>
			<li class="right"><a href="${contextPath}/aday/login"><i
					class="ti-lock"></i>Aday</a></li>
		</ul>
	</div>
</div>