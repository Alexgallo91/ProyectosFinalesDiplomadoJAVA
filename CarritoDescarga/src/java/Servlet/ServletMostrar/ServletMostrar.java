
package Servlet.ServletMostrar;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import Producto.Producto;


public class ServletMostrar extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
    }

    
    /*Hacemos uso exclusivo*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession sesionActual = request.getSession();
        Producto HP, DELL, VAIO, IBM, COMPAQ;
        HP = new Producto("HP", "Teclado", 230.00);
        DELL = new Producto("DELL", "Scanner", 720.00);
        VAIO = new Producto("VAIO", "Camara Digital", 2500.00);
        IBM = new Producto("IBM", "Memory Stick", 300.00);
        COMPAQ = new Producto("COMPAQ", "Quemador", 500.00);
        
        //parametros del request
        int cantidad = new Integer(request.getParameter("cantidad"));
        String marca = (String) request.getParameter("listaProductos");
    
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        ArrayList<Producto> productos = new ArrayList<Producto>();
        productos.add(HP);
        productos.add(DELL);
        productos.add(VAIO);
        productos.add(IBM);
        productos.add(COMPAQ);
        
        //se crea el araylist
        ArrayList<Integer> cantidadArreglo;
      
        //si el arrayList no existe
        if(sesionActual.getAttribute("cantidadArreglo") == null || 
                sesionActual.getAttribute("cantidadArreglo") == "")
        {
            //este arreglo representa la cantidad de articulos por marca
            cantidadArreglo = new ArrayList<Integer>();
            //establecemos en 0 a todo el array con 5 index
            for(int i = 0; i < 5; i++)
            {
               cantidadArreglo.add(0);
            }
        
            for(int i = 0; i < productos.size(); i++)
            {
               if(marca.equals(productos.get(i).getClave()))
                {
                    cantidadArreglo.set(i, cantidad);
                }
            }
            
            sesionActual.setAttribute("cantidadArreglo", cantidadArreglo);
        }
        else
        {
            cantidadArreglo = (ArrayList<Integer>)sesionActual.getAttribute("cantidadArreglo");
            
            for(int i = 0; i < productos.size(); i++)
            {
               if(marca.equals(productos.get(i).getClave()))
                {
                    cantidadArreglo.set(i, cantidad + cantidadArreglo.get(i));
                }
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
            out.println("<li><a href=\"./Compra.html\" class=\"hvr-underline-from-center\">Compra</a></li>");			
            out.println("</ul>");		
            out.println("</nav>");
            out.println("<section id=\"principal\">");
            out.println("<center><h1 style=\"color:white; font-size: 30px;\">Productos en proceso de compra</h1></center>");
            out.println("<br><br>");
            
            /*Seccion principal*/
            //nos enseña los productos del carrito

            for(int i = 0; i < cantidadArreglo.size(); i++)
            {
                if(cantidadArreglo.get(i) > 0)
                {
                    out.println("<h1 class=\"colorBlanco\"><center>" 
                            + productos.get(i).getClave() + " marca " 
                            + productos.get(i).getClave() 
                            + "          cantidad: " + cantidadArreglo.get(i) + " piezas. </h1></center>");
                }
            }
            
            //guardamos el arreglo en la sesion
            sesionActual.removeAttribute("cantidadArreglo");
            sesionActual.setAttribute("cantidadArreglo", cantidadArreglo);
            
            out.println("<form method=\"post\" action=\"terminar\" >");
            out.println("<center>");
            out.println("<br>");
            out.println("<br>");
            out.println("<input type=\"submit\" value=\"Terminar Compra\" class=\"botonGrande\">");
            out.println("</center>");
            out.println("<br>");
            out.println("</form>");
            out.println("<form method=\"post\" action=\"SeguirComprando\" >");
            out.println("<center>");
            out.println("<br>");
            out.println("<br>");
            out.println("<input type=\"submit\" value=\"Seguir comprando\" class=\"botonGrande\">");
            out.println("</center>");
            out.println("</form>");
            out.println("</section>");	
            out.println("<footer id=\"pie\"><small>Derechos Reservados &copy; 2016</small></footer>");	
            out.println("</section>");	
            out.println("</body>");
            out.println("</html>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
