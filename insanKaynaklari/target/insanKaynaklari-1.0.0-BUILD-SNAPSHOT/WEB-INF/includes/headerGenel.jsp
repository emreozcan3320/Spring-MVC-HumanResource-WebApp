<div class="header">
		<!-- Start intro section -->
		<section id="intro" class="section-intro">
			<div class="logo-menu">
				<nav class="navbar navbar-default" role="navigation"
					data-spy="affix" data-offset-top="50">
					<!-- Menu Begining -->
					<jsp:include page="menuler/menuGeneral.jsp"></jsp:include>
					<!-- Menu End -->

					<!-- Mobile Menu Start -->
					<jsp:include page="menuler/mobilMenuGeneral.jsp"></jsp:include>
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

			<div class="search-container">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<h1>Find the job that fits your life</h1>
							<br>
							<h2>
								More than <strong>12,000</strong> jobs are waiting to Kickstart
								your career!
							</h2>
							<div class="content">
								<form method="" action="">
									<div class="row">
										<div class="col-md-4 col-sm-6">
											<div class="form-group">
												<input class="form-control" type="text"
													placeholder="job title / keywords / company name">
												<i class="ti-time"></i>
											</div>
										</div>
										<div class="col-md-4 col-sm-6">
											<div class="form-group">
												<input class="form-control" type="email"
													placeholder="city / province / zip code"> <i
													class="ti-location-pin"></i>
											</div>
										</div>
										<div class="col-md-3 col-sm-6">
											<div class="search-category-container">
												<label class="styled-select"> <select
													class="dropdown-product selectpicker">
														<option>All Categories</option>
														<option>Finance</option>
														<option>IT & Engineering</option>
														<option>Education/Training</option>
														<option>Art/Design</option>
														<option>Sale/Markting</option>
														<option>Healthcare</option>
														<option>Science</option>
														<option>Food Services</option>
												</select>
												</label>
											</div>
										</div>
										<div class="col-md-1 col-sm-6">
											<button type="button" class="btn btn-search-icon">
												<i class="ti-search"></i>
											</button>
										</div>
									</div>
								</form>
							</div>
							<div class="popular-jobs">
								<b>Popular Keywords: </b> <a href="#">Web Design</a> <a href="#">Manager</a>
								<a href="#">Programming</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- end intro section -->
	</div>