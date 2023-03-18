public class Calculadora // Calculadora de numeros. No es necesario crear instancias
{
    public static double sumar(double x, double y)
    {
        return x + y;
    }
    public static double restar(double x, double y)
    {
        return x - y;
    }
    public static double multiplicar(double x, double y)
    {
        return x * y;
    }
    public static double dividir(double x, double y)
    {
        if (y == 0)
            return 0;
        return x / y;
    }
}
