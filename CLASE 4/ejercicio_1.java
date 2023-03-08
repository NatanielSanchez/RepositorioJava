import mi_paquete.*;
import java.util.Scanner;

public class ejercicio_1
{
	public static void main(String[] args)
	{
		System.out.println("\nEJERCICIO 1:");
		
		Scanner sc = new Scanner (System.in);
		Arreglo v = new Arreglo(3); // se crea un arreglo
		System.out.println("- Ingrese los tres numeros del arreglo: ");
		for (int i = 0; i < v.getLength(); i++)
		{
			System.out.print(">>> ");
			int num = sc.nextInt();
			v.set(i, num); // se inicializa el valor num en la casilla v[i]
		}
		
		System.out.println("\nIngrese 1 para ordenar de menor a mayor, o 2 para mayor a menor: "); // se elige como ordenar el arreglo
		int opc;
		do
		{
			System.out.print(">>> ");
			opc = sc.nextInt();
		}
		while (opc < 1 || opc > 2);
		
		if (opc == 1)
			v.selectionSortAsc();
		if (opc == 2)
			v.selectionSortDesc();
		
		System.out.print("\nArreglo ordenado: ");
		System.out.print(v.toString());
	}
}