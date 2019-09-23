<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookie</title>
</head>
<body>
<%
    Cookie[] cookies = (Cookie[]) request.getAttribute("cookies");
%>
<% for (Cookie c : cookies) { %>
    <div>
        <p><strong>Name:</strong> <%= c.getName()%></p>
        <p><strong>Value:</strong> <%= c.getValue()%></p>
        <p><strong>MaxAge:</strong> <%= c.getMaxAge()%></p>
        <p><strong>Path:</strong> <%= c.getPath()%></p>
    </div>
<%}%>
</body>
</html>
