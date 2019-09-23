package com.kox.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "AddUserServlet", urlPatterns = "/addUser")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String mobile_phone = request.getParameter("mobile_phone");
        String status = request.getParameter("status");

        Object obj = request.getAttribute("connection");
        Connection conn = null;
        if (obj != null && obj instanceof Connection) {
            conn = (Connection) obj;
        }

        if (conn != null) {
            try {
                CallableStatement cs = conn.prepareCall("call create_user(?, ?, ?, ?, ?, ?)");
                cs.setString(1, name);
                cs.setString(2, phone);
                cs.setString(3, mobile_phone);
                cs.setString(4, status);
                cs.setString(5, email);
                cs.execute();
                response.sendRedirect("/");
            } catch (SQLException e) {
                response.getWriter().print("<p style='color: red'>" + e.getMessage() + "</p>");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/addUser.jsp").forward(request, response);
    }
}
