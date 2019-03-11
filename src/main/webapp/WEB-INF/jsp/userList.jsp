<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pl">
<head>
<title>Welcome page</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style2.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<nav>
		<div class="nav-bar">
			<a href="${pageContext.request.contextPath}/user/usersList">Users</a>
			<a href="${pageContext.request.contextPath}/book/booksList">Books</a>
			<a href="${pageContext.request.contextPath}/book/readFileForm">Read
				File</a>
			<div class="float-right">
				<a href="${pageContext.request.contextPath}/user/loginForm">Login</a>
				<a href="${pageContext.request.contextPath}/user/registerForm">Register</a>
				<a href="#" id="search"><i>fottello</i></a>
			</div>
		</div>
		<div></div>
	</nav>
	<section class="container" style="margin-top:20px;">
		<div id=content>
			<table class="table table-striped">
				<tr class="table-tr">
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Username</th>
					<th>Email</th>
					<th>Password</th>
					<th></th>
				</tr>
				<tbody>
					<c:forEach var="tempUser" items="${users}">
						<c:url var="deleteLink" value="/user/delete">
							<c:param name="userId" value="${tempUser.id}"></c:param>
						</c:url>
						<tr>
							<td>${tempUser.firstname}</td>
							<td>${tempUser.lastname}</td>
							<td>${tempUser.username}</td>
							<td>${tempUser.email}</td>
							<td>${tempUser.password}</td>
							<td><a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure want to delete this book?'))) return false">Delete</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
</body>




</html>