
import conexion.conexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class insertarUsuario extends HttpServlet {

    //usuario y password para la BD
    private final String USER = "postgres"; 
    private final String PASS = "admin";
    private int contador = 1;
    
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String cancelar = request.getParameter("cancelar");
        String agregar = request.getParameter("agregar");
        
        //datos del request
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String fechaInicio = request.getParameter("fecha");
        String puesto = request.getParameter("puesto");
        String departamento = request.getParameter("departamento");
        
        out.println("arreglar: " + agregar);
        out.println("cancelar: " + cancelar);
       
        out.println("<br><br>"+nombre+"<br>");
        out.println(apellido+"<br>");
        out.println(email+"<br>");
        out.println(fechaInicio+"<br>");
        out.println(puesto+"<br>");
        out.println(departamento+"<br>");
        
        
        if(cancelar != null) //SI EL USUARIO LE DIO EN EL BOTON CANCELAR
        {
            response.sendRedirect("index.jsp");
        }
        
        out.println("que sucede?");
        //conexion BD
        try
        {
            out.println("hola desde la declaracion de variables");
            conexionBD obtainCon = new conexionBD(USER, PASS);
            Connection miConexion = obtainCon.obtenerConexion();
            Statement query; //objeto statement para llevar acabo instrucciones SQL
            String sentenciaSQL; //String de la orden en SQL
            ResultSet miTabla; //obtenemos todos los registros con el select en employees
            int arregloRegistros[]; //arreglo de registros ejecutados por el batch
            int nuevoIdUsuario = 1;
            
            
            query = miConexion.createStatement();
            miTabla = query.executeQuery("select * from employees order by employee_id");
            
            /*recorremos la tabla para comparar los id de los empleados con el contador
            , en caso de que sea diferente el contador en todos los id's de la tabla
            se establece como el nuevo id del nuevo empleado*/
            
            while(miTabla.next())
            {
                int id = Integer.parseInt(miTabla.getString("employee_id"));
                
                if(id == nuevoIdUsuario)
                {
                    nuevoIdUsuario++;
                    out.println("numeros iguales: " + nuevoIdUsuario);
                }
            }
            
            out.println("Numero id: " + nuevoIdUsuario);
            
            miTabla.close(); //cerramos miTabla
            
            query = miConexion.createStatement();
            miConexion.setAutoCommit(false);
            sentenciaSQL = 
                    String.format("INSERT INTO employees (employee_id, first_name, "
                                + "last_name, email, hire_date, job_id, department_id) VALUES "
                                + "(%d, '%s', '%s', '%s', "
                                + "'%s', '%s', '%s');", nuevoIdUsuario, nombre, apellido, email, fechaInicio,
                                puesto, departamento); 

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
            catch(NumberFormatException e)
            {
                out.println("<h1>Error: "+e.getMessage()+"</h1>");
            }  
            catch(Exception e)
            {
                out.println("<h1>Error: "+e.getMessage()+"</h1>");
            }
    }//fin de doGet

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
