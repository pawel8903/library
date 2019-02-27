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
			<a href="#"><i>fontello</i>Logo</a> <a href="#">Users</a> <a href="#">Books</a>
			<a href="#">Read File</a> <a href="#">More</a> <a href="#"
				id="search" class="float-right"><i>fottello</i></a>
			<div class="section-group row">
				<form:form method="post" enctype="multipart/form-data"
					action="file/">
					<div>
						<input type="file" name="filename" />
						<button type="submit" value="upload">Upload</button>
					</div>
				</form:form>
			</div>
		</div>
		<div>
			
		</div>
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
							class="d-inline">Register</a></td>
						
					</tr>
				</table>
			</form:form>

		</div>
	</section>
</body>




</html>