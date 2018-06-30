<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="author" content="Jobboard">
    
    <title>JobBoard - Bootstrap HTML5 Job Portal Template</title>    

    <!-- Favicon -->
    <link rel="shortcut icon" href="resources/theme1/favicon.png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/theme1/css/bootstrap.min.css" type="text/css">    
    <link rel="stylesheet" href="resources/theme1/css/jasny-bootstrap.min.css" type="text/css">  
    <link rel="stylesheet" href="resources/theme1/css/bootstrap-select.min.css" type="text/css">  
    <!-- Material CSS -->
    <link rel="stylesheet" href="resources/theme1/css/material-kit.css" type="text/css">
    <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="resources/theme1/fonts/font-awesome.min.css" type="text/css"> 
    <link rel="stylesheet" href="resources/theme1/fonts/themify-icons.css"> 

    <!-- Animate CSS -->
    <link rel="stylesheet" href="resources/theme1/extras/animate.css" type="text/css">
    <!-- Owl Carousel -->
    <link rel="stylesheet" href="resources/theme1/extras/owl.carousel.css" type="text/css">
    <link rel="stylesheet" href="resources/theme1/extras/owl.theme.css" type="text/css">
    <!-- Rev Slider CSS -->
    <link rel="stylesheet" href="resources/theme1/extras/settings.css" type="text/css"> 
    <!-- Editor -->
    <link rel="stylesheet" href="resources/theme1/extras/froala_editor.min.css" type="text/css"> 
    <!-- Slicknav js -->
    <link rel="stylesheet" href="resources/theme1/css/slicknav.css" type="text/css">
    <!-- Main Styles -->
    <link rel="stylesheet" href="resources/theme1/css/main.css" type="text/css">
    <!-- Responsive CSS Styles -->
    <link rel="stylesheet" href="resources/theme1/css/responsive.css" type="text/css">

    <!-- Color CSS Styles  -->
    <link rel="stylesheet" type="text/css" href="resources/theme1/css/colors/red.css" media="screen" />

     
    
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

        
	
      <section class="section text-center" >
      <div class="container">
                <!-- Start Animations Text -->
                <h1>
                    You are using Free Lite version of Job Board<br> Purchase Full version to Get all Pages and Features
                </h1>
              <br>
                <!-- End Animations Text -->

                <!-- Start Buttons -->
                <a rel="nofollow" target="_blank" href="https://rebrand.ly/gg-jobboard-purchase" class="btn btn-common btn-large"><i class="fa fa-cart"></i> Purchase Now</a>
        </div>
      </section>
        

    <!-- Footer Section Start -->
    <jsp:include page="../includes/footer.jsp"></jsp:include>
    <!-- Footer Section End -->  
    
    <!-- Go To Top Link -->
    <a href="#" class="back-to-top">
      <i class="ti-arrow-up"></i>
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
        
    <!-- Main JS  -->
    <script type="text/javascript" src="resources/theme1/js/jquery-min.js"></script>      
    <script type="text/javascript" src="resources/theme1/js/bootstrap.min.js"></script>    
    <script type="text/javascript" src="resources/theme1/js/material.min.js"></script>
    <script type="text/javascript" src="resources/theme1/js/material-kit.js"></script>
    <script type="text/javascript" src="resources/theme1/js/jquery.parallax.js"></script>
    <script type="text/javascript" src="resources/theme1/js/owl.carousel.min.js"></script>
    <script type="text/javascript" src="resources/theme1/js/jquery.slicknav.js"></script>
    <script type="text/javascript" src="resources/theme1/js/main.js"></script>
    <script type="text/javascript" src="resources/theme1/js/jquery.counterup.min.js"></script>
    <script type="text/javascript" src="resources/theme1/js/waypoints.min.js"></script>
    <script type="text/javascript" src="resources/theme1/js/jasny-bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/theme1/js/bootstrap-select.min.js"></script>
    <script type="text/javascript" src="resources/theme1/js/form-validator.min.js"></script>
    <script type="text/javascript" src="resources/theme1/js/contact-form-script.js"></script>
    <script type="text/javascript" src="resources/theme1/js/froala_editor.min.js"></script>
	<script type="text/javascript" src="resources/theme1/js/fullscreen.min.js"></script>

	<script>
        $(function() {
          $('#edit').froalaEditor()
        });
      </script>
      
  </body>
</html>
