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
			<div id="search-form"><form method="get" action="search">
				<select name="searchBy">
					<option value=""></option>
					<option value="Title">Title</option>
					<option value="Author">Author</option>
					<option value="Description">Description</option>
				</select>
				<input name="searchTerm" value="${searchTerm}"/>
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
		<div id=content>
			<input type="button" value="Add book"
				onclick="window.location.href='showFormForAdd';return false;"
				class="btn btn-primary" id="add-btn" />
			<table class="table table-striped">
				<tr class="table-tr">
					<th>Title</th>
					<th>Author</th>
					<th>Description</th>
					<th>Available number</th>
					<th>Type of book</th>
					<th></th>
				</tr>
				<tbody>
					<c:forEach var="tempBook" items="${books}">
						<c:url var="updateLink" value="/book/showFormForUpdate">
							<c:param name="bookId" value="${tempBook.id}"></c:param>
						</c:url>
						<c:url var="deleteLink" value="/book/delete">
							<c:param name="bookId" value="${tempBook.id}"></c:param>
						</c:url>
						<tr>
							<td>${tempBook.title}</td>
							<td>${tempBook.author}</td>
							<td>${tempBook.description}</td>
							<td>${tempBook.availableNumber}</td>
							<td><c:forEach var="tempType" items="${tempBook.types}">
									<label>${tempType.type},</label>
								</c:forEach></td>
							<td><a href="${updateLink}">Update</a> <a
								href="${deleteLink}"
								onclick="if(!(confirm('Are you sure want to delete this book?'))) return false">Delete</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
</body>




</html>