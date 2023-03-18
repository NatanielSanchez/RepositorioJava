public class testing
{
    public static void main(String[] args)
    {
        double n1, n2, n3;
        System.out.println("80 * 3 = " + Calculadora.multiplicar(n1 = 80, n2 = 3));

        System.out.println("(150 + 180) / 3 = " +
                Calculadora.dividir( Calculadora.sumar(n1=150, n2=180), n3=3 ) );

        System.out.println("(90 - 50) * 15 = " +
                Calculadora.multiplicar( Calculadora.restar(n1=90, n2=50), n3=15 ) );

        System.out.println("(70 + 40) * 25 = " +
                Calculadora.multiplicar( Calculadora.sumar(n1=70, n2=40), n3=25 ) );
    }
}
