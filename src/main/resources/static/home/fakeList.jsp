<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../head.jsp"></jsp:include>
<title>허위 매물 신고 목록(원본)</title>

	<!-- Favicon -->
	<link rel="shortcut icon" href="favicon.ico">
	<link rel="icon" href="favicon.ico" type="image/x-icon">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">   
	<!-- Bootstrap table CSS -->
	<link href="/resources/vendors/bootstrap-table/dist/bootstrap-table.min.css" rel="stylesheet" type="text/css" />
	<!-- Toggles CSS -->
	<link href="/resources/vendors/jquery-toggles/css/toggles.css" rel="stylesheet" type="text/css">
	<link href="/resources/vendors/jquery-toggles/css/themes/toggles-light.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
	<link href="/resources/dist/css/style.css" rel="stylesheet" type="text/css">
	
	<style>
		table {
			table-layout: fixed;
		}
		td, th {
			text-overflow: ellipsis;
			overflow: hidden;
			white-space: nowrap;
		}
	</style>

</head>
<body>
	<jsp:include page="../navAdmin.jsp"></jsp:include>

	<!-- Modal Carousel-->
	<div class="modal fade" id="exampleModalCarousel" tabindex="-1" role="dialog" aria-labelledby="exampleModalCarousel" aria-hidden="true"  style="min-height: 100% ;">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
			<!-- 모달 내용 -->	
			</div>
		</div>
	</div>
	<!-- /Modal Carousel-->
	
	
	
	
	<!-- HK Wrapper -->
	<div class="hk-wrapper hk-alt-nav">
	
		<!-- Main Content -->
	    <div class="hk-pg-wrapper">
		
			<!-- Container -->
		    <div class="container">
		        <!-- Title -->
		          <div class="hk-pg-header">
		              <h4 class="hk-pg-title"><span class="pg-title-icon"><span class="feather-icon"><i data-feather="archive"></i></span></span>최근 신고된 내역</h4>
		          </div>
		          <!-- /Title -->
			
				<!-- Row -->
	            <div class="row">
	                <div class="col-xl-12">
						<section class="hk-sec-wrapper">
	                        <h5 class="hk-sec-title">허위 매물 신고 목록</h5>
	                        <p class="mb-40">허위 매물 신고 목록은 <code>최신순</code> 으로 보여집니다.</p>
	                        <div class="row">
	                            <div class="col-sm">
	                            
	                            <div>
									<form>
										<div class="row mb-2">
											<div class="col-6"></div>
											<div class="col">
												<select name="search" class="form-select form-select-sm">
													<option value="0">검색 항목 선택</option>
													<option value="1" ${pager.search == 1 ? "selected" : ""}>부동산명</option>
													<option value="2" ${pager.search == 2 ? "selected" : ""}>매물NO</option>
													<option value="3" ${pager.search == 3 ? "selected" : ""}>내용</option>
													<option value="4" ${pager.search == 4 ? "selected" : ""}>상태(Y/N)</option>
												</select>
											</div>
											<div class="col">
												<input type="text" name="keyword" class="form-control form-control-sm" value="${pager.keyword}">
											</div>
											<div class="col-1 d-grid">
												<button class="badge-soft-success">검색</button>
											</div>
										</div>
									</form>
								</div>
	                            
	                                <div class="table-wrap">
	                                    <div class="table-responsive">
	                                        <table class="table mb-0">
	                                            <thead>
	                                                <tr>
	                                                    <th colspan="2">신고NO</th>
	                                                    <th colspan="4">부동산명</th>
	                                                    <th colspan="2">매물NO</th>
	                                                    <th colspan="7">내용</th>
	                                                    <th colspan="3">신고날짜</th>
	                                                    <th colspan="2">상태</th>
	                                                </tr>
	                                            </thead>
	                                            <tbody>
	                                            	<c:forEach var="item" items="${fakeList}">
		                                                <tr>
		                                                    <th scope="row" colspan="2" id="fakeNo">${item.fakeNo}</th>
		                                                    <td colspan="4" id="fakeCompName">${item.compName}</td>
		                                                    <td colspan="2" id="fakeItemNo">${item.itemNo}</td>
		                                                    <td colspan="7" id="fakeContent">
		                                                    	<!-- Button trigger modal -->
							        							<a class="modalBtn"  href="/fake/listOne/${item.fakeNo}">
							        								<button class="btn btn-secondary" data-toggle="modal" data-target="#exampleModalCarousel">
							        									${item.fakeContent}
		                                                    		</button>
		                                                    	</a>
		                                                    </td>
		                                                    <td colspan="3"><fmt:formatDate value="${item.registDate}" pattern="yyyy-MM-dd"/></td>
		                                                    <td colspan="2">
		                                                    	<c:if test="${item.useAt eq 'N' || item.useAt eq 'I'}"> <!-- null/I -->
		                                                    		<a href="/fake/update${item.itemNo}" class="btn btn-warning btn-sm">
		                                                    			<i class="bi bi-brush"></i>
		                                                    		</a>
		                                                    	</c:if>
		                                                    	<c:if test="${item.useAt ne 'N' && item.useAt ne 'I'}"> <!-- P/F -->
		                                                    		<a href="/fake/update${item.itemNo}" class="btn btn-light btn-sm">
		                                                    			<i class="bi bi-brush"></i>
		                                                    		</a>
		                                                    	</c:if>		                                                    	
		                                                    </td>
		                                                </tr>
		                                            </c:forEach>
		                                            <c:if test="${list.size() < 1}">
														<tr>
															<td colspan="5">검색 된 내역이 없습니다.</td>
														</tr>
													</c:if>
	                                            </tbody>
	                                            
	                                            <tfoot>
													<tr>
														<td colspan="20">
															<ul class="pagination justify-content-center mt-3">
																<li class="page-item"><a class="page-link" href="?page=1&${pager.query}">처음</a></li>
																<li class="page-item"><a class="page-link" href="?page=${pager.prev}${pager.query}">이전</a></li>
																<c:forEach var="page" items="${pager.list}">
																	<li class="page-item"><a class="page-link ${page == pager.page ? 'active' : ''}" href="?page=${page}${pager.query}">${page}</a></li>
																</c:forEach>
																<li class="page-item"><a class="page-link" href="?page=${pager.next}${pager.query}">다음</a></li>
																<li class="page-item"><a class="page-link" href="?page=${pager.last}${pager.query}">마지막</a></li>
															</ul>
														</td>
													</tr>
												</tfoot>	                                            
	                                        </table>
	                                    </div>
	                                </div>
       
	                            </div>
	                        </div>
	                    </section>
	                </div>
	            </div>
	            <!-- /Row -->
	        </div>
	        <!-- /Container -->
	        <!-- Footer -->
	        <div class="hk-footer-wrap container">
	            <footer class="footer">
	                <div class="row">
	                    <div class="col-md-6 col-sm-12">
	                        <p>Pampered by<a href="BBGG-a.site" class="text-dark" target="_blank">BBGG</a> © 2023</p>
	                    </div>
	                    <div class="col-md-6 col-sm-12">
	                        <p class="d-inline-block">Follow us</p>
	                        <a href="#" class="d-inline-block btn btn-icon btn-icon-only btn-indigo btn-icon-style-4"><span class="btn-icon-wrap"><i class="fa fa-facebook"></i></span></a>
	                        <a href="#" class="d-inline-block btn btn-icon btn-icon-only btn-indigo btn-icon-style-4"><span class="btn-icon-wrap"><i class="fa fa-twitter"></i></span></a>
	                        <a href="#" class="d-inline-block btn btn-icon btn-icon-only btn-indigo btn-icon-style-4"><span class="btn-icon-wrap"><i class="fa fa-google-plus"></i></span></a>
	                    </div>
	                </div>
	            </footer>
	        </div>
	        <!-- /Footer --> 
		</div>
		<!-- /Main Content -->
	</div>
            
       
    <!-- jQuery -->
    <script src="/resources/vendors/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendors/popper.js/dist/umd/popper.min.js"></script>
    <script src="/resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Slimscroll JavaScript -->
    <script src="/resources/dist/js/jquery.slimscroll.js"></script>

    <!-- FeatherIcons JavaScript -->
    <script src="/resources/dist/js/feather.min.js"></script>

    <!-- Fancy Dropdown JS -->
    <script src="/resources/dist/js/dropdown-bootstrap-extended.js"></script>

    <!-- Bootstrap-table JavaScript -->
    <script src="/resources/vendors/bootstrap-table/dist/bootstrap-table.min.js"></script>
    <script src="/resources/dist/js/bootstrap-table-data.js"></script>

    <!-- Peity JavaScript -->
    <script src="/resources/vendors/peity/jquery.peity.min.js"></script>
    <script src="/resources/dist/js/peity-data.js"></script>

    <!-- Toggles JavaScript -->
    <script src="/resources/vendors/jquery-toggles/toggles.min.js"></script>
    <script src="/resources/dist/js/toggle-data.js"></script>

    <!-- Init JavaScript -->
    <script src="/resources/dist/js/init.js"></script>
    
    <script>
	 $('.modalBtn').on('click', function(e){
		  e.preventDefault();
		  $('.modal').modal('show').find('.modal-content').load($(this).attr('href'));
		});
	</script>
    
<jsp:include page="../footer.jsp"></jsp:include>
<jsp:include page="../js.jsp"></jsp:include>
</body>
</html>