
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBD {
    
    private final String URL = "jdbc:postgresql://localhost:5432/Diplomado";
    private String usuario;
    private String password;
    private Class driver;
    private Connection con;
    
    public conexionBD(String usuario, String password)
    {
        this.setPassword(password);
        this.setUsuario(usuario);
    }
    
    public void setUsuario(String user)
    {
        this.usuario = user;
    }
    
    public String getUsuario()
    {
        return this.usuario;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    public Connection obtenerConexion() throws 
            ClassNotFoundException, SQLException
    {
        //intentamos conectarnos a la base de datos
        driver = Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, this.getUsuario(), this.getPassword());
        
        return con;
    }
}
