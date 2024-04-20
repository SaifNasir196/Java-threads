package Class1.threads;

public class JoinExample2 implements Runnable {
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run method has started.");
        
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " run method is running. " + i);
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println(Thread.currentThread().getName() + " run method has ended.");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new JoinExample2());
        Thread thread2 = new Thread(new JoinExample2());

        thread1.start();

        // uncomment this to see what happens when threads join
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        thread2.start();

    }
}
