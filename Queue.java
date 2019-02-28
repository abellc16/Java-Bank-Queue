/**
 * @author Camby Abell
 * @assignment assg8_Abell
 * @filename Queue.java
 */

package assg8_Abell;

public class Queue implements QueueInterface
{
	private Node<Process> lastNode;
	
	/**
	 * Creates a new, empty queue.
	 * Default constructor.
	 */
	public Queue()
	{
		lastNode = null;
	}
	
	/**
	 * Determines whether a queue is empty.
	 * @return true - if the queue is empty.
	 * @return false - if the queue is not empty.
	 */
	public boolean isEmpty()
	{
		return lastNode == null;
	}
	
	/**
	 * Retrieves and removes the front of a queue.
	 * @return - the first item in a queue
	 * @throws QueueException if the queue is empty
	 */
	public Object dequeue() throws QueueException
	{
		if(isEmpty() == false)
		{
			Node<Process> firstNode = lastNode.getNext();
			
			if(firstNode.equals(lastNode))
			{
				lastNode = null;
			}
			else
			{
				lastNode.setNext(firstNode.getNext());
			}
			
			return firstNode.getItem();
		}
		else
		{
			throw new QueueException("QueueException on dequeue: queue empty.");
		}
	}
	
	/**
	 * Removes all of the items in a queue.
	 * @throws QueueException if the queue is empty
	 */
	public void dequeueAll()
	{
		lastNode = null;
	}
	
	/**
	 * Retrieves the item at the front of a queue.
	 * @return - the first item in a queue
	 * @throws QueueException if the queue is empty
	 */
	public Object peek() throws QueueException
	{
		if(!isEmpty() == true)
		{
			Node<Process> firstNode = lastNode.getNext();
			return firstNode.getItem();
		}
		else
		{
			throw new QueueException("QueueException on peek: queue empty");
		}
	}

	/**
	 * Adds an item to the end of the queue.
	 * @param newItem - the new item added to the end of the queue.
	 * @throws QueueException if the item cannot be added to the queue.
	 */
	public void enqueue(Object newItem) 
	{
		Node<Process> newNode = new Node<Process>((Process) newItem);
		
		if(isEmpty() == true)
		{
			newNode.setNext(newNode);
		}
		else
		{
			newNode.setNext(lastNode.getNext());
			lastNode.setNext(newNode);
		}
		
		lastNode = newNode;
	}
}
