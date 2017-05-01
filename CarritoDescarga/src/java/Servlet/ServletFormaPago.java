package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import Producto.*;

public class ServletFormaPago extends HttpServlet {

    
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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession sesionActual = request.getSession();
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        //array de nuestro carrito de compra
        ArrayList<Integer> cantidad = (ArrayList<Integer>) sesionActual.getAttribute("cantidadArreglo");
        
        //Array de los productos a mostrar
        ArrayList<Producto> productos = new ArrayList<Producto>();
        Producto HP, DELL, VAIO, IBM, COMPAQ;
        HP = new Producto("HP", "Teclado", 230.00);
        DELL = new Producto("DELL", "Scanner", 720.00);
        VAIO = new Producto("VAIO", "Camara Digital", 2500.00);
        IBM = new Producto("IBM", "Memory Stick", 300.00);
        COMPAQ = new Producto("COMPAQ", "Quemador", 500.00);
        
        //agregamos 
        productos.add(HP);
        productos.add(DELL);
        productos.add(VAIO);
        productos.add(IBM);
        productos.add(COMPAQ);
        
        String formaDePago = request.getParameter("tipo_pago");
        String formaDeEnvio = request.getParameter("tipo_envio");
        double costoTotal = 0;
        
        out.println("<!DOCTYPE html>");    
        out.println("<html>");    
        out.println("<head>");    
        out.println("<meta charset=\"utf-8\">");	
        out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");	
        out.println("<title>Compra</title>");	
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/hoja1.css\">");	
        out.println("<style>body h1, h2{color:white;}</style>");
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
        out.println("<center><h1 style=\"color:white; font-size: 30px;\">Proceso de compra</h1></center>");
        out.println("<br><br>");
        
        /*Cuenta la cantidad de productos por el precio individual del mismo, y generamos el costo total*/
        for(int i=0; i<cantidad.size(); i++)
        {
            costoTotal += (productos.get(i).getPrecio() * cantidad.get(i)); 
        }
        
        /*Vamos a mostrar los productos con su precio respectivo*/
        out.println("<center>");
        out.println("<table style=\"background-color:white; font-size: 19px;\">");
        out.println("<tr>" +
                        "<th>Nombre</th>" +
                        "<th>Marca</th>" +
                        "<th>Precio</th>" +
                        "<th>Cantidad</th>" +
                        "<th>Total</th>" +
                        "</tr>");
        for(int i = 0; i < productos.size();i++)
        {
            out.println("<tr>" +
                        "<td>"+productos.get(i).getNombre()+"</th>" +
                        "<td>"+productos.get(i).getClave()+"</th>" +
                        "<td>"+productos.get(i).getPrecio()+"</th>" +
                        "<td>"+cantidad.get(i)+"</th>" +
                        "<td>"+(cantidad.get(i) * productos.get(i).getPrecio())+"</th>" +
                        "</tr>");
        }
        out.println("</table>");
        out.println("<br><br>");
        
//        imprimimos la forma de pago y el tipo de envio, dependiendo de lo que 
//        haya ingresado el usuario en el form
        
        if(formaDePago.equals("tarjetaCredito"))
        {
            out.println("<form>" +
                       "<h1>Pago por tarjeta de credito</h1>" +
                       "<label>Ingresa El numero de Tarjeta de Credito:</label><br>" +
                       "<input type=\"number\" name=\"tarjeta\" required><br>" +
                       "<label>Banco:</label> <br>" +
                       "<select required>" +
                       "    <option value = \"Banorte\">Banorte</option>" + 
                       "    <option value = \"Bancomer\">Bancomer</option>" + 
                       "    <option value = \"Santander\">Santander</option>" +
                       "    <option value = \"Serfin\">Serfin</option>" + 
                       "</select>" +
                       "</form> <br><br>");
        }
        else if(formaDePago.equals("depositoBancario"))
        {
            out.println("<h1>Pago con deposito bancario</h1>" + 
                       "<br><h2>Numero de Cuenta: 2345-232145</h2><br>" +
                       "<h2>Banco: Santander</h2>" +
                       "<br><br>");
        }
        
        if(formaDeEnvio.equals("gastosEnvio"))
        {
            out.println("<h1>Envio con gastos</h1>" + 
                        "<br><h2>Costo: $350</h2>");
        }
        else if(formaDeEnvio.equals("paqueteria"))
        {
            out.println("<h1>Envio por paqueteria</h1>");
        }
        
        //si el envio es con gastos incluidos imprimos la suma de total a pagar junto con
        //los gastos de envio
        if(formaDeEnvio.equals("gastosEnvio"))
        {
            out.println("<br><br>");
            out.println("<center><h1>TOTAL A PAGAR:</h1></center>");
            out.println("<br>");
            out.println("<center><h2>$"+(costoTotal+350.00)+" MXN</h2></center>");
        }
        else
        {
            out.println("<br><br>");
            out.println("<center><h1>TOTAL A PAGAR:</h1></center>");
            out.println("<br>");
            out.println("<center><h2>$"+(costoTotal)+" MXN</h2></center>");
        }
        
        //creamos un boton para poder finalizar la compra con el servlet agradecimiento
        out.println("<form action=\"Agradecimiento\" method=\"post\">");
        out.println("<input type=\"submit\" value=\"Terminar mi compra\" class=\"botonGrande\">");
        out.println("</form>");
        out.println("<br>");
        
        out.println("</center>");
        out.println("</section>");	
        out.println("<footer id=\"pie\"><small>Derechos Reservados &copy; 2016</small></footer>");	
        out.println("</section>");	
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
