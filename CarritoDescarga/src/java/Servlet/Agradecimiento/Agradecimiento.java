
package Servlet.Agradecimiento;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Agradecimiento extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Agradecimiento</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Agradecimiento at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>" +
        "<html>" + 
        "<head>" +
            "<meta charset=\"utf-8\">" +
            "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">" +
            "<title>Compra</title>" +
            "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/hoja1.css\">" +
        "</head>" +
        "<body>" +
            "<section id=\"contenido\">" +

            "<header id=\"cabecera\">" +
                "<h1>COMPRA</h1>" +
            "</header>" +
            "<nav id=\"menu\">" +
                "<ul>" +
                    "<li><a href=\"./Home.html\" class=\"hvr-underline-from-center\">Home</a></li>" +
                    "<li><a href=\"./Ingreso.html\" class=\"hvr-underline-from-center\">Ingreso</a></li>" +
                    "<li><a href=\"/Carrito/ingresar\" class=\"hvr-underline-from-center\">Estado</a></li>" +
                    "<li><a href=\"/Carrito/Compra\" class=\"hvr-underline-from-center\">Compra</a></li>" +
                "</ul>" +
            "</nav>" +
            "<section id=\"principal\">" +
            
                "<h1 class=\"titulo\">MUCHAS GRACIAS, TU COMPRA HA SIDO PROCESADA</h1>" +

            "</section>" +
            "<footer id=\"pie\"><small>Derechos Reservados &copy; 2016</small></footer>" +
                
            "</section>" +
        "</body>" +
        "</html> ");
        
        out.close();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
