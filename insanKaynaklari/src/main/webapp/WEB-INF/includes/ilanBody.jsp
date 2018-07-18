<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<!-- Page Content -->
    <div class="container">

      <div class="row">
      <input id="ilan_id" type="text" hidden style="display:none;" value="${ilan_id}"/>
      <input id="uzmanlik" type="text" hidden style="display:none;" value="${uzmanlik}"/>
      

        <!-- Post Content Column -->
        <div class="col-lg-8">

          <!-- Title -->
          <h1 class="mt-4" id="title"></h1>

          <!-- Author -->
          <input id="kelimeArray" type="text" hidden style="display:none;" />
          <input id="uyusanAdaArray" type="text" hidden style="display:none;" value="anlamadim"/>
          <p>
            Oluşturulma Tarihi
            <!--  <a id="create_date" style="color:#e25a67;"></a> -->
            <span class="badge badge-secondary" id="create_date"></span>
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
          <p class="lead" id="job_definition"></p>
          <hr>
			
		  <h5>Aranan Uzmanlıklar</h5>	
          <p id="expertise"></p>
          <hr>
			
		  <h5>Aranan Kişisel Özellikler</h5>
          <p id="personal_qualities"></p>

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
            <h5 class="card-header">İlan Bilgisi</h5>
            <div class="card-body">
            <h6>Status : <span class="badge badge-secondary" id="status"></span></h6>
            <h6>Başvuru Sayısı : <span class="badge badge-secondary" id="basvuranSayisiBadge"></span></h6>
            <h6>Aktivasyon Tarihi <span class="badge badge-secondary" id="activation_date"></span></h6>
            <h6>Expiration Tarihi <span class="badge badge-secondary" id="expiration_date"></span></h6>
            </div>
          </div>

          <!-- Categories Widget -->
          <div class="card my-4">
            <h5 class="card-header">İşlemler</h5>
            <div class="card-body">
			<input type="hidden" id="hrId" value="${ilan_id}">
            <button type="button" class="btn btn-warning" onclick="basvuranBilgisiDialogBox()">Bavuran Adaylar  &nbsp <span class="badge badge-warning" id="basvuranSayisi"></span></button>
            <br>
            <br>
            <button type="button" class="btn btn-danger" onclick = "deleteJob(${ilan_id})">Delete</button>
            <br>
            <br>
            <button type="button" class="btn btn-success" onclick="Edit()">Düzenle</button>
            </div>
          </div>

          <!-- Side Widget -->
          <div class="card my-4">
            <h5 class="card-header">Side Widget</h5>
            <div class="card-body">
              You can put anything you want inside of these side widgets. They are easy to use, and feature the new Bootstrap 4 card containers!
            </div>
          </div>

        </div>

      </div>
      <!-- /.row -->

    </div>
    <!-- Page Content END-->