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
	<jsp:include page="../common/customer/slideHome.jsp"></jsp:include>
	<div id="mainBody">
		<div class="container">
			<div class="row">
				<div class="span12">
					<div>
						<form class="form-inline pull-right"
							action="${pageContext.request.contextPath}/home" method="GET">
							<input  name = "search" class="srchTxt" type="text" />
							<button type="submit" id="submitButton" class="btn btn-primary">Search</button>
						</form>
					</div>
					<h4>Latest Products</h4>
					<ul class="thumbnails">
						<c:forEach items="${allProduct}" var="product">
							<li class="span3">
								<div class="thumbnail">
									<a><img
										src="${pageContext.request.contextPath}/images/${product.image}"
										alt="" /></a>
									<div class="caption">
										<h5>${product.name}</h5>
										<p>${product.detail}</p>
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
				<div class="content-pagination pull-right">
					<ul class="pagination">
						<li><c:if test="${back > -1}">
								<c:if test="${search == null || search.equals('')}">
									<a class="pagination-a"
										href="${pageContext.request.contextPath}/home/${back}">Back</a>
								</c:if>
								<c:if test="${search != null && !search.equals('')}">
									<a class="pagination-a"
										href="${pageContext.request.contextPath}/home/${back}?search=${search}">Back</a>
								</c:if>
							</c:if> <c:if test="${back == -1}">
								<a class="pagination-a">Back</a>
							</c:if> <c:forEach begin="1" end="${totalPage}" varStatus="status">
								<c:if test="${search == null || search.equals('')}">

									<a class="pagination-a"
										href="${pageContext.request.contextPath}/home/${status.count}"
										<c:if test="${currenPage == status.count}">
															 style="background: #b5b5ca;"
															 </c:if>>${status.count}
									</a>

								</c:if>
								<c:if test="${search != null && !search.equals('')}">
									<a class="pagination-a"
										href="${pageContext.request.contextPath}/home/${status.count}?search=${search}"
										<c:if test="${currenPage == status.count}">
															 style="background: #b5b5ca;"
															 </c:if>>${status.count}</a>
								</c:if>
							</c:forEach> <c:if test="${next > -1}">
								<c:if test="${search == null || search.equals('')}">
									<a class="pagination-a"
										href="${pageContext.request.contextPath}/home/${next}">Next</a>
								</c:if>
								<c:if test="${search != null && !search.equals('')}">
									<a class="pagination-a"
										href="${pageContext.request.contextPath}/home/${next}?search=${search}">Next</a>
								</c:if>
							</c:if> <c:if test="${next == -1}">
								<a class="pagination-a">Next</a>
							</c:if></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../common/customer/footer.jsp"></jsp:include>
</body>
</html>