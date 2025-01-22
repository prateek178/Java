package servlet;

import dao.UserDAO;
import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
//@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user input from the registration form
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // Validate input
        if (username == null || username.isEmpty() ||email == null || email.isEmpty() ||password == null || password.isEmpty() ||
            confirmPassword == null || confirmPassword.isEmpty()) {
            response.sendRedirect("register.jsp?error=All fields are required");
            return;
        }

        if (!password.equals(confirmPassword)) {
            response.sendRedirect("register.jsp?error=Passwords do not match");
            return;
        }

        // Create a User object
        User newUser = new User(0, username, email, password);

        // Register the user using UserDAO
        boolean isRegistered = UserDAO.registerUser(newUser);

        if (isRegistered) {
            // Redirect to login page on successful registration
            response.sendRedirect("login.jsp?message=Registration successful! Please log in.");
        } else {
            // Redirect back to registration page on failure
            response.sendRedirect("register.jsp?error=Registration failed. Username or email might already exist.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }
}
