public class Taxi extends Auto implements Tributable
{
    private String licencia;

    public Taxi(String patente, String marca, int modelo, String licencia)
    {
        super(patente, marca, modelo);
        this.licencia = licencia;
    }

    public String getLicencia()
    {
        return licencia;
    }

    @Override
    public float calcularImpuestos()
    {
        return 20;
    }

    @Override
    public String toString()
    {
        return "Taxi: Licencia " + licencia + " ( " + super.toString() + " ) ";
    }
}
