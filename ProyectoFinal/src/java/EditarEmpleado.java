import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarEmpleado extends HttpServlet {

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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       out.println("<html>");
        out.println("<head>");
        out.println("<title>Edicion empleado</title>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/form.css\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/enlaces.css\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/tabla.css\">");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<h1>AGREGAR EMPLEADO</h1>");
        
        //enlaces
        out.println("<div id=\"a\">");
        out.println("<h2><a href=\"paginaBienvenida.jsp\">Principal</a></h2>");
        out.println("<h2><a href=\"listaEmpleados.jsp\">Regresar</a></h2>");
        out.println("</div>");
        
        out.println("<div id=\"form\">");
        out.println("<form action=\"ActualizarEmpleado?id="
                    +request.getParameter("id")+"\" method=\"post\">");
        out.println("<table>");
        
        //nombre del empleado
        out.println("<tr>");
        out.println("<td><strong>Nombre:</strong></td>");
        out.println("<td>"
                + "<input type=\"text\" name=\"nombre\""
                + ">"
                + "</td>");
        out.println("</tr>");
        
        //apellido
        out.println("<tr>");
        out.println("<td><strong>Apellido:</strong></td>");
        out.println("<td>"
                + "<input type=\"text\" name=\"apellido\""
                + ">"
                + "</td>");
        out.println("</tr>");
        
        //fecha contratacion
        out.println("<tr>");
        out.println("<td><strong>Fecha de contratacion:</strong></td>");
        out.println("<td>"
                + "<input type=\"date\" name=\"fecha\""
                + " required>"
                + "</td>");
        out.println("</tr>");
        
        //puesto de trabajo
        out.println("<tr>");
        out.println("<td><strong>Puesto:</strong></td>");
        out.println("<td>"
                  + "<select name=\"puesto\">"
                  + "<option value=\"AD_PRES\">President</option>"
                  + "<option value=\"AD_VP\">Administration Vice President</option>"
                  + "<option value=\"AD_ASST\">Administration Assistant</option>"
                  + "<option value=\"FI_MGR\">Financer Manager</option>"
                  + "<option value=\"FI_ACCOUNT\">Accountant</option>"
                  + "<option value=\"AC_MGR\">Accounting Manager</option>"
                  + "<option value=\"AC_ACCOUNT\">Public Accountant</option>"
                  + "<option value=\"SA_MAN\">Sales Manager</option>"
                  + "<option value=\"SA_REP\">Sales Representative</option>"
                  + "<option value=\"PU_MAN\">Purchasing Manager</option>"
                  + "<option value=\"PU_CLERK\">Purchasing clerk</option>"
                  + "<option value=\"ST_MAN\">Stock Manager</option>"
                  + "<option value=\"ST_CLERK\">Stock Clerk</option>"
                  + "<option value=\"SH_CLERK\">Shipping Clerk</option>"
                  + "<option value=\"IT_PROG\">Programmer</option>"
                  + "<option value=\"MK_MAN\">Marketing Manager</option>"
                  + "<option value=\"MK_REP\">Marketing Representative</option>"
                  + "<option value=\"HR_REP\">Human Resourcer Representative</option>"
                  + "<option value=\"PR_REP\">Public Relations Representative</option>"
                  + "</select>"
                  + "</td>");
        out.println("</tr>");
        
         //Email
        out.println("<tr>");
        out.println("<td><strong>Email:</strong></td>");
        out.println("<td>"
                + "<input type=\"email\" name=\"email\""
                + " required>"
                + "</td>");
        out.println("</tr>");
       
        //departamento
        out.println("<tr>");
        out.println("<td><strong>Departamento:</strong></td>");
        out.println("<td>"
                  + "<select name=\"departamento\">"
                  + "<option value=\"10\">Administration</option>"
                  + "<option value=\"20\">Marketing</option>"
                  + "<option value=\"30\">Purchasing</option>"
                  + "<option value=\"40\">Human Resources</option>"
                  + "<option value=\"50\">Shipping</option>"
                  + "<option value=\"60\">IT</option>"
                  + "<option value=\"70\">Public Relations</option>"
                  + "<option value=\"80\">Sales</option>"
                  + "<option value=\"90\">Executive</option>"
                  + "<option value=\"100\">Finance</option>"
                  + "<option value=\"110\">Accounting</option>"
                  + "<option value=\"120\">Treasury</option>"
                  + "<option value=\"130\">Corporate Tax</option>"
                  + "<option value=\"140\">Control and Credit</option>"
                  + "<option value=\"150\">Shareholder Services</option>"
                  + "<option value=\"160\">Benefits</option>"
                  + "<option value=\"170\">Manufacturing</option>"
                  + "<option value=\"180\">Construction</option>"
                  + "<option value=\"190\">Constracting</option>"
                  + "<option value=\"200\">Operations</option>"
                  + "<option value=\"210\">IT Support</option>"
                  + "<option value=\"220\">NOC</option>"
                  + "<option value=\"230\">IT Helpdesk</option>"
                  + "<option value=\"240\">Government Sales</option>"
                  + "<option value=\"250\">Retail Sales</option>"
                  + "<option value=\"260\">Recruiting</option>"
                  + "<option value=\"270\">Payroll</option>"
                  + "</select>"
                  + "</td>");
        out.println("</tr>");
        
        out.println("</table>");
        
        //buttons
        out.println("<input type=\"submit\" name=\"actualizar\" value=\"actualizar\" id=\"b1\">");
        out.println("<input type=\"submit\" name=\"cancelar\" value=\"cancelar\" id=\"b2\">");
        
        out.println("</form>");
        out.println("</div>");
        
        out.println("</body>");
        out.println("</html>");
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
