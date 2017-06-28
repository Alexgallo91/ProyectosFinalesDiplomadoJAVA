
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PUESTOS</title>
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
           
            try
            {
                miConexion = con.obtenerConexion();
                out.println("<h1>LISTA PUESTOS</h1>");
                query = miConexion.createStatement();
                llenarTabla = "select * from jobs;";
                miTabla = query.executeQuery(llenarTabla);
                
                //ENLACES REGRESAR Y PRINCIPAL
                out.println("<div id=\"a\">");
                out.println("<h2><a href=\"paginaBienvenida.jsp\">Principal</a></h2>");
                out.println("</div>");
                
                //creamos la tabla
                out.println("<center>");
                out.println("<table id=\"tablaEmpleados\">");
                
                out.println("<tr>");
                out.println("<th>Puesto</th>");
                out.println("<th>Salario Minimo</th>");
                out.println("<th>Salario Maximo</th>");
                out.println("</tr>");
  
                while(miTabla.next())
                { 
                    contadorRegistros++;
                    //creamos los inputs y llenamos la tabla
                    out.println("<tr>");

                    //puesto
                    out.println("<td>");
                    out.println("<a href=\"empleadosPorPuestos.jsp?idPuesto=" 
                              + miTabla.getString("job_id") 
                              + "&nombrePuesto="+miTabla.getString("job_title")
                              +"\">"+ miTabla.getString("job_title") + "</a>");
                    out.println("</td>");

                    //salario minimo
                    out.println("<td>");
                    out.println(miTabla.getString("min_salary"));
                    out.println("</td>");
                    
                    //salario maximo
                    out.println("<td>");
                    out.println(miTabla.getString("max_salary"));
                    out.println("</td>");
                }
                
                out.println("</tr>");
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
