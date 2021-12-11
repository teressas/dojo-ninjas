<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>New Dojo</title>
</head>
<body>
	<div class="container mt-5">
		<h1>New Dojo</h1>
		<form:form action="/dojos/new" method="post" modelAttribute="newDojo" class="form">
			<form:label path="name" class="form-label">Name:</form:label>
			<form:errors path="name" class="text-danger" />
			<form:input path="name" type="text" class="form-control" />

			<button class="btn btn-primary">Create</button>
		</form:form>
	</div>
</body>
</html>