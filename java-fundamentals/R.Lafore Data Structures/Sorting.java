package Lafor_Arrays;


class ArrayB
{
    private long[] arr;
    private int nElems;

    public ArrayB(int max)
    {
        arr = new long[max];
        nElems = 0;
    }

    public void insert(long value)
    {
        arr[nElems] = value;
        nElems++;
    }

    public void display() // displays array contents
    {
        for(int j=0; j<nElems; j++) // for each element,
            System.out.print(arr[j] + " "); // display it
        System.out.println("");
    }

    public void swap(int one,int two)
    {
        long temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

    public void bubbleSort()
    {
        int out, in;
        for(out = nElems-1; out>1; out --)
        {
            for(in=0; in<out;in++)
            {
                if(arr[in] > arr[in+1])
                    swap(in, in+1);
            }
        }
    }

    public void selectionSort()
    {
        int out , in , min;

        for(out=0; out<nElems-1;out++)
        {
            min = out;
            for(in=out+1; in<nElems; in++)
                if(arr[in]<arr[min])
                    min = in;
            swap(out,in);
        }
    }

    public void insertionSort()
    {
        int in , out;

        for(out=1;out<nElems;out++)
        {
            long temp = arr[out];
            in = out;

            while(in>0 && arr[in-1] >= temp)
            {
                arr[in] = arr[in-1];
                --in;
            }

            arr[in] = temp;
        }
    }




}

public class Sorting {
    public static void main(String[] args)
    {
        int maxSize = 100;
        ArrayB arr;
        arr = new ArrayB(maxSize);

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

        arr.display();

        arr.bubbleSort();
        arr.selectionSort();
        arr.insertionSort();

        arr.display();


    }
}
