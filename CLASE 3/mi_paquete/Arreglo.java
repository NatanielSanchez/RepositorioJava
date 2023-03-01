package mi_paquete;

public class Arreglo
{
	private int v[]; // Creacion de la referencia a un vector
	
	public Arreglo (int n) // Creacion del objeto vector con n cantidad de elementos tipo int.
	{
		if (n <= 0) 
			n = 100;
		v = new int[n];
	}
	
	public int get(int i) // Retorna el valor contenido en v[i]
	{
		return v[i];
	}
	
	public void set(int i, int x) // Asigna un valor x en la posicion v[i]
	{
		v[i] = x;
	}
	
	public int getLength() // Retorna el tamaño del vector
	{
		return v.length;
	}
	
	public int getSuma(int x) // Retorna la suma de valores mayores a x
	{
		int suma = 0;
		for (int i=0; i < v.length; i++)
		{
			if (v[i] > x)
				suma += v[i];
		}
		return suma;
	}
	
	public void selectionSortAsc() // ORDENAMIENTO POR SELECCION DIRECTA
	{
		int n = v.length;
		for(int i = 0; i < n - 1; i++ )
		{
			for( int j = i + 1; j < n; j++ )
			{
				if( v[i] > v[j] )
				{
					int aux = v[i];
					v[i] = v[j];
					v[j] = aux;
				}
			}
		}
	}
	
	public void selectionSortDesc() // ORDENAMIENTO POR SELECCION DIRECTA DESCENDIENTE
	{
		int n = v.length;
		for(int i = 0; i < n - 1; i++ )
		{
			for( int j = i + 1; j < n; j++ )
			{
				if( v[i] < v[j] )
				{
					int aux = v[i];
					v[i] = v[j];
					v[j] = aux;
				}
			}
		}
	}
	
	public String toString() // Retorna el vector en forma de texto para un buen print
	{
		String txt = "[ " + String.valueOf(v[0]);
		for (int i=1; i < v.length; i++)
		{
			txt += ", ";
			txt += String.valueOf(v[i]);
		}
		txt += " ]";
		return txt;
	}
}