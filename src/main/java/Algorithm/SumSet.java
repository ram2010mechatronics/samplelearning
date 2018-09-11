package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class SumSet {
    static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
        int s = 0;
        for (int x: partial) s += x;
        if (s == target)
            System.out.println("sum("+Arrays.toString(partial.toArray())+")="+target);
        if (s >= target)
            return;
        for(int i=0;i<numbers.size();i++) {
            ArrayList<Integer> remaining = new ArrayList<Integer>();
            int n = numbers.get(i);
            for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
            ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
            partial_rec.add(n);
            sum_up_recursive(remaining,target,partial_rec);
        }
    }
    static void sum_up(ArrayList<Integer> numbers, int target) {
        sum_up_recursive(numbers,target,new ArrayList<Integer>());
    }
    public static void main(String args[]) {
        Integer[] numbers = {37,28,16,44,36,37,43,50,22,13,28,41,10,14,27,41,27,23,37,12,19,18,30,33,31,13,24,18,36,30,3,23,9,20,18,44,7,12,43,30,24,22,20,35,38,49,25,16,21,14,27,42,31,7,24,13,21,47,32,6,26,35,28,37,6,47,30,14,8,25,46,33,46,15,18,35,15,44,1,38,9,27,29,39};
        int target = 85;
        sum_up(new ArrayList<Integer>(Arrays.asList(numbers)),target);
    }
}