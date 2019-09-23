package org.itstep.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/*",
          filterName = "EncodingFilter",
          initParams = {
            @WebInitParam(name = "foo", value = "Hello WebFilter")
          })
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Фильтер EncodingFilter инициализирован");
        String foo = filterConfig.getInitParameter("foo");
        System.out.println("foo = " + foo);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        httpServletRequest.setCharacterEncoding("utf-8");

        httpServletRequest.setAttribute("attr", "Привет от фильтра");

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setContentType("text/html");
        httpServletRequest.setCharacterEncoding("utf-8");

        System.out.println("Предфильтр");
        chain.doFilter(request, response);
        System.out.println("Постфильтр");
    }

    @Override
    public void destroy() {
        System.out.println("Фильтер EncodingFilter разрушен");
    }
}
