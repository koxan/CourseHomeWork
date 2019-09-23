package org.itstep;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HomeController. Method get");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/home.jsp");

        req.setAttribute("title", "Home page");
        List<String> data = new ArrayList<>();
        data.add("first");
        data.add("second");
        data.add("third");

        req.setAttribute("data", data);

        dispatcher.forward(req, resp);
    }
}
