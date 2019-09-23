package com.kox.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@WebFilter(urlPatterns = {"/", "/addUser"})
public class MainFilter implements Filter {
    private static Properties prop;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext ctx = filterConfig.getServletContext();
        String user = ctx.getInitParameter("mysql.user");
        String password = ctx.getInitParameter("mysql.password");
        String constring = ctx.getInitParameter("mysql.constring");

        prop = new Properties();
        prop.setProperty("user", user);
        prop.setProperty("password", password);
        prop.setProperty("constring", constring);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(prop.getProperty("constring"), prop);
            servletRequest.setAttribute("connection", conn);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (ClassNotFoundException | SQLException e) {
            String error = e.getMessage();
            servletRequest.setAttribute("error", error);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {
    }
}
