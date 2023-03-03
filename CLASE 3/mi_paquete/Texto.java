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
	
	public String encode_1()
	{
		String code_table = "abcdefghijklmnñopqrstuvwxyz";
		String encoded_text = "";
		
		for (int i=0; i < txt.length(); i++)
		{
			char c = txt.charAt(i);
			if (c == ' ')
			{
				encoded_text = encoded_text + "$";
				continue;
			}
			
			int index = code_table.indexOf(c);
			if (index == (code_table.length() - 1))
				encoded_text = encoded_text + code_table.charAt(0);
			else
				encoded_text = encoded_text + code_table.charAt(index+1);
		}
		return encoded_text;
	}
	
	public String encode_2()
	{
		String code_table = "abcdefghijklmnñopqrstuvwxyz";
		String encoded_text = "";
		
		for (int i=0; i < txt.length(); i++)
		{
			char c = txt.charAt(i);
			if (c == ' ')
			{
				encoded_text = encoded_text + "$";
				continue;
			}
			
			int index = code_table.indexOf(c);
			if (index == (code_table.length() - 1))
				encoded_text = encoded_text + code_table.charAt(1);
			else
			{
				if (index == (code_table.length() - 2))
					encoded_text = encoded_text + code_table.charAt(0);
				else
					encoded_text = encoded_text + code_table.charAt(index+2);
			}
		}
		return encoded_text;
	}
	
	public String decode_1()
	{
		String code_table = "abcdefghijklmnñopqrstuvwxyz";
		String decoded_text = "";
		
		for (int i=0; i < txt.length(); i++)
		{
			char c = txt.charAt(i);
			if (c == '$')
			{
				decoded_text = decoded_text + " ";
				continue;
			}
			
			int index = code_table.indexOf(c);
			if (index == 0)
				decoded_text = decoded_text + code_table.charAt(code_table.length() - 1);
			else
				decoded_text = decoded_text + code_table.charAt(index-1);
		}
		return decoded_text;
	}
	
	public String decode_2()
	{
		String code_table = "abcdefghijklmnñopqrstuvwxyz";
		String decoded_text = "";
		
		for (int i=0; i < txt.length(); i++)
		{
			char c = txt.charAt(i);
			if (c == '$')
			{
				decoded_text = decoded_text + " ";
				continue;
			}
			
			int index = code_table.indexOf(c);
			if (index == 1)
				decoded_text = decoded_text + code_table.charAt(code_table.length() - 1);
			else
			{
				if (index == 0)
					decoded_text = decoded_text + code_table.charAt(code_table.length() - 2);
				else
					decoded_text = decoded_text + code_table.charAt(index-2);
			}
		}
		return decoded_text;
	}
}