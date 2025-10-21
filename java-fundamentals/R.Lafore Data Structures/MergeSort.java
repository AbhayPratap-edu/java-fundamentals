package Lafor_Arrays;

//Time Complexity: O(n log n) - consistently fast for all cases
//Space Complexity: O(n) - requires extra workspace array

class DArray{
    private long[] theArray; // Main array to be sorted
    private int nElems; //Number of actual elements in array

    public DArray(int max){
        theArray = new long[max]; // Allocate memory for array
        nElems = 0;
    }   // Constructor: Create array with specified maximum size

    public void insert(long value){
        theArray[nElems] = value;
        nElems++;
    } // put elements to array

    public void display(){
        for(int j=0;j<nElems;j++)
            System.out.print(theArray[j] + " ");
        System.out.println();
    } // display array contents

    public void mergeSort(){
        long[] workSpace = new long[nElems]; // Create temporary array for merging
        recMergeSort(workSpace,0,nElems-1); //Start recursive sort with full range
    } // called by main() provides workspace

    /**
     * RECURSIVE MERGE SORT - The heart of the algorithm
     *
     * DIVIDE AND CONQUER Strategy:
     * 1. DIVIDE: Split array in half
     * 2. CONQUER: Recursively sort each half
     * 3. COMBINE: Merge the two sorted halves
     *
     * @param workSpace - temporary array for merging operations
     * @param lowerBound - starting index of range to sort
     * @param upperBound - ending index of range to sort
     */

    private void recMergeSort(long[] workSpace,int lowerBound,int upperBound){

        if(lowerBound == upperBound)
            return; // range is 1  no use of sorting , exit recursion
        else{
            int mid = (lowerBound+upperBound) / 2; // divide step

            // CONQUER STEP: Recursively sort both halves
            recMergeSort(workSpace,lowerBound,mid); // sort low half
            recMergeSort(workSpace,mid+1,upperBound); // sort high half

            // COMBINE STEP: Merge the two now-sorted halves
            merge(workSpace,lowerBound,mid+1,upperBound);
        }
    }

    /**
     * MERGE OPERATION - Combines two sorted subarrays into one sorted array
     *
     * This is where the actual sorting happens! We have two sorted pieces:
     * - Left subarray:  theArray[lowPtr...mid]     (already sorted)
     * - Right subarray: theArray[highPtr...upperBound]  (already sorted)
     *
     * Goal: Merge them into workSpace, then copy back to theArray
     *
     * @param workSpace - temporary array to build merged result
     * @param lowPtr - start of left sorted subarray
     * @param highPtr - start of right sorted subarray
     * @param upperBound - end of right sorted subarray
     */
    private void merge(long[] workSpace,int lowPtr,int highPtr,int upperBound){
        int j=0; // workspace index
        int lowerBound = lowPtr; // Remember original start position
        int mid = highPtr-1; // End of left subarray
        int n = upperBound-lowerBound+1; // Total elements to merge

        // Compare current elements from left and right subarrays
        while( lowPtr <= mid && highPtr <= upperBound ){
            if( theArray[lowPtr] < theArray[highPtr])
                workSpace[j++] = theArray[lowPtr++];
            else
                workSpace[j++] = theArray[highPtr++];
        }

        // If left subarray still has elements, copy them all
        while(lowPtr <= mid)
            workSpace[j++] = theArray[lowPtr++];

        // If right subarray still has elements, copy them all
        while(highPtr <= upperBound)
            workSpace[j++] = theArray[highPtr++];

        // COPY BACK: Move merged result from workspace back to original array
        for(j=0; j<n; j++)
            theArray[lowerBound+j] = workSpace[j];

    }// end merge

} // end class DArray


public class MergeSort {
    public static void main(String[] args){
        int maxSize = 100; // array size
        DArray arr; // ref to array
        arr = new DArray(maxSize); // create array

        arr.insert(64); // insert items
        arr.insert(21);
        arr.insert(33);
        arr.insert(70);
        arr.insert(12);
        arr.insert(85);
        arr.insert(44);
        arr.insert(3);
        arr.insert(99);
        arr.insert(0);
        arr.insert(108);
        arr.insert(36);

        arr.display();

        arr.mergeSort();

        arr.display();

    }// end main method
}
