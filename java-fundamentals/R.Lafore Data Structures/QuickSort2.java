package Lafor_Arrays;

public class QuickSort2 {
    public static void main(String[] args){

        int max = 10;
        ArrayQS arr = new ArrayQS(max);

        for(int j=0;j<max;j++){
            long n = (int)(java.lang.Math.random()*99);
            arr.insert(n);
        }

        arr.display();
        arr.quickSort();
        arr.display();
    }
}

class ArrayQS{

    public void quickSort(){
        recQuickSort(0,nElems-1);
    }

    private void recQuickSort(int left, int right) {
        int size = right-left+1;
        if(size<=3) // manual sort if small
            manualSort(left,right);
        else { // quicksort if large
            long median = medianOf3(left,right);
            int partition = partitionIt(left,right,median);
            recQuickSort(left,partition-1);
            recQuickSort(partition+1,right);
        }
    }// end recQuickSort()

    public long medianOf3(int left,int right){
        int center = (left+right)/2;

        if(theArray[left]>theArray[center])
            swap(left,center);

        if(theArray[left]>theArray[right])
            swap(left,right);

        if(theArray[center]>theArray[right])
            swap(center,right);

        swap(center,right-1);
        return theArray[right-1];
    }

    public void swap(int dex1,int dex2){
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }

    public int partitionIt(int left,int right,long pivot){
        int leftPtr = left;
        int rightPtr = right -1 ;

        while(true) {

            while (theArray[++leftPtr] < pivot) ;// find bigger

            while (theArray[--rightPtr] > pivot) ; // find smaller

            if (leftPtr >= rightPtr)
                break; // if pointers cross
            else
                swap(leftPtr, rightPtr);
        }// end while(true) loop
        swap(leftPtr,right-1);
        return leftPtr;
    } // end partitionIt

    public void manualSort(int left,int right){
        int size = right - left+1;
        if(size<=1)
            return;
        if(size==2){
            if(theArray[left]>theArray[right])
                swap(left,right);
            return;
        }
        else{
            if(theArray[left]>theArray[right-1])
                swap(left,right-1);
            if(theArray[left]>theArray[right])
                swap(left,right);
            if(theArray[right-1]>theArray[right])
                swap(right-1,right);
        }
    }// end manual sort()


    private long[] theArray;
    private  int nElems = 0;

    public ArrayQS(int max){
        theArray = new long[max];
        nElems = 0;
    } // Array constructor

    public void insert(long value){
        theArray[nElems] = value;
        nElems++;
    }

    public void display(){
        System.out.print("A=");
        for(int j=0;j<nElems;j++)
            System.out.print(theArray[j] + " ");
        System.out.println(" ");
    }
}