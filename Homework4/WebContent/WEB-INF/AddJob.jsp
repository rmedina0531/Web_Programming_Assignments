<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Job</title>
</head>
<body>

<form method="post" action="./AddJob" >
	<table border="1" cellpadding="2" cellspacing="2" style="text-align:left">
	<tbody>
		<tr>
			<th>Job Title</th>
			<td><input name="title" size="60" /></td>
		</tr>
		<tr>
			<th>Category</th>
			<td><select name="category"><option>Software Development</option><option>System Administration</option></select></td>
		</tr>
		<tr>
			<th>Location</th>
			<td><input name="location" size="60" /></td>
		</tr>
		<tr>
			<th>Preferred Qualifications</th>
			<td>
				<input name="qualifications" type="checkbox" value="Java" /> Java 
				<input name="qualifications" type="checkbox" value="Python" /> Python 
				<input name="qualifications" type="checkbox" value="MySQL" /> MySQL 
				<input name="qualifications" type="checkbox" value="Oracle" /> Oracle 
				<input name="qualifications" type="checkbox" value="Azure" /> Azure 
				<input name="qualifications" type="checkbox" value="AWS" /> AWS
			</td>
		</tr>
		<tr>
			<td colspan="2" rowspan="1"><input name="post" type="submit" value="Post" /></td>
		</tr>
	</tbody>
</table>
</form>
</body>
</html>