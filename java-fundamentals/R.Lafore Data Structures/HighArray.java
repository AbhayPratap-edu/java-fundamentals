package Lafor_Arrays;

class HighArrayApp
{
    public static void main(String[] args) {
        int maxSize = 100; // array size
        HighArray arr;//reference to array
        arr = new HighArray(maxSize);//create the array

        arr.insertAtEnd(77);
        arr.insertAtEnd(99);
        arr.insertAtEnd(44);
        arr.insertAtEnd(55);
        arr.insertAtEnd(22);
        arr.insertAtEnd(88);
        arr.insertAtEnd(11);
        arr.insertAtEnd(10);
        arr.insertAtEnd(66);
        arr.insertAtEnd(33);

        arr.display();

        int searchKey = 35;
        if(arr.findL(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't findL " + searchKey);

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        arr.display();
    }// end main()
} // end class HighArrayApp

class HighArray {
    private long[] a; // ref to array a
    private int nElems; // number of data items

    public HighArray(int max)//constructor
    {
        a = new long[max];// create the array
        nElems = 0;// no items yet
    }

    public boolean findL(long searchKey) // linear search
    { // findL specified value
        int j;
        for(j=0; j<nElems; j++) // for each element,
        {
            if(a[j] == searchKey)//found item?
                break; // exit loop
        }
        return j != nElems;
    }
    public int findB(long searchKey)
            //Binary search
    {
        int lowerBound = 0 ;
        int upperBound = nElems - 1;
        int curIn;
        while(true){
            curIn = (lowerBound + upperBound)/2;
            if(a[curIn]==searchKey)
                return curIn;//found it
            else if(lowerBound > upperBound)
                return nElems;// can't findL it
            else{
                if(a[curIn] < searchKey)
                    lowerBound = curIn + 1;//it's in upper half
                else
                    upperBound = curIn - 1;//it's in lower half
            }//end else divide range
        }//end while
    }//end findB


    public void insertAtEnd(long value)
    {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value)
    {
        int j;
        for(j=0; j<nElems;j++){
            if(value == a[j])
                break;
        }
        if(j==nElems)
            return false;
        else {
            for(int k=j; k<nElems; k++)
                a[k] = a[k+1];
            nElems--;
            return true;
        }
    }

    public void display()
    {
        for(int j=0; j<nElems; j++)
            System.out.print(a[j] + " ");

        System.out.println(" ");
    }
}
