package com.kox;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String login = "";
        String password = "";
        boolean isHereLogin = false;
        boolean isHerePassword = false;
        if (cookies != null) {
            for (Cookie current : cookies) {
                if (!isHereLogin && current.getName().equals("loginCookie")) {
                    login = current.getValue();
                    if (login.equals("")) {
                        break;
                    }
                    isHereLogin = true;
                }
                if (!isHerePassword && current.getName().equals("passwordCookie")) {
                    password = current.getValue();
                    if (password.equals("")) {
                        break;
                    }
                    isHerePassword = true;
                }
            }
        }

        if (isHereLogin && isHerePassword) {
            req.setAttribute("isHereCookie", true);
            doPost(req, resp);
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/view.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object maybeBoolean = req.getAttribute("isHereCookie");
        Boolean isHereCookie = false;
        if (maybeBoolean instanceof Boolean) {
            isHereCookie = (Boolean) maybeBoolean;
        }

        String login = "";
        String password = "";

        if (isHereCookie) {
            for (Cookie current : req.getCookies()) {
                if (current.getName().equals("loginCookie")) {
                    login = current.getValue();
                }
                if (current.getName().equals("passwordCookie")) {
                    password = current.getValue();
                }
            }
        } else {
            login = req.getParameter("login");
            password = req.getParameter("password");
        }

        boolean remember = false;
        if (req.getParameter("remember") != null) {
            remember = true;
        }

        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/hw8_web", "root", "");
            PreparedStatement isValidUserQuery = conn.prepareStatement("SELECT * FROM user WHERE login = ? AND password = ?");
            isValidUserQuery.setString(1, login);
            isValidUserQuery.setString(2, password);
            ResultSet rs = isValidUserQuery.executeQuery();
            boolean isValidUser = rs.next();
            RequestDispatcher rd = null;
            if (isValidUser) {
                if (remember) {
                    Cookie loginCookie = new Cookie("loginCookie", login);
                    Cookie passwordCookie = new Cookie("passwordCookie", password);
                    loginCookie.setMaxAge(60 * 60 * 24 * 31);
                    passwordCookie.setMaxAge(60 * 60 * 24 * 31);
                    resp.addCookie(loginCookie);
                    resp.addCookie(passwordCookie);
                }
                rd = req.getRequestDispatcher("/WEB-INF/jsp/secret.jsp");
            } else {
                rd = req.getRequestDispatcher("/WEB-INF/jsp/notValidUser.jsp");
            }
            rd.forward(req, resp);
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
