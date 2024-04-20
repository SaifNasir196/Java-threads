package Class1.threads;

public class RunnableExample2 implements Runnable {
	
	@Override
	public void run() {
		
		System.out.println("Inside Thread: " + Thread.currentThread().getName());
				
		System.out.println("RunnableExample run method has started.");
		System.out.println("RunnableExample run method has ended.");
	}
	
	public static void main(String[] args) {

		Thread thread0 = new Thread(new RunnableExample2());
		
		thread0.start();

		Thread thread1 = new Thread(new RunnableExample2());
		
		thread1.start();
	}
}
