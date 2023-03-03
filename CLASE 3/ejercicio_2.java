import mi_paquete.*;
import java.util.Scanner;

public class ejercicio_2
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner (System.in);
		System.out.print("- Ingrese el texto a codificar: \n>>> ");
		String a = sc.nextLine();
		Texto texto = new Texto(a);
		
		int opc;
		do
		{
			System.out.print("- Ingrese 1 para desfase simple, o 2 para desface doble: \n>>> ");
			opc = sc.nextInt();
		}
		while (opc < 1 || opc > 2);
		
		Texto texto_codificado;
		if (opc == 1)
		{
			System.out.println("- Texto codificado (desfase 1): ");
			String b = texto.encode_1();
			texto_codificado = new Texto(b);
			System.out.println(texto_codificado.getTexto());
			
			System.out.println("- Texto de-codificado: ");
			System.out.println(texto_codificado.decode_1());
		}
		else
		{
			System.out.println("- Texto codificado (desfase 2): ");
			String b = texto.encode_2();
			texto_codificado = new Texto(b);
			System.out.println(texto_codificado.getTexto());
			
			System.out.println("- Texto de-codificado: ");
			System.out.println(texto_codificado.decode_2());
		}
	}
}