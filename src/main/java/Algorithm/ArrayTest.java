package Algorithm;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest {

    public static void main(String[] args){
        int[] data = new int[25];
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for(int i=0;i<data.length;i++){
            data[i]=rand.nextInt(100);
        }
        int[] Orig = Arrays.copyOf(data,data.length);
        System.out.println("arrays equal before sort: "+Arrays.equals(data, Orig));
        Arrays.sort(data);
        System.out.println("arrays equal after sort: " + Arrays.equals(data, Orig));
        System.out.println("orig = " + Arrays.toString(Orig));
        System.out.println("data = " + Arrays.toString(data));
    }
}
