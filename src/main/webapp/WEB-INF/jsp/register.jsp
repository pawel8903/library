<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
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
		<div id="error" class="text-center"><span class="alert alert-info" role="alert">${error}</span></div>
		<form:form action="registerUser" method="post" class="form-signin"
			modelAttribute="userForm">
			<h2 class="h2 mb-3 font-weight-normal text-center">Register</h2>
			<div class="form-group">
				<label class="label label-primary">Firstname</label>
				<form:input path="firstname" class="form-control" />
			</div>
			<div class="form-group">
				<label class="label label-primary">Lastname</label>
				<form:input path="lastname" class="form-control" />
			</div>
			<div class="form-group">
				<label class="label label-primary">Username</label>
				<form:input path="username" class="form-control" />
			</div>
			<div class="form-group">
				<label class="label label-primary">Email</label>
				<form:input type="email" path="email" class="form-control" />
			</div>
			<div class="form-group">
				<label class="label label-primary">Password</label> <input
					type="password" name="password" class="form-control" />
			</div>
			<div class="form-group">
				<label class="label label-primary">Config password</label> <input
					type="password" name="configPassword" class="form-control" />
			</div>
			<div class="text-center">
			<button type="submit" class="btn btn-primary btn-block d-inline">Register</button>
			<a href="${pageContext.request.contextPath}/loginForm" class="d-inline">Cancel</a>
			</div>
		</form:form>
	</section>

</body>

</html>