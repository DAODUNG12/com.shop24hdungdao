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
						<h3 class="page-header">Thêm Sản Phẩm</h3>
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
										<form action="${pageContext.request.contextPath}/admin/createProduct"
											method="POST" role="form" enctype="multipart/form-data">
											<div class="form-group">
												<label>Name</label> <input name="name" class="form-control">
											</div>
											<div class="form-group">
												<label>Price</label> <input type="number" name="price"
													class="form-control" placeholder="Price">
											</div>
											<div class="form-group">
												<label>Category</label> <select class="form-control"
													name="category">
													<c:forEach items="${category}" var="cate">
														<option value="${cate.id}">${cate.name}</option>
													</c:forEach>
												</select>
											</div>
											<div class="form-group">
												<label>Quantity</label> <input type="number" name="quantity"
													class="form-control" placeholder="Quantity">
											</div>
											<div class="form-group">
												<label>Detail</label>
												<textarea name="detail" class="form-control" rows="3"></textarea>
											</div>
											<div class="form-group">
												<span class="field-title">Image </span> <input type="file"
													name="image">
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