package com.kox;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/hw8_web", "root", "");
            PreparedStatement isHereUserQuery = conn.prepareStatement("SELECT * FROM user WHERE login = ?");
            isHereUserQuery.setString(1, login);
            ResultSet rs = isHereUserQuery.executeQuery();
            boolean isHereUser = rs.next();
            if (isHereUser) {
                req.setAttribute("login", login);
                RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/itshere.jsp");
                rd.forward(req, resp);
            } else {
                PreparedStatement addUserQuery = conn.prepareStatement("INSERT INTO user VALUES(NULL, ?, ?)");
                addUserQuery.setString(1, login);
                addUserQuery.setString(2, password);
                addUserQuery.execute();

                RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/view.jsp");
                rd.forward(req, resp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
