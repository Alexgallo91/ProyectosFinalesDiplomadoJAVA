//javaBean usuario
package usuario;

public class usuario {
    
    private String nombre;
    
    public usuario(String nombre)
    {
        this.setNombre(nombre);
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
    
}
