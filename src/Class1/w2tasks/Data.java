

package Class1.w2tasks;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<BigInteger> data = new ArrayList<>();
    private int length;

    public Data(int length) {
        this.length = length;
        setData();
    
    }

    private void setData() {
        for (int i = 0; i < length; i++) {
            data.add(BigInteger.valueOf(i));
        }
    }

    public List<List<BigInteger>> createSlices(int slices) {
        int sliceSize = length / slices;
        List<List<BigInteger>> slicedData = new ArrayList<>();

        for(int i = 0; i < slices; i++) {
            slicedData.add(new ArrayList<>());
            for (int j = 0; j < sliceSize; j++) {
                BigInteger num = data.get(i * sliceSize + j).add(BigInteger.ONE);
                slicedData.get(i).add(num);
            }
        }

        return slicedData;
    }


}

