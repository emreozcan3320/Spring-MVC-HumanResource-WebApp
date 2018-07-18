<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>SB Admin - Start Bootstrap Template</title>
  <!-- Bootstrap core CSS-->
  <link href="resources/adminPanel/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="resources/adminPanel/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="resources/adminPanel/css/sb-admin.css" rel="stylesheet">
  <!--===============================================================================================-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" >
	<link rel="stylesheet" type="text/css" href="resources/custom/css/social.css">
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Login</div>
      <div class="card-body">
        <a href="https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id=${client_id }
		&redirect_uri=${redirect_url }&state=fdfdfdfd&scope=r_basicprofile%20r_emailaddress"  class="btn btn-block btn-social btn-linkedin">
  			<span class="fab fa-linkedin fa-2x"></span>
  				LinkedIn İle Giriş Yap
			</a>
		<hr>
		<a href="${contextPath}">Anasayfa</a>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="resources/adminPanel/vendor/jquery/jquery.min.js"></script>
  <script src="resources/adminPanel/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="resources/adminPanel/vendor/jquery-easing/jquery.easing.min.js"></script>
  
</body>

</html>
