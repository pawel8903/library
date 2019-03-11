<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
			<div id="search-form"><form method="get" action="search" >
				<select name="searchBy">
					<option value=""></option>
					<option value="Title">Title</option>
					<option value="Author">Author</option>
					<option value="Description">Description</option>
				</select> <input name="searchTerm" value="${searchTerm}" />
				<button type="submit">fottello</button>
			</form></div>
			<div class="float-right">
				<a href="${pageContext.request.contextPath}/user/loginForm">Login</a>
				<a href="${pageContext.request.contextPath}/user/registerForm">Register</a>
			</div>
		</div>
		<div></div>
	</nav>
	<section class="container">
		<div id=content class="section-group row">
			<form:form method="post" enctype="multipart/form-data" action="file">
				<div>
					<input type="file" name="filename" class="btn btn-primary " />
					<button type="submit" value="upload" class="btn btn-primary ">Upload</button>
				</div>
			</form:form>
		</div>
	</section>
</body>




</html>