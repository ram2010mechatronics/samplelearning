package Algorithm;

public class Scores {
    public static final int maxEntries = 10;
    protected int numEntries;
    protected GameEntry[] entries;

    public Scores(){
        entries = new GameEntry[maxEntries];
        numEntries = 0;
    }

    public String toString(){
        String s = "[";
        for(int i=0;i<numEntries;i++){
            if(i>0) s+= ",";
            s+=entries[i];
        }
    return s+"]";
    }

}
