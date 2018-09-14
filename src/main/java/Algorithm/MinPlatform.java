package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MinPlatform {

    static class Reader{
        BufferedReader br;
        StringTokenizer st;
        public Reader(){ br = new BufferedReader(new InputStreamReader(System.in));   }

        String next(){
            while (st == null || !st.hasMoreElements()){
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt()
        {
            return Integer.parseInt(next());
        }
        long nextLong()
        {
            return Long.parseLong(next());
        }
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        Reader sc = new Reader();
        int tc = sc.nextInt();
        while (tc != 0) {
            int NoofTrains = sc.nextInt();
            int[] arrivalTime = new int[NoofTrains];
            int[] departureTime = new int[NoofTrains];
            for (int i = 0; i < NoofTrains; i++)
                arrivalTime[i] = sc.nextInt();
            for (int i = 0; i < NoofTrains; i++)
                departureTime[i] = sc.nextInt();
            for (int j = 0; j < NoofTrains; j++) {
                if (arrivalTime[j] > departureTime[j]) {
                    departureTime[j] += 2400;
                }
            }
            System.out.println(MinimumPlat(arrivalTime, departureTime));
            tc--;
        }
    }

    private static int MinimumPlat(int[] arrivalTime, int[] departureTime) {
        HashMap<Integer, List<String>> platform = new HashMap<>();
        int val = 0;
        int min = 0;
        for (int j = 0; j < arrivalTime.length; j++) {
            platform.putIfAbsent(arrivalTime[j], new ArrayList<>());
            platform.putIfAbsent(departureTime[j], new ArrayList<>());
            platform.get(arrivalTime[j]).add("Arrival");
            platform.get(departureTime[j]).add("Departure");
        }

        for (int k : platform.keySet()) {
            for (String c : platform.get(k)) {
                if (c.equals("Arrival")) {
                    val += 1;
                    min = Math.max(val, min);
                } else {
                    val -= 1;
                }
            }
        }

        return min;
    }
}
