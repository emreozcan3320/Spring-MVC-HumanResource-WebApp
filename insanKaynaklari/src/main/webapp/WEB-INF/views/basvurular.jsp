<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta name="author" content="Jobboard">

<title>JobBoard - Bootstrap HTML5 Job Portal Template</title>

<!-- Theme1 Links starts -->
<jsp:include page="../includes/theme1Links.jsp"></jsp:include>
<!-- Theme1 Links Ends -->

<!-- Color CSS Styles  -->
<link rel="stylesheet" type="text/css"
	href="resources/theme1/css/colors/red.css" media="screen" />



</head>

<body>
	<!-- Header Section Start -->
	<div class="header">
		<!-- Start intro section -->
		<section id="intro" class="section-intro">
			<div class="logo-menu">
				<nav class="navbar navbar-default" role="navigation"
					data-spy="affix" data-offset-top="50">
					<!-- Menu Begining -->
					<jsp:include page="../includes/menuGeneral.jsp"></jsp:include>
					<!-- Menu End -->
					<!-- Mobile Menu Start -->
					<jsp:include page="../includes/mobilMenuGeneral.jsp"></jsp:include>
					<!-- Mobile Menu End -->
				</nav>

				<!-- Off Canvas Navigation -->
				<div class="navmenu navmenu-default navmenu-fixed-left offcanvas">
					<!--- Off Canvas Side Menu -->
					<jsp:include page="../includes/offCanvasSideMenu.jsp"></jsp:include>
					<!--- End Off Canvas Side Menu -->
				</div>
				<!--- End Off Canvas Side Menu -->
				<div class="tbtn wow pulse" id="menu" data-wow-iteration="infinite"
					data-wow-duration="500ms" data-toggle="offcanvas"
					data-target=".navmenu">
					<p>
						<i class="ti-files"></i> All Pages
					</p>
				</div>
			</div>
			<!-- Header Section End -->

			<!-- Search Container Start -->
			<jsp:include page="../includes/ilanSearch.jsp"></jsp:include>
			<!-- Search Container End  -->
		</section>
		<!-- end intro section -->
	</div>
	<!-- Header Section End   -->



	<section class="section text-center">
		<div class="container">
			<!-- Start Animations Text -->
			<h1>
				Bu aday basvurular sayfasıdır
			</h1>
			<br>
			<!-- End Animations Text -->

			<!-- Start Buttons -->
			<a rel="nofollow" target="_blank"
				href="https://rebrand.ly/gg-jobboard-purchase"
				class="btn btn-common btn-large"><i class="fa fa-cart"></i>
				Purchase Now</a>
		</div>
	</section>


	<!-- Footer Section Start -->
	<jsp:include page="../includes/footer.jsp"></jsp:include>
	<!-- Footer Section End -->

	<!-- Go To Top Link -->
	<a href="#" class="back-to-top"> <i class="ti-arrow-up"></i>
	</a>

	<div id="loading">
		<div id="loading-center">
			<div id="loading-center-absolute">
				<div class="object" id="object_one"></div>
				<div class="object" id="object_two"></div>
				<div class="object" id="object_three"></div>
				<div class="object" id="object_four"></div>
				<div class="object" id="object_five"></div>
				<div class="object" id="object_six"></div>
				<div class="object" id="object_seven"></div>
				<div class="object" id="object_eight"></div>
			</div>
		</div>
	</div>

	<!-- Theme1 Scripts Starts -->
	<jsp:include page="../includes/theme1Scripts.jsp"></jsp:include>
	<!-- Theme1 Scripts Ends -->

</body>
</html>