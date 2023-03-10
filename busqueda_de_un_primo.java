import java.util.Scanner;
import java.io.File;

public class busqueda_de_un_primo // busca el primer numero primo de un archivo con numeros
{	
	public static void main(String[] args)
	{
		File file = new File("numeros.txt");
		
		System.out.println("SE BUSCA EL PRIMER NUMERO PRIMO DEL ARCHIVO EN " + file.getAbsolutePath());
		try (Scanner sc = new Scanner(file))
		{
			while (sc.hasNextInt())
			{
				int num = sc.nextInt();
				if (isPrime(num))
				{
					System.out.println("PRIMER PRIMO ENCONTRADO: " + num);
					break;
				}
			}
		}
		catch (Exception ex)
		{
			System.out.println("Algo salio mal... ");
		}
	}
	
	public static boolean isPrime (int x)
	{
		if (x == 2 || (x%2) == 0)
				return false;
		
		for (int i = 3; i< (x/2); i++)
		{
			if ( (x%i) == 0 )
				return false;
		}
		return true;
	}
}