<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная</title>
</head>
<body>
<h1>Hello <%= request.getParameter("login") %></h1><br>
<a href="/logout">Выйти</a>
</body>
</html>
