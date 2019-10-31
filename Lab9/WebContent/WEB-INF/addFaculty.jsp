<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Faculty</title>
</head>
<body>


<form method="post" action="./AddFaculty">
<h3 style="margin-left: 40px;"><a href="./ECSTFaculty">ECST Faculty</a> &gt; Add Faculty</h3>

<table border="1" cellpadding="2" cellspacing="2">
	<tbody>
		<tr>
			<th scope="row">Department</th>
			<td>
			<select name="department">
				<c:forEach items="${departments}" var="department">
					<option>${department.name}</option>
				</c:forEach>
			</select></td>
		</tr>
		<tr>
			<th scope="row">Name</th>
			<td><input name="name" type="text" /></td>
		</tr>
		<tr>
			<th scope="row">Chairperson:</th>
			<td><input name="chairperson" type="checkbox" /></td>
		</tr>
		<tr>
			<td colspan="2" scope="row"><input name="add" type="submit" value="Add" /></td>
		</tr>
	</tbody>
</table>
</form>

</body>
</html>