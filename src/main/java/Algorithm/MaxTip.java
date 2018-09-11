package Algorithm;

import java.lang.*;
import java.util.Scanner;


public class MaxTip {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        int i = 1;
        while(i <= T) {
            int N = in.nextInt();
            int X = in.nextInt();
            int Y = in.nextInt();

            int rahul[] = new int[N];
            int ankit[] = new int[N];
            for(int j=0; j<N; j++)
                rahul[j] = in.nextInt();
            for(int j=0; j<N; j++)
                ankit[j] = in.nextInt();

            for(int k=0; k<N-1; k++)
                for(int j=0; j<N-1-k; j++)
                    if(Math.abs(rahul[j] - ankit[j]) < Math.abs(rahul[j+1] - ankit[j+1])) {
                        int temp = rahul[j];
                        rahul[j] = rahul[j+1];
                        rahul[j+1] = temp;
                        int temp2 = ankit[j];
                        ankit[j] = ankit[j+1];
                        ankit[j+1] = temp2;
                    }

            int tip = 0, rahulCount = X, ankitCount = Y;
            for(int j=0; j<N; j++) {
                if(rahul[j] >= ankit[j] && rahulCount != 0) {
                    rahulCount--;
                    tip += rahul[j];
                } else if(rahul[j] <= ankit[j] && ankitCount != 0) {
                    ankitCount--;
                    tip += ankit[j];
                } else if(rahulCount == 0 && rahul[j] >= ankit[j]) {
                    ankitCount--;
                    tip += ankit[j];
                } else if(ankitCount == 0 && rahul[j] <= ankit[j]) {
                    rahulCount--;
                    tip += rahul[j];
                }
            }
            System.out.println(tip);
            i++;
        }
    }
}

