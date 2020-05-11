<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="../common/head.jsp"></jsp:include>
<body>
	<div id="wrapper">
		<jsp:include page="../common/lefmenu.jsp"></jsp:include>
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h3 class="page-header">Danh Sách Sản Phẩm</h3>
						<span class="message-delete">${message}</span>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">

							<!-- /.panel-heading -->
							<div class="panel-body">
								<form
									action="${pageContext.request.contextPath}/admin/listProduct"
									method="GET" class="form-inline ml-auto search-bottom">
									<div class="form-group">
										<input name="search" class="form-control" type="text"
											placeholder="Search" aria-label="Search">
									</div>
									<button class="btn btn-outline-white btn-md my-0 ml-sm-2"
										type="submit">Search</button>
									<a type="button"
										href="${pageContext.request.contextPath}/admin/createProduct"
										class="btn btn-primary pull-right">Add</a>
								</form>
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>Mã sản phẩm</th>
												<th>Tên sản phẩm</th>
												<th>Giá sản phẩm</th>
												<th>Hình ảnh</th>
												<th>Chi tiết</th>
												<th>Số lượng</th>
												<th>Loại sản phẩm</th>
												<th colspan="2" class="center">Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${allProduct}" var="product">
												<tr class="gradeA">
													<td>${product.id}</td>
													<td>${product.name}</td>
													<td>${product.price}VND</td>
													<td class="image-td">
													<img class="img-thumbnail"src="${pageContext.request.contextPath}/images/${product.image}">	
													<td>${product.detail}</td>
													<td>${product.quantity}</td>
													<td>${product.category.name}</td>
													<td><a
														href="${pageContext.request.contextPath}/admin/edit/${product.id}"
														class="glyphicon glyphicon-pencil"></a></td>
													<td><a
														href="${pageContext.request.contextPath}/admin/listProduct/delete/${product.id}/${currenPage}"
														class="glyphicon glyphicon-trash"></a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<div class="content-pagination pull-right">
										<ul class="pagination">
											<li><c:if test="${back > -1}">
													<c:if test="${search == null || search.equals('')}">
														<a class="pagination-a"
															href="${pageContext.request.contextPath}/admin/listProduct/${back}">Back</a>
													</c:if>
													<c:if test="${search != null && !search.equals('')}">
														<a class="pagination-a"
															href="${pageContext.request.contextPath}/admin/listProduct/${back}?search=${search}">Back</a>
													</c:if>
												</c:if> <c:if test="${back == -1}">
													<a class="pagination-a">Back</a>
												</c:if> <c:forEach begin="1" end="${totalPage}" varStatus="status">
													<c:if test="${search == null || search.equals('')}">

														<a class="pagination-a"
															href="${pageContext.request.contextPath}/admin/listProduct/${status.count}"
															<c:if test="${currenPage == status.count}">
															 style="background: #b5b5ca;"
															 </c:if>>${status.count}
														</a>

													</c:if>
													<c:if test="${search != null && !search.equals('')}">
														<a class="pagination-a"
															href="${pageContext.request.contextPath}/admin/listProduct/${status.count}?search=${search}"
															<c:if test="${currenPage == status.count}">
															 style="background: #b5b5ca;"
															 </c:if>>${status.count}</a>
													</c:if>
												</c:forEach> <c:if test="${next > -1}">
													<c:if test="${search == null || search.equals('')}">
														<a class="pagination-a"
															href="${pageContext.request.contextPath}/admin/listProduct/${next}">Next</a>
													</c:if>
													<c:if test="${search != null && !search.equals('')}">
														<a class="pagination-a"
															href="${pageContext.request.contextPath}/admin/listProduct/${next}?search=${search}">Next</a>
													</c:if>
												</c:if> <c:if test="${next == -1}">
													<a class="pagination-a">Next</a>
												</c:if></li>
										</ul>
									</div>
								</div>
							</div>
							<!-- /.panel-body -->
						</div>
						<!-- /.panel -->
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>