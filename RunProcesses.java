/**
 * @author Camby Abell
 * @assignment assg8_Abell
 * @filename RunProcesses.java
 */

package assg8_Abell;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class RunProcesses 
{
	public static void main(String[] args) 
	{
		// Declarations
		Queue processQueue = new Queue();
		LinkedList<Process> tempList = new LinkedList<Process>();
		LinkedList<Process> eList = new LinkedList<Process>();
		int currentTime = 0;
		int numEvents = 0;
		
		// Read in data and store them all in the queue
		try {
			Scanner f = new Scanner(new File("QueueInput.txt"));
			
			while(f.hasNextInt())
			{
				int a = f.nextInt();
				int t = f.nextInt();
				
				Process p = new Process(a, t);
				processQueue.enqueue(p);
				numEvents++;
			}
			f.close();
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
				
		// Pull out first event and set time to the event start time
		try {
			Process temp = (Process) processQueue.dequeue();
			tempList.add(temp);
			eList.add(temp);
			currentTime = temp.getArrival();
			System.out.println("Simulation beginning...");
			System.out.println("Processing an arrival at time: " + temp.getArrival());
		}
		catch (QueueException e) {
			System.out.println(e);
		}
				
		// Continue pulling out and processing events.
		while(!processQueue.isEmpty())
		{
			try {
				Process temp = (Process) processQueue.dequeue();
				temp.setDepTime(tempList.peekLast().getDepTime());
				
				// If the new arrival time is greater than all current departure times.
				if(temp.getArrival() > (tempList.peekLast().getDepTime()))
				{
					temp.setDepTime(temp.getArrival());
				}
				int tempTime = temp.getArrival();
				
				// Iterate through list to find all departure times before the new current time.
				for(int i = 0; i < tempList.size(); i++)
				{
					if(tempList.get(i).getDepTime() <= tempTime)
					{
						System.out.println("Processing a departure at time: " + tempList.get(i).getDepTime());
						tempList.remove(i);
					}
				}
				
				// Add new process to both event lists
				tempList.add(temp);
				eList.add(temp);
				
				// Add the new arrival to the output and set the new current time.
				if(temp.getArrival() > currentTime)
				{
					System.out.println("Processing an arrival at time: " + temp.getArrival());
					currentTime = temp.getArrival();
				}
			}
			catch (QueueException e) {
				System.out.println(e);
			}
		}
		
		// Display final departure to the output.
		System.out.println("Processing a departure at: " + eList.getLast().getDepTime());

		// Figure out the average wait time
		int[] waitTime = new int[numEvents];
		double avgWait = 0.0;
		for(int i = 0; i < eList.size(); i++)
		{
			waitTime[i] = eList.get(i).getDepTime() - eList.get(i).getArrival();
		}
		avgWait = IntStream.of(waitTime).sum() / numEvents;
		
		// Final statistics
		System.out.println("\nFinal Statistics: ");
		System.out.println("Total people processed: " + numEvents);
		System.out.println("Average amount of time spent waiting: " + avgWait);
	}
}
