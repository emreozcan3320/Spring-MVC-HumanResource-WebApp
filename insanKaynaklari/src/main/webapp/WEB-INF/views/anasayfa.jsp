<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta name="author" content="kadiremreozcan">

<title>JobBoard - Bootstrap HTML5 Job Portal Template</title>

<!-- Theme1 Links starts -->
<jsp:include page="../includes/theme1Links.jsp"></jsp:include>
<!-- Theme1 Links Ends -->

</head>

<body>
<% if (session.getAttribute("hrSession") == null && session.getAttribute("adaySession") == null) { %>
    <jsp:include page="../includes/headerGenel.jsp"></jsp:include>
<% } if (session.getAttribute("adaySession") != null) {%>
    <jsp:include page="../includes/headerAday.jsp"></jsp:include>
<% }if (session.getAttribute("hrSession") != null) { %>
	<jsp:include page="../includes/headerIsveren.jsp"></jsp:include>
<%} %>

	<!-- Find Job Section Start -->
	<section class="find-job section">
		<div class="container">
			<h2 class="section-title">Hot Jobs</h2>
			<div class="row">
				<div class="col-md-12">
					<div class="job-list">
						<div class="thumb">
							<a href="job-details.html"><img
								src="resources/theme1/img/jobs/img-1.jpg" alt=""></a>
						</div>
						<div class="job-list-content">
							<h4>
								<a href="job-details.html">Need a web designer</a><span
									class="full-time">Full-Time</span>
							</h4>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
								Illum quaerat aut veniam molestiae atque dolorum omnis
								temporibus consequuntur saepe. Nemo atque consectetur saepe
								corporis odit in dicta reprehenderit, officiis, praesentium?</p>
							<div class="job-tag">
								<div class="pull-left">
									<div class="meta-tag">
										<span><a href="browse-categories.html"><i
												class="ti-brush"></i>Art/Design</a></span> <span><i
											class="ti-location-pin"></i>Washington, USA</span> <span><i
											class="ti-time"></i>60/Hour</span>
									</div>
								</div>
								<div class="pull-right">
									<div class="icon">
										<i class="ti-heart"></i>
									</div>
									<a href="job-details.html" class="btn btn-common btn-rm">More
										Detail</a>
								</div>
							</div>
						</div>
					</div>
					<div class="job-list">
						<div class="thumb">
							<a href="job-details.html"><img
								src="resources/theme1/img/jobs/img-2.jpg" alt=""></a>
						</div>
						<div class="job-list-content">
							<h4>
								<a href="job-details.html">Front-end developer needed</a><span
									class="full-time">Full-Time</span>
							</h4>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
								Illum quaerat aut veniam molestiae atque dolorum omnis
								temporibus consequuntur saepe. Nemo atque consectetur saepe
								corporis odit in dicta reprehenderit, officiis, praesentium?</p>
							<div class="job-tag">
								<div class="pull-left">
									<div class="meta-tag">
										<span><a href="browse-categories.html"><i
												class="ti-desktop"></i>Technologies</a></span> <span><i
											class="ti-location-pin"></i>Cupertino, CA, USA</span> <span><i
											class="ti-time"></i>60/Hour</span>
									</div>
								</div>
								<div class="pull-right">
									<div class="icon">
										<i class="ti-heart"></i>
									</div>
									<a href="job-details.html" class="btn btn-common btn-rm">More
										Detail</a>
								</div>
							</div>
						</div>
					</div>
					<div class="job-list">
						<div class="thumb">
							<a href="job-details.html"><img
								src="resources/theme1/img/jobs/img-3.jpg" alt=""></a>
						</div>
						<div class="job-list-content">
							<h4>
								<a href="job-details.html">Senior Accountant</a><span
									class="part-time">Part-Time</span>
							</h4>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
								Illum quaerat aut veniam molestiae atque dolorum omnis
								temporibus consequuntur saepe. Nemo atque consectetur saepe
								corporis odit in dicta reprehenderit, officiis, praesentium?</p>
							<div class="job-tag">
								<div class="pull-left">
									<div class="meta-tag">
										<span><a href="browse-categories.html"><i
												class="ti-home"></i>Finance</a></span> <span><i
											class="ti-location-pin"></i>Delaware, USA</span> <span><i
											class="ti-time"></i>60/Hour</span>
									</div>
								</div>
								<div class="pull-right">
									<div class="icon">
										<i class="ti-heart"></i>
									</div>
									<a href="job-details.html" class="btn btn-common btn-rm">More
										Detail</a>
								</div>
							</div>
						</div>
					</div>
					<div class="job-list">
						<div class="thumb">
							<a href="job-details.html"><img
								src="resources/theme1/img/jobs/img-4.jpg" alt=""></a>
						</div>
						<div class="job-list-content">
							<h4>
								<a href="job-details.html">Fullstack web developer needed</a><span
									class="full-time">Full-Time</span>
							</h4>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
								Illum quaerat aut veniam molestiae atque dolorum omnis
								temporibus consequuntur saepe. Nemo atque consectetur saepe
								corporis odit in dicta reprehenderit, officiis, praesentium?</p>
							<div class="job-tag">
								<div class="pull-left">
									<div class="meta-tag">
										<span><a href="browse-categories.html"><i
												class="ti-desktop"></i>Technologies</a></span> <span><i
											class="ti-location-pin"></i>New York, USA</span> <span><i
											class="ti-time"></i>60/Hour</span>
									</div>
								</div>
								<div class="pull-right">
									<div class="icon">
										<i class="ti-heart"></i>
									</div>
									<a href="job-details.html" class="btn btn-common btn-rm">More
										Detail</a>
								</div>
							</div>
						</div>
					</div>
				</div>
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

	<!-- Category Section Start -->
	<section class="section text-center">
		<div class="container">
			<h1>Kategory</h1>
		</div>
		</div>
	</section>
	<!-- Category Section End -->

	<!-- Featured Jobs Section Start -->
	<section class="featured-jobs section">
		<div class="container">
			<h2 class="section-title">Featured Jobs</h2>
			<div class="row">
				<div class="col-md-4 col-sm-6 col-xs-12">
					<div class="featured-item">
						<div class="featured-wrap">
							<div class="featured-inner">
								<figure class="item-thumb">
									<a class="hover-effect" href="job-page.html"> <img
										src="resources/theme1/img/features/img-1.jpg" alt="">
									</a>
								</figure>
								<div class="item-body">
									<h3 class="job-title">
										<a href="job-page.html">Graphic Designer</a>
									</h3>
									<div class="adderess">
										<i class="ti-location-pin"></i> Dallas, United States
									</div>
								</div>
							</div>
						</div>
						<div class="item-foot">
							<span><i class="ti-calendar"></i> 4 months ago</span> <span><i
								class="ti-time"></i> Full Time</span>
							<div class="view-iocn">
								<a href="job-page.html"><i class="ti-arrow-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-12">
					<div class="featured-item">
						<div class="featured-wrap">
							<div class="featured-inner">
								<figure class="item-thumb">
									<a class="hover-effect" href="job-page.html"> <img
										src="resources/theme1/img/features/img-2.jpg" alt="">
									</a>
								</figure>
								<div class="item-body">
									<h3 class="job-title">
										<a href="job-page.html">Software Engineer</a>
									</h3>
									<div class="adderess">
										<i class="ti-location-pin"></i> Delaware, United States
									</div>
								</div>
							</div>
						</div>
						<div class="item-foot">
							<span><i class="ti-calendar"></i> 5 months ago</span> <span><i
								class="ti-time"></i> Part Time</span>
							<div class="view-iocn">
								<a href="job-page.html"><i class="ti-arrow-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-12">
					<div class="featured-item">
						<div class="featured-wrap">
							<div class="featured-inner">
								<figure class="item-thumb">
									<a class="hover-effect" href="job-page.html"> <img
										src="resources/theme1/img/features/img-3.jpg" alt="">
									</a>
								</figure>
								<div class="item-body">
									<h3 class="job-title">
										<a href="job-page.html">Managing Director</a>
									</h3>
									<div class="adderess">
										<i class="ti-location-pin"></i> NY, United States
									</div>
								</div>
							</div>
						</div>
						<div class="item-foot">
							<span><i class="ti-calendar"></i> 3 months ago</span> <span><i
								class="ti-time"></i> Full Time</span>
							<div class="view-iocn">
								<a href="job-page.html"><i class="ti-arrow-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-12">
					<div class="featured-item">
						<div class="featured-wrap">
							<div class="featured-inner">
								<figure class="item-thumb">
									<a class="hover-effect" href="job-page.html"> <img
										src="resources/theme1/img/features/img-3.jpg" alt="">
									</a>
								</figure>
								<div class="item-body">
									<h3 class="job-title">
										<a href="job-page.html">Graphic Designer</a>
									</h3>
									<div class="adderess">
										<i class="ti-location-pin"></i> Washington, United States
									</div>
								</div>
							</div>
						</div>
						<div class="item-foot">
							<span><i class="ti-calendar"></i> 1 months ago</span> <span><i
								class="ti-time"></i> Part Time</span>
							<div class="view-iocn">
								<a href="job-page.html"><i class="ti-arrow-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-12">
					<div class="featured-item">
						<div class="featured-wrap">
							<div class="featured-inner">
								<figure class="item-thumb">
									<a class="hover-effect" href="job-page.html"> <img
										src="resources/theme1/img/features/img-2.jpg" alt="">
									</a>
								</figure>
								<div class="item-body">
									<h3 class="job-title">
										<a href="job-page.html">Software Engineer</a>
									</h3>
									<div class="adderess">
										<i class="ti-location-pin"></i> Dallas, United States
									</div>
								</div>
							</div>
						</div>
						<div class="item-foot">
							<span><i class="ti-calendar"></i> 6 months ago</span> <span><i
								class="ti-time"></i> Full Time</span>
							<div class="view-iocn">
								<a href="job-page.html"><i class="ti-arrow-right"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-12">
					<div class="featured-item">
						<div class="featured-wrap">
							<div class="featured-inner">
								<figure class="item-thumb">
									<a class="hover-effect" href="job-page.html"> <img
										src="resources/theme1/img/features/img-1.jpg" alt="">
									</a>
								</figure>
								<div class="item-body">
									<h3 class="job-title">
										<a href="job-page.html">Managing Director</a>
									</h3>
									<div class="adderess">
										<i class="ti-location-pin"></i> NY, United States
									</div>
								</div>
							</div>
						</div>
						<div class="item-foot">
							<span><i class="ti-calendar"></i> 7 months ago</span> <span><i
								class="ti-time"></i> Part Time</span>
							<div class="view-iocn">
								<a href="job-page.html"><i class="ti-arrow-right"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Featured Jobs Section End -->

	<!-- Start Purchase Section -->
	<section class="section purchase" data-stellar-background-ratio="0.5">
		<div class="container">
			<div class="row">
				<div class="section-content text-center">
					<h1 class="title-text">Looking for a Job</h1>
					<p>Join thousand of employers and earn what you deserve!</p>
					<a href="my-account.html" class="btn btn-common">Get Started
						Now</a>
				</div>
			</div>
		</div>
	</section>
	<!-- End Purchase Section -->

	<!-- Blog Section -->
	<section id="blog" class="section">
		<!-- Container Starts -->
		<div class="container">
			<h2 class="section-title">Latest News</h2>
			<div class="row">
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 blog-item">
					<!-- Blog Item Starts -->
					<div class="blog-item-wrapper">
						<div class="blog-item-img">
							<a href="single-post.html"> <img
								src="resources/theme1/img/blog/home-items/img1.jpg" alt="">
							</a>
						</div>
						<div class="blog-item-text">
							<div class="meta-tags">
								<span class="date"><i class="ti-calendar"></i> Dec 20,
									2017</span> <span class="comments"><a href="#"><i
										class="ti-comment-alt"></i> 5 Comments</a></span>
							</div>
							<a href="single-post.html">
								<h3>Tips to write an impressive resume online for beginner
								</h3>
							</a>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
								Labore praesentium asperiores ad vitae.</p>
							<a href="single-post.html" class="btn btn-common btn-rm">Read
								More</a>
						</div>
					</div>
					<!-- Blog Item Wrapper Ends-->
				</div>

				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 blog-item">
					<!-- Blog Item Starts -->
					<div class="blog-item-wrapper">
						<div class="blog-item-img">
							<a href="single-post.html"> <img
								src="resources/theme1/img/blog/home-items/img2.jpg" alt="">
							</a>
						</div>
						<div class="blog-item-text">
							<div class="meta-tags">
								<span class="date"><i class="ti-calendar"></i> Jan 20,
									2018</span> <span class="comments"><a href="#"><i
										class="ti-comment-alt"></i> 5 Comments</a></span>
							</div>
							<a href="single-post.html">
								<h3>Let's explore 5 cool new features in JobBoard theme</h3>
							</a>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
								Labore praesentium asperiores ad vitae.</p>
							<a href="single-post.html" class="btn btn-common btn-rm">Read
								More</a>
						</div>
					</div>
					<!-- Blog Item Wrapper Ends-->
				</div>

				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 blog-item">
					<!-- Blog Item Starts -->
					<div class="blog-item-wrapper">
						<div class="blog-item-img">
							<a href="single-post.html"> <img
								src="resources/theme1/img/blog/home-items/img3.jpg" alt="">
							</a>
						</div>
						<div class="blog-item-text">
							<div class="meta-tags">
								<span class="date"><i class="ti-calendar"></i> Mar 20,
									2018</span> <span class="comments"><a href="#"><i
										class="ti-comment-alt"></i> 5 Comments</a></span>
							</div>
							<a href="single-post.html">
								<h3>How to convince recruiters and get your dream job</h3>
							</a>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
								Labore praesentium asperiores ad vitae.</p>
							<a href="single-post.html" class="btn btn-common btn-rm">Read
								More</a>
						</div>
					</div>
					<!-- Blog Item Wrapper Ends-->
				</div>
			</div>
		</div>
	</section>
	<!-- blog Section End -->

	<!-- Testimonial Section Start -->
	<section id="testimonial" class="section">
		<div class="container">
			<div class="row">
				<div class="touch-slider" class="owl-carousel owl-theme">
					<div class="item active text-center">
						<img class="img-member"
							src="resources/theme1/img/testimonial/img1.jpg" alt="">
						<div class="client-info">
							<h2 class="client-name">
								Jessica <span>(Senior Accountant)</span>
							</h2>
						</div>
						<p>
							<i class="fa fa-quote-left quote-left"></i> The team that was
							assigned to our project... were extremely professional <i
								class="fa fa-quote-right quote-right"></i><br> throughout
							the project and assured that the owner expectations were met and
							<br> often exceeded.
						</p>
					</div>
					<div class="item text-center">
						<img class="img-member"
							src="resources/theme1/img/testimonial/img2.jpg" alt="">
						<div class="client-info">
							<h2 class="client-name">
								John Doe <span>(Project Menager)</span>
							</h2>
						</div>
						<p>
							<i class="fa fa-quote-left quote-left"></i> The team that was
							assigned to our project... were extremely professional <i
								class="fa fa-quote-right quote-right"></i><br> throughout
							the project and assured that the owner expectations were met and
							<br> often exceeded.
						</p>
					</div>
					<div class="item text-center">
						<img class="img-member"
							src="resources/theme1/img/testimonial/img3.jpg" alt="">
						<div class="client-info">
							<h2 class="client-name">
								Helen <span>(Engineer)</span>
							</h2>
						</div>
						<p>
							<i class="fa fa-quote-left quote-left"></i> The team that was
							assigned to our project... were extremely professional <i
								class="fa fa-quote-right quote-right"></i><br> throughout
							the project and assured that the owner expectations were met and
							<br> often exceeded.
						</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Testimonial Section End -->

	<!-- Clients Section -->
	<section class="clients section">
		<div class="container">
			<h2 class="section-title">Clients & Partners</h2>
			<div class="row">
				<div id="clients-scroller">
					<div class="items">
						<img src="resources/theme1/img/clients/img1.png" alt="">
					</div>
					<div class="items">
						<img src="resources/theme1/img/clients/img2.png" alt="">
					</div>
					<div class="items">
						<img src="resources/theme1/img/clients/img3.png" alt="">
					</div>
					<div class="items">
						<img src="resources/theme1/img/clients/img4.png" alt="">
					</div>
					<div class="items">
						<img src="resources/theme1/img/clients/img5.png" alt="">
					</div>
					<div class="items">
						<img src="resources/theme1/img/clients/img6.png" alt="">
					</div>
					<div class="items">
						<img src="resources/theme1/img/clients/img6.png" alt="">
					</div>
					<div class="items">
						<img src="resources/theme1/img/clients/img6.png" alt="">
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Client Section End -->

	<!-- Counter Section Start -->
	<section id="counter">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="counting">
						<div class="icon">
							<i class="ti-briefcase"></i>
						</div>
						<div class="desc">
							<h2>Jobs</h2>
							<h1 class="counter">12050</h1>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="counting">
						<div class="icon">
							<i class="ti-user"></i>
						</div>
						<div class="desc">
							<h2>Members</h2>
							<h1 class="counter">10890</h1>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="counting">
						<div class="icon">
							<i class="ti-write"></i>
						</div>
						<div class="desc">
							<h2>Resume</h2>
							<h1 class="counter">700</h1>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="counting">
						<div class="icon">
							<i class="ti-heart"></i>
						</div>
						<div class="desc">
							<h2>Company</h2>
							<h1 class="counter">9050</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Counter Section End -->

	<!-- Infobox Section Start -->
	<section class="infobox section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="info-text">
						<h2>Don't Want To Miss a Thing?</h2>
						<p>
							Just go to <a href="#">Google Play</a> to download JobBoard Mini
						</p>
					</div>
					<a href="#" class="btn btn-border">Google Play</a>
				</div>
			</div>
		</div>
	</section>
	<!-- Infobox Section End -->

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
