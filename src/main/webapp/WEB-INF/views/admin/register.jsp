<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop24hDungDao</title>

<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/admin/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="${pageContext.request.contextPath}/admin/css/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/admin/css/startmin.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/admin/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/admin/css/custom.css"
	rel="stylesheet" type="text/css">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h6 class="register-Notification">${message}</h6>
						<h2 class="panel-title">REGISTER</h2>
					</div>
					<div class="panel-body">
						<form action="register" method="POST" class="form-horizontal"
							role="form">
							<div class="form-group">
								<label for="firstName" class="col-sm-2 control-label">UserName</label>
								<div class="col-sm-10">
									<input type="text" name="username" id="firstName"
										placeholder="UserName" class="form-control" autofocus>
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-sm-2 control-label">Pass*</label>
								<div class="col-sm-10">
									<input type="password" name="password" id="password"
										placeholder="Pass" class="form-control" autofocus>
								</div>
							</div>

							<div class="form-group">
								<label for="type_user" class="col-sm-2 control-label">TypeUser</label>
								<div class="col-sm-10">
									<input type="text" name="type_user" id="type_user"
										placeholder="Type_User" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label for="name" class="col-sm-2 control-label">Name </label>
								<div class="col-sm-10">
									<input type="name" name="name" id="name" placeholder="Name"
										class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label for="email" class="col-sm-2 control-label">Email
								</label>
								<div class="col-sm-10">
									<input type="email" name="email" id="email" placeholder="Email"
										class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-sm-2 control-label">Address</label>
								<div class="col-sm-10">
									<input type="text" name="address" placeholder="address"
										class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label for="birthDate" class="col-sm-2 control-label">Age</label>
								<div class="col-sm-10">
									<input type="number" name="age" id="age" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label for="phoneNumber" class="col-sm-2 control-label">Phone</label>
								<div class="col-sm-10">
									<input type="text" name="phone" id="phoneNumber"
										placeholder="Phone" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">Gender</label>
								<div class="col-sm-10">
									<div class="row">
										<div class="col-sm-4">
											<label class="radio-inline"> <input type="radio"
												name="nam" value="Nam">Nam
											</label>
										</div>
										<div class="col-sm-4">
											<label class="radio-inline"> <input type="radio"
												value="Nữ">Nữ
											</label>
										</div>
									</div>
								</div>
							</div>
							<!-- /.form-group -->
							<div class="action-register">
								<button type="submit" class="btn btn-primary">Register</button>
							</div>
						</form>
						<!-- /form -->
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/admin/js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/admin/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="${pageContext.request.contextPath}/admin/js/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${pageContext.request.contextPath}/admin/js/startmin.js"></script>

</body>
</html>
