public class Remis extends Auto implements Tributable
{
    private String licencia;
    private int agencia; // del 0 al 9

    public Remis(String patente, String marca, int modelo, String licencia, int agencia)
    {
        super(patente, marca, modelo);
        this.licencia = licencia;
        this.agencia = agencia;
    }

    public String getLicencia()
    {
        return licencia;
    }

    public int getAgencia()
    {
        return agencia;
    }

    @Override
    public float calcularImpuestos()
    {
        return 50;
    }

    @Override
    public String toString()
    {
        return "Remis: Licencia " + licencia + " | Agencia: " + agencia + " ( " + super.toString() + " ) ";
    }
}
