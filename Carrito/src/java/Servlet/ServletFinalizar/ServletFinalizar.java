
package Servlet.ServletFinalizar;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletFinalizar extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletFinalizar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletFinalizar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        doPost(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
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
            
                "<h1 class=\"titulo\">Ingresa tus datos</h1>" +
                "<br><br>" +

                "<form class=\"form\" action=\"ServletFormaPago\" method=\"post\" accept-charset=\"utf-8\">" +
                "<label class=\"tituloForm\">Nombre Completos:</label><br>" +
                "<input type=\"text\" name=\"nombre\" placeholder=\"Nombre Completo\" required> <br>" +
                "<label class=\"tituloForm\">Email:</label><br>" +
                "<input type=\"email\" name=\"email\" placeholder=\"Correo Electronico\" required> <br>" +
                "<label class=\"tituloForm\">Domicilio:</label><br>" +
                "<input type=\"text\" name=\"domicilio\" placeholder=\"Domicilio\" required> <br>" +
                
                "<br><br>" +
                "<label class=\"tituloForm\">Forma de Pago</label>" +
                "<br><br>" +

                "<!--Radio Button para el tipo de compra-->" +
                "<input type=\"radio\" name=\"tipo_pago\" value=\"tarjetaCredito\" checked>Con tarjeta de credito <br>" +
                "<input type=\"radio\" name=\"tipo_pago\" value=\"depositoBancario\">Deposito Bancario <br>" +
                "<br>" +
                "<label class=\"tituloForm\">Tipo de envio</label>" +
                "<br><br>" +

                "<!--Radio Button para el tipo de envio-->" +
                "<input type=\"radio\" name=\"tipo_envio\" value=\"gastosEnvio\" checked>A domicilio con gastos de Envio <br>" +
                "<input type=\"radio\" name=\"tipo_envio\" value=\"paqueteria\">A paqueteria <br>" +

                "<br>" +
                "<input type=\"submit\" name=\"Enviar\" class=\"botonGrande\">" +

                "</form>" +

            "</section>" +
            "<footer id=\"pie\"><small>Derechos Reservados &copy; 2016</small></footer>" +
                
            "</section>" +
        "</body>" +
        "</html> ");


    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
