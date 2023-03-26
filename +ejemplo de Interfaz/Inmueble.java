public class Inmueble implements Tributable
{
    private int id;
    private int metros_totales;
    private int metros_ocupados;

    public Inmueble() {}

    public Inmueble(int id, int metros_totales, int metros_ocupados)
    {
        if (metros_ocupados <= metros_totales)
        {
            this.id = id;
            this.metros_totales = metros_totales;
            this.metros_ocupados = metros_ocupados;
        }
    }

    public int getId()
    {
        return id;
    }

    public int getMetros_totales()
    {
        return metros_totales;
    }

    public int getMetros_ocupados()
    {
        return metros_ocupados;
    }

    @Override
    public String toString()
    {
        return "Inmueble: " + id + " | " + metros_totales + " m2 | " + metros_ocupados + " m2 | ";
    }

    @Override
    public float calcularImpuestos()
    {
        return 25*metros_ocupados;
    }
}
