package com.kox.servlet;

import com.va.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MainServlet", urlPatterns = "/")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object obj = request.getAttribute("connection");
        Connection conn = null;
        if (obj != null && obj instanceof Connection) {
            conn = (Connection) obj;
        }

        List<User> users = new ArrayList<>();

        if (conn != null) {
            try {
                CallableStatement cs = conn.prepareCall("call select_users()");
                ResultSet rs = cs.executeQuery();

                while (rs.next()) {
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String status = rs.getString("status");

                    User user = new User(name, email, status);
                    users.add(user);
                }
                request.setAttribute("users", users);
                request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
            } catch (SQLException e) {
                response.getWriter().print("<p style='color: red'>" + e.getMessage() + "</p>");
            }
        } else {
            response.getWriter().print("<p style='color: red'>conn error</p>");
        }
    }
}
