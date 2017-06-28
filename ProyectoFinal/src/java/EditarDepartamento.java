
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditarDepartamento extends HttpServlet {


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
        String nombreDepartamento = "";
        int idDepartamento = Integer.parseInt(request.getParameter("dep"));
        
        switch (idDepartamento)
        {
            case 10:
                nombreDepartamento = "Administration";
                break;

            case 20:
                nombreDepartamento = "Marketing";
                break;

            case 30:
                nombreDepartamento = "Purchasing";
                break;

            case 40:
                nombreDepartamento = "Human Resources";
                break;

            case 50:
                nombreDepartamento = "Shipping";
                break;

            case 60:
                nombreDepartamento = "IT";
                break;

            case 70:
                nombreDepartamento = "Public Relations";
                break;

            case 80:
                nombreDepartamento = "Sales";
                break;

            case 90:
                nombreDepartamento = "Executive";
                break;

            case 100:
                nombreDepartamento = "Finance";
                break;

            case 110:
                nombreDepartamento = "Accounting";
                break;

            case 120:
                nombreDepartamento = "Treasury";
                break;

            case 130:
                nombreDepartamento = "Corporate Tax";
                break;

            case 140:
                nombreDepartamento = "Control and Credit";
                break;

            case 150:
                nombreDepartamento = "Shareholder Services";
                break;

            case 160:
                nombreDepartamento = "Benefits";
                break;

            case 170:
                nombreDepartamento = "Manufacturing";
                break;

            case 180:
                nombreDepartamento = "Construction";
                break;

            case 190:
                nombreDepartamento = "Constracting";
                break;

            case 200:
                nombreDepartamento = "Operations";
                break;

            case 210:
                nombreDepartamento = "IT Support";
                break;

            case 220:
                nombreDepartamento = "NOC";
                break;

            case 230:
                nombreDepartamento = "IT Helpdesk";
                break;

            case 240:
                nombreDepartamento = "Government Sales";
                break;

            case 250:
                nombreDepartamento = "Retail Sales";
                break;

            case 260:
                nombreDepartamento = "Recruiting";
                break;

            case 270:
                nombreDepartamento = "Payroll";
                break;
        }

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Edicion empleado</title>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/form.css\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/enlaces.css\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/tabla.css\">");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<h1>AGREGAR DEPARTAMENTO</h1>");
        
        //enlaces
        out.println("<div id=\"a\">");
        out.println("<h2><a href=\"paginaBienvenida.jsp\">Principal</a></h2>");
        out.println("<h2><a href=\"listaDepartamentos.jsp\">Regresar</a></h2>");
        out.println("</div>");

        out.println("<div id=\"form\">");
        out.println("<form action=\"ActualizarDepartamento?id="
                    +request.getParameter("id")+"\" method=\"post\">");
        out.println("<table>");
        
        //nombre departamento
        out.println("<tr>");
        out.println("<td><strong>Departamento:</strong></td>");
        out.println("<td>"
                + "<input type=\"text\" name=\"nombre\""
                + " value=\""+nombreDepartamento+"\" readonly>"
                + "</td>");
        out.println("</tr>");
        
        //id gerente
        out.println("<tr>");
        out.println("<td><strong>Gerente:</strong></td>");
        out.println("<td>"
                + "<input type=\"text\" name=\"gerente\""
                + " value=\""+request.getParameter("manager")+"\" readonly>"
                + "</td>");
        out.println("</tr>");
        
       //ubicacion
        out.println("<tr>");
        out.println("<td><strong>Ubicacion:</strong></td>");
        out.println("<td>"
                  + "<select name=\"ubicacion\" required>"
                  + "<option value=\"1000\">ROMA</option>"
                  + "<option value=\"1100\">VENICE</option>"
                  + "<option value=\"1200\">TOKYO</option>"
                  + "<option value=\"1300\">HIROSHIMA</option>"
                  + "<option value=\"1400\">SOUTHLAKE</option>"
                  + "<option value=\"1500\">SOUTH SAN FRANCISCO</option>"
                  + "<option value=\"1600\">SOUTH BRUNSWICK</option>"
                  + "<option value=\"1700\">SEATTLE</option>"
                  + "<option value=\"1800\">TORONTO</option>"
                  + "<option value=\"1900\">WHITEHORSE</option>"
                  + "<option value=\"2000\">BEIJING</option>"
                  + "<option value=\"2100\">BOMBAY</option>"
                  + "<option value=\"2200\">SYDNEY</option>"
                  + "<option value=\"2300\">SINGAPORE</option>"
                  + "<option value=\"2400\">LONDON</option>"
                  + "<option value=\"2500\">OXFORD</option>"
                  + "<option value=\"2600\">STRETFORD</option>"
                  + "<option value=\"2700\">MUNICH</option>"
                  + "<option value=\"2800\">SAU PAULO</option>"
                  + "<option value=\"2900\">GENEVA</option>"
                  + "<option value=\"3000\">BERN</option>"
                  + "<option value=\"3100\">UTRECHT</option>"
                  + "<option value=\"3200\">MEXICO CITY</option>"
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
