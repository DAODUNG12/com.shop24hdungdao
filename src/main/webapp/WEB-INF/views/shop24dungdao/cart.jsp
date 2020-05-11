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
					<h3>SHOPPING CART</h3>
					<hr class="soft" />
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Image</th>
								<th>Detail</th>
								<th>Name</th>
								<th>Quantity</th>
								<th>Price</th>
								<th>Total</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="cart" items="${sessionScope.listCart}">
								<tr>
									<td><img width="60"
										src="${pageContext.request.contextPath}/images/${cart.product.image}"
										alt="" /></td>
									<td><span>${cart.product.detail}</span></td>
									<td>${cart.product.name}</td>
									<td>${cart.quantity}</td>
									<td><strong>${cart.product.price}<span>
												VND</span></strong></td>
									<td><strong>${cart.quantity * cart.product.price}<span>
												VND</span></strong></td>
												<td class="del-goods-col"><a 
												class="glyphicon glyphicon-trash" href="${pageContext.request.contextPath}/delete/${cart.product.id}">Delete</a>
											</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div>
						<ul>
							<li class="pull-right"><Strong>Total Price:</Strong> <strong
								class="price">${totalPrice}<span> VND</span></strong></li>
						</ul>
					</div>
					<a href="${pageContext.request.contextPath}/home"
						class="btn btn-large"><i class="icon-arrow-left"></i> Continue
						Shopping </a>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../common/customer/footer.jsp"></jsp:include>
</body>
</html>