package Class1.threads;

public class JoinExample implements Runnable {
	private float result;
	public void run() {
		System.out.println("JoinExample run method has started.");
		
		for (int i = 0; i < 5; i++) {
            System.out.println("JoinExample2 run method is running.");
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		System.out.println("JoinExample run method has ended.");
	}
	public float getResult() {
		return result;
	}
	public static void main(String[] args) throws InterruptedException {
		JoinExample runnable  = new JoinExample();
		Thread thread = new Thread(runnable);
		thread.start();
		
		// Main thread calls join on ‘thread’ so main thread is blocked until ‘thread’ finishes then main continues
		System.out.println("Waiting for thread to terminate.");
		thread.join();		
		System.out.println("Thread terminated.");
		System.out.println("Main thread continues.");
	}	
}
