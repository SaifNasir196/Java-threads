package Class1.w2tasks;
import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private Data data;
    private List<List<BigInteger>> slicedData;
    private List<Thread> threads = new ArrayList<>();
    private List<DataRunnable> runnables = new ArrayList<>();

    public Main(int size) {
        this.data = new Data(size);
    }
    

    public BigInteger calculateMean(int slices) {
        slicedData = data.createSlices(slices);
        
        // Create and start threads 
        for (List<BigInteger> slice: slicedData) {
            DataRunnable dr = new DataRunnable(slice);
            runnables.add(dr);

            Thread t = new Thread(dr);
            threads.add(t);
            t.start();
        }

        // Wait for all threads to finish
        for (Thread t: threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Compute the mean of means
        BigInteger sum = BigInteger.ZERO;
        for (DataRunnable dr: runnables) {
            sum = sum.add(dr.getMean());
        }
        return sum.divide(BigInteger.valueOf(slices));
    }



    public static void main(String[] args) {
        Main main = new Main(32000);

        int[] slices = {1, 2, 4, 8, 16, 32, 64};
        long[] meanTimes = new long[slices.length];

        for (int i = 0; i < slices.length; i++){

            long totalTimes = 0L;
            for (int j = 0; j < 10; j++) {
                long start = System.nanoTime();
                
                main.calculateMean(slices[i]);
                
                totalTimes += System.nanoTime() - start;
            }
            meanTimes[i] = totalTimes / 10;

        }

        for (int i = 0; i < slices.length; i++) {
            System.out.println("Mean time for " + slices[i] + " slices: " + meanTimes[i]/100 + " ns");
        }
    }
}
