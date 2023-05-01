<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- CORE INPUT FOR THE c: stuff -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- OTHER NECCESSARY STUFF -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- BOOTSTRAP WILL GO HERE -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<title>Shelf Contained book list</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-3">
        <div class="container">
            <a class="navbar-brand text-primary" href="#">Shelf Contained</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active text-secondary" href="/books">All Books</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active text-secondary" href="/books/new">Add a Book</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active text-secondary" href="/movies">All Movies</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active text-secondary" href="/movies/new">Add a Movie</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active text-secondary" href="/dashboard">Log Out</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
	<div class="container">
		<h1>Books</h1>
		<table class="table table-primary">
			<thead>
				<tr>
					<th>Name</th>
					<th>Author</th>
					<th>Category</th>
					<th>Already Read</th>
					<th>Posted By</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${allBooks}">
					<tr>
						<td><c:out value="${book.name}" /> </td>
						<td><c:out value="${book.author}" /> </td>
						<td><c:out value="${book.category}" /> </td>
						<%--
							<td>
								<c:out value="${book.readYet}" />
							</td>
						 --%>
						<td>
							<c:choose>
								<c:when test="${oneBook.readYet}">
									Yes
								</c:when>
								<c:otherwise>
									No
								</c:otherwise>
							</c:choose>
						</td>
						<td><c:out value="${book.creator.userName}" />  </td>
						<td>
							<a href="/books/${book.id}">View</a>
							<c:if test ="${user_id == book.creator.id}">
								<a href="/books/${book.id}/edit">Edit</a>
								<a href="/books/${book.id}/delete">Delete</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>