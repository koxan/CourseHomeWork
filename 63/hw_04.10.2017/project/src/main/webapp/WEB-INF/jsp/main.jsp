<%@ page import="java.util.List" %>
<%@ page import="com.va.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homework</title>
    <style>
        table {
            border-collapse: collapse;
        }

        th {
            background: lightgray;
        }

        td, th {
            border: 1px solid black;
            padding: 5px;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>NAME</th>
        <th>EMAIL</th>
        <th>STATUS</th>
        <th>ACTION</th>
    </tr>
    <%
        Object obj = request.getAttribute("users");
        List<User> users = null;
        if (obj != null && obj instanceof List<?>) {
            users = (List<User>) obj;
        }

        if (users != null) {
            for (User cur : users) {
                String name = cur.getName();
                String email = cur.getEmail();
                String status = cur.getStatus();
    %>
    <tr>
        <td><%=name%></td>
        <td><%=email%></td>
        <td><%=status%></td>
        <td></td>
    </tr>
    <%
            }
        }
    %>
</table>
<a href="/addUser">addUser</a>
</body>
</html>
