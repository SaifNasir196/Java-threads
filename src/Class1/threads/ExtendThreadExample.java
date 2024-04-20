package Class1.threads;

public class ExtendThreadExample extends Thread {

	@Override
	public void run() {
		
		System.out.println("ExtendThreadExample run method has started.");
		System.out.println("ExtendThreadExample run method has ended.");
	}
	
	public static void main(String[] args) {

		ExtendThreadExample thread = new ExtendThreadExample();
		
		thread.start();
	}
}


/*
 * 
 * Thread Class vs Runnable Interface 
 *
 *	- If we extend the Thread class, our class cannot extend any other class because Java doesn’t support multiple inheritance. But, if we implement the Runnable interface, our class can still extend other base classes.
 *
 * 	- We can achieve basic functionality of a thread by extending Thread class because it provides some inbuilt methods like yield(), interrupt() etc. that are not available in Runnable interface.
 *
 *	- Using runnable will give you an object that can be shared amongst multiple threads. 
 */