/*SERVLET PARA ELIMINAR A UN EMPLEADO EN ESPECIFICO EN EL JSP DEL LISTADO
DE EMPLEADOS*/

import conexion.conexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class eliminarEmpleado extends HttpServlet {

    //usuario y password para la BD
    private final String USER = "postgres"; 
    private final String PASS = "admin";
    private int idUsuario;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        processRequest(request, response);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("estamos en el servlet eliminar");
        
        //id del usuario
        idUsuario = Integer.parseInt(request.getParameter("id"));
        
        //conexion BD
        try
        {
            conexionBD obtainCon = new conexionBD(USER, PASS);
            Connection miConexion = obtainCon.obtenerConexion();
            Statement query; //objeto statement para llevar acabo instrucciones SQL
            String sentenciaSQL; //String de la orden en SQL
            int arregloRegistros[]; //arreglo de registros ejecutados por el batch
            idUsuario = Integer.parseInt(request.getParameter("id"));
            
            query = miConexion.createStatement();
            miConexion.setAutoCommit(false);
            sentenciaSQL = "delete from employees where employee_id = "+idUsuario+";";
           
            query.addBatch(sentenciaSQL);
            arregloRegistros = query.executeBatch();
            miConexion.commit();
            miConexion.close();

            response.sendRedirect("listaEmpleados.jsp");     
            out.println("que mierda?");
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        processRequest(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
