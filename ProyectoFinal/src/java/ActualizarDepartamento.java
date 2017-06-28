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

public class ActualizarDepartamento extends HttpServlet {
    
    //usuario y password para la BD
    private final String USER = "postgres"; 
    private final String PASS = "admin";
    
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
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        //cambiar todo el procedimiento para actualizar departamento
        processRequest(request, response);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String actualizar = request.getParameter("actualizar");
        String cancelar = request.getParameter("cancelar");
        
        out.println("<h1>TOMA DE DECISION PARA ACTUALIZAR DEPARTAMENTO</h1>");
        out.println("<h2>actualizar: "+actualizar+"</h2>");
        out.println("<h2>cancelar: "+cancelar+"</h2>");
        
        if(cancelar != null)
        {
            response.sendRedirect("paginaBienvenida.jsp");
        }
        
        if(actualizar != null)
        {
            out.println("Le diste en actualizar");
            String sentenciaSQL;
            
            String nombreDepartamento = request.getParameter("nombre");
            String idGerente = request.getParameter("gerente");
            String ubicacion = request.getParameter("ubicacion");
            
            //DEBO CHECAR COMO ACTUALIZAR EL EMPLEADO
            //sentenciaSQL = String.format("update ")
            
            String []datosUsuario = {nombreDepartamento, idGerente, ubicacion};
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

                query = miConexion.createStatement();
                miConexion.setAutoCommit(false);
         
                sentenciaSQL = String.format("update departments set location_"
                                           + "id = %s where department_name = "
                                           + "'%s';", ubicacion, nombreDepartamento);
                query.addBatch(sentenciaSQL);
                arregloRegistros = query.executeBatch();
                miConexion.commit();
                miConexion.close();
                
                response.sendRedirect("listaDepartamentos.jsp");     
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
