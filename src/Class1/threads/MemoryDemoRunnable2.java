package Class1.threads;

public class MemoryDemoRunnable2 implements Runnable {
	private int counter = 0;
	public void run() {
		for (int i = 0; i < 100_000; i++) {
			counter++;
		}
		System.out.println(Thread.currentThread().getName() +  " " +  counter);
	}
	public static void main(String[] args) {
		MemoryDemoRunnable2 runnable1 = new MemoryDemoRunnable2();	
		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable1);

		//  we would expect counter = 200,000 since each thread runs 100,000 on same counter
		//  wont happen cuz the threads interfere with each other.
		//  this is because "counter++" is not one atomic operation
		//  it is actually three operations: read, increment, write
		//  so when two threads are running, they can interfere with each other
		//  and the final value of counter will be less than 200,000
		//  to fix this, we need to use synchronization
		//  this is called race conditio

		thread1.start();
		thread2.start();
	}	
}
