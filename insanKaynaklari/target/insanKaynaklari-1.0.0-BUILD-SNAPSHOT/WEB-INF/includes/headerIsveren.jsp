<div class="header">
		<!-- Start intro section -->
		<section id="intro" class="section-intro">
			<div class="logo-menu">
				<nav class="navbar navbar-default" role="navigation"
					data-spy="affix" data-offset-top="50">
					<!-- Menu Begining -->
					<jsp:include page="menuler/menuIsveren.jsp"></jsp:include>
					<!-- Menu End -->

					<!-- Mobile Menu Start -->
					<jsp:include page="menuler/mobilMenuIsveren.jsp"></jsp:include>
					<!-- Mobile Menu End -->
				</nav>

				<!-- Off Canvas Navigation -->
				<jsp:include page="offCanvasSideMenu.jsp"></jsp:include>
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
		</section>
		<!-- end intro section -->
	</div>