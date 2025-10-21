package Lafor_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapSort {
    public static void main(String[] args) throws IOException{

        int size , j;
        System.out.print("Enter number of items: ");
        size = getInt();
        HeapHS theHeap = new HeapHS(size);

        for(j=0;j<size;j++){
            int random = (int)(java.lang.Math.random()*100);
            NodeHS newNode = new NodeHS(random);
            theHeap.insertAt(j, newNode);
            theHeap.incrementSize();
        }

        System.out.print("Random: ");
            theHeap.displayArray();

        for(j=size/2-1;j>=0;j--) // make random array into heap
            theHeap.trickleDown(j);

        System.out.print("Heap:  ");
        theHeap.displayArray(); // display heap array
        theHeap.displayHeap(); // display heap

        for(j=size-1;j>=0;j--){ // remove from heap and store at array end
            NodeHS biggestNode = theHeap.remove();
            theHeap.insertAt(j,biggestNode);
        }

        System.out.print("Sorted: ");
        theHeap.displayArray();

    } // end main()

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public static char getChar() throws IOException{
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException{
        String s = getString();
        return Integer.parseInt(s);
    }
}

class HeapHS {
    private NodeHS[] heapArray;
    private int maxSize; // size of array
    private int currentSize; // number of nodes in array

    public HeapHS(int mx){
        maxSize = mx;
        currentSize = 0;
        heapArray = new NodeHS[maxSize];
    } // constructor

    public NodeHS remove(){
        NodeHS root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    } // end remove

    public void trickleDown(int index) {
        int largerChild;
        NodeHS top = heapArray[index]; // save root
        while(index < currentSize/2) // while node has at least one child
        {
            int leftChild = 2*index+1;
            int rightChild = leftChild+1;

            //find larger child
            if(rightChild<currentSize && heapArray[leftChild].getKey()<heapArray[rightChild].getKey() )
                largerChild = rightChild;
            else
                largerChild = leftChild;

            if(top.getKey() >= heapArray[largerChild].getKey() )
                break;

            heapArray[index] = heapArray[largerChild]; // shift largerChild Up
            index = largerChild; // go down
        } // end while
        heapArray[index] = top; // root to index
    }// end trickle down

    public void displayHeap(){
        System.out.print("heapArray: ");
        for(int m=0; m<currentSize;m++)
            if (heapArray[m] != null )
                System.out.print( heapArray[m].getKey() + " ");
            else
                System.out.print( "-- ");

        System.out.println();

        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "...............................";
        System.out.println(dots+dots); // dotted top line

        while(currentSize>0){
            if(column == 0)
                for(int k=0;k<nBlanks;k++)
                    System.out.print(' ');

            System.out.print(heapArray[j].getKey());

            if(++j == currentSize ) // done ?
                break;

            if(++column == itemsPerRow ) // end of row?
            {
                nBlanks /=2;  // half the blanks
                itemsPerRow *=2; // twice the items
                column = 0; // start over on
                System.out.println(); // new row
            }
            else // not end of row — add spacing between siblings
                for(int k=0; k<nBlanks*2-2;k++)
                    System.out.print(' ');
        } // end while
        System.out.println("\n"+dots+dots); // dotted bottom line
    } // end displayHeap

    public void displayArray(){
        for(int j=0;j<maxSize;j++)
            System.out.print(heapArray[j].getKey()+ " ");
        System.out.println();
    }

    public void insertAt(int index,NodeHS newNode){
        heapArray[index] = newNode;
    }

    public void incrementSize(){
        currentSize++;
    }
} // end class HeapHS

class NodeHS {
    private int iData; // data item ( key )

    public NodeHS(int key){
        iData = key;
    }

    public int getKey(){
        return iData;
    }

}// end class NodeHS
