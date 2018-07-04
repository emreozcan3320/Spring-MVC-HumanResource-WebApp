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

<style>
.info{padding-bottom : 15px;}

.info_button{
width : 90%;
}

</style>

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
					<jsp:include page="../includes/menuler/menuGeneral.jsp"></jsp:include>
					<!-- Menu End -->
					<!-- Mobile Menu Start -->
					<jsp:include page="../includes/menuler/mobilMenuGeneral.jsp"></jsp:include>
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



	<!-- Find Job Section Start -->
	<section class="find-job section">
		<!-- Page Content -->
    <div class="container">

      <div class="row">

        <!-- Post Content Column -->
        <div class="col-lg-8">

          <!-- Title -->
          <h1 class="mt-4" id="title">${ilan.title}</h1>

          <!-- Author -->
          <p>
            Oluşturulma Tarihi
            <!--  <a id="create_date" style="color:#e25a67;"></a> -->
            <span class="badge badge-secondary" id="create_date">${ilan.create_date}</span>
          </p>

          <!-- Date/Time 
          <p id="create_date"></p>
          -->

          <hr>

          <!-- Preview Image -->
          <img class="img-fluid rounded" src="http://placehold.it/900x300" alt="">

          <hr>

          <!-- Post Content -->
          <h5>İş Tanımı</h5>
          <p class="lead" id="job_definition">${ilan.job_definition}</p>
          <hr>
			
		  <h5>Aranan Uzmanlıklar</h5>	
          <p id="expertise">${ilan.expertise}</p>
          <hr>
			
		  <h5>Aranan Kişisel Özellikler</h5>
          <p id="personal_qualities">${ilan.personal_qualities}</p>

			<!--  
          <blockquote class="blockquote">
            <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
            <footer class="blockquote-footer">Someone famous in
              <cite title="Source Title">Source Title</cite>
            </footer>
          </blockquote>

          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Error, nostrum, aliquid, animi, ut quas placeat totam sunt tempora commodi nihil ullam alias modi dicta saepe minima ab quo voluptatem obcaecati?</p>

          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Harum, dolor quis. Sunt, ut, explicabo, aliquam tenetur ratione tempore quidem voluptates cupiditate voluptas illo saepe quaerat numquam recusandae? Qui, necessitatibus, est!</p>
		
          <hr>
          -->

        </div>

        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">

          <!-- Search Widget -->
          <div class="card my-4">
            <div class="card-body" style="text-align:center">
            	<h3>İlan Bilgisi</h3>
            	<hr>
            	<h5 class="info">Başvuru Sayısı : <span class="badge badge-secondary">1.326</span></h5>
            	
            	<h5 class="info">Aktivasyon Tarihi <span class="badge badge-secondary" id="create_date">${ilan.create_date}</span></h5>
            	
            	<h5 class="info">Expiration Tarihi <span class="badge badge-secondary" id="expiration_date">${ilan.expiration_date}</span></h5>
            	
            	<a href="ilanlarBasvur/${ilan.id}" class="btn btn-common btn-rm info_button" style="text-align:center">Başvur</a>
            </div>
          </div>

          

        </div>

      </div>
      <!-- /.row -->

    </div>
    <!-- Page Content END-->
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

</body>
</html>
