import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

public class SimpleList // Lista simple enlazada. Los elementos a insertar deben implementar Comparable
{
	private Node frente;
	
	public SimpleList()
	{
		frente = null;
	}
	
	public void addFirst(Comparable x) throws InvalidParameterException
	// Añade un elemento a la lista, en forma de PILA
	{
		if ( !isHomogeneous(x) ) throw new InvalidParameterException("Insercion de elemento no homogeneo.");

		Node p = new Node(x, frente);
		frente = p;
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
	}
	
	public void clear( ) // Limpia la lista
	{
		frente = null;
	}
	
	public Comparable getFirst() throws NoSuchElementException
	// Devuelve el primer elemento
	{
		if (frente == null) throw new NoSuchElementException("Error: Lista vacía.");
		return frente.getInfo();
	}
	
	public Comparable removeFirst() throws NoSuchElementException
	// Devuelve el primer elemento y lo elimina de la lista
	{
		if (frente == null) throw new NoSuchElementException("Error: Lista vacía.");

		Comparable x = frente.getInfo();
		frente = frente.getNext();
		return x;
	}

	public boolean isHomogeneous(Comparable x) // Verifica insercion válida y homogenea
	{
		if (x == null) return false; // NO SE INSERTAN ELEMENTOS NULL
		if (frente != null && x.getClass() != frente.getInfo().getClass()) return false;
		return true;
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
			stb.append(p.toString());
			if ( p.getNext() != null ) stb.append(" - ");
			p = p.getNext();
		}
		
		stb.append(" ]");
		return stb.toString();
	}
}