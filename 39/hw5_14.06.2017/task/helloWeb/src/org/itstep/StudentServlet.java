package org.itstep;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; character set=utf-8");

        PrintWriter out = resp.getWriter();
        String first_name = req.getParameter("first_name");
        out.println("<!doctype html>" +
                "<html>" +
                "<head>" +
                "<title>Student form</title>" +
                "<meta character='utf-8'/>" +
                "</head>" +
                "<body>" +
                "<h1>Student form</h1>" +
                "<p><a href='/'>Home</a></p>" +
                "<form method=\"post\" action=\"/students\">\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <td>First name:</td>\n" +
                "            <td><input type=\"text\" style=\"width: 100%\" name=\"first_name\" value='" + (first_name != null ? first_name : "") +"'  /></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>Last name:</td>\n" +
                "            <td><input type=\"text\"  style=\"width: 100%\" name=\"last_name\" /></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>Age:</td>\n" +
                "            <td><input type=\"number\"  style=\"width: 100%\" min=\"10\" step=\"0.5\" max=\"85\" name=\"age\" /></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>Gender:</td>\n" +
                "            <td>\n" +
                "                <input type=\"radio\" name=\"gender\" value=\"male\" />\n" +
                "                male\n" +
                "                <input type=\"radio\" name=\"gender\" value=\"female\" />\n" +
                "                female\n" +
                "                <input type=\"radio\" name=\"gender\" value=\"unknown\" checked />\n" +
                "                unknown\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td colspan=\"2\"><input type=\"submit\" style=\"float: right\" /></td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</form>");
        //out.println("<p><strong>QueryString</strong>: " + req.getQueryString() + "</p>");


        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");

        System.out.println("first_name = " + first_name);
        System.out.println("last_name = " + last_name);
        System.out.println("gender = " + gender);
        System.out.println("age = " + age);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Подключеник к базе данных");

            System.out.println("Сохранение данных студента");

            System.out.println("Закрытие соединения");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        doGet(req, resp);

        // перенаправление на главную страницу
        //resp.sendRedirect("/");
    }
}
