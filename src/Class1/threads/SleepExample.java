package Class1.threads;

public class SleepExample implements Runnable {
	
	@Override
	public void run() {
		
		System.out.println("SleepExample run method has started.");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("SleepExample run method has ended.");
	}
	
	public static void main(String[] args) {

		Thread thread = new Thread(new SleepExample());
		
		thread.start();
	}
}
