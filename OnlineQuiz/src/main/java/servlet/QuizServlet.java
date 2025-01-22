package servlet;

import dao.QuizDAO;
import model.Quiz;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
//@WebServlet("/ResultServlet")
public class QuizServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Quiz> quizzes = QuizDAO.getAllQuizzes();
        request.setAttribute("quizzes", quizzes);
        RequestDispatcher rd = request.getRequestDispatcher("quizSelection.jsp");
        rd.forward(request, response);
    }
}
