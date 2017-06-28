<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HISTORIAL DE PUESTO POR EMPLEADO</title>
        <link rel="stylesheet" type="text/css" href="css/tabla.css">
        <link rel="stylesheet" type="text/css" href="css/list.css">
    </head>
    <body>
        
        <%@page import="java.sql.*"%>
        <%@page import="conexion.conexionBD"%>
        
        <% 
           Connection miConexion;
           final String USER = "postgres"; 
           final String PASS = "admin";
           final String nombreUsuario = request.getParameter("nombre");
           final String idEmpleado = request.getParameter("id");
           conexionBD con = new conexionBD(USER, PASS);
           Statement query; //objeto statement para llevar acabo instrucciones SQL
           String llenarTabla = ""; 
           ResultSet miTabla; //resultados obtenidos de la sentencia
           int contadorRegistros = 1;

            try
            {
                miConexion = con.obtenerConexion();
                out.println("<h1>HISTORIAL DE PUESTOS</h1>");
                query = miConexion.createStatement();
                llenarTabla = "select * from job_history where employee_id = "+idEmpleado+";";
                miTabla = query.executeQuery(llenarTabla);
        %>
        
        <!--DATOS DEL EMPLEADO-->
        <h2>Historial de puestos</h2>
        <h2>id del emepleado:<%= idEmpleado %></h2>
        <h2>Nombre del empleado: <%=nombreUsuario%></h2>
        
        <%
                //creamos la tabla
                out.println("<center>");
                out.println("<table id=\"tablaEmpleados\">");
                
                out.println("<tr>");
                out.println("<th>Puesto</th>");
                out.println("<th>Fecha inicio</th>");
                out.println("<th>Fecha fin</th>");
                out.println("<th>Departamento</th>");
                out.println("</tr>");
                
                while(miTabla.next())
                {
                    contadorRegistros++;
                    //creamos los inputs y llenamos la tabla
                    out.println("<tr>");

                    //puesto
                    out.println("<td>"+miTabla.getString("job_id")+"</td>");

                    //fecha inicio
                    out.println("<td>"+miTabla.getString("start_date")+"</td>");
                    
                    //fecha fin
                    out.println("<td>"+miTabla.getString("end_date")+"</td>");
                    
                    //departamento
                    out.println("<td>"+miTabla.getString("department_id")+"</td>");
                }               
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
