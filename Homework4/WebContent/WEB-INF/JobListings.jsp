<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Job Listings</title>
</head>
<body>
<h1>JOBS AVAILABLE</h1>
<table border="1">
<tr>
	<th>ID</th><th>JobTitle</th><th>Category</th><th>Location</th><th>Preferred Qualifications</th><th>Operation</th>
</tr>
<c:forEach items="${jobList}" var="job">
	<tr>
		<td>${job.jobID}</td>
		<td>${job.jobTitle}</td>
		<td>${job.category}</td>
		<td>${job.location}</td>
		<td>${job.qualificationsString}</td>
		<td><a href="./EditJob?jobID=${job.jobID}">Edit</a></td>
</c:forEach>

</table>
<a href="./AddJob">Add Job</a><br>

</body>
</html>