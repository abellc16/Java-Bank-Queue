/**
 * @author Camby Abell
 * @assignment assg8_Abell
 * @filename Process.java
 */
package assg8_Abell;

public class Process 
{
	// Declarations
	private int arrival;
	private int transTime;
	private int depTime;
	
	/**
	 * Default constructor for a Process, although rare it is necessary.
	 */
	public Process()
	{
		arrival = 0;
		transTime = 0;
		depTime = 0;
	}
	
	/**
	 * Constructor for a Process.
	 * @param a - the arrival time of a Process
	 * @param t - the time it takes for a Process to complete
	 */
	public Process(int a, int t)
	{
		arrival = a;
		transTime = t;
		depTime = a + t;
	}
	
	/**
	 * getArrival() returns the arrival time of a Process.
	 * @return - the arrival time of a Process.
	 */
	public int getArrival()
	{
		return this.arrival;
	}
	
	/**
	 * getTransTime() returns the transaction time of a Process to complete.
	 * @return - the transaction time of a Process to complete.
	 */
	public int getTransTime()
	{
		return this.transTime;
	}
	
	public int getDepTime()
	{
		return this.depTime;
	}
	
	/**
	 * setArrival() will set the arrival time of a Process.
	 * @param a - the time of an arrival.
	 */
	public void setArrival(int a)
	{
		this.arrival = a;
	}
	
	/**
	 * setTransTime() will set the transaction time of a Process.
	 * @param t
	 */
	public void setTransTime(int t)
	{
		this.transTime = t;
	}
	
	/**
	 * setDepTime() will set the departure time of a Process
	 * @param x - an amount of time that will be subtracted to find DepTime.
	 */
	public void setDepTime(int x)
	{
		this.depTime = this.transTime + x;
	}
	
	/**
	 * toString() will print the information of a Process in a clear and readable format.
	 */
	public String toString()
	{
		return "Arr time: " + this.getArrival() + " Trans time: " + this.getTransTime() 
			 + " Dep Time: " + this.getDepTime();
	}
}
