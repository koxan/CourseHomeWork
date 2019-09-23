package com.kox;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HomeController");

        List<>
        req.setAttribute("test", "test");

        RequestDispatcher rd = req.getRequestDispatcher("/view.jsp");
        rd.forward(req, resp);
    }
}
