package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method		
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null){
			throw new NullPointerException("List is empty");			
		}
		
		LLNode<E> n = new LLNode<E>(element);
		n.prev = tail.prev;
		n.next = n.prev.next;
		n.prev.next = n;
		tail.prev = n;
		size++;
		return false;		
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method.		
		
		if (size == 0) {
			throw new IndexOutOfBoundsException("List is empty");
		} 
		
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index Out Of Bounds");
		}
		
		LLNode<E> n = head;			//Create a node to going through the link list
		for(int i=-1; i<index; i++){
			n = n.next;				//Going until index
		}
		return n.data;				//Return node's data
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= size && index != 0) {
			throw new IndexOutOfBoundsException("Index Out Of Bounds");
		}
		
		if(element == null){
			throw new NullPointerException("Element is empty");			
		}
		
		LLNode<E> actual = head;			//Create a node to going through the link list		
		LLNode<E> n = new LLNode<E>(element);	//Create the element to add
		
		for(int i=-1; i<index; i++){
			actual = actual.next;			
		}
		n.next = actual;
		n.prev = actual.prev;
		actual.prev.next = n;
		actual.prev = n;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index Out Of Bounds");
		}
		
		if (size == 0) {
			throw new IndexOutOfBoundsException("List is empty");
		}
		
		LLNode<E> n = head;			//Create a node to going through the link list
		for(int i=-1; i<index; i++){
			n = n.next;				//Going until index
		}
			
		E data = n.data;
		n.prev.next = n.next;
		n.next.prev = n.prev;
		n = null;
		size--;
		return data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element)
	{
		// TODO: Implement this method
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("Index Out Of Bounds");
		}
		
		if(element == null){
			throw new NullPointerException("Element is empty");			
		}
		
		if(size == 0){
			throw new NullPointerException("Element is empty");			
		}
		
		LLNode<E> nodeToAdd = new LLNode<E>(element);	//Create the element to add
		LLNode<E> nodeToDel = head;			//Create a node to going through the link list
		for(int i=-1; i<index; i++){
			nodeToDel = nodeToDel.next;				//Going until index
		}
			
		E data = nodeToDel.data;
		
		nodeToDel.prev.next = nodeToAdd;
		nodeToDel.next.prev = nodeToAdd;
		nodeToAdd.next = nodeToDel.next;
		nodeToAdd.prev = nodeToDel.prev;
		nodeToDel = null;		
		return data;
	}  	
	
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public String toString(){
		return "el nodo" + this + " tiene el dato " + this.data;	
		
	}
	

}
