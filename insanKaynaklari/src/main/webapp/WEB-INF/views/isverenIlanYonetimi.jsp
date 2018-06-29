<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	İlan Yönetimi Sayfası
</h1>

<div class="container">
	<div class="row">
		<ul id="list">
			
		</ul>
	</div>
</div>


<a href="${contextPath}/isveren/ilanEkle">Yeni İlan</a>
<a href="${contextPath}/">Anasayfa</a>
<a href="${contextPath}/isveren/adayInfo">Aday Bilgileri</a>
<a href="${contextPath}/isveren/index">Panel</a>
<a href="${contextPath}/isveren/login">Çıkıs</a>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="resources/custom/js/isverenIlanYonetimi.js"></script>

</body>
</html>
