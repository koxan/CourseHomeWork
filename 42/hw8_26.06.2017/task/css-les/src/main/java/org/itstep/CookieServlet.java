package org.itstep;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // получить все куки
        Cookie[] cookies = req.getCookies();

        req.setAttribute("cookies", cookies);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/cookie.jsp");
        rd.forward(req, resp);
    }
}
