<%@ page import="java.time.LocalDate" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>Size: <%= request.getParameter("size") %></p>

<%! int count = 0; %>
<%
    // скриплеты
    // Объявление локальной переменной
    LocalDate date = LocalDate.now();
    count++;
%>

<h1>Сейчас <%= date %>
</h1>
<!-- комментарии -->
<%--Подключение к базе данных:--%>
<%--логин: root--%>
<%--пароль: admin --%>
<ul>
    <%
        PrintWriter o = response.getWriter();
        for (int i = 0; i < 10; i++) {
            out.println("<li>item " + (i + 10) + "</li>");
        } %>

    <% for (int i = 0; i < 10; i++) { %>
    <li>item <%= i + 1 %>
    </li>
    <%}%>
</ul>
<p>Count: <%=count%>
</p>
</body>
</html>
