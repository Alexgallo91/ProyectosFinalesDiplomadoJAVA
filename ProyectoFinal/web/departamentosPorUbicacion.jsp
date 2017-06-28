<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DEPARTAMENTOS POR UBICACION</title>
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
            conexionBD con = new conexionBD(USER, PASS);
            Statement query; //objeto statement para llevar acabo instrucciones SQL
            String llenarTabla = ""; 
            ResultSet miTabla; //resultados obtenidos de la sentencia
            int contadorRegistros = 1;
            int idUbicacion = Integer.parseInt(request.getParameter("id")); 
           
            //para obtener el nombre del departamento
            String nombreDepartamento = "";
           
            try
            {
                miConexion = con.obtenerConexion();
                out.println("<h1>DEPARTAMENTOS POR UBICACION</h1>");
                out.println("<br>");
                out.println("<h2>Ubicacion seleccionado: "+request.getParameter("ubicacion")
                           +" "+nombreDepartamento+"</h2>");
                out.println("<h2>Id de la ubicacion: "+idUbicacion+"</h2>");
                query = miConexion.createStatement();
                llenarTabla = String.format("select * from departments "
                                          + "where location_id = %d order by location_id;", idUbicacion);   
                           
                miTabla = query.executeQuery(llenarTabla);
                
                //enlaces
                out.println("<div id=\"a\">");
                out.println("<h2><a href=\"paginaBienvenida.jsp\">Principal</a></h2>");
                out.println("<h2><a href=\"listaUbicaciones.jsp\">Regresar</a></h2>");
                out.println("</div>");
                
                //creamos la tabla
                out.println("<center>");
                out.println("<table id=\"tablaEmpleados\">");
                
                out.println("<tr>");
                out.println("<th>NOMBRE DEPARTAMENTO</th>");
                out.println("<th>GERENTE</th>");
                out.println("<th>UBICACION</th>");
                out.println("</tr>");
                
                while(miTabla.next())
                {
                    contadorRegistros++;
                    //creamos los inputs y llenamos la tabla
                    out.println("<tr>");

                    //nombre del empleado
                    out.println("<td>");
                    out.println(miTabla.getString("department_name"));
                    out.println("</td>");

                    //gerente
                    out.println("<td>");
                    out.println(miTabla.getString("manager_id"));
                    out.println("</td>");

                    //ubicacion
                    out.println("<td>");
                    out.println(request.getParameter("ubicacion"));
                    out.println("</td>");
                    
                    out.println("</tr>");
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
