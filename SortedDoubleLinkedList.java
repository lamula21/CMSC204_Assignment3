import java.util.Comparator;
import java.util.ListIterator;


import java.util.Collection;
import java.util.Collections;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

//	Node<T> tail;
//	Node<T> head;
	Comparator<T> comparator2;
	
	
	/**
	 * Constructor that initialize a comparator
	 * @param comparator2
	 */
	SortedDoubleLinkedList(Comparator<T> comparator2){
//		this.tail = super.tail;
//		this.head = super.head;
		this.comparator2 = comparator2;
		
	}
	
	
	/**
	 * Inserts the specified element at the correct position in the sorted list.
	 * Notice we can insert the same element several times. 
	 * Your implementation must traverse the list only once in order to perform the insertion. 
	 * Do not implement this method using iterators. 
	 * Notice that you don't need to call any of the super class methods in order to implement this method.
	 * @param data 
	 * @return a reference to the current object
	 */
	public SortedDoubleLinkedList<T> add( T data){

		Node<T> newNode = new Node(null,data,null);
		Node<T> current = head.getNext();
		Node<T> previous = null;
		
		// Traverse from the head.next to the tail
		while(current != null && current.getData() != null &&comparator2.compare(data, current.getData()) >= 1) {
			
			previous = current;
			current = current.getNext();
		}
		

		// If the previous element is null (head)
		// Then add between head and head.next
		if (previous == null)
		{
			newNode = new Node<T>( head, data, head.getNext());

			// Link newNode between head and head.next
			head.getNext().setPrevious(newNode);
			head.setNext(newNode);
			
			// Increment size
			size++;
			
			return this;
		}
		// Otherwise add between previous and current
		else {
			Node<T> predecessor = previous;
			Node<T> succesor = current;
			
			predecessor.setNext(newNode);
			succesor.setPrevious(newNode);
			
			newNode.setPrevious(predecessor);
			newNode.setNext(succesor);
			
			// Increment size
			size++;
			
			return this;
		}
	}
	
	
	
	/**
	 * @throws UnsupportedOperationException if method is called
	 */
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	
	
	/**
	 * @throws UnsupportedOperationException if method is called
	 */
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	
	
	/**
	 * Implements the iterator by calling the super class iterator method.
	 * @override iterator in class BasicDoubleLinkedList<T>
	 * @return an iterator positioned at the head of the list
	 */
	@Override
	public ListIterator<T> iterator(){
		return super.iterator();
		
	}
	
	
	/**
	 * Implements the remove operation by calling the super class remove method.
	 * @override remove in class BasicDoubleLinkedList<T>
	 * @param data - the data element to be removed
	 * @param comparator - the comparator to determine equality of data elements
	 * @return this or null
	 */
	@Override
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
		super.remove(data, comparator);
		return this;
		
	}
	
	
	
}
