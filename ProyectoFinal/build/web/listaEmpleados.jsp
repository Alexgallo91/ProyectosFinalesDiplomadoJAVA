<%-- 
    Document   : listaEmpleados
    Created on : 6/09/2016, 05:26:54 PM
    Author     : FSociety90
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EMPLEADO</title>
        <link rel="stylesheet" type="text/css" href="css/tabla.css">
        <link rel="stylesheet" type="text/css" href="css/list.css">
        <link rel="stylesheet" type="text/css" href="css/enlaces.css">
    </head>
    <body>
        
        <%@page import="java.sql.*"%>
        <%@page import="conexion.conexionBD"%>
        
        <% 
           Connection miConexion;
           final String USER = "postgres"; 
           final String PASS = "admin";
           conexionBD con = new conexionBD(USER, PASS);
           Statement query; //objeto statement para llevar acabo instrucciones SQL
           String llenarTabla = ""; 
           ResultSet miTabla; //resultados obtenidos de la sentencia
           int contadorRegistros = 1;

            try
            {
                miConexion = con.obtenerConexion();
                out.println("<h1>LISTA EMPLEADOS</h1>");
                query = miConexion.createStatement();
                llenarTabla = "select * from employees order by last_name;";
                miTabla = query.executeQuery(llenarTabla);
                
                //ENLACES REGRESAR Y PRINCIPAL
                out.println("<div id=\"enlaces\">");
                out.println("<h2><a href=\"paginaBienvenida.jsp\">Principal</a></h2>");
                out.println("</div>");
                
                //creamos la tabla
                out.println("<center>");
                out.println("<table id=\"tablaEmpleados\">");
                
                out.println("<tr>");
                out.println("<th>NOMBRE</th>");
                out.println("<th>FECHA</th>");
                out.println("<th>PUESTO</th>");
                out.println("<th>EMAIL</th>");
                out.println("<th>DEPARTAMENTO</th>");
                out.println("<th></th>");
                out.println("</tr>");
                
                while(miTabla.next())
                {
                    contadorRegistros++;
                    //creamos los inputs y llenamos la tabla
                    out.println("<tr>");

                    //nombre del empleado
                    out.println("<td>");
                    out.println("<a href=\"historialPuestosEmpleado.jsp?id="
                               +miTabla.getString("employee_id")+"&"
                               +"nombre="+miTabla.getString("first_name")+"\">"
                               +miTabla.getString("last_name")
                               +" "+miTabla.getString("first_name")+"</a>");
                    out.println("</td>");

                    //fecha
                    out.println("<td>");
                    out.println(miTabla.getString("hire_date"));
                    out.println("</td>");

                    //Puesto
                    out.println("<td>");
                    out.println(miTabla.getString("job_id"));
                    out.println("</td>");

                    //Email
                    out.println("<td>");
                    out.println(miTabla.getString("email"));
                    out.println("</td>");

                    //Departamento
                    out.println("<td>");
                    out.println(miTabla.getString("department_id"));
                    out.println("</td>");

                    out.println("<td>");
                    out.println("<ul>");
                    out.println("<li><a href=\"AgregarUsuario?id="+miTabla.getString("employee_id")
                               + "\"><img src=\" imagenes/agregar.png \" width=\"50\" "
                               + "height=\"50\"  ></a></li>");
                    
                    out.println("<li><a href=\"EditarEmpleado?id="+miTabla.getString("employee_id")
                               + "\"><img src=\" imagenes/editar.png \" width=\"50\" "
                               + "height=\"50\"  ></a></li>");
                    
                    out.println("<li><a href=\"eliminarEmpleado?id="+miTabla.getString("employee_id")
                               + "\"><img src=\" imagenes/eliminar.png \" width=\"50\" "
                               + "height=\"50\"  ></a></li>");
                    out.println("</ul>");
                    out.println("</tr>");
                }
                
                miConexion.close();
            }
            catch(ClassNotFoundException e)
            {
                out.println("<h1>"+e.getMessage()+"</h1>");
            }
            catch(SQLException e)
            {
                out.println("<h1>"+e.getMessage()+"</h1>");
            }
                //fin del form
                //fin de la tabla
                out.println("</table>");
                out.println("<center>");
        %>
    </body>
</html>
