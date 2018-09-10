package Algorithm;

public class ArraySorting {

    public static char[] insertionSort(char[] data){
        int n = data.length;
        for (int k=0;k<n;k++){
            char cur = data[k];
            int j=k;
            while(j>0&&data[j-1]<cur){
                data[j]=data[j-1];
                j--;
            }
            data[j]=cur;
        }

        return data;
    }

    public static void main(String[] args){
        String name = "ramachandran";
        char[] chr = name.toCharArray();
        chr=insertionSort(chr);
        name = String.valueOf(chr);
        System.out.println(name);
    }
}
