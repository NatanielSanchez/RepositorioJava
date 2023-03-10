import java.io.File;
import java.io.FileWriter;

public class crear_y_escribir_un_archivo // crea y escribe un archivo con numeros separados por un espacio
{
	public static void main(String[] args)
	{
		File file = new File("numeros.txt");
		try
		{
			if (file.exists())
			{
				file.delete();
				file.createNewFile();
			}
			
			FileWriter escritor = new FileWriter(file);
			Integer numero = 0;
			for (int i = 0; i < 20; i++)
			{
				numero = Integer.valueOf( (int) Math.round(1000 * Math.random()) );
				escritor.write( numero.toString());
				escritor.write( " " ); // cambie este caracter a cualquier caracter que se quiera usar como separador
			}
			escritor.close();
		}
		catch (Exception ex)
		{
			System.out.println("Algo salio mal... ");
		}
	}
}