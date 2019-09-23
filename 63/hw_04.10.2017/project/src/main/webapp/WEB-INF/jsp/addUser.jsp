<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addUser</title>
    <style>
        button {
            width: 100%;
        }
    </style>
</head>
<body>
<form action="/addUser" class="user" method="post" novalidate="novalidate">
    <input name="csrfmiddlewaretoken" value="lQLVeNTlSkFzLmjsxGvI8YtPyipeWDGuap1FaI6rPCqzolSchoTSSmMxGwTvT2t2"
           type="hidden">
    <table>
        <tr>
            <td><label for="id_name">Name</label></td>
            <td><input name="name" maxlength="100" required="" id="id_name"
                       aria-required="true" type="text"></td>
        </tr>
        <tr>
            <td><label for="id_email">E-mail</label></td>
            <td><input name="email" required="" id="id_email" aria-required="true"
                       type="email"></td>
        </tr>
        <tr>
            <td><label for="id_phone">Phone</label></td>
            <td><input name="phone"
                       pattern="\+\s?\d{1,2}\s?\(?\d{3}\)?\s?\d{3}\s?\d{2}\s?\d{2}"
                       maxlength="100" id="id_phone" type="text"></td>
        </tr>
        <tr>
            <td><label for="id_mobile_phone">Mobile phone</label></td>
            <td><input name="mobile_phone"
                       pattern="\+\s?\d{1,2}\s?\(?\d{3}\)?\s?\d{3}\s?\d{2}\s?\d{2}"
                       maxlength="100" id="id_mobile_phone" type="text"></td>
        </tr>
        <tr>
            <td><label for="id_status">Status</label></td>
            <td><select name="status" id="id_status">
                <option value="inactive" selected="selected">Inactive</option>
                <option value="active">Active</option>
            </select></td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit">Create</button></td>
        </tr>
    </table>
</form>
</body>
</html>
