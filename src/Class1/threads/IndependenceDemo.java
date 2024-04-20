package Class1.threads;

public class IndependenceDemo implements Runnable {
	
	public void run() {
		
		while (true) {
			
			System.out.println("Executing thread run method.");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {

		IndependenceDemo stoppable  = new IndependenceDemo();
		Thread thread = new Thread(stoppable);
		thread.start();
		Thread.sleep(4000);
		System.out.println("Exiting main method.");		
	}	
}
