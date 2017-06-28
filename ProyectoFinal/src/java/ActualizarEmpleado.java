
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import conexion.conexionBD;

public class ActualizarEmpleado extends HttpServlet {
    
    //usuario y password para la BD
    private final String USER = "postgres"; 
    private final String PASS = "admin";
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        processRequest(request, response);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String actualizar = request.getParameter("actualizar");
        String cancelar = request.getParameter("cancelar");
        
        out.println("<h1>TOMA DE DECISION PARA ACTUALIZAR EMPLEADO</h1>");
        out.println("<h2>actualizar: "+actualizar+"</h2>");
        out.println("<h2>cancelar: "+cancelar+"</h2>");
        
        if(cancelar != null)
        {
            response.sendRedirect("listaEmpleados.jsp");
        }
        
        if(actualizar != null)
        {
            out.println("Le diste en actualizar");
            
            String nombre;
            String apellido;
            String fecha;
            String puesto;
            String email;
            String sentenciaSQL;
            
            nombre = request.getParameter("nombre");
            apellido = request.getParameter("apellido");
            fecha = request.getParameter("fecha");
            puesto = request.getParameter("puesto");
            email = request.getParameter("email");
            
            //DEBO CHECAR COMO ACTUALIZAR EL EMPLEADO
            //sentenciaSQL = String.format("update ")
            
            String []datosUsuario = {nombre, apellido, fecha, puesto, email};
            for(String dato: datosUsuario)
            {
                out.println("<br>"+dato);
            }
            
            //ejecutamos el batch
            try
            {
                conexionBD obtainCon = new conexionBD(USER, PASS);
                Connection miConexion = obtainCon.obtenerConexion();
                Statement query; //objeto statement para llevar acabo instrucciones SQL
                int arregloRegistros[]; //arreglo de registros ejecutados por el batch
               
                //obtenemos el id del empleado
                int idUsuario = Integer.parseInt(request.getParameter("id"));
               
                out.println("<br>Id usuario: " + idUsuario);
                query = miConexion.createStatement();
                out.println("se ejecuto");
                miConexion.setAutoCommit(false);
                out.println("se ejecuto");
                sentenciaSQL = "update employees set first_name = '"+nombre+"', \n" +
                               "last_name = '"+apellido+"', \n" +
                               "email = '"+email+"', \n" +
                               "hire_date = '"+fecha+"', \n" +
                               "job_id = '"+puesto+"' \n" +
                               "where employee_id = "+idUsuario+";";
                out.println("se ejecuto");
                query.addBatch(sentenciaSQL);
                arregloRegistros = query.executeBatch();
                miConexion.commit();
                miConexion.close();
                
                response.sendRedirect("listaEmpleados.jsp");     
            }
            catch(SQLException e)
            {
                out.println("<h1>Error: "+e.getMessage()+"</h1>");
            }
            catch(IOException e)
            {
                out.println("<h1>Error: "+e.getMessage()+"</h1>");
            }
            catch(NumberFormatException e)
            {
                out.println("<h1>Error: "+e.getMessage()+"</h1>");
            }  
            catch(Exception e)
            {
                out.println("<h1>Error: "+e.getMessage()+"</h1>");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
