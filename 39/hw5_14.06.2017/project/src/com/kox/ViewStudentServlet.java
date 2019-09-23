package com.kox;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class ViewStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Students:</h1>");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hw5_web", "root", "");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");
            ResultSetMetaData rsMeta = rs.getMetaData();
            int colCount = rsMeta.getColumnCount();
            writer.println("<table style='border-collapse:collapse'>" +
                    "<tr style='background:gray'>");
            for (int i = 1; i <= colCount; i++) {
                writer.println("<td style='padding:3px;border: 1px solid black;color:white;text-align:center'>" +
                        rsMeta.getColumnName(i) +
                        "</td>");
            }
            writer.println("</tr>");
            while (rs.next()) {
                writer.println("<tr>");
                for (int i = 1; i <= colCount; i++) {
                    writer.println("<td style='padding:3px;border: 1px solid black'>" +
                            rs.getObject(i) +
                            "</td>");
                }
                writer.println("</tr>");

            }
            writer.println("</table>" +
                    "<p><a href='/addStudent'>Add student</a></p>");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            writer.println("<p style='color:red'>DB's error</p>");
        }
    }
}
