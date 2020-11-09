package lr222qo_assign2.Queue;

import java.util.Iterator;
/**
 * The Queue is used to insert elements at the end of the queue and removes from the beginning of the queue. It follows FIFO concept.
 * @author Leonardo Pedro
 */
public interface Queue {
	  /**
	   * Returns the current size of the Queue.
	   * @return Current length of the queue
	   */
	   public int size();                     // current queue size 
	   /**
	    * A boolean that returns true if empty.
	    * @return
	    */
	   public boolean isEmpty();              // true if queue is empty 
	   /**
	    * Adds object <code>element</code> to the end of the queue.
	    */
	   public void enqueue(Object element);   // add element at end of queue 
	   /**
	    * Retrieves the first element from the front end of the queue, and removes it from the queue.
	    * @return The first queued element.
	    */
	   public Object dequeue();               // return and remove first element. 
	   /**
	    * Retrieves the first element from the front end of the queue.  
	    * @return The first queued Object
	    */
	   public Object first();                 // return (without removing) first element
	   /**
	    * Retrieves the last element from the back end of the queue. 
	    * @return The first queued Object
	    */
	   public Object last();                  // return (without removing) last element 
	   /**
	    * @return A String containing the contents of the Queue.
	    */
	   public String toString();              // return a string representation of the queue content
	   /**
	    * Creates an iterator for this queue.
	    * @return The queue's iterator.
	    */
	   public Iterator<Object> iterator();    // element iterator
}
