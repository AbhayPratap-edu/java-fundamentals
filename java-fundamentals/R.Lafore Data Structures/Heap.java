package Lafor_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Heap {
    public static void main(String[] args) throws IOException{
        int value,value2;
        HeapH theHeap = new HeapH(31);// create a heap of max size 31
        boolean success;

        theHeap.insert(70); // insert 10 items
        theHeap.insert(40);
        theHeap.insert(50);
        theHeap.insert(20);
        theHeap.insert(60);
        theHeap.insert(100);
        theHeap.insert(80);
        theHeap.insert(30);
        theHeap.insert(10);
        theHeap.insert(90);

        while(true){
            System.out.print("Enter the first letter of: ");
            System.out.print("show, insert, remove, change: ");
            int choice = getChar();
            switch (choice){
                case 's':
                    theHeap.displayHeap();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    success = theHeap.insert(value);
                    if( !success )
                        System.out.println("can't insert; heap full");
                    break;
                case 'r':
                    if( !theHeap.isEmpty() )
                        theHeap.remove();
                    else
                        System.out.println("Can't remove; heap empty");
                    break;
                case 'c':
                    System.out.print("Enter current index of item: ");
                    value = getInt();
                    System.out.print("Enter new Key: ");
                    value2 = getInt();
                    success  = theHeap.change(value,value2);
                    if( !success )
                        System.out.println("Invalid index");
                    break;
                default:
                    System.out.println("Invalid entry\n");
            }// end switch
        }//end while
    }// end main()

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

class HeapH{
    private NodeHP[] heapArray;
    private int maxSize; // size of array
    private int currentSize; // number of nodes in array

    public HeapH(int mx){
        maxSize = mx;
        currentSize = 0;
        heapArray = new NodeHP[maxSize];
    } // constructor

    public boolean isEmpty(){
        return currentSize==0;
    }

    public boolean insert(int key){
        if(currentSize==maxSize)
            return false;
        NodeHP newNode = new NodeHP(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }// end insert

    private void trickleUp(int index) {
        int parent = (index-1)/2;
        NodeHP bottom = heapArray[index];

        while(index>0 && heapArray[parent].getKey() < bottom.getKey() ){
            heapArray[index] = heapArray[parent]; // move it down
            index = parent;
            parent = (parent -1)/2;
        } // end while
        heapArray[index] = bottom;
    } // end trickleUp

    public NodeHP remove(){
        NodeHP root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    } // end remove

    private void trickleDown(int index) {
        int largerChild;
        NodeHP top = heapArray[index]; // save root
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

    public boolean change(int index,int newValue){
        if(index<0 || index>=currentSize )
            return false;
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);

        if(oldValue<newValue)
            trickleUp(index);
        else
            trickleDown(index);

        return true;
    } // end change

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

}


class NodeHP{
    private int iData; // data item ( key )

    public NodeHP(int key){
        iData = key;
    }

    public int getKey(){
        return iData;
    }

    public void setKey(int id){
        iData = id;
    }
}// end class NodeHP