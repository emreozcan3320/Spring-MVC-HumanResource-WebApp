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
  <!-- Page level plugin CSS-->
  <link href="resources/adminPanel/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="resources/adminPanel/css/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark sidenav-toggled" id="page-top">

<style>
.hrefTable { cursor: pointer; }

</style>

  <!-- Navigation-->
  <jsp:include page="../includes/adminPanelNav.jsp"></jsp:include>
  
  
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">İsveren</a>
        </li>
        <li class="breadcrumb-item active">İlan / Bilgi</li>
      </ol>
      
      <div class="row">
        <div class="col-12">
        <jsp:include page="../includes/ilanBody.jsp"></jsp:include>
        </div>
      </div>
            
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    
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
  
  <!-- Bootstrap core JavaScript-->
    <script src="resources/adminPanel/vendor/jquery/jquery.min.js"></script>
    <script src="resources/adminPanel/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="resources/adminPanel/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="resources/adminPanel/vendor/datatables/jquery.dataTables.js"></script>
    <script src="resources/adminPanel/vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="resources/adminPanel/js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="resources/adminPanel/js/sb-admin-datatables.min.js"></script>
    
    <script src="resources/custom/js/ilanBody.js"></script>
</body>

</html>

