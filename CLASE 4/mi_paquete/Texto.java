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
	
	
	public String encode(int desfaze) // Codifica el texto, usando la tabla ASCII
	{
		String encoded_text = "";
		
		for (int i=0; i < txt.length(); i++)
		{
			char c = txt.charAt(i);

			int num = c;
			num += desfaze;
			while (num > 126)
			{
				num = num - 126 + 32;
			}
			c = (char) num;
			encoded_text = encoded_text + c;
		}
		return encoded_text;
	}
	
	public String decode(int desfaze) // Decodifica el texto
	{
		String decoded_text = "";
		
		for (int i=0; i < txt.length(); i++)
		{
			char c = txt.charAt(i);
			
			int num = c;
			num -= desfaze;
			while (num < 32)
			{
				num = num + 126 - 32;
			}
			c = (char) num;
			decoded_text = decoded_text + c;
		}
		return decoded_text;
	}
}