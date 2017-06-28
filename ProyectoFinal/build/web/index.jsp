
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link rel="stylesheet" type="text/css" href="css/hoja1.css">
    </head>
    <body>
        
        <section id="login">
            <h1 id="titulo">LOGIN SITIO </h1>

            <form action="verificacionUsuario" method="post" id="miForm">
            <input type="text" name="usuario" placeholder="Ingresa tu usuario"><br>
            <input type="password" name="password" placeholder="Ingresa tu contraseña"><br><br>
            <center><input type="submit" name="ingresar" value="INGRESAR"></center>
            </form>

        </section>
    </body>
</html>
