import java.util.Iterator;
import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

public class SimpleList <E extends Comparable> implements Iterable<E>
// Lista simple enlazada. Los elementos a insertar deben implementar Comparable
{
	private Node<E> frente;
	private int length;
	
	public SimpleList()
	{
		frente = null;
		length = 0;
	}

	public Iterator<E> iterator()
	{
		return new SimpleListIterator();
	}

	public int getLength()
	{
		return length;
	}

	public void add(int i, E x) throws InvalidParameterException
	// Añade un elemento en la posicion i
	{
		if ( i == 0 ) // Invoco addFirst si i es 0 (o sea, el primer elemento)
		{
			addFirst(x);
			return;
		}
		if ( i > length || i < 0 ) throw new InvalidParameterException("Indice fuera de rango: i = " + i);

		Node<E> p = frente;
		for (int j = 0; j < i-1; j++)
		{
			p = p.getNext();
		}

		// Ahora creo un nuevo nodo, apuntado por el nodo i-1 (p), el cual apunta al siguiente de p.
		p.setNext( new Node(x, p.getNext() ) );
		length++;
	}

	public void addInOrder(E x) throws InvalidParameterException
	// Añade un objeto x de forma ordenada, segun su implementacion del metodo compareTo()
	{
		if ( x == null ) throw new InvalidParameterException("Insercion de objeto null");

		Node<E> nuevo = new Node<>(x, null);
		Node<E> p = frente, q = null; // p es el puntero "actual", q es el anterior a p
		while(p != null && x.compareTo(p.getInfo()) >= 0) // Si p no es null, y x es mayor o igual a p...
		{
			q = p; // ... pongo el actual en anterior...
			p = p.getNext(); // y muevo el puntero actual al siguiente.
		}
		// Se inserta el nuevo en el medio de p y q
		nuevo.setNext( p );
		if( q != null ) q.setNext( nuevo );
		else frente = nuevo;
	}

	public void addFirst(E x)
	// Añade un elemento a la lista, en forma de PILA
	{
		Node<E> p = new Node(x, frente);
		frente = p;
		length++;
	}

	public void addLast(E x)
	// Añade un elemento a la lista, en forma de COLA
	{
		Node<E> p = frente;
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

	public E getFirst() throws NoSuchElementException
	// Devuelve el primer elemento
	{
		if (frente == null) throw new NoSuchElementException("Error: Lista vacía.");
		return frente.getInfo();
	}

	public E get(int i) throws InvalidParameterException
	// Devuelve el objeto en el indice i
	{
		if (i >= length || i < 0)
			throw new InvalidParameterException("Indice fuera de rango: i = " + i + " | Ultimo elemento: " + (length-1));
		if (i == 0) return getFirst();

		Node<E> p = frente;
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
	
	public E removeFirst() throws NoSuchElementException
	// Devuelve el primer elemento y lo elimina de la lista
	{
		if (frente == null) throw new NoSuchElementException("Error: Lista vacía.");

		E x = frente.getInfo();
		frente = frente.getNext();
		length--;
		return x;
	}

	public E remove(int i) throws InvalidParameterException
	// Devuelve el objeto en el indice i y lo elimina de la lista
	{
		if (i >= length || i < 0)
			throw new InvalidParameterException("Indice fuera de rango: i = " + i + " | Ultimo elemento: " + (length-1));
		if (i == 0)
		{
			return removeFirst();
		}

		Node<E> p = frente;
		for (int j = 0; j < i-1; j++)
		{
			p = p.getNext();
		}
		Node<E> aux = p.getNext();
		p.setNext( aux.getNext() );
		length--;
		return aux.getInfo();
	}

	public void set(int i, E x) throws InvalidParameterException
	// Cambio el objeto en i por el objeto x
	{
		if (i >= length || i < 0)
			throw new InvalidParameterException("Indice fuera de rango: i = " + i + " | Ultimo elemento: " + (length-1));

		Node<E> p = frente;
		for (int j = 0; j < i; j++)
		{
			p = p.getNext();
		}
		p.setInfo(x);
	}

	public int indexOf(E x)
	// Verifica si el elemento x está en la lista. Devuelve su indice si lo encuentra, o -1 de lo contrario.
	{
		int i = 0;
		Node<E> p = frente;
		for (int j = 0; j < length; j++)
		{
			if (p.getInfo().compareTo(x) == 0) return i;

			p = p.getNext();
			i++;
		}
		return -1;
	}

	public boolean contains(E x) // Verifica si el elemento x está en la lista
	{
		Node<E> p = frente;
		while (p != null && x.compareTo( p.getInfo() ) != 0)
		{
			p = p.getNext();
		}
		return (p != null);
	}

	public E greaterObject()
	// Devuelve el mayor elemento de la lista, segun el metodo compareTo()
	{
		Node<E> p = frente;
		E mayor = p.getInfo();

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
		Node<E> p = frente;
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

	/** Iterador de la clase SimpleList
	 *
	 */
	public class SimpleListIterator implements Iterator<E>
	{
		private Node<E> actual; // dirección del nodo que toca procesar.
		private Node<E> previo; // dirección del nodo anterior al actual.
		public SimpleListIterator()
		{
			actual = null;
			previo = null;
		}

		/**
		 * Indica si queda algun objeto en el recorrido del iterador.
		 * @return true si queda algun objeto en el recorrido - false si no
		 * quedan objetos.
		 */
		public boolean hasNext()
		{
			if (frente == null) return false;
			if (actual != null && actual.getNext() == null) return false;
			return true;
		}

		/**
		 * Retorna el siguiente objeto en el recorrido del iterador. *
		 * @return el siguiente objeto en el recorrido.
		 * @throws NoSuchElementException si la lista esta vacia o en la lista
		 * no quedan elementos por recorrer.
		 */
		public E next()
		{
			if (!hasNext()) throw new NoSuchElementException("No quedan elementos");

			if (actual == null)
			{
				actual = frente;
			}
			else
			{
				previo = actual;
				actual = actual.getNext();
			}
			return actual.getInfo();
		}
		/**
		 * Elimina el objeto actual del iterador. El iterador queda ubicado en el
		 * elemento siguiente al eliminado.
		 */
		public void remove()
		{
			Node<E> aux = actual;
			if (actual != null)
			{
				if (previo == null)
				{
					frente = actual.getNext();
				}
				else
				{
					previo.setNext(actual.getNext());
				}
				actual = actual.getNext();
				aux.setNext(null);
			}
			else throw new NoSuchElementException();
		}
	}
}