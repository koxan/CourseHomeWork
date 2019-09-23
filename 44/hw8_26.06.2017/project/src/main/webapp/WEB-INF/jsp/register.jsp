<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="static/register/style.css">
</head>
<body>
<h1>Регистрация:</h1>
<form action="/register" method="post">
    <table>
        <tr>
            <td>Логин:</td>
            <td><input type="text" name="login" required></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="password" required></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"></td>
        </tr>
    </table>
</form>
<a href="/">На главную</a>
</body>
</html>
