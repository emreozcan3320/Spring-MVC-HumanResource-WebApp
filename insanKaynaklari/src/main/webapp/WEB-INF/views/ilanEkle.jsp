<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  
<title>Home</title>

<!-- Special version of Bootstrap that only affects content wrapped in .bootstrap-iso -->
	<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	
<!-- Bootstrap core CSS-->
  <link href="resources/adminPanel/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="resources/adminPanel/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="resources/adminPanel/css/sb-admin.css" rel="stylesheet">
  
</head>
<body>

	<!-- Inline CSS based on choices in "Settings" tab -->
	<style>
		.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p,
		.bootstrap-iso form {
			font-family: Arial, Helvetica, sans-serif;
			color: black
		}

		.bootstrap-iso form button, .bootstrap-iso form button:hover {
			color: #ffffff !important;
		}

		.asteriskField {
			color: red;
		}
	</style>
	
	<jsp:include page="../includes/adminPanelNav.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="index.html">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">Blank Page</li>
      </ol>
      <div class="row">
        <div class="col-12">
        <jsp:include page="../includes/ilanEkleForm.jsp"></jsp:include>
        </div>
      </div>
    </div> 
    <br>
    <br>
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © Your Website 2018</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="login.html">Logout</a>
          </div>
        </div>
      </div>
    </div>
    </div>
	
	<!-- 
	<script type="text/javascript" src="resources/custom/js/jquery-min.js"></script>
	<script type="text/javascript" src="resources/custom/js/bootstrap.min.js"></script>
	 -->
	 <!-- Bootstrap core JavaScript-->
    <script src="resources/adminPanel/vendor/jquery/jquery.min.js"></script>
    <script src="resources/adminPanel/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="resources/adminPanel/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="resources/adminPanel/js/sb-admin.min.js"></script>
    
	  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
    	$(function () {
    		$( "#datepicker" ).datepicker({
    			monthNames: [ "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık" ],
    			dayNamesMin: [ "Pa", "Pt", "Sl", "Ça", "Pe", "Cu", "Ct" ]
    			});
    		
    		$( "#datepickerTwo" ).datepicker({
    			monthNames: [ "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık" ],
    			dayNamesMin: [ "Pa", "Pt", "Sl", "Ça", "Pe", "Cu", "Ct" ]
    			});
    		
        	//$("#datepicker").datepicker();
            //$("#datepickerTwo").datepicker();
        });
   	</script>
	<script type="text/javascript" src="resources/custom/js/ilanEkle.js"></script>
</body>
</html>
