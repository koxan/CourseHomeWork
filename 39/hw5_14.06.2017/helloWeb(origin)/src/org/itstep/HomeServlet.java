package org.itstep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        PrintWriter writer = resp.getWriter();

        writer.println("<!doctype html>" +
                "<html>" +
                "<head>" +
                "<title>Student list</title>" +
                "<meta character='utf-8'/>" +
                "<style>" +
                "table {border-collapse:collapse}" +
                "table tr:first-child {background:gray;color:white;text-align:center}" +
                "td {border:1px solid black; padding:3px}" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<h1>Student list:</h1>");

        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/hw5_web", "root", "");
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM student");
            ResultSetMetaData rsMeta = rs.getMetaData();
            int colCount = rsMeta.getColumnCount();
            writer.println("<table>" +
                    "<tr>");
            for (int i = 1; i <= colCount; i++) {
                writer.println("<td>" +
                        rsMeta.getColumnName(i) +
                        "</td>");
            }
            writer.println("</tr>");
            while (rs.next()) {
                writer.println("<tr>");
                for (int i = 1; i <= colCount; i++) {
                    writer.println("<td>" +
                            rs.getObject(i) +
                            "</td>");
                }
                writer.println("</tr>");

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            resp.sendRedirect("/error");
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                resp.sendRedirect("/error");
            }
        }

        writer.println("</table>" +
                "<p><a href='/addStudent'>Add Student</a></p>" +
                "</body>" +
                "</html>");
    }
}
