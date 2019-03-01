<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Welcome page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	
	<section class="container">
		<div id="error" class="text-center">
			<span class="alert alert-info" role="alert">${error}</span>
		</div>
		<form:form class="form-signin" action="userLogin" method="post">

			<h2 class="h2 mb-3 font-weight-normal text-center">Login</h2>
			<div class="form-group">
				<label class="label label-primary">Username/Email</label> <input
					type="text" name="login" class="form-control" />
			</div>
			<div class="form-group">
				<label class="label label-primary">Password</label> <input
					type="password" name="password" class="form-control" />
			</div>
			<div class="text-center controll-btn">
				<button type="submit" class="btn btn-primary btn-block d-inline">Login</button>
				<a href="${pageContext.request.contextPath}/user/registerForm"
					class="d-inline">Register</a>
			</div>
		</form:form>
	</section>

</body>

</html>