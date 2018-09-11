package Algorithm;

import java.util.*;
import java.lang.*;


class re {
    public static void main (String[] args) {
        //code
        Scanner s = new Scanner(System.in);
        int tc = s.nextInt();
        for(int j=0;j<tc;j++){
            int n = s.nextInt();
            int temp=n;

            ArrayList<Integer> list = new ArrayList<>();
            if(n/10==0) {
                list.add(0);
                n/=10;
            }
            while(n!=0){
                list.add(n%10);
                n/=10;
            }
            Collections.reverse(list);
            if(list.size()==1) {
                System.out.print(temp);

                continue;
            }
            boolean check=false;
            for(int i=0;i<list.size()/2;i++){
                if(list.get(i)!=list.get(list.size()-1-i)) {
                    check=true;
                    break;
                }
            }
            if(check==false) {
                System.out.println(temp);
                return;
            }
            for(int i=0;i<list.size()/2;i++){
                if(list.get(i)!=list.get(list.size()-1-i)) {
                    int x = list.get(i);

                    list.set(list.size()-1-i, x);
                }
            }

            for(int i=0;i<list.size();i++) {
                System.out.print(list.get(i));
            }
            System.out.println();
        }
        s.close();
    }
}
