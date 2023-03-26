public class Node
{
	private Comparable info;
	private Node next;
	
	public Node( )
	{ 
	}
	
	public Node(Comparable x, Node p)
	{
		info = x;
		next = p;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public void setNext(Node p)
	{
		next = p;
	}
	
	public Comparable getInfo()
	{
		return info;
	}
	
	public void setInfo(Comparable p)
	{
		info = p;
	}
	
	public String toString()
	{
		return info.toString();
	}
	
}