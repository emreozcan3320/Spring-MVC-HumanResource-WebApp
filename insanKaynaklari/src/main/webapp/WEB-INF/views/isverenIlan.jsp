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
	İsvrenin İlanları
</h1>

<a href="${contextPath}/">Anasayfa</a>
<a href="${contextPath}/isveren/adayInfo">Aday Bilgileri</a>
<a href="${contextPath}/isveren/index">Panel</a>
<a href="${contextPath}/isveren/login">Çıkıs</a>
</body>
</html>
