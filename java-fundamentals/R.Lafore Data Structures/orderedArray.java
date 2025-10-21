package Lafor_Arrays;

class OrdArray
{
    private long[] a; // ref to array a
    private int nElems ; // number of data items

    public OrdArray(int max)
    {
        a  = new long[max]; // create array
        nElems = 0;
    }

    public int size()
    { return nElems; }

    public int find(long searchKey)
    {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while(true)
        {
            curIn = (lowerBound + upperBound) / 2 ;
            if(a[curIn]==searchKey)
                return curIn;
            else if (lowerBound > upperBound)
                return nElems;
            else
            {
                if(a[curIn] < searchKey )
                    lowerBound = curIn + 1; // its in upper half
                else
                    upperBound = curIn - 1;
            }
        }

    }

    public void insert(long value)
    {
        int j;
        for(j=0; j<nElems; j++)
            if(a[j] > value)
                break;
        for(int k=nElems; k>j; k--)
            a[k] = a[k-1];
        a[j] = value;
        nElems++;
    }

    public boolean delete(long value)
    {
        int j = find(value);
        if(j==nElems)
            return false;
        else
        {
            for(int k=j; k<nElems; k++)
                a[k] = a[k+1];
            nElems--;
            return true;
        }
    }

    public void display() // displays array contents
    {
        for(int j=0; j<nElems; j++) // for each element,
            System.out.print(a[j] + " "); // display it
        System.out.println(" ");
    }
}
public class orderedArray
{
    public static void main(String[] args)
    {
        int maxSize = 100; //array size
        OrdArray arr;// reference array
        arr = new OrdArray(maxSize);

        arr.insert(77); // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(10);
        arr.insert(66);
        arr.insert(33);

        int searchKey = 55;
        if(arr.find(searchKey) != arr.size() )
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can’t find " + searchKey);

        arr.display(); // display items
        arr.delete(10); // delete 3 items
        arr.delete(55);
        arr.delete(99);
        arr.display(); // display items again
    }
}
