package Ingreso.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Usuario.Usuario;

public class Ingreso extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession actual = request.getSession();
        String errorUrl = "ErrorIngreso.html"; 
        
        if(actual.getAttribute("usuario") == "" || actual.getAttribute("usuario") == null)
        {
            response.sendRedirect(errorUrl);
        }
        else
        {
            ServletContext contexto = this.getServletContext();
            contexto.getRequestDispatcher("/SesionIniciada.jsp").forward(request, response);   
        }
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String usuarioJSP = "";
        String usuarioServlet = "Admin";
        String passwordJSP = "";
        String passwordServlet = "Admin";
        
        usuarioJSP = request.getParameter("nombre");
        passwordJSP = request.getParameter("password");
        
        if(usuarioServlet.equals(usuarioJSP) && passwordServlet.equals(passwordJSP))
        {
            //creamos la sesion
            HttpSession session = request.getSession();
            //le asignamos el id al String noCuenta como atributo de la sesion
            session.setAttribute("noCuenta", session.getId());
            session.setAttribute("usuario", new Usuario(usuarioJSP, passwordJSP));
            ServletContext contexto = this.getServletContext();
            contexto.getRequestDispatcher("/SesionIniciada.jsp").forward(request, response);   
        }
        else
        {
            response.sendRedirect("ErrorIngreso.html");
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    

}
