<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>

<h1>Login de Usuario</h1>
<div>
    <form action="/ManejoDeSesiones/login" method="post">
        <div>
            <label for="username">Nombre de Usuario:</label>
            <div>
                <input type="text" name="username" id="username">
            </div>
        </div>

        <div>
            <label for="password">Password: </label>
            <div>
                <input type="password" name="password" id="pass">
            </div>
        </div>
        <div>
            <input type="submit" value="Enviar">
        </div>

    </form>
</div>

</body>
</html>
