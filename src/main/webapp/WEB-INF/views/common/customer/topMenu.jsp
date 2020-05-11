<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<div id="header">
	<div class="container">
		<div id="welcomeLine" class="row">
			<div class="span6">
				<i class="icon-user"></i><strong>
					${currentAccount.name}</strong>
			</div>
			<div class="span6">
				<div class="pull-right">
					<a href="${pageContext.request.contextPath}/cart"><span
						class="btn btn-mini btn-primary"><i
							class="icon-shopping-cart icon-white"></i> Cart </span> </a>
							<c:if test="${currentAccount == null}">
							 <a
						href="${pageContext.request.contextPath}/login"><span
						class="btn btn-mini btn-primary"><i
							class="icon-user icon-white"></i> LogIn </span> </a>
							</c:if>
							<c:if test="${currentAccount != null}">
							 <a
						href="${pageContext.request.contextPath}/logout"><span
						class="btn btn-mini btn-primary"><i
							class="icon-user icon-white"></i> LogOut </span> </a>
							</c:if>
				</div>
			</div>
		</div>
		<!-- Navbar ================================================== -->
		<div id="logoArea" class="navbar">
			<a id="smallScreen" data-target="#topMenu" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="navbar-inner">
				<a class="brand" href="index.html">Shop24hDungDao</a>
				<ul id="topMenu" class="nav pull-right">
					<li class=""><a href="${pageContext.request.contextPath}/home">Home</a></li>
					<li class=""><a
						href="${pageContext.request.contextPath}/listProduct">Category</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- Header End====================================================================== -->
</html>