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
						<h3 class="page-header">Danh Sách Tài khoản</h3>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">

							<!-- /.panel-heading -->
							<div class="panel-body">
								<form action="${pageContext.request.contextPath}/admin/listUser"
												method="GET" class="form-inline ml-auto search-bottom">
									<div class="form-group">
										<input class="form-control" type="text" name="search" placeholder="Search"
											aria-label="Search">
									</div>
									<button class="btn btn-outline-white btn-md my-0 ml-sm-2"
										type="submit">Search</button>
								</form>
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>Tài khoản</th>
												<th>Tên</th>
												<th>Địa chỉ</th>
												<th>Tuổi</th>
												<th>Giới tính</th>
												<th>Email</th>
												<th>Loại tài khoản</th>
												<th>Số điện thoại</th>
												<th colspan="2" class="center">Action</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach items="${allUser}" var="user">
											<tr class="gradeA">
												<td>${user.username}</td>
												<td>${user.name}</td>
												<td>${user.address}</td>
												<td>${user.age}</td>
												<td>${user.gender}</td>
												<td>${user.email}</td>
												<td>${user.typeUser}</td>
												<td>${user.phone}</td>
												<td><a href="editProduct.html"
													class="glyphicon glyphicon-pencil"></a></td>
												<td><a class="glyphicon glyphicon-trash"></a></td>
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
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>