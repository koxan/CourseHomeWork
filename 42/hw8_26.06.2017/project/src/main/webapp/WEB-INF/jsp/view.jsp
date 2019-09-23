<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomeWork</title>
    <link rel="stylesheet" href="static/view/style.css">
</head>
<body>
<h1>View</h1>
<form method="post" action="/">
    <table>
        <tr>
            <td>имя:</td>
            <td><input type="text" required name="login"></td>
        </tr>
        <tr>
            <td>пароль:</td>
            <td><input type="password" required name="password"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="checkbox" name="remember">Запомнить</td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"></td>
        </tr>
    </table>
</form>
<a href="/register">Регистрация</a>
</body>
</html>
