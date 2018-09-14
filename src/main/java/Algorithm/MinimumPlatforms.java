package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class MinimumPlatforms {
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

    public static void main(String[] args){
        Reader sc =new Reader();
        int tc = sc.nextInt();
        while(tc!=0){
            int NoofTrains = sc.nextInt();
            int[] arrivalTime = new int[NoofTrains];
            int[] departureTime = new int[NoofTrains];
            for(int i=0;i<NoofTrains;i++)
                arrivalTime[i] = sc.nextInt();
            for(int i=0;i<NoofTrains;i++)
                departureTime[i] = sc.nextInt();
            System.out.println(MinimumPlat(arrivalTime,departureTime));
            tc--;
        }
    }

    private static int MinimumPlat(int[] arrivalTime, int[] departureTime) {
        LinkedHashMap<Integer,TrainEntry> platform = new LinkedHashMap();
        LinkedHashMap<Object,Integer> Train = new LinkedHashMap();

        for(int i=0;i<arrivalTime.length;i++){
            Train.put(arrivalTime[i]+"."+i,departureTime[i]);
        }
        if(Train.size()==1)return 1;
        int NextTrain;
        /*Object[] arrival = Train.keySet().toArray();*/
        Arrays.sort(arrivalTime);
        for(int i = 0; i<arrivalTime.length-1; i++) {
            NextTrain = findnextTrain(arrivalTime, arrivalTime[i]);

            if(i==0)
                platform.put(arrivalTime[i], new TrainEntry(arrivalTime[i],Train.get(arrivalTime[i])));
            int NextDepat=findNextDepat(platform,Train);
            if(Train.get(NextDepat) < NextTrain){
                if(platform.keySet().size()>1){
                    platform.remove(NextDepat);
                    platform.put(NextTrain, new TrainEntry(NextTrain, Train.get(NextTrain)));

                }
                else {
                    platform.remove(arrivalTime[i]);
                    platform.put(NextTrain, new TrainEntry(NextTrain, Train.get(NextTrain)));
                }
            }

            else{
                platform.put(NextTrain, new TrainEntry(NextTrain,Train.get(NextTrain)));
            }
        }

        return (platform.keySet()).size();
    }

    private static int findNextDepat(LinkedHashMap<Integer, TrainEntry> platform, LinkedHashMap<Object, Integer> train) {
        int diff = 0;
        int n = platform.keySet().size();
        Object[] arra = platform.keySet().toArray();
        if(n==1) return (int) arra[0];
        for (int i=0; i<n-1; i++)
            for (int j=i+1; j<n; j++)
                if (Math.abs(train.get(arra[i]) - train.get(arra[j])) > diff)
                    diff = (int) arra[j];

        return diff;
    }

    private static int findnextTrain(int[] arrivalTime, int cur) {
        int size = arrivalTime.length;
        while(size!=0){
           if(arrivalTime[size-1]%cur == min(arrivalTime,cur)) return arrivalTime[size-1];
            size--;
        }
        return 0;
    }

    private static int min(int[] arr,int cur) {
          int diff = Integer.MAX_VALUE;
          int n = arr.length;
            for (int i=0; i<n-1; i++)
                for (int j=i+1; j<n; j++)
                    if (Math.abs((arr[i] - arr[j]) )< diff && arr[i]==cur) {
                        diff = Math.abs((arr[i] - arr[j]));
                        return diff;
                    }
          return diff;
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
            return "("+arrival+":"+depart+")";
        }
    }
}
