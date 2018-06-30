<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>Home</title>
</head>
<body>
<jsp:include page="../includes/headerGenel.jsp"></jsp:include>
<h1>
	404 
</h1>
<jsp:include page="../includes/footer.jsp"></jsp:include>

<a href="#">LOGO</a>
<a href="${contextPath}/aday">Aday</a>
<a href="${contextPath}/isveren">İK Uzmanı</a>
<a href="${contextPath}/ilanlar">İlanlar</a>
</body>
</html>
