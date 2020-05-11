<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../common/customer/head.jsp"></jsp:include>
<body>
	<jsp:include page="../common/customer/topMenu.jsp"></jsp:include>
	<div id="mainBody">
		<div class="container">
			<div class="row">
				<div class="span12">
					<div>
						<form class="form-inline pull-right"
							action="${pageContext.request.contextPath}/listProduct" method="GET">
							<input  name = "search" class="srchTxt" type="text" />
							<button type="submit" id="submitButton" class="btn btn-primary">Search</button>
						</form>
					</div>
					<h4>Latest Products</h4>
					<ul class="thumbnails">
						<c:forEach items="${allProduct}" var="product">
							<li class="span3">
								<div class="thumbnail">
									<a href="product_details.html"><img
										src="${pageContext.request.contextPath}/images/${product.image}"
										alt="" /></a>
									<div class="caption">
										<h5>
											<span class="name-product">${product.name}</span>
										</h5>
										<p>
											<span class="name-product">${product.detail}</span>
										</p>
										<form
											action="${pageContext.request.contextPath}/add/${product.id}"
											method="POST">
											<h4 style="text-align: center">
												<input id="product-quantity3" name="quantity" type="number"
													value="1" min="1" class="form-control input-sm">
												<button class="btn" type="submit">Add to Cart</button>
												<a class="btn btn-primary">${product.price} VND</a>
											</h4>
										</form>
									</div>
								</div>
							</li>
						</c:forEach>
					</ul>

				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../common/customer/footer.jsp"></jsp:include>
</body>
</html>