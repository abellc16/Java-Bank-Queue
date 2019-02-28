/**
 * @author Camby Abell
 * @assignment assg8_Abell
 * @filename QueueInterface.java
 */

package assg8_Abell;

public interface QueueInterface 
{
	/**
	 * Determines whether a queue is empty.
	 * @return true - if the queue is empty.
	 * @return fasle - if the queue is not empty.
	 */
	public boolean isEmpty();
	
	/**
	 * Adds an item to the end of the queue.
	 * @param newItem - the new item added to the end of the queue.
	 */
	public void enqueue(Object newItem);
	
	/**
	 * Retrieves and removes the front of a queue.
	 * @return - the first item in a queue
	 * @throws QueueException if the queue is empty
	 */
	public Object dequeue() throws QueueException;
	
	/**
	 * Removes all of the items in a queue.
	 * @throws QueueException if the queue is empty
	 */
	public void dequeueAll() throws QueueException;
	
	/**
	 * Retrieves the item at the front of a queue.
	 * @return - the first item in a queue
	 * @throws QueueException if the queue is empty
	 */
	public Object peek() throws QueueException;
}
