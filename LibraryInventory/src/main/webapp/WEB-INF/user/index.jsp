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
<title>Insert title here</title>
</head>
<body>
	<div class ="container">
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
	                        <a class="nav-link active text-secondary" href="/dashboard">Dashboard</a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link active text-secondary" href="/dashboard">Log Out</a>
	                    </li>
	                </ul>
	            </div>
	        </div>
	    </nav>
		<h1>Login and Reg</h1>
		<form:form action="/register" method="POST" modelAttribute="newUser" >
			<p>
				Username:
				<form:input type="text" path="userName"/>
				<form:errors path="userName" />
			</p>
			<p>
				Email:
				<form:input type="email" path="email"/>
				<form:errors path="email" />
			</p>
			<p>
				Password:
				<form:input type="password" path="password"/>
				<form:errors path="password" />
			</p>
			<p>
				Confirm Password:
				<form:input type="password" path="confirm"/>
				<form:errors path="confirm" />
			</p>
			<button>Register</button>
		</form:form>
		<hr />
		<form:form action="/login" method="POST" modelAttribute="newLogin" >
			<p>
				Email:
				<form:input type="email" path="email"/>
				<form:errors path="email" />
			</p>
			<p>
				Password:
				<form:input type="password" path="password"/>
				<form:errors path="password" />
			</p>
			<button>Login</button>
		</form:form>
		
		
	</div>
</body>
</html>