<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Secret</title>
</head>
<body>
<h1>Это секретная страница</h1>
<p>Привет, <%=request.getParameter("login")%>!</p>
<a href="/">На главную</a>
<br>
<a href="/exit">Выйти из логина</a>
</body>
</html>
