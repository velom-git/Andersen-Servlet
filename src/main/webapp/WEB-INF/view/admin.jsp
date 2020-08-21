<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Панель администратора</title>
</head>
<body>
<h1>Кого сделать админом?</h1>
<form method="post" action="/change">

    <input type="text" required placeholder="login" name="login"><br>
    <input class="button" type="submit" value="Изменить">

</form>
</body>
</html>
