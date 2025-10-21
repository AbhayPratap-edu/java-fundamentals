package Lafor_Arrays;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//hash table with open addressing and linear probing

public class HashTable {
    public static void main(String[] args) throws IOException {

        DataItemH adataItemH;
        int aKey,size,n,keysPerCell;

        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter the initial number of items: ");
        n = getInt();
        keysPerCell = 10;

        HashTableH theHashTable = new HashTableH(size);

        for(int j=0;j<n;j++){
            aKey = (int)(java.lang.Math.random()*keysPerCell*size);
            adataItemH = new DataItemH(aKey);
            theHashTable.insert(adataItemH);
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
                    adataItemH = new DataItemH(aKey);
                    theHashTable.insert(adataItemH);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter the key value to find: ");
                    aKey = getInt();
                    adataItemH = theHashTable.find(aKey);
                    if(adataItemH != null )
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

class HashTableH{
    private DataItemH[] hashArray; // array holds hash table
    private int arraySize;
    private DataItemH nonItem; // for deleted item

    public HashTableH(int size){
        arraySize = size;
        hashArray = new DataItemH[arraySize];
        nonItem = new DataItemH(-1); // deleted item key is -1
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

    public int hashFunc(int key){
        return key%arraySize;
    }

    public void insert(DataItemH item){
        // assumes table not full
        int key = item.getKey();
        int hashVal = hashFunc(key);

        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
            ++hashVal;// go to next cell
            hashVal %= arraySize; // wraparound if necessary
        }
        hashArray[hashVal] = item;
    } // end insert()

    public DataItemH delete(int key){
        int hashVal = hashFunc(key);

        while(hashArray[hashVal] != null){
            if(hashArray[hashVal].getKey() == key){
                DataItemH temp = hashArray[hashVal]; // save the item
                hashArray[hashVal] = nonItem; // deleteItem
                return temp;
            }//found the key
            ++hashVal; // go to next cell
            hashVal %= arraySize; // wraparound if necessary
        }//until empty cell
        return null; // can't find item
    } // end delete()

    public DataItemH find(int key){
        int hashVal = hashFunc(key);

        while(hashArray[hashVal] != null ){
            if(hashArray[hashVal].getKey() == key )// found the key?
                return hashArray[hashVal];
            ++hashVal; // go to next cell
            hashVal %= arraySize;
        }
        return null;
    }
}// end class HashTableH

class DataItemH{
    private int iData; // data item (key)

    public DataItemH(int ii){
        iData = ii;
    }

    public int getKey(){
        return iData;
    }
}// end class DataItem
