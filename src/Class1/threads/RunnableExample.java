package Class1.threads;

public class RunnableExample implements Runnable {
	
	@Override
	public void run() {
		
		System.out.println("RunnableExample run method has started.");
		System.out.println("RunnableExample run method has ended.");
	}
	
	public static void main(String[] args) {

		Thread thread = new Thread(new RunnableExample());
		
		thread.start();
	}
}
