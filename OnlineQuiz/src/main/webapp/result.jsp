<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dao.QuizDAO" %>
<%@ page import="model.User" %>
<%
    User user = (User) session.getAttribute("user");
    int score = (int) request.getAttribute("score");
    int quizId = (int) request.getAttribute("quizId");

    QuizDAO.saveResult(user.getId(), quizId, score);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
<h2>Quiz Results</h2>
    <p>User: <%= user.getUsername() %></p>
    <p>Score: <%= score %></p>
    <a href="index.jsp">Go to Home</a>
</body>
</html>