
package servlets;

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
import javax.servlet.http.HttpSession;

public class verificacionUsuario extends HttpServlet {

    private Statement query;
    private String llentaTabla;
    private ResultSet miTabla;
    private HttpSession miSesion;
    private String direccion;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
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
        String nombre;
        String contraseña;
        Connection con;
        
        out.println("Entraste al login mi buen");
        
        //obtenemos el usuario del request
        nombre = request.getParameter("usuario");
        contraseña = request.getParameter("password");
        
        out.println("<h2>usuario: "+nombre+"</h2>");
        out.println("<h2>contraseña: "+contraseña+"</h2>");
        conexionBD conBD = new conexionBD("postgres", "admin");

        //intentamos conectarnos a la base de datos
        try
        {
            con = conBD.obtenerConexion();
            out.println("Logramos la conexion");
            
            query = con.createStatement();
            llentaTabla = "select * from password;";
            miTabla = query.executeQuery(llentaTabla);
            
            while(miTabla.next())
            {
                out.println("<h2>id: "+miTabla.getString("id_usuario")+"</h2><br>");
                out.println("<h2>nombre: "+miTabla.getString("nombre_usuario")+"</h2><br>");
                out.println("<h2>usuario: "+miTabla.getString("password")+"</h2><br>");
                
                if(nombre.equals(miTabla.getString("nombre_usuario")) && 
                        contraseña.equals(miTabla.getString("password")))
                {
                    //obtenemos o creamos una nueva sesion
                    miSesion = request.getSession();
                    miSesion.setAttribute("nombre", nombre);
                    direccion = "paginaBienvenida.jsp";
                    break;
                }
                else
                {
                    direccion = "ErroAcceso.jsp";
                }
            }
            response.sendRedirect(direccion);
        }
        catch(ClassNotFoundException e)
        {
            out.println("<h1>ERROR: "+e.getMessage()+"</h1>");
        }
        catch(SQLException e)
        {
            out.println("<h1>ERROR: "+e.getMessage()+"</h1>");
        }
    }

    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }// </editor-fold>

}
