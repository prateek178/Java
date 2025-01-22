<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
<%@ page import="dao.QuizDAO" %>
<%@ page import="model.Quiz" %>
<%
    List<Quiz> quizzes = QuizDAO.getAllQuizzes();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Quiz</title>
</head>
<body>
<h2>Select a Quiz</h2>
    <ul>
        <% for (Quiz quiz : quizzes) { %>
        <li>
            <a href="quiz.jsp?quizId=<%= quiz.getId() %>"><%= quiz.getName() %></a>
        </li>
        <% } %>
    </ul>
</body>
</html>