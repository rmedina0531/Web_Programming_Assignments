<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Driving Test</title>
</head>
<body>
<h1>Question Number ${index + 1}</h1>
<h2>${questions.get(index).description}</h2>
1. ${questions.get(index).answerA}<br>
2. ${questions.get(index).answerB}<br>
3. ${questions.get(index).answerC}<br>
Correct Answer: ${questions.get(index).correctAnswer}<br><br>
<a href="${prevLink}">prev</a>
<a href="${nextLink}">next</a>
</body>
</html>