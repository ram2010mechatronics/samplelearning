package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SaveIronMan {
    public static void main(String[] args){
        FastReader sc =new FastReader();
        int tc = sc.nextInt();
        while(tc!=0) {
            String s = sc.nextLine();
            s =remove_regex(s);
            s = remove_space(s);
            System.out.println(checkforPalindrome(s));
            tc--;
        }
    }

    private static String checkforPalindrome(String s) {
        char[] charr = s.toCharArray();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        if(s.length()%2==0) {
            for (int i = 0; i <= (s.length() / 2) - 1; i++)
                s1.append(charr[i]);
            for (int j = s.length() - 1; j >= s.length() / 2; j--)
                s2.append(charr[j]);
            if (s1.toString().equalsIgnoreCase(s2.toString())) return "Yes";
        }
        else {
            for (int i = 0; i <= (Math.abs(s.length() / 2)) - 1; i++)
                s1.append(charr[i]);
            for (int j = s.length() - 1; j > Math.abs(s.length() / 2); j--)
                s2.append(charr[j]);
            if (s1.toString().equalsIgnoreCase(s2.toString())) return "Yes";
        }
        return "No";
    }

    private static String remove_space(String s) {
        return s.replaceAll(" ","");
    }

    private static String remove_regex(String s) {
        return s.replaceAll("[^a-zA-Z0-9\\s]", "");
    }

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
                catch (IOException  e)
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

}
