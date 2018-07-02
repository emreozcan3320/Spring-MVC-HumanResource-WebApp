<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

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
										placeholder="job title / keywords / company name"> <i
										class="ti-time"></i>
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
											<option>IT And Engineering</option>
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