package com.codeup.adlister.controllers;

import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.codeup.adlister.dao.DaoFactory.getUsersDao;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TODO: show the registration form
        request.getRequestDispatcher("/register.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO: ensure the submitted information is valid
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User(username,email,password);

        if(username.trim().isEmpty() || email.trim().isEmpty() || password.trim().isEmpty()) {
            response.getWriter().println("Uh oh, one of these fields is empty");
        }
        // TODO: create a new user based off of the submitted information
        // TODO: if a user was successfully created, send them to their profile
        if(getUsersDao().findByUsername(username) == null) {
            Long id = getUsersDao().insert(user);
            System.out.println(id);
            if(id != null){
                request.getSession().setAttribute("user", username);
                response.sendRedirect("/profile");
            }else{
                response.sendRedirect("/login");
            }
        }
    }
}
