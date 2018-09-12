package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindHowManyX {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader( System . in ));
        }
        String next()
        {
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
        FastReader sc =new FastReader();
        int tc = sc.nextInt();
        while(tc!=0) {
            int x = sc.nextInt();
            int[] arr = new int[2];
            for(int j=0; j<2; j++)
                arr[j] = sc.nextInt();
            System.out.println(count(arr,x));
            tc--;
        }
    }

    private static int count(int[] arr, int x) {
        int count=0,i=1,k,n;
        for(i = arr[0]+i;i<arr[1];i++){
            n = i;
            while(n!=0){
                k=n%10;
                n=n/10;
                if(k==x)
                    count++;
            }
        }
        return count;
    }

}
