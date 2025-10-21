package Lafor_Arrays;

import java.io.IOException;

class PriorityQ{
    // array in sorted order , from max at 0 to min at size -1
    private int maxSize ;
    private long[] queArray;
    private int nItems;

    public PriorityQ(int s){
        maxSize = s;
        queArray =  new long[maxSize];
        nItems = 0;
    }

    public void insert(long item){
        int j;

        if(nItems==0)
            queArray[nItems++] = item; // if no items, insert at 0
        else{
            for(j=nItems-1;j>0;j--){ // start at end
                if( item>queArray[j] )  // if new item larger,
                    queArray[j+1] = queArray[j]; // shift upward
                else // if smaller done shifting
                    break;
            } // end for loop
            queArray[j+1] = item; // insert item after shifting
            nItems++;
        } // end else ( nItems > 0 )
    } // end insert

    public long remove(){
        return queArray[--nItems];
    }

    public long peekMin(){
        return queArray[nItems-1];
    }

    public boolean isEmpty(){
        return (nItems==0);
    }

    public boolean isFull(){
        return (nItems == maxSize );
    }

} // end class PriorityQ

class PriorityQueOnArray {
    public static void main(String[] args) throws IOException{

        PriorityQ thePQue = new PriorityQ(5);
        thePQue.insert(30);
        thePQue.insert(50);
        thePQue.insert(10);
        thePQue.insert(40);
        thePQue.insert(20);

        while( !thePQue.isEmpty() ){

            long item = thePQue.remove();
            System.out.println(item + " ");
        } // end while

        System.out.println();
    } // end main method
}
