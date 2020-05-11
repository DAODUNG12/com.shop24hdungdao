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
						<h3 class="page-header">Sửa Hóa Đơn</h3>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">

							<div class="panel-body">
								<div class="row">
									<div class="col-lg-6">
										<form
											action="${pageContext.request.contextPath}/admin/editOrders/${editOrders.id}"
											method="POST" role="form">
											<div class="form-group">
												<label>Ngày Đặt hàng</label> <input readonly
													value="${editOrders.orderDate}" type="datetime" name="date"
													class="form-control">
											</div>
											<div class="form-group">
												<span class="field-title">Status </span> <select
													class="status-select form-control" name="status">
													<c:forEach items="${arrStatus}" var="status">

														<option value="${status.key}"
															<c:if test="${status.key == editOrders.status}">
														selected
														</c:if>>

															${status.value}</option>
													</c:forEach>
												</select>
											</div>
											<div class="form-group">
												<label>Giá Sản phẩm</label> <input readonly
													value="${editOrders.orderTotalPrice}" type="number"
													name="orderTotalPrice" class="form-control" placeholder="Email">
											</div>
											<div class="form-group">
												<label>Địa chỉ nhận sản phẩm</label> <input readonly
													value="${editOrders.address}" class="form-control"
													type="text" name="address">
											</div>
											<div class="form-group">
												<label>Tên</label> <input readonly value="${editOrders.name}"
													class="form-control" type="text" name="name">
											</div>
											<div class="form-group">
												<label>Email</label> <input readonly value="${editOrders.email}"
													class="form-control" type="text" name="email">
											</div>
											<div class="form-group">
												<label>Số điện thoại</label> <input readonly
													value="${editOrders.phone}" class="form-control"
													type="text" name="phone">
											</div>
											<div class="form-group">
												<label">Username </label> <input readonly type="text"
													class="form-control" name="username"
													value="${editOrders.account.username}">
											</div>
											<button type="submit" class="btn btn-primary">Submit</button>
											<button type="reset" class="btn btn-default">Cancel</button>
										</form>
									</div>

								</div>
								<!-- /.row (nested) -->
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