import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

public class SimpleList // Lista simple enlazada. Los elementos a insertar deben implementar Comparable
{
	private Node frente;
	private int length;
	
	public SimpleList()
	{
		frente = null;
		length = 0;
	}

	public int getLength()
	{
		return length;
	}

	public void add(int i, Comparable x) throws InvalidParameterException
	// Añade un elemento en la posicion i
	{
		if ( !isHomogeneous(x) ) throw new InvalidParameterException("Insercion de elemento no homogeneo.");
		if ( i == 0 ) // Invoco addFirst si i es 0 (o sea, el primer elemento)
		{
			addFirst(x);
			return;
		}
		if ( i > length || i < 0 ) throw new InvalidParameterException("Indice fuera de rango: i = " + i);

		Node p = frente;
		for (int j = 0; j < i-1; j++)
		{
			p = p.getNext();
		}

		// Ahora creo un nuevo nodo, apuntado por el nodo i-1 (p), el cual apunta al siguiente de p.
		p.setNext( new Node(x, p.getNext() ) );
		length++;
	}

	public void addFirst(Comparable x) throws InvalidParameterException
	// Añade un elemento a la lista, en forma de PILA
	{
		if ( !isHomogeneous(x) ) throw new InvalidParameterException("Insercion de elemento no homogeneo.");

		Node p = new Node(x, frente);
		frente = p;
		length++;
	}

	public void addLast(Comparable x) throws InvalidParameterException
	// Añade un elemento a la lista, en forma de COLA
	{
		if ( !isHomogeneous(x) ) throw new InvalidParameterException("Insercion de elemento no homogeneo.");

		Node p = frente;
		if (p == null) // Si la lista esta vacía, simplemente se añade el elemento
		{
			p = new Node(x, frente);
			frente = p;
		}
		else
		{
			while (p != null)
			{
				if (p.getNext() == null)
				{
					p.setNext(new Node(x, null));
					break;
				}
				p = p.getNext();
			}
		}
		length++;
	}

	public Comparable getFirst() throws NoSuchElementException
	// Devuelve el primer elemento
	{
		if (frente == null) throw new NoSuchElementException("Error: Lista vacía.");
		return frente.getInfo();
	}

	public Comparable get(int i) throws InvalidParameterException
	// Devuelve el objeto en el indice i
	{
		if (i >= length || i < 0)
			throw new InvalidParameterException("Indice fuera de rango: i = " + i + " | Ultimo elemento: " + (length-1));
		if (i == 0) return getFirst();

		Node p = frente;
		for (int j = 0; j < i; j++)
		{
			p = p.getNext();
		}
		return p.getInfo();
	}
	
	public void clear( ) // Limpia la lista
	{
		frente = null;
		length = 0;
	}
	
	public Comparable removeFirst() throws NoSuchElementException
	// Devuelve el primer elemento y lo elimina de la lista
	{
		if (frente == null) throw new NoSuchElementException("Error: Lista vacía.");

		Comparable x = frente.getInfo();
		frente = frente.getNext();
		length--;
		return x;
	}

	public Comparable remove(int i) throws InvalidParameterException
	// Devuelve el objeto en el indice i y lo elimina de la lista
	{
		if (i >= length || i < 0)
			throw new InvalidParameterException("Indice fuera de rango: i = " + i + " | Ultimo elemento: " + (length-1));
		if (i == 0)
		{
			return removeFirst();
		}

		Node p = frente;
		for (int j = 0; j < i-1; j++)
		{
			p = p.getNext();
		}
		Node aux = p.getNext();
		p.setNext( aux.getNext() );
		length--;
		return aux.getInfo();
	}

	public void set(int i, Comparable x) throws InvalidParameterException
	// Cambio el objeto en i por el objeto x
	{
		if ( !isHomogeneous(x) ) throw new InvalidParameterException("Insercion de elemento no homogeneo.");
		if (i >= length || i < 0)
			throw new InvalidParameterException("Indice fuera de rango: i = " + i + " | Ultimo elemento: " + (length-1));

		Node p = frente;
		for (int j = 0; j < i; j++)
		{
			p = p.getNext();
		}
		p.setInfo(x);
	}

	public boolean isHomogeneous(Comparable x) // Verifica insercion válida y homogenea
	{
		if (x == null) return false; // NO SE INSERTAN ELEMENTOS NULL
		if ( frente != null && x.getClass() != frente.getInfo().getClass() ) return false;
		return true;
	}

	public int indexOf(Comparable x)
	// Verifica si el elemento x está en la lista. Devuelve su indice si lo encuentra, o -1 de lo contrario.
	{
		if (!isHomogeneous(x)) return -1;

		int i = 0;
		Node p = frente;
		for (int j = 0; j < length; j++)
		{
			if (p.getInfo().compareTo(x) == 0) return i;

			p = p.getNext();
			i++;
		}
		return -1;
	}

	public boolean contains(Comparable x) // Verifica si el elemento x está en la lista
	{
		if (!isHomogeneous(x)) return false;

		Node p = frente;
		while (p != null && x.compareTo(p.getInfo()) != 0)
		{
			p = p.getNext();
		}
		return (p != null);
	}

	public Comparable higherObject()
	// Devuelve el mayor elemento de la lista, segun el metodo compareTo()
	{
		Node p = frente;
		Comparable mayor = p.getInfo();

		while (p != null)
		{
			if ( p.getInfo().compareTo(mayor) > 0 )
			{
				mayor = p.getInfo();
			}
			p = p.getNext();
		}
		return mayor;
	}

	public String toString()
	// Devuelve la informacion de la lista en un String.
	// ! Se recomienda que los objetos de la lista tengan un toString() !
	{
		Node p = frente;
		StringBuilder stb = new StringBuilder("[ ");
		
		while( p != null )
		{
			stb.append( p.toString() );
			if ( p.getNext() != null ) stb.append(" - ");
			p = p.getNext();
		}
		
		stb.append(" ]");
		return stb.toString();
	}

}