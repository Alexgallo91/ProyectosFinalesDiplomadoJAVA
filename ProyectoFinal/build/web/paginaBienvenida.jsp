<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Indice</title>
         <link rel="stylesheet" type="text/css" href="css/hoja1.css">
         <link rel="stylesheet" type="text/css" href="css/indice.css">
    </head>
    <body>
        
        <div id="titulo">
           <h1>BIENVENIDO ${sessionScope.nombre}<!--nombre usuario--></h1>  
        </div>
       
        <ul>
            <li><a href="listaEmpleados.jsp">EMPLEADOS</a></li><br>
            <li><a href="listaDepartamentos.jsp">DEPARTAMENTOS</a></li><br>
            <li><a href="listaPuestos.jsp">PUESTOS</a></li><br>
            <li><a href="listaUbicaciones.jsp">UBICACIONES</a></li><br>
        </ul>
        
    </body>
</html>
