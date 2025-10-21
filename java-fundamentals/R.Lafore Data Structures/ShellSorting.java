package Lafor_Arrays;

public class ShellSorting {
    public static void main(String[] args){

        int maxSize = 10;
        ArraySS arr = new ArraySS(maxSize);

        for(int j=0;j<maxSize;j++){
            long n = (int)(java.lang.Math.random()*99);
            arr.insert(n);
        } // fill array with random numbers

        arr.display();
        arr.shellSort();
        arr.display();
    }
}

class ArraySS{
    private long[] theArray; // ref to the Array
    private int nElems; // number of data items

    public ArraySS(int max){
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value){
        theArray[nElems]=value;
        nElems++;
    }

    public void display(){
        System.out.print("A=");
        for(int j=0;j<nElems;j++)
            System.out.print(theArray[j] + " ");
        System.out.println(" ");
    }

    public void shellSort(){
        int inner, outer;
        long temp;

        int h=1;
        while(h<nElems/3)
            h=h*3 + 1;

        while(h>0){

            for(outer=h;outer<nElems; outer++){
                temp = theArray[outer];
                inner = outer;

                while(inner>h-1 && theArray[inner-h] >= temp){
                    theArray[inner] = theArray[inner-h];
                    inner = inner - h;
                }
                theArray[inner]=temp;
            }// end for loop
            h=(h-1)/3;
        }// end while(h>0)
    }// end shellShort

} // end class ArraySS