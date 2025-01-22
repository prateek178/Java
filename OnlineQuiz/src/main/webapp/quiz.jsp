<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="dao.QuizDAO" %>
<%@ page import="model.Question" %>
<%
    int quizId = Integer.parseInt(request.getParameter("quizId"));
    List<Question> questions = QuizDAO.getQuestionsByQuizId(quizId);
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz</title>
</head>
<body>
  <h2>Quiz</h2>
    <form action="ResultServlet" method="post">
        <input type="hidden" name="quizId" value="<%= quizId %>">
        <%
            for (int i = 0; i < questions.size(); i++) {
                Question q = questions.get(i);
        %>
        <div>
            <p><%= (i + 1) + ". " + q.getQuestionText() %></p>
            <label><input type="radio" name="q<%= i %>" value="A"> <%= q.getOptionA() %></label><br>
            <label><input type="radio" name="q<%= i %>" value="B"> <%= q.getOptionB() %></label><br>
            <label><input type="radio" name="q<%= i %>" value="C"> <%= q.getOptionC() %></label><br>
            <label><input type="radio" name="q<%= i %>" value="D"> <%= q.getOptionD() %></label><br>
        </div>
        <%
            }
        %>
        <button type="submit">Submit Quiz</button>
    </form>
</body>
</html>