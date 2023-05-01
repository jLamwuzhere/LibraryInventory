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
<title>Shelf Contained show</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-3">
        <div class="container">
            <a class="navbar-brand text-primary" href="#">Shelf-Contained</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active text-secondary" href="/books">All books</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active text-secondary" href="/books/new">Add a book</a>
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
	<div class ="container">
		<div class="card" style="width: 60%">
			<h1 class="">Details</h1>
			<div class=" card-body text-bg-primary p-3">
				<h1>
					<u class="pb-4"><c:out value="${oneMovie.movieName}" /></u>
				</h1>
				<h2>
					by:
					<c:out value="${oneMovie.star}" />
				</h2>
				<h2>
					genre:
					<c:out value="${oneMovie.movieCategory}" />
				</h2>
				<h2>
					About:
					<c:out value="${oneMovie.movieDescription}" />
				</h2>
				<h2>
					Already read?
					<c:choose>
						<c:when test="${oneMovie.seenIt}">Yes</c:when>
						<c:otherwise>Not yet</c:otherwise>
					</c:choose>
				</h2>
				<div class="d-flex justify-content-end border-top">
					<h3>
						From
						<strong class="text-black">
							<c:out value="${oneMovie.creator.userName}" />
						</strong>
						's library
					</h3>
				</div>
			</div>
		</div>
	</div>
</body>
</html>