
package Producto;

public class Producto {
    
    private String clave, nombre;
    private Double precio;
    
    public Producto()
    {
        this.clave = "";
        this.nombre = "";
        this.precio = 0.0;
    }
    
    public Producto(String clave, String nombre, Double num)
    {
        this.clave = clave;
        this.nombre = nombre;
        this.precio = num;
    }
    
    public void setClave(String clave)
    {
        this.clave = clave;
    }
    
    public String getClave()
    {
        return this.clave;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public String getNombre()
    {
        return this.nombre;
    }
    
    public void setPrecio(double num)
    {
        this.precio = num;
    }
    
    public Double getPrecio()
    {
        return this.precio;
    }
    
}
