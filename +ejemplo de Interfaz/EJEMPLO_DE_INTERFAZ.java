public class EJEMPLO_DE_INTERFAZ
{
    public static void main(String[] args)
    {
        // Tributable es una interfaz implementada en todas las clases
        // Por lo tanto, se puede usar una variable para referenciar objetos "tributables"
        // Note que Inmueble no es parte de la jerarquia de Auto
        Tributable bienes[] = new Tributable[4];
        bienes[0] = new Auto("AB456PY", "Ford", 2010);
        bienes[1] = new Taxi("cd983po", "fiat", 2019, "T999");
        bienes[2] = new Remis("fg219bn", "toyota", 2011, "R666", 5);
        bienes[3] = new Inmueble(999, 100, 85);
        // Ahora los objetos creados pueden ser consderados de tipo Tributable
        // por lo que puedo iterar el arreglo y llamar a su metodo en comun (dada por la interfaz)
        int total = 0;
        for (Tributable x : bienes)
        {
            total += x.calcularImpuestos();
        }
        System.out.println(total);


    }
}
