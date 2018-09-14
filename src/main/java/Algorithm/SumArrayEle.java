package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SumArrayEle {
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        int tc = s.nextInt();
        while(tc!=0){
            int e = s.nextInt();
            //int[] arr = new int[e];
            /*for(int j=0; j<e; j++)
                arr[j] = s.nextInt();*/
            int[] arr = Arra(e);
            int[] arr1 = Arra(e);
            int sum = s.nextInt();
            Arrays.sort(arr);
            System.out.println(result(arr,sum));
            tc--;
        }
    }

    public static int result(int[] arr, int sum){
        int lowerIndex,upperIndex;
        if(arr.length>=4){
            for(int i=0;i<arr.length-3;i++) {
                int total=0;
                for (int j = i; j <= i + 3; j++) {
                    total = total + arr[j];
                }
                if (total == sum) return 1;
                else if (total>sum)  {
                    lowerIndex = i-4;
                    upperIndex = i+7;
                    if(lowerIndex<0) lowerIndex = 0;
                    if(upperIndex>arr.length) upperIndex = arr.length;
                    return(arrysplit(arr,sum,lowerIndex,upperIndex));
                }
            }
        }
        return 0;
    }

    public static int arrysplit(int[] arr, int sum, int lowerIndex, int upperIndex){
        ArrayList<Integer> newArr = new ArrayList<>();
        for(int i = lowerIndex;i<upperIndex;i++){
            newArr.add(arr[i]);
        }
       return checkforsum(newArr,sum);
    }

    private static int checkforsum(ArrayList<Integer> newArr, int sum) {
        for(int i =0;i<newArr.size();i++)
            for(int j=i+1;j<newArr.size();j++)
                for(int k = j+1;k<newArr.size();k++)
                    for(int l =k+1;l<newArr.size();l++)
                        if(newArr.get(i)+newArr.get(j)+newArr.get(k)+newArr.get(l)==sum)
                            return 1;
        return 0;
    }

    public static int[] Arra(int size) {
        int[] kickerNumbers = new int[size];
        for (int i = 0; i < kickerNumbers.length; i++) {
            kickerNumbers[i] = randomRange(900, 2359);
        }
        System.out.println(Arrays.toString(kickerNumbers));
        return kickerNumbers;
    }

    public static int randomRange(int min, int max) {
        return (int) Math.round(((Math.random() * (max - min)) + min));
    }
}