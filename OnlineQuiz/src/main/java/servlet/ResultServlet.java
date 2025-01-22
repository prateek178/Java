package servlet;

import dao.QuizDAO;
import model.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quizId = Integer.parseInt(request.getParameter("quizId"));
        List<Question> questions = QuizDAO.getQuestionsByQuizId(quizId);

        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            String userAnswer = request.getParameter("q" + i);
            if (userAnswer != null && userAnswer.charAt(0) == questions.get(i).getCorrectOption()) {
                score++;
            }
        }

        request.setAttribute("score", score);
        request.setAttribute("quizId", quizId);
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}
