package Algorithm;

import java.util.*;
import java.lang.*;
import java.io.*;

class MinimumPlatform2 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int n = 0;
        for (int i=0;i<T;i++) {
            n = in.nextInt();
            int[] arr = new int[n];
            int[] dep = new int[n];
            for (int j=0;j<n;j++) {
                arr[j] = in.nextInt();
            }
            for (int j=0;j<n;j++) {
                dep[j] = in.nextInt();
            }
            for (int j = 0; j < n; j++) {
                if (arr[j] > dep[j]) {
                    dep[j] += 2400;
                }
            }
            //Arrays.sort(arr);
            //Arrays.sort(dep);
            TreeMap<Integer, List<Character>> map = new TreeMap<>();
            for (int j = 0; j < n; j++) {
                map.putIfAbsent(arr[j], new ArrayList<>());
                map.putIfAbsent(dep[j], new ArrayList<>());
                map.get(arr[j]).add('a');
                map.get(dep[j]).add('d');
            }
            int cur = 0;
            int max = 0;
            for (int k : map.keySet()) {
                //System.out.println(k);
                for (Character c : map.get(k)) {
                    if (c == 'a') {
                        cur += 1;
                        max = Math.max(cur, max);
                    } else {
                        cur -= 1;
                    }
                }
            }
            System.out.println(max);
        }
    }
}