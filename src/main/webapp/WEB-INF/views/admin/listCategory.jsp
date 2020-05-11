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
						<h3 class="page-header">Danh Sách Loại Sản Phẩm</h3>
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
								<form class="form-inline ml-auto search-bottom">
									<div class="form-group">
										<input class="form-control" type="text" placeholder="Search"
											aria-label="Search">
									</div>
									<button class="btn btn-outline-white btn-md my-0 ml-sm-2"
										type="submit">Search</button>
									<a type="button"
										href="${pageContext.request.contextPath}/admin/createCategory"
										class="btn btn-primary pull-right">Add</a>
								</form>

								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>Tên loại sản phẩm</th>
												<th colspan="2" class="action-th">Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${allCategory}" var="category">
												<tr class="gradeA">
													<td>${category.name}</td>
													<td><a
														href="${pageContext.request.contextPath}/admin/editCategory/${category.id}"
														class="glyphicon glyphicon-pencil"></a></td>
													<td><a
														href="${pageContext.request.contextPath}/admin/listCategory/delete/${category.id}"
														class="glyphicon glyphicon-trash"></a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
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
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>