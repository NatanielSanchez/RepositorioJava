package miPaquete;
import java.util.Arrays;

public class Matriz // Clase para crear y manejar matrizes de tipo int
{
    int[][] matriz;

    public Matriz(int f, int c) // genera una matriz de f filas y c columnas
    {
        if (f<=0) f=10;
        if (c<=0) c=10;
        matriz = new int[f][c];
    }

    public int[][] getMatriz()
    {
        return matriz;
    }

    public void setMatriz(int[][] matriz)
    {
        this.matriz = matriz;
    }

    public int getNum(int f, int c) // Devuelve un elemento de la matriz
    {
        return matriz[f][c];
    }

    public void setNum(int f, int c, int x) // Asigno un numero en la casilla [f][c]
    {
        matriz[f][c] = x;
    }
	
	public int[] getFila(int f) // Devuelve una fila (o sea, un arreglo de tipo int)
	{
		return matriz[f];
	}
	
	public int[][] getColumna(int c) // Devuelve una matriz tipo int, representando UNA columna seleccionada con "c"
	{
		int[][] x = new int[matriz.length][1];
		
		for (int f=0; f < matriz.length; f++)
		{
			x[f][0] = matriz[f][c];
		}
		
		return x;
	}

    public int getLengthF() // Retorna la cantidad de Filas de la matriz
    {
        return matriz.length;
    }

    public int getLengthC() // Retorna la cantidad de Columnas de la matriz
    {
        return matriz[0].length;
    }

    public void generate() // llena la matriz con numeros aleatorios
    {
        for (int f = 0; f < matriz.length; f++)
        {
            for (int c = 0; c < matriz[0].length; c++)
            {
                matriz[f][c] = (int) Math.round(100 * Math.random());
            }
        }
    }

    @Override
    public String toString() // Devuelve toda la matriz en texto
    {
        String txt = "";
        for (int f = 0; f < matriz.length; f++)
        {
            txt += "[ " + matriz[f][0] ;
            for (int c = 1; c < matriz[0].length; c++)
            {
                txt += " , " + Integer.toString(matriz[f][c]);
            }
            txt += " ]\n";
        }
        return txt;
    }

    public String toString(String a, String b)
    // Devuelve toda la matriz en texto, con cabeceras para cada fila y cada elemento de la fila
    {
        String txt = "";
        for (int f = 0; f < matriz.length; f++)
        {
            txt +=  a + " " +  Integer.toString(f+1) + " - " ;
            for (int c = 0; c < matriz[0].length; c++)
            {
                txt += b + ": " + Integer.toString(matriz[f][c]);
            }
            txt += "\n";
        }
        return txt;
    }

    public float promedioC(int c) // Devuelve el promedio de la columna c ingresada por parametro
    {
        if (c > matriz[0].length) return -1;
        float total = 0;
        for (int f = 0; f < matriz.length; f++)
        {
            total += matriz[f][c];
        }
        return ( total / (float) matriz.length );
    }

    public void sort() // Ordena los elementos de cada fila de una matriz
    {
        for (int f=0; f < matriz.length; f++)
        {
            for(int c = 0; c < matriz[0].length - 1; c++ )
            {
                for( int j = c + 1; j < matriz[0].length; j++ )
                {
                    if( matriz[f][c] > matriz[f][j] )
                    {
                        int aux = matriz[f][c];
                        matriz[f][c] = matriz[f][j];
                        matriz[f][j] = aux;
                    }
                }
            }
        }
    }
}
