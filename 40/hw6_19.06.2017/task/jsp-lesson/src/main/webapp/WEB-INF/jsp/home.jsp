<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= request.getAttribute("title") %>
    </title>
</head>
<body>
<h1><%= request.getAttribute("title") %>
</h1>
<p>Data</p>
<ul>
    <%
        List<String> data = (List<String>) request.getAttribute("data");
        for (String val : data) {
    %>
    <li><%=val%>
    </li>
    <% }%>
</ul>
</body>
</html>
