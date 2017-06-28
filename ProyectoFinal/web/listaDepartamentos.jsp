
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DEPARTAMENTOS</title>
        <link rel="stylesheet" type="text/css" href="css/tabla.css">
        <link rel="stylesheet" type="text/css" href="css/list.css">
        
    </head>
    <body>
        
        <%@page import="java.sql.*"%>
        <%@page import="conexion.conexionBD"%>
        
        <% Connection miConexion;
           final String USER = "postgres"; 
           final String PASS = "admin";
           conexionBD con = new conexionBD(USER, PASS);
           Statement query; //objeto statement para llevar acabo instrucciones SQL
           String llenarTabla = ""; 
           ResultSet miTabla; //resultados obtenidos de la sentencia
           int contadorRegistros = 1;
           String claveNombreDepartamento = "";
           int idDepartamento;
        %>
           
        <%
            try
            {
                miConexion = con.obtenerConexion();
                out.println("<h1>LISTA DEPARTAMENTOS</h1>");
                query = miConexion.createStatement();
                llenarTabla = "select * from departments;";
                miTabla = query.executeQuery(llenarTabla);
                
                //ENLACES REGRESAR Y PRINCIPAL
                out.println("<div id=\"a\">");
                out.println("<h2><a href=\"paginaBienvenida.jsp\">Principal</a></h2>");
                out.println("</div>");
                
                //creamos la tabla
                out.println("<center>");
                out.println("<table id=\"tablaDepartamentos\">");
                
                out.println("<tr>");
                out.println("<th>Nombre</th>");
                out.println("<th>Gerente</th>");
                out.println("<th>Ubicacion</th>");
                out.println("<th></th>");
                out.println("</tr>");
                    
                while(miTabla.next())
                {
                    contadorRegistros++;
                    
                    //establecemos el id del departamento
                    idDepartamento = Integer.parseInt(miTabla.getString("department_id"));
                    
                    //creamos los inputs y llenamos la tabla
                    out.println("<tr>");

                    //nombre del departamento
                    out.println("<td>");
                    out.println("<a href=\"empleadosPorDepartamento.jsp?idDepartamento="+idDepartamento+"\">"
                               +miTabla.getString("department_name")+"</a>");
                    out.println("</td>");

                    
                    //id del gerente
                    out.println("<strong>");
                    out.println("<td>");
                    out.println(miTabla.getString("manager_id"));
                    out.println("</td>");
                    out.println("</strong>");
                    
                    //obtenemos id y nombre
                    int idLocation = Integer.parseInt(miTabla.getString("location_id"));
                    
                    switch (idLocation)
                    {
                        case 1000:
                            claveNombreDepartamento = "1000 Roma";
                            break;
                            
                        case 1100:
                            claveNombreDepartamento = "1100 Venice";
                            break;

                        case 1200:
                            claveNombreDepartamento = "1200 Tokio";
                            break;
                            
                        case 1300:
                            claveNombreDepartamento = "1300 Hiroshima";
                            break;
                            
                        case 1400:
                            claveNombreDepartamento = "1400 Southlake";
                            break;
                            
                        case 1500:
                            claveNombreDepartamento = "1500 South San Francisco";
                            break;
                            
                        case 1600:
                            claveNombreDepartamento = "1600 South Brunswick";
                            break;
                        
                        case 1700:
                            claveNombreDepartamento = "1700 Seatle";
                            break;

                        case 1800:
                            claveNombreDepartamento = "1800 Toronto";
                            break;

                        case 1900:
                            claveNombreDepartamento = "1900 Whitehorse";
                            break;

                        case 2000:
                            claveNombreDepartamento = "2000 Beijing";
                            break;

                        case 2100:
                            claveNombreDepartamento = "2100 Bombay";
                            break;

                        case 2200:
                            claveNombreDepartamento = "2200 Sydney";
                            break;
                        
                        case 2300:
                            claveNombreDepartamento = "2300 Singapore";
                            break;
                        
                        case 2400:
                            claveNombreDepartamento = "2400 London";
                            break;

                        case 2500:
                            claveNombreDepartamento = "2500 Oxford";
                            break;

                        case 2600:
                            claveNombreDepartamento = "2600 Stretford";
                            break;

                        case 2700:
                            claveNombreDepartamento = "2700 Munich";
                            break;

                        case 2800:
                            claveNombreDepartamento = "2800 Sao Paulo";
                            break;

                        case 2900:
                            claveNombreDepartamento = "2900 Geneva";
                            break;
                        
                        case 3000:
                            claveNombreDepartamento = "3000 Bern";
                            break;

                        case 3100:
                            claveNombreDepartamento = "3100 Utrecht";
                            break;

                        case 3200:
                            claveNombreDepartamento = "3200 Mexico City";
                            break;
                    }// fin break
                       
                    //id_ubicacion
                    out.println("<strong>");
                    out.println("<td>");
                    out.println(claveNombreDepartamento);
                    out.println("</td>");
                    out.println("</strong>");
                    
                    //opcioneditar
                    out.println("<td>");
                    out.println("<ul>");
                    out.println("<li><a href=\"EditarDepartamento?dep="
                                +miTabla.getString("department_id")+""
                              + "&manager="+miTabla.getString("manager_id")+""
                              + "\"><img src=\" imagenes/editar.png \" width=\"50\" "
                               + "height=\"50\"  ></a></li>");
                    out.println("</ul>");
                    out.println("</td>");
                    
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
