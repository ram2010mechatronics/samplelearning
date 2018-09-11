package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class SumArrayEle {
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        int tc = s.nextInt();
        while(tc!=0){
            int e = s.nextInt();
            int[] arr = new int[e];
            for(int j=0; j<e; j++)
                arr[j] = s.nextInt();
            int sum = s.nextInt();
           // System.out.println(result(new ArrayList<Integer> (Arrays.asList(arr)),sum));
            tc--;
        }
    }

    public static int result(int[] arr,int arr_size,int sum){
        int l, r;
        l = 0;
        r = arr_size-1;
        if(arr.length>=4){
            while(l<r){
                if(arr[l] + arr[l+1] + arr[r-1] + arr[r] == sum)
                    return 1;
                else if((arr[l] + arr[l+1] + arr[r-1] + arr[r]) < sum)
                    l++;
                else
                    r--;
            }
        }
        return 0;
    }
}
