package Algorithm;

public class ClosestPalindrome {

    public static String nearestPalindrome(String n){
        long m = Long.parseLong(n);
        for (long i = 0;;i++ ) {
            if (isPalindrome(m - i))
                return "" + (m - i);
            if (isPalindrome(m+i))
                return ""+(m+i);
        }
    }

    private static boolean isPalindrome(long l) {
        long t = l, rev = 0;
        while(t>0){
            rev = 10*rev+t%10;
            t/=10;
        }
        return rev == l;
    }

    public static void main(String[]args){
       String result = nearestPalindrome("19");
       System.out.println(result);
    }


}
