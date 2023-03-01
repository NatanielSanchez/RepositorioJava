import mi_paquete.Texto;
import java.util.Scanner;

public class ejercicio_clase3
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner (System.in);
		System.out.print("Ingrese un texto: ");
		String a = sc.nextLine();
		Texto texto = new Texto(a);
		System.out.print("Ingrese UNA letra a buscar en el texto: ");
		char letra = sc.next().charAt(0);
		
		int contador = texto.contarLetras(letra);
		System.out.print("La letra " + letra + " aparece " + contador + " veces en el texto.");
	}
}