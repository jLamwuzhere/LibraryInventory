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
<title>Shelf Contained new movie</title>
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
		<h1>Add a movie</h1>
		<form:form method="POST" action="/movies/new" modelAttribute="movieObj" >
			<form:input type="hidden" path="creator" value="${user_id}" />
			<p>
				Name:
				<form:input type="text" path="movieName"/>
				<form:errors path="movieName" />
			</p>
			<p>
				Starring:
				<form:input type="text" path="star"/>
				<form:errors path="star" />
			</p>
			<p>
				Description:
				<form:textarea type="text" path="movieDescription"/>
				<form:errors path="movieDescription" />
			</p>
			<p>
				Category:
				<form:textarea type="text" path="movieCategory"/>
				<form:errors path="movieCategory" />
			</p>
			<p>
				Have you seen this movie yet?:
				<form:checkbox path="seenIt"/>
				<form:errors path="seenIt" />
			</p>
			<button>Add to Shelf</button>
		</form:form>
	</div>
</body>
</html>