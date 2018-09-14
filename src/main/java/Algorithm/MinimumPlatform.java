package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MinimumPlatform {

    static class Reader{
        BufferedReader br;
        StringTokenizer st;

        public Reader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreElements())
            {
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
        HashMap<String, TrainEntry> platform = new HashMap<>();
        int size =0;
        ArrayList list = new ArrayList();


        for (int i = 0; i < arrivalTime.length; i++){
            list.add(new TrainEntry(arrivalTime[i], departureTime[i]));
        }

        Collections.sort(list, TrainEntry.sort);

        for (int i = 0; i < list.size(); i++) {

            String[] val = list.get(i).toString().split(":");

            String key = checkforKey(platform,Integer.parseInt(val[0]));
            if(key!=null){
                platform.remove(key);
                platform.put("Train"+i, new TrainEntry(Integer.parseInt(val[0]), Integer.parseInt(val[1])));
            }
            else{
                platform.put("Train"+i, new TrainEntry(Integer.parseInt(val[0]), Integer.parseInt(val[1])));
            }
            if(platform.size()>size) size = platform.size();
        }

        return size;
    }

    private static String checkforKey(HashMap<String, TrainEntry> platform, int i) {
        for(String key : platform.keySet()){
            String depval = String.valueOf(platform.get(key));
            String depval1[] = depval.split(":");
            int depval2 = Integer.parseInt(depval1[1]);
            if(depval2<=i){
                return key;
            }
        }
        return null;
    }


    static class TrainEntry {
        protected int arrival;
        protected int depart;

        public TrainEntry(int n, int s){
            arrival = n;
            depart = s;
        }
        public int getArrival(){
            return arrival;
        }

        public int getDepart(){
            return depart;
        }

        public String toString(){
            return arrival+":"+depart;
        }
        public static Comparator<TrainEntry> sort = new Comparator<TrainEntry>() {
            public int compare(TrainEntry s1, TrainEntry s2) {
                int arrivalTime1 = s1.getArrival();
                int arrivalTime2 = s2.getArrival();
                return arrivalTime1 - arrivalTime2;
            }
        };
    }
}
