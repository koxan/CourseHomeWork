<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Itshere</title>
</head>
<body>
<h1 style="color:red">Пользователь <span style="text-decoration: underline">"<%=request.getAttribute("login")%>"</span> уже зарегестрирован.</h1>
<a href="/">На главную</a>
</body>
</html>
