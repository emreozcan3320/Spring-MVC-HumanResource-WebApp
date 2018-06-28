<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="author" content="Jobboard">
    
    <title>JobBoard - Bootstrap HTML5 Job Portal Template</title>    

    <!-- Favicon -->
    <link rel="shortcut icon" href="resources/theme1/img/favicon.png">
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
        <div class="logo-menu">
          <nav class="navbar navbar-default main-navigation" role="navigation" data-spy="affix" data-offset-top="50">
            <div class="container">
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand logo" href="index.html"><img src="resources/theme1/img/logo.png" alt=""></a>
              </div>

              <div class="collapse navbar-collapse" id="navbar">              
                 <!-- Start Navigation List -->
                <ul class="nav navbar-nav">
                  <li>
                    <a href="index.html">
                    Home <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown">
                      <li>
                        <a class="active" href="index.html">
                        Home 1
                        </a>
                      </li>
                      <li>
                        <a href="index-02.html">
                        Home 2
                        </a>                          
                      </li>
                      <li>
                        <a href="index-03.html">
                        Home 3
                        </a>
                      </li>
                      <li>
                        <a href="index-04.html">
                        Home 4
                        </a>
                      </li>
                    </ul>
                  </li>
                  <li>
                    <a href="about.html">
                    Pages <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown">
                      <li>
                        <a href="about.html">
                        About
                        </a>
                      </li>
                      <li>
                        <a href="job-page.html">
                        Job Page
                        </a>
                      </li>
                      <li>
                        <a href="job-details.html">
                        Job Details
                        </a>
                      </li>
                      <li>
                        <a href="resume.html">
                        Resume Page
                        </a>
                      </li>
                      <li>
                        <a href="privacy-policy.html">
                        Privacy Policy
                        </a>
                      </li>
                      <li>
                        <a href="faq.html">
                        FAQ
                        </a>
                      </li>
                      <li>
                        <a href="pricing.html">
                        Pricing Tables
                        </a>
                      </li>
                      <li>
                        <a href="contact.html">
                        Contact
                        </a>
                      </li>
                    </ul>
                  </li>
                  <li>
                    <a href="#">
                    Candidates <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown">
                      <li>
                        <a href="browse-jobs.html">
                        Browse Jobs
                        </a>
                      </li>
                      <li>
                        <a href="browse-categories.html">
                        Browse Categories
                        </a>
                      </li>
                      <li>
                        <a href="add-resume.html">
                        Add Resume
                        </a>
                      </li>
                      <li>
                        <a href="manage-resumes.html">
                        Manage Resumes
                        </a>
                      </li>
                      <li>
                        <a href="job-alerts.html">
                        Job Alerts
                        </a>
                      </li>
                    </ul>
                  </li>
                  <li>
                    <a class="active" href="#">
                    Employers <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown">
                      <li>
                        <a class="active" href="post-job.html">
                        Add Job
                        </a>
                      </li>
                      <li>
                        <a href="manage-jobs.html">
                        Manage Jobs
                        </a>
                      </li>
                      <li>
                        <a href="manage-applications.html">
                        Manage Applications
                        </a>
                      </li>
                      <li>
                        <a href="browse-resumes.html">
                        Browse Resumes
                        </a>
                      </li>
                    </ul>
                  </li>
                  <li>
                    <a href="blog.html">
                    Blog <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown">
                      <li>
                        <a href="blog.html">
                        Blog - Right Sidebar
                        </a>
                      </li>
                      <li>
                        <a href="blog-left-sidebar.html">
                        Blog - Left Sidebar
                        </a>
                      </li>
                      <li><a href="blog-full-width.html">Blog - Full Width</a></li>
                      <li>
                        <a href="single-post.html">
                        Blog Single Post
                        </a>
                      </li>
                    </ul>
                  </li>
                </ul>
                <ul class="nav navbar-nav navbar-right float-right">
                  <li class="left"><a href="post-job.html"><i class="ti-pencil-alt"></i> Post A Job</a></li>
                  <li class="right"><a href="my-account.html"><i class="ti-lock"></i>  Log In</a></li>
                </ul>
              </div>
            </div>
            <!-- Mobile Menu Start -->
            <ul class="wpb-mobile-menu">
              <li>
                <a href="index.html">Home</a>
                <ul>
                  <li><a href="index.html">Home 1</a></li>
                  <li><a href="index-02.html">Home 2</a></li>
                  <li><a href="index-03.html">Home 3</a></li>
                  <li><a href="index-04.html">Home 4</a></li>
                </ul>                       
              </li>
              <li>
                <a href="about.html">Pages</a>
                <ul>
                  <li><a href="about.html">About</a></li>
                  <li><a href="job-page.html">Job Page</a></li>
                  <li><a href="job-details.html">Job Details</a></li>
                  <li><a href="resume.html">Resume Page</a></li>
                  <li><a href="privacy-policy.html">Privacy Policy</a></li>
                  <li><a href="faq.html">FAQ</a></li>
                  <li><a href="pricing.html">Pricing Tables</a></li>
                  <li><a href="contact.html">Contact</a></li>
                </ul>
              </li>
              <li>
                <a href="#">For Candidates</a>
                <ul>
                  <li><a href="browse-jobs.html">Browse Jobs</a></li>
                  <li><a href="browse-categories.html">Browse Categories</a></li>
                  <li><a href="add-resume.html">Add Resume</a></li>
                  <li><a href="manage-resumes.html">Manage Resumes</a></li>
                  <li><a href="job-alerts.html">Job Alerts</a></li>
                </ul>
              </li>
              <li>
                <a class="active" href="#">For Employers</a>
                <ul>
                  <li><a class="active" href="post-job.html">Add Job</a></li>
                  <li><a href="manage-jobs.html">Manage Jobs</a></li>
                  <li><a href="manage-applications.html">Manage Applications</a></li>
                  <li><a href="browse-resumes.html">Browse Resumes</a></li>
                </ul>
              </li> 
              <li>
                <a href="blog.html">Blog</a>
                <ul class="dropdown">
                  <li><a href="blog.html">Blog - Right Sidebar</a></li>
                  <li><a href="blog-left-sidebar.html">Blog - Left Sidebar</a></li>
                  <li><a href="blog-full-width.html">Blog - Full Width</a></li>
                  <li><a href="single-post.html">Blog Single Post</a></li>
                </ul>
              </li>  
              <li class="btn-m"><a href="post-job.html"><i class="ti-pencil-alt"></i> Post A Job</a></li>
              <li class="btn-m"><a href="my-account.html"><i class="ti-lock"></i>  Log In</a></li>          
            </ul>
            <!-- Mobile Menu End --> 
          </nav>

          <!-- Off Canvas Navigation -->
          <div class="navmenu navmenu-default navmenu-fixed-left offcanvas"> 
          <!--- Off Canvas Side Menu -->
            <div class="close" data-toggle="offcanvas" data-target=".navmenu">
                <i class="ti-close"></i>
            </div>
              <h3 class="title-menu">All Pages</h3>
              <ul class="nav navmenu-nav">
                <li><a href="index.html">Home</a></li>
                <li><a href="index-02.html">Home Page 2</a></li>
                <li><a href="index-03.html">Home Page 3</a></li>
                <li><a href="index-04.html">Home Page 4</a></li>
                <li><a href="about.html">About us</a></li>            
                <li><a href="job-page.html">Job Page</a></li>             
                <li><a href="job-details.html">Job Details</a></li>    
                <li><a href="resume.html">Resume Page</a></li> 
                <li><a href="privacy-policy.html">Privacy Policy</a></li>
                <li><a href="pricing.html">Pricing Tables</a></li>
                <li><a href="browse-jobs.html">Browse Jobs</a></li>
                <li><a href="browse-categories.html">Browse Categories</a></li>
                <li><a href="add-resume.html">Add Resume</a></li>
                <li><a href="manage-resumes.html">Manage Resumes</a></li> 
                <li><a href="job-alerts.html">Job Alerts</a></li> 
                <li><a href="post-job.html">Add Job</a></li>  
                <li><a href="manage-jobs.html">Manage Jobs</a></li>
                <li><a href="manage-applications.html">Manage Applications</a></li>
                <li><a href="browse-resumes.html">Browse Resumes</a></li>
                <li><a href="contact.html">Contact</a></li>
                <li><a href="faq.html">Faq</a></li>
                <li><a href="my-account.html">Login</a></li>
              </ul><!--- End Menu -->
          </div> <!--- End Off Canvas Side Menu -->
          <div class="tbtn wow pulse" id="menu" data-wow-iteration="infinite" data-wow-duration="500ms" data-toggle="offcanvas" data-target=".navmenu">
            <p><i class="ti-files"></i> All Pages</p>
          </div>
      </div>
      <!-- Header Section End -->  

      <!-- Header Section End -->
			<div class="search-container-ilanlar">
				<div class="container">
					<div class="row">
						<div class="col-md-12">						
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
      </div>
    </section>      

    <!-- Footer Section Start -->
    <footer>
      <!-- Footer Area Start -->
      <section class="footer-Content">
        <div class="container">
          <div class="row">
            <div class="col-md-3 col-sm-6 col-xs-12">
              <div class="widget">
                <h3 class="block-title"><img src="resources/theme1/img/logo.png" class="img-responsive" alt="Footer Logo"></h3>
                <div class="textwidget">
                  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque lobortis tincidunt est, et euismod purus suscipit quis. Etiam euismod ornare elementum. Sed ex est, consectetur eget facilisis sed, auctor ut purus.</p>
                </div>
              </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
              <div class="widget">
                <h3 class="block-title">Quick Links</h3>
                <ul class="menu">
                  <li><a href="#">About Us</a></li>
                  <li><a href="#">Support</a></li>
                  <li><a href="#">License</a></li>
                  <li><a href="#">Terms & Conditions</a></li>
                  <li><a href="#">Contact</a></li>
                </ul>
              </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
              <div class="widget">
                <h3 class="block-title">Trending Jobs</h3>
                <ul class="menu">
                  <li><a href="#">Android Developer</a></li>
                  <li><a href="#">Senior Teamleader</a></li>
                  <li><a href="#">iOS Developer</a></li>
                  <li><a href="#">Junior Tester</a></li>
                  <li><a href="#">Full Stack Developer</a></li>
                </ul>
              </div>
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12">
              <div class="widget">
                <h3 class="block-title">Follow Us</h3>
                <div class="bottom-social-icons social-icon">  
                  <a class="twitter" href="https://twitter.com/GrayGrids"><i class="ti-twitter-alt"></i></a>
                  <a class="facebook" href="https://web.facebook.com/GrayGrids"><i class="ti-facebook"></i></a>                   
                  <a class="youtube" href="https://youtube.com"><i class="ti-youtube"></i></a>
                  <a class="dribble" href="https://dribbble.com/"><i class="ti-dribbble"></i></a>
                  <a class="linkedin" href="https://www.linkedin.com/"><i class="ti-linkedin"></i></a>
                </div>  
                <p>Join our mailing list to stay up to date and get notices about our new releases!</p>
                <form class="subscribe-box">
                  <input type="text" placeholder="Your email">
                  <input type="submit" class="btn-system" value="Send">
                </form> 
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- Footer area End -->
      
      <!-- Copyright Start  -->
      <div id="copyright">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <div class="site-info text-center">
                <p>All copyrights reserved @ 2017 - Design & Development by <a href="http://graygrids.com">Graygrids</a></p>
              </div>   
            </div>
          </div>
        </div>
      </div>
      <!-- Copyright End -->

    </footer>
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
    <script type="text/javascript" src="resources/theme1/js/jquery.themepunch.revolution.min.js"></script>
    <script type="text/javascript" src="resources/theme1/js/jquery.themepunch.tools.min.js"></script>
    <script type="text/javascript" src="resources/theme1/js/froala_editor.min.js"></script>
    <script type="text/javascript" src="resources/theme1/js/fullscreen.min.js"></script>

      <script>
        $(function() {
          $('#edit').froalaEditor()
        });
      </script>
      
  </body>
</html>