<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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



</head>

<body>
	<!-- Header Section Start -->
	<div class="header">
		<!-- Start intro section -->
		<section id="intro" class="section-intro">
			<div class="logo-menu">
				<nav class="navbar navbar-default" role="navigation" data-spy="affix" data-offset-top="50">
				
				<% if (session.getAttribute("hrSession") == null && session.getAttribute("adaySession") == null) { %>
    				<jsp:include page="../includes/menuler/menuGeneral.jsp"></jsp:include>
					<jsp:include page="../includes/menuler/mobilMenuGeneral.jsp"></jsp:include>
				<% } if (session.getAttribute("adaySession") != null) {%>
    				<jsp:include page="../includes/menuler/menuAday.jsp"></jsp:include>
					<jsp:include page="../includes/menuler/mobilMenuAday.jsp"></jsp:include>
				<% }if (session.getAttribute("hrSession") != null) { %>
					<jsp:include page="../includes/menuler/menuIsveren.jsp"></jsp:include>
					<jsp:include page="../includes/menuler/mobilMenuIsveren.jsp"></jsp:include>
				<%} %>
					
				</nav>

				<div class="navmenu navmenu-default navmenu-fixed-left offcanvas">
					<jsp:include page="../includes/offCanvasSideMenu.jsp"></jsp:include>
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



	<!-- Find Job Section Start -->
	<section class="find-job section">
		<div class="container">
			<h2 class="section-title">ilanlar</h2>
			<div class="row" id="ilan_list">
				<div class="col-md-12">
					<div class="showing pull-left">
						<a href="#">Showing <span>6-10</span> Of 24 Jobs
						</a>
					</div>
					<ul class="pagination pull-right">
						<li class="active"><a href="#" class="btn btn-common"><i
								class="ti-angle-left"></i> prev</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li class="active"><a href="#" class="btn btn-common">Next
								<i class="ti-angle-right"></i>
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<!-- Find Job Section End -->


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
	<script type="text/javascript"
		src="resources/custom/js/ilanlar.js"></script>

</body>
</html>
