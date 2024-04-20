package Class1.threads;

public class LambdaExample {
	
	public static void main(String[] args) {

		Runnable runnable  = () -> {
			System.out.println("LambdaExample run method has started.");
			System.out.println("LambdaExample run method has ended.");
		};
		
		Thread thread = new Thread(runnable);
		
		thread.start();
	}
}
