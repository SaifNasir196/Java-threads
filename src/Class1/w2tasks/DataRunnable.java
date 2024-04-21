package Class1.w2tasks;
import java.math.BigInteger;
import java.util.List;

public class DataRunnable implements Runnable {
    
    private List<BigInteger> slice;
    private BigInteger mean = BigInteger.ZERO;
    public DataRunnable(List<BigInteger> slicedData) {
        this.slice = slicedData;
    }

    @Override
    public void run() {
        BigInteger sum = BigInteger.ZERO;
        
        for (BigInteger num : slice) {
            sum = sum.add(num);
        }
        // System.out.println("Sum: " + sum);
        mean = sum.divide(BigInteger.valueOf(slice.size()));
    }

    public BigInteger getMean() {
        return mean;
    }

}
