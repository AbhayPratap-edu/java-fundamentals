package Lafor_Arrays;

public class QuickSort1 {
    public static void main(String[] args){
        int max = 15;
        ArrayQK arr = new ArrayQK(max);

        for(int j=0; j<max;j++){
            long n = (int)(java.lang.Math.random()*99);
            arr.insert(n);
        } // fill array with random numbers

        arr.display();
        arr.quickSort();
        arr.display();
    }
}

class ArrayQK{

    public void quickSort(){
        recQuickSort(0,nElems-1);
    }

    public void recQuickSort(int left,int right){

        if(right-left<=0) // if size <= 1 , already sorted
            return;
        else{
            long pivot = theArray[right]; // right most item

            int partition = partitionIt(left,right,pivot);
            recQuickSort(left,partition-1); // sort left side
            recQuickSort(partition+1,right); // sort right side
        }
    } // end recQuckSort

    public int partitionIt(int left,int right,long pivot){
        int leftPtr = left-1;
        int rightPtr = right; // 

        while(true){

            while (theArray[++leftPtr]<pivot);// find bigger item
            while (rightPtr>0 && theArray[--rightPtr] > pivot); // find smaller item

            if(leftPtr>= rightPtr)
                break;
            else
                swap(leftPtr,rightPtr);
        }// end while
        swap(leftPtr,right); // restore pivot
        return leftPtr; // return pivot location
    } // end partitionIt()

    private void swap(int dex1, int dex2) {
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }

    private long[] theArray;
    private int nElems;

    public ArrayQK(int max){
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value){
        theArray[nElems]= value;
        nElems++;
    }

    public void display(){
        System.out.print("A=");
        for(int j=0;j<nElems;j++)
            System.out.print(theArray[j] + " ");
        System.out.println(" ");
    }
}


