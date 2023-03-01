import mi_paquete.*;
import java.util.Scanner;

public class ejercicio_clase3
{
	public static void main(String[] args)
	{
		// EJERCICIO 1.a:
		System.out.println("EJERCICIO 1.a:");
		Scanner sc = new Scanner (System.in);
		System.out.print("- Ingrese un texto: ");
		String a = sc.nextLine();
		Texto texto = new Texto(a);
		System.out.print("- Ingrese UNA letra a buscar en el texto: ");
		char letra = sc.next().charAt(0);
		
		int contador = texto.contarLetras(letra);
		System.out.println("La letra \"" + letra + "\" aparece " + contador + " veces en el texto.");

		// EJERCICIO 1.b
		System.out.println("\nEJERCICIO 1.b:");
		Arreglo v = new Arreglo(3);
		
		System.out.println("- Ingrese los tres numeros del arreglo: ");
		for (int i = 0; i < v.getLength(); i++)
		{
			System.out.print(">>> ");
			int num = sc.nextInt();
			v.set(i, num);
		}
		
		System.out.print("\nIngrese 1 para ordenar de menor a mayor, o 2 para mayor a menor: ");
		int opc = sc.nextInt();
		if (opc == 1)
			v.selectionSortAsc();
		else
			v.selectionSortDesc();
		
		System.out.print("\nArreglo ordenado: ");
		System.out.print(v.toString());
		
		// EJERCICIO 1.c
		System.out.println("\nEJERCICIO 1.c:");
		System.out.print("- Ingrese la cantidad de numeros del vector: ");
		int n = sc.nextInt();
		Arreglo v2 = new Arreglo(n);
		
		System.out.println("- Ingrese los numeros: ");
		for (int i = 0; i < v2.getLength(); i++)
		{
			System.out.print(">>> ");
			int num = sc.nextInt();
			v2.set(i, num);
		}
		
		System.out.println("VECTOR: " + v2.toString());
		System.out.print("- Ingrese numero x: ");
		int x = sc.nextInt();
		
		System.out.print("La suma de los numeros mayores a " + x + " es: " + v2.getSuma(x));
	}
}