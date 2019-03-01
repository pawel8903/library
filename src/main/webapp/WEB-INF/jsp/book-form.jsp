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
			<a href="${pageContext.request.contextPath}/book/readFileForm">Read File</a>
			<div class="float-right">
				<a href="${pageContext.request.contextPath}/user/loginForm">Login</a>
				<a href="${pageContext.request.contextPath}/user/registerForm">Register</a>
				<a href="#" id="search"><i>fottello</i></a>
			</div>
		</div>
		<div></div>
	</nav>
	<section class="container">
		<div id=content>
			<h1>Save Book</h1>
			<form:form action="saveBook" modelAttribute="book" method="post">
				<form:hidden path="id" />
				<table>
					<tr>
						<td><label>Title:</label></td>
						<td><form:input path="title" /></td>
					</tr>
					<tr>
						<td><label>Author:</label></td>
						<td><form:input path="author" /></td>
					</tr>
					<tr>
						<td><label>Description:</label></td>
						<td><form:input path="description" /></td>
					</tr>
					<tr>
						<td><label>Availeble number:</label></td>
						<td><form:input path="availableNumber" /></td>
					</tr>
					<tr>
						<td><label>Type of book:</label></td>
						<td>
							<ul class="typeList">
								<c:forEach var="tempType" items="${types}">
									<li><input type="checkbox" value="${tempType.type}">${tempType.type}</li>
								</c:forEach>
							</ul>
						</td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="save" /><a
							href="${pageContext.request.contextPath}/book/booksList"
							class="d-inline">cancel</a></td>

					</tr>
				</table>
			</form:form>

		</div>
	</section>
</body>




</html>