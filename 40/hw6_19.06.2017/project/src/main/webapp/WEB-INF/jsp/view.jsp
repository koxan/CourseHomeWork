<%@ page import="com.va.Link" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homework</title>
    <link rel="stylesheet" href="../../static/style.css">
    <%--<link href="${pageContext.request.contextPath}/static/style.css" rel="stylesheet" >--%>
    <%--<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/style.css"/>--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />--%>
    <%--<style>--%>
    <%--<%@include file="style.css"%>--%>
    <%--</style>--%>
</head>
<body>
<h1>Записная книга:</h1>
<p><img src="../../static/cat.jpeg" alt="cat" width="200px"></p>
<p>кот для примера добавления ресурса в jsp с перенаправлением из сервлета</p>
<table class="main">
    <%
        Object maybeBook = request.getAttribute("book");
        List<Link> book = null;
        if (maybeBook != null && maybeBook instanceof List<?>) {
            book = (List<Link>) maybeBook;
        }
        if (book != null) {%>
    <tr>
        <td>id</td>
        <td>имя</td>
        <td>описание</td>
        <td>ссылка</td>
        <td>создана</td>
    </tr>
            <%for(Link current : book) {
                int id = current.getId();
                String name = current.getName();
                String describe_link = current.getDescribe_link();
                describe_link = (describe_link != null) ? describe_link : "";
                String link = current.getLink();
                Timestamp created = current.getCreated();
    %>
    <tr>
        <td><a href="<%=link%>"><%=id%></a></td>
        <td><a href="<%=link%>"><%=name%></a></td>
        <td><a href="<%=link%>"><%=describe_link%></a></td>
        <td><a href="<%=link%>"><%=link%></a></td>
        <td><a href="<%=link%>"><%=created%></a></td>
    </tr>
    <%}
    }
    %>
</table>

<form method="post" action="/">
    <table>
        <caption>Добавить ссылку:</caption>
        <tr>
            <td>имя:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>описание:</td>
            <%--<td><input type="text" name="describe_link"></td>--%>
            <td><textarea name="describe_link" rows="5"></textarea></td>
        </tr>
        <tr>
            <td>ссылка:</td>
            <td><input type="text" name="link" id=""></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
