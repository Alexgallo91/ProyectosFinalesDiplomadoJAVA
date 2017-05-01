package Usuario;

public class Usuario {
    
    private String usuario;
    private String password;
    public Usuario()
    {
        this.usuario = "";
        this.password = "";
    }
    
    public Usuario(String nombre, String password)
    {
        this.usuario = nombre;
        this.password = password;
    }
    
    private void setUsuario(String nombre)
    {
        this.usuario = nombre;
    }
    
    private void setPassword(String pass)
    {
        this.password = pass;
    }
    
    public String getUsuario()
    {
        return this.usuario;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
}
