package mi_paquete;

public class Texto
{
	private String txt;
	
	public Texto()
	{
		txt = "";
	}
	
	public Texto(String a)
	{
		txt = a;
	}
	
	public String getTexto()
	{
		return txt;
	}
	
	public void setTexto(String a)
	{
		txt = a;
	}
	
	public int contarLetras(char letra)
	{
		int cont = 0;
		int size = txt.length();
		
		for (int i=0; i < size; i++)
		{
			if (txt.charAt(i) == Character.toLowerCase(letra) || txt.charAt(i) == Character.toUpperCase(letra))
				cont++;
		}
		
		return cont;
	}
}