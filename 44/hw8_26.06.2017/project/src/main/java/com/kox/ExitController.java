package com.kox;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExitController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie current : cookies) {
                if (current.getName().equals("loginCookie") || current.getName().equals("passwordCookie")) {
                    current.setMaxAge(1);
                    current.setValue("");
                    resp.addCookie(current);
                }
            }
        }
        RequestDispatcher rd = req.getRequestDispatcher("/");
        rd.forward(req, resp);
    }
}
