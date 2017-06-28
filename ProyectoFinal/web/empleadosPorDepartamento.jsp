<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EMPLEADOS POR DEPARTAMENTO</title>
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
           int idDepartamento = Integer.parseInt(request.getParameter("idDepartamento")); 
           
            //para obtener el nombre del departamento
            String nombreDepartamento = "";
            switch (idDepartamento)
            {
                case 10:
                    nombreDepartamento = "Administration";
                    break;

                case 20:
                    nombreDepartamento = "Marketing";
                    break;

                case 30:
                    nombreDepartamento = "Purchasing";
                    break;

                case 40:
                    nombreDepartamento = "Human Resources";
                    break;

                case 50:
                    nombreDepartamento = "Shipping";
                    break;

                case 60:
                    nombreDepartamento = "IT";
                    break;

                case 70:
                    nombreDepartamento = "Public Relations";
                    break;

                case 80:
                    nombreDepartamento = "Sales";
                    break;

                case 90:
                    nombreDepartamento = "Executive";
                    break;

                case 100:
                    nombreDepartamento = "Finance";
                    break;

                case 110:
                    nombreDepartamento = "Accounting";
                    break;

                case 120:
                    nombreDepartamento = "Treasury";
                    break;

                case 130:
                    nombreDepartamento = "Corporate Tax";
                    break;

                case 140:
                    nombreDepartamento = "Control and Credit";
                    break;

                case 150:
                    nombreDepartamento = "Shareholder Services";
                    break;

                case 160:
                    nombreDepartamento = "Benefits";
                    break;

                case 170:
                    nombreDepartamento = "Manufacturing";
                    break;

                case 180:
                    nombreDepartamento = "Construction";
                    break;

                case 190:
                    nombreDepartamento = "Constracting";
                    break;

                case 200:
                    nombreDepartamento = "Operations";
                    break;

                case 210:
                    nombreDepartamento = "IT Support";
                    break;

                case 220:
                    nombreDepartamento = "NOC";
                    break;

                case 230:
                    nombreDepartamento = "IT Helpdesk";
                    break;

                case 240:
                    nombreDepartamento = "Government Sales";
                    break;

                case 250:
                    nombreDepartamento = "Retail Sales";
                    break;

                case 260:
                    nombreDepartamento = "Recruiting";
                    break;

                case 270:
                    nombreDepartamento = "Payroll";
                    break;
            }

            try
            {
                miConexion = con.obtenerConexion();
                out.println("<h1>EMPLEADOS POR DEPARTAMENTO</h1>");
                out.println("<br>");
                out.println("<h2>Departamento seleccionado: "+nombreDepartamento+"</h2>");
                out.println("<h2>Id del departamento: "+idDepartamento+"</h2>");
                
                //ENLACES REGRESAR Y PRINCIPAL
                out.println("<div id=\"enlaces\">");
                out.println("<h2><a href=\"paginaBienvenida.jsp\">Principal</a></h2>");
                out.println("<h2><a href=\"listaDepartamentos.jsp\">Regresar</a></h2>");
                out.println("</div>");
                
                query = miConexion.createStatement();
                llenarTabla = String.format("select * from employees where "
                                          + "department_id = %d;", idDepartamento);   
                           
                miTabla = query.executeQuery(llenarTabla);
                
                //creamos la tabla
                out.println("<center>");
                out.println("<table id=\"tablaEmpleados\">");
                
                out.println("<tr>");
                out.println("<th>NOMBRE</th>");
                out.println("<th>FECHA CONTRATACION</th>");
                out.println("<th>PUESTO</th>");
                out.println("<th>EMAIL</th>");
                out.println("<th>DEPARTAMENTO</th>");
                out.println("</tr>");
                
                while(miTabla.next())
                {
                    contadorRegistros++;
                    //creamos los inputs y llenamos la tabla
                    out.println("<tr>");

                    //nombre del empleado
                    out.println("<td>");
                    out.println(miTabla.getString("first_name"));
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
                    out.println(nombreDepartamento);
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
