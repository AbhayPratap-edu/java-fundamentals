package Lafor_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashChain {
    public static void main(String[] args) throws IOException {
        int aKey;
        LinkHC aDataItem;
        int size,n,keyPerCell = 100;

        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();

        HashTableHC theHashTable = new HashTableHC(size);

        for(int j=0;j<n;j++){
            aKey = (int)(java.lang.Math.random()*keyPerCell*size);
            aDataItem = new LinkHC(aKey);
            theHashTable.insert(aDataItem);
        }
        while(true){
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, or find: ");

            char choice = getChar();
            switch (choice){
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new LinkHC(aKey);
                    theHashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if(aDataItem != null )
                        System.out.println("Found " + aKey);
                    else
                        System.out.println("could not find " + aKey);
                default:
                    System.out.print("Invalid entry\n");
            } // end switch
        } // end while
    } // end main()

    public static String getString() throws IOException{
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

class HashTableHC{
    private SortedListHC[] hashArray; // array of lists
    private int arraySize;

    public HashTableHC(int size){
        arraySize = size;
        hashArray = new SortedListHC[arraySize];// create array
        // fill array with lists
        for(int j=0;j<arraySize;j++)
            hashArray[j] = new SortedListHC();
    } // constructor

    public void displayTable(){
        for(int j=0;j<arraySize;j++){
            System.out.print(j+". ");// display cell number
            hashArray[j].displayList(); // display list
        }
    }

    public int hashFuncHC(int key){
        return key % arraySize;
    }

    public void insert(LinkHC theLink){
        int key = theLink.getKey();
        int hashVal = hashFuncHC(key);
        hashArray[hashVal].insert(theLink); // insert at hashVal
    }

    public void delete(int key){
        int hashVal  = hashFuncHC(key);
        hashArray[hashVal].delete(key);
    }

    public LinkHC find(int key){
        int hashVal = hashFuncHC(key);
        LinkHC theLink = hashArray[hashVal].find(key);
        return theLink;
    }
} // end class HashTableHC

class LinkHC{
    private int iData; //data item
    public LinkHC next;

    public LinkHC(int it){
        iData = it;
    }

    public int getKey(){
        return iData;
    }

    public void displayLink(){
        System.out.print(iData + " ");
    }
}

class SortedListHC {
    private LinkHC first; // ref to first list item

    public SortedListHC(){
        first = null;
    }

    public void insert(LinkHC theLink){
        int key = theLink.getKey();
        LinkHC previous = null;
        LinkHC current = first;

        while(current != null && key>current.getKey() ){
            previous = current;
            current = current.next;
        }

        if(previous == null )
            first =theLink;
        else
            previous.next = theLink;
        theLink.next = current;
    }// end insert link in order

    public void delete(int key){
        // assumes non-empty list
        LinkHC previous = null;
        LinkHC current = first;

        while( current != null && key!= current.getKey() ){
            previous = current;
            current = current.next;
        }

        if( previous == null )
            first = first.next;
        else
            previous.next = current.next;
    } // end delete

    public LinkHC find(int key){
        LinkHC current = first;

        while(current != null && current.getKey() <= key ){
            if(current.getKey() == key )
                return current;
            current = current.next;
        }
        return null;
    } // end find

    public void displayList(){
        System.out.print("List(first-->last): ");
        LinkHC current = first;

        while(current != null ){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    } // end displayList

} // end class SortedListHC
