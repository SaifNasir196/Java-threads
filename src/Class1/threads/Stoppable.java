package Class1.threads;

public class Stoppable implements Runnable {
	
	private boolean stopped = false;
	
	public boolean isStopped() {
		return stopped;
	}

	public void setStopped() {
		this.stopped = true;
	}

	@Override
	public void run() {
		
		System.out.println("SleepExample run method has started.");
		
		while (!stopped) {
			
			System.out.println("Executing run method.");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Stop has been requested.");
	}
	
	public static void main(String[] args) throws InterruptedException {

		Stoppable stoppable  = new Stoppable();
		
		Thread thread = new Thread(stoppable);
		
		thread.start();
		
		Thread.sleep(5000);
		
		stoppable.setStopped();
		
		System.out.println("Exiting main method.");		
	}	
}
