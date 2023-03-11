package mi_paquete;

public class Producto // nombre y precio de un producto de supermercado
{
    private String nombre;
    private float precio;

    public Producto()
    {
        this.nombre = "NULL";
        this.precio = 0;
    }

    public Producto(String nombre, float precio)
    {
        this.nombre = nombre.toUpperCase();
        this.precio = precio;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre.toUpperCase();
    }

    public float getPrecio()
    {
        return precio;
    }

    public void setPrecio(float precio)
    {
        this.precio = precio;
    }

    @Override
    public String toString()
    {
        return "PRODUCTO: " + nombre + " | " +
                "PRECIO (unidad): " + precio;
    }
}


