
package Compra.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import Producto.Producto;


public class Compra extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Compra</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Compra at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession actual = request.getSession();
        String errorUrl = "ErrorIngreso.html"; 

                
        if(actual.getAttribute("usuario") == "" || actual.getAttribute("usuario") == null)
        {
            response.sendRedirect(errorUrl);
        }
        else
        {
            //ARRAY LIST DE LOS PRODUCTOS
            ArrayList<Producto> productos;
            productos = new ArrayList<Producto>();
            
            for(int i = 0; i <= 4; i++)
            {
               switch(i)
               {
                   case 0:
                       productos.add(new Producto("HP", "Teclado", 230.00));
                       break;
                   case 1:
                       productos.add(new Producto("DELL", "Scanner", 720.00));
                       break;
                   case 2:
                       productos.add(new Producto("VAIO", "Camara Digital", 2500.00));
                       break;
                   case 3:
                       productos.add(new Producto("IBM", "Memory Stick", 300.00));
                       break;
                   case 4:
                       productos.add(new Producto("COMPAQ", "Quemador", 500.00));
                       break;
               }
            }
           
            out.println("<!DOCTYPE html>");    
            out.println("<html>");    
            out.println("<head>");    
            out.println("<meta charset=\"utf-8\">");	
            out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");	
            out.println("<title>Compra</title>");	
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/hoja1.css\">");	
            out.println("</head>");  
            out.println("<body>");   
            out.println("<section id=\"contenido\">");	
            out.println("<header id=\"cabecera\">");	
            out.println("<h1>COMPRA</h1>");	
            out.println("</header>");	
            out.println("<nav id=\"menu\">");	
            out.println("<ul>");		
            out.println("<li><a href=\"./Home.html\" class=\"hvr-underline-from-center\">Home</a></li>");			
            out.println("<li><a href=\"./Ingreso.html\" class=\"hvr-underline-from-center\">Ingreso</a></li>");			
            out.println("<li><a href=\"/Carrito/ingresar\" class=\"hvr-underline-from-center\">Estado</a></li>");			
            out.println("<li><a href=\"/Carrito/Compra\" class=\"hvr-underline-from-center\">Compra</a></li>");			
            out.println("</ul>");		
            out.println("</nav>");
            out.println("<section id=\"principal\">");
            out.println("<center>");
            out.println("<h1 class=\"menB\">Bievenido Usuario noCuenta: " +actual.getAttribute("noCuenta")+ " </h1>");
            out.println("</center>");

            out.println("<!--Ejemplo de lista dentro de form-->"); 
            out.println("<center>");
            out.println("<form action=\"mostrar\" method=\"post\" class=\"pad\">");
            out.println("<label>Articulo</label>");
            out.println("<select class=\"box\" name=\"listaProductos\">");
            for(int i = 0; i < productos.size(); i++)
            {   
                out.println("<option value="+productos.get(i).getClave()+">"
                        +productos.get(i).getNombre()+" "+productos.get(i).getClave()+"  $"+productos.get(i).getPrecio()+"</option>");
            }
            out.println("</select>");
            out.println("<label>Cantidad</label>");
            out.println("<input class=\"box\" type=\"number\" name=\"cantidad\" min=\"0\" max=\"100\" required>" );
            out.println("<br>");
            out.println("<input type=\"submit\" name=\"botonComprar\" value=\"Comprar\">");
            out.println("</form><br><br>");
            
            //botones submit para mirar el carro de compra y finalizarl

            out.println("</center>");
             
            out.println("</section>");	
            out.println("<footer id=\"pie\"><small>Derechos Reservados &copy; 2016</small></footer>");	
            out.println("</section>");	
            out.println("</body>");
            out.println("</html>");
        }
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    

}
