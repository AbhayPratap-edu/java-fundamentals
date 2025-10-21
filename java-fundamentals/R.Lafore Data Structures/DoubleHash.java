package Lafor_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoubleHash {
    public static void main(String[] args) throws IOException {

        DataItemDH adataItemDH;
        int aKey,size,n,keysPerCell;

        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter the initial number of items: ");
        n = getInt();
        keysPerCell = 10;

        HashTableDH theHashTable = new HashTableDH(size);

        for(int j=0;j<n;j++){
            aKey = (int)(java.lang.Math.random()*keysPerCell*size);
            adataItemDH = new DataItemDH(aKey);
            theHashTable.insert(aKey,adataItemDH);
        }

        while(true){
            System.out.print("Enter first letter of ");
            System.out.print("show ,insert ,delete ,or find: ");
            char choice = getChar();
            switch(choice){
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    adataItemDH = new DataItemDH(aKey);
                    theHashTable.insert(aKey,adataItemDH);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter the key value to find: ");
                    aKey = getInt();
                    adataItemDH = theHashTable.find(aKey);
                    if(adataItemDH != null )
                        System.out.println("found " + aKey);
                    else
                        System.out.println("could not find " + aKey);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }// end switch
        }// end while
    }// end main()

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

class HashTableDH{
    private DataItemDH[] hashArray; // array holds hash table
    private int arraySize;
    private DataItemDH nonItem; // for deleted item

    public HashTableDH(int size){
        arraySize = size;
        hashArray = new DataItemDH[arraySize];
        nonItem = new DataItemDH(-1); // deleted item key is -1
    } // constructor

    public void displayTable(){
        System.out.print("Table: ");
        for(int j=0;j<arraySize;j++){
            if(hashArray[j] != null )
                System.out.print(hashArray[j].getKey()+ " ");
            else
                System.out.print("** ");
        }
        System.out.print("");
    }

    public int hashFunc1(int key){
        return  key % arraySize;
    }

    public int hashFunc2(int key){
        //non-zero , less than array size, different from hF1
        //array size must be relatively prime to 5,4,3and 2
        return 5 - key % 5;
    }
    // hash function contain two parts

    public void insert(int key,DataItemDH item){
        // assumes table not full
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key); // get step size until empty cell or -1

        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
            hashVal += stepSize; // add the step
            hashVal %= arraySize; // wraparound if necessary
        }
        hashArray[hashVal] = item; // insert item
    } // end insert()

    public DataItemDH delete(int key){
        int hashVal = hashFunc1(key); // hash the key
        int stepSize = hashFunc2(key); // get step size

        while(hashArray[hashVal] != null){
            if(hashArray[hashVal].getKey() == key){
                DataItemDH temp = hashArray[hashVal]; // save the item
                hashArray[hashVal] = nonItem; // deleteItem
                return temp;
            }//found the key
            hashVal += stepSize; //
            hashVal %= arraySize; // wraparound if necessary
        }//until empty cell
        return null; // can't find item
    } // end delete()

    public DataItemDH find(int key){
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while(hashArray[hashVal] != null ){
            if(hashArray[hashVal].getKey() == key )// found the key?
                return hashArray[hashVal];
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }
}


class DataItemDH{
    private int iData; // data item (key)

    public DataItemDH(int ii){
        iData = ii;
    }

    public int getKey(){
        return iData;
    }
}// end class DataItem