package mi_paquete;

public class ItemCarrito // Un item representa un producto y su cantidad
{
    private Producto producto;
    private int cantidad;
    private float precioUnidad;

    public ItemCarrito()
    {
        this.cantidad = 0;
        this.precioUnidad = 0;
    }

    public ItemCarrito(Producto producto, int cantidad)
    {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnidad = producto.getPrecio();
    }

    public Producto getProducto()
    {
        return producto;
    }

    public int getCantidad()
    {
        return cantidad;
    }

    public float getPrecioUnidad()
    {
        return precioUnidad;
    }

    public void setProducto(Producto producto)
    {
        this.producto = producto;
    }

    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
    }

    public void setPrecioUnidad(float precioUnidad)
    {
        this.precioUnidad = precioUnidad;
    }

    public float subTotal() // calcula el sub total de producto segun la cantidad
    {
        return (float) precioUnidad*cantidad;
    }

    @Override
    public String toString()
    {
        String x = "";
        return x = producto.toString() + " | CANTIDAD: " + cantidad;
    }
}
