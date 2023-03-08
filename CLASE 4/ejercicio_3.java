import mi_paquete.*;
import java.util.Scanner;
import java.io.File; 
import java.io.FileWriter; 
import java.io.IOException;

public class ejercicio_3
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner (System.in);
		File entrada = new File("texto_original.txt");
		File salida = new File("texto_procesado.txt");
		
		System.out.println("*** SELCCIONE LA ACCION A REALIZAR: ***");
		System.out.println("1- Codificar un texto.");
		System.out.println("2- De-codificar un texto.");
		int opc;
		do
		{
			System.out.print(">>> ");
			opc = sc.nextInt();
			sc.nextLine(); // se "come" el \n de input anterior
		}
		while (opc < 1 || opc > 2);
		
		System.out.println("\n*** INGRESE EL TEXTO: ***");
		System.out.print(">>> ");
		String a = sc.nextLine();
		Texto txt = new Texto(a);
		
		System.out.println("\n*** INGRESE EL VALOR DE DESPLAZO (entre 1 y 1000): ***");
		int desfaze;
		do
		{
			System.out.print(">>> ");
			desfaze = sc.nextInt();
		}
		while (desfaze < 1 || desfaze > 1000);
		sc.close();
		
		Texto texto_final = new Texto(procesarTexto(txt, opc, desfaze)); // procesa el texto ingresado segun las opciones seleccionadas
		writeFiles(txt, texto_final, entrada, salida); // escribe los archivos
		System.out.println("\nArchivos generados en " + entrada.getAbsoluteFile().getParent());
	}
	
	public static String procesarTexto(Texto txt, int opc, int desfaze)
	{
		String texto_procesado;
		
		if (opc == 1)
		{
			texto_procesado = txt.encode(desfaze);
			return texto_procesado;
		}
		else
		{
			texto_procesado = txt.decode(desfaze);
			return texto_procesado;
		}
	}
	
	public static void writeFiles(Texto txt_in, Texto txt_out, File a, File b)
	{
		try
		{
			a.createNewFile();
			b.createNewFile();
			FileWriter escritor_A = new FileWriter(a);
			FileWriter escritor_B = new FileWriter(b);
			
			escritor_A.write(txt_in.getTexto());
			escritor_A.close();
			escritor_B.write(txt_out.getTexto());
			escritor_B.close();
		}
		catch (Exception ex)
		{
			System.out.println("Algo salio mal...");
		}
	}
}