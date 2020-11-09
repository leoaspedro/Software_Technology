package lr222qo_assign2.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
	/**
	 * LinkedQueue is an implementation of Queue using
	 * the head-tail approach.
	 * @author Leonardo Pedro
	 *
	 */
	public class LinkedQueue implements Queue {
	private int size = 0;
	private Node head = null;
	private Node tail = null;
   /** 
	* Queue size
	*@return  <code>Integer</code> current size of the queue.
	*
	*/
	@Override
	public int size() {
		return size;
	}
	 /**  
	 * Returns true if the size equals <code>0</code>; The queue is empty.
	 */
	@Override
	public boolean isEmpty() {
		if(size == 0) {
		return true;	
		}
		return false;
	}
	/**
	 * Adds an element <code>element</code> to the the queue.
	 */
	@Override
	public void enqueue(Object element) {
	if ( head == null) {                       // Add first element
		head = new Node(element);
		tail = head;
	
	}
	else {
		tail.next = new Node(element);         //Creating a new element
		tail = tail.next;                      // Update tail
	}
		size++;
	}
	/**
	 * Removes and returns the first element from the list.
	 */
	@Override
	public Object dequeue() {
		
		if(head != null) {
			Object help = head.value;
			head = head.next;
			size--;
			return help;
		}
		
		else {
			throw new NoSuchElementException("Nothing in the queue");
		}
		
	}
	
	/**
	 * Returns the first object in the queue, without removing it.
	 */
	@Override
	public Object first() {
		if(head != null) {
			return head.value;
		}
		else {
			throw new NoSuchElementException("No elements in the queue");
		}
	}
	/**
	 * Returns the last element in the queue, without removing it.
	 */
	@Override
	public Object last() {
		if(head != null) {
			return tail.value;
		}
		else {
				throw new NoSuchElementException("No elements in the queue");
		}
	
	}
	
	
	/**
	 * Returns this iterator for this queue.
	 */
	@Override
	public Iterator<Object> iterator() {
		return new QueueIterator();
	}
	/**
	 * Returns an string of every elements in the Queue.
	 */
	@Override
	public String toString() {
		String text = "";
		Iterator<Object> IT = this.iterator();
		
		while (IT.hasNext())
			text = text +IT.next()+" ";
		
		return text;
		
	}
	
private class QueueIterator implements Iterator<Object>{

	private Node current = head;
	@Override
	public boolean hasNext() {
		if(current != null) {
			return true;
		}
		return false;
	}

	@Override
	public Object next() {
		Object element = current.value;
		current = current.next;
		return element;
	}
	
	
}
}
