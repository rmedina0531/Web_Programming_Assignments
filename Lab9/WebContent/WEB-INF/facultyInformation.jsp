<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ECST Faculty</title>
</head>
<body>

<h3 style="margin-left: 40px;">ECST Faculty</h3>

<p style="margin-left: 40px;"><a href="./AddDepartment">Add Department</a> | <a href="./AddFaculty">Add Faculty</a></p>

<div style="margin-left: 40px;">
<table border="1" cellpadding="2" cellspacing="2">
	<thead>
		<tr>
			<th scope="col">Department</th>
			<th scope="col">Faculty</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${departments}" var="department">
			<tr>
			<td rowspan="${department.size}">${department.name}</td>
			<td>${department.head.name}</td>
			</tr>
				<c:forEach items="${department.tail}" var="faculty">
					<tr>
					<td>${faculty.name}</td>
					</tr>
				</c:forEach>
			<tr>
		</c:forEach>
	</tbody>
		
		
		<!-- 
		<tr>
			<td rowspan="2">Computer Science</td>
			<td>Kang (Chair)</td>
		</tr>
		<tr>
			<td>Sun</td>
		</tr>
		<tr>
			<td>Electrical and Computer Engineering</td>
			<td>Agarwal</td>
		</tr>
		</tbody> -->
</table>

</body>
</html>