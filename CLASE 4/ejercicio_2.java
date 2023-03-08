import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ejercicio_2
{
	public static void main(String[] args)
	{
		String path = "numeros.txt";
		
		int opc;
		System.out.println("Seleccione la operacion a realizar:");
		System.out.println(" 1 - Sumar los numeros del archivo");
		System.out.println(" 2 - Multiplicar los numeros del archivo");
		
		Scanner sc = new Scanner (System.in);
		do
		{
			System.out.print(">>> ");
			opc = sc.nextInt();
		}
		while (opc < 1 || opc > 2);
		
		System.out.println("RESULTADO: " + resultado(path, opc));
	}
	
	public static int resultado(String a, int b)
	{
		File archivo = new File(a);
		
		int res = 0;
		boolean primer_vuelta = true;
		try (Scanner sc = new Scanner(archivo)) // se lee el archivo con un scanner
		{
			while (sc.hasNextInt()) // verifica si se lee un numero en el archivo
			{
				int num = sc.nextInt();
				if (b == 1)
					res += num;
				if (b == 2)
				{
					if (primer_vuelta)
					{
						res = num;
						primer_vuelta = false;
					}
					else
						res *= num;
				}
			}
		}
		catch (FileNotFoundException ex)
		{
			System.out.println("No existe el archivo...");
			return 0;
		}
		return res;
	}
}