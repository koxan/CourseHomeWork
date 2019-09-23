package org.itstep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf8");
        resp.setContentType("text/html; charset=utf-8");
        resp.setHeader("myheader", "some data");

        PrintWriter out = resp.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Подключеник к базе данных");

            System.out.println("Выгрузка данных о студентах");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        out.println("<!doctype html>" +
                "<html>" +
                "<head>" +
                    "<title>Student list</title>" +
                    "<meta character='utf-8'/>" +
                "</head>" +
                "<body>" +
                "<h1>Student list</h1>" +
                "<p><a href='/students'>Students</a></p>" +
                "</body>" +
                "</html>" +
                "");
    }
}
