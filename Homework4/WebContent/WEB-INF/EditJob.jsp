<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Job</title>
</head>
<body>
Edit Jobs Page

<form method="post" action="./EditJob" >


<table border="1" cellpadding="2" cellspacing="2" style="text-align:left">
	<tbody>
		<tr>
			<th>Id</th>
			<td>${editJob.jobID}</td>
		</tr>
		<tr>
			<th>Job Title</th>
			<td><input name="title" size="60" value="${editJob.jobTitle}" /></td>
		</tr>
		<tr>
			<th>Category</th>
			<td><select name="category"><option selected="selected">Software Development</option><option>System Administration</option></select></td>
		</tr>
		<tr>
			<th>Location</th>
			<td><input name="location" size="60" value="${editJob.location}" /></td>
		</tr>
		<tr>
			<th>Preferred Qualifications</th>
			<td>  
			   <c:forEach items="${editJob.qualifications}" var="qualification">
				<c:choose> 
					<c:when test="${qualification.required}">
						<input checked="checked" name="qualifications" type="checkbox" 
						value="${qualification.qualification}" /> ${qualification.qualification}
					</c:when>
					<c:otherwise>
						<input name="qualifications" type="checkbox" value="${qualification.qualification}" /> ${qualification.qualification}
					</c:otherwise>
				</c:choose>
			   
			   </c:forEach>
			   
			</td>
		</tr>
		<tr>
			<td colspan="2" rowspan="1"><input name="post" type="submit" value="Save" /></td>
		</tr>
	</tbody>
</table>



</form>
</body>
</html>