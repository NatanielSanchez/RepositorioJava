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
	
	public String encode_1() // Codifica el texto con desfase 1, usando la tabla ASCII
	{
		String encoded_text = "";
		
		for (int i=0; i < txt.length(); i++)
		{
			char c = txt.charAt(i);

			int num = c;
			if (num == 126)
				c = (char) 32;
			else
			{
				num++;
				c = (char) num;
			}
			encoded_text = encoded_text + c;
		}
		return encoded_text;
	}
	
	public String encode_2() // Codifica el texto con desfase 2, usando la tabla ASCII
	{
		String encoded_text = "";
		
		for (int i=0; i < txt.length(); i++)
		{
			char c = txt.charAt(i);
			
			int num = c;
			if (num == 125)
				c = (char) 32;
			else
			{
				if (num == 126)
					c = (char) 33;
				else
				{
					num += 2;
					c = (char) num;
				}
			}
			encoded_text = encoded_text + c;
		}
		return encoded_text;
	}
	
	public String decode_1() // Decodifica el texto
	{
		String decoded_text = "";
		
		for (int i=0; i < txt.length(); i++)
		{
			char c = txt.charAt(i);
			
			int num = c;
			if (num == 32)
				c = (char) 126;
			else
			{
				num--;
				c = (char) num;
			}
			decoded_text = decoded_text + c;
		}
		return decoded_text;
	}
	
	public String decode_2() // Decodifica el texto
	{
		String decoded_text = "";
		
		for (int i=0; i < txt.length(); i++)
		{
			char c = txt.charAt(i);
			
			int num = c;
			if (num == 33)
				c = (char) 126;
			else
			{
				if (num == 32)
					c = (char) 125;
				else
				{
					num -= 2;
					c = (char) num;
				}
			}
			decoded_text = decoded_text + c;
		}
		return decoded_text;
	}
}