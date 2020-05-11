<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<div class="navbar-header">
			<a class="navbar-brand" href="https://www.facebook.com/dunghanam1212">Shop24h.DungDao</a>
		</div>

		<ul class="nav navbar-right navbar-top-links">
			 <li class="dropdown">
					<a href="${pageContext.request.contextPath}/logout">LOGOUT</a>
			</li>	
				<!-- <ul class="dropdown-menu dropdown-user">
					<li><a href="#">Login</a></li>

					<li class="divider"></li>
					<li><a href="#">Logout</a></li>
				</ul></li> -->
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav">
					<li class="sidebar-search"></li>
					<li><a href="${pageContext.request.contextPath}/admin/admin">Home</a>
					</li>
					<li><a href="${pageContext.request.contextPath}/admin/listUser">Quản
							lý tài khoản</a></li>
					<li><a
						href="${pageContext.request.contextPath}/admin/listCategory">Quản
							lý Loại sản phẩm</a></li>
					<li><a
						href="${pageContext.request.contextPath}/admin/listProduct">Quản
							lý Sản phẩm</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/listOrder">Quản lý hóa đơn</a></li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side -->
	</nav>
</body>
</html>