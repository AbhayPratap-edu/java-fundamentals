package Lafor_Arrays;

public class QueueOnArray {
    public static void main(String[] args){

        QueueFunc theQueue = new QueueFunc(5); // queue holds 5 args

        theQueue.insert(10); // insert 4 items
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        theQueue.remove(); // remove 3 items
        theQueue.remove(); // (10, 20, 30)
        theQueue.remove();

        theQueue.insert(50); // insert 4 more items
        theQueue.insert(60); // (wraps around)
        theQueue.insert(70);
        theQueue.insert(80);

        while( !theQueue.isEmpty() ) {
            long n = theQueue.remove();
            System.out.print(n + " ");
        }

        System.out.println();
    } // end main method
}

class QueueFunc{
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public QueueFunc(int s){
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    } // constructor

    public void insert(long j){
        if( rear == maxSize -1)
            rear = -1; // deal with wraparound

        queArray[++rear] = j; // increment rear and insert
        nItems++;
    }

    public long remove(){
        long temp = queArray[front++]; // get value from front and increase front
        if(front == maxSize)
            front = 0; // deal with wraparound
        nItems--;
        return temp;
    }

    public long peekFront(){
        return queArray[front];
    }

    public boolean isEmpty(){
        return (nItems==0);
    }

    public boolean isFull(){
        return (nItems==maxSize);
    }

    public int size(){
        return nItems;
    }

} // end class QueueFunc