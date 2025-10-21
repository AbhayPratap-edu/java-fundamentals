package Lafor_Arrays;

//LinkQ = node.
//FirstLastListQ = manages nodes.
//LinkQueue = adapts linked list to work like a Queue.
//QueOnLinkList = test drive

class LinkQueue{
    private FirstLastListQ theList;

    public LinkQueue(){
        theList = new FirstLastListQ(); // make 2 ended list
    }

    public boolean isEmpty(){
        return theList.isEmpty();
    } // check if queue is empty

    public void insert(long j){
        theList.insertLast(j);
    } // insert , rear of queue

    public long remove(){
        return theList.deleteFirst();
    } // remove, front of queue

    public void displayQueue(){
        System.out.print("Queue (front --> rear): ");
        theList.deleteFirst();
    }
} // end class LinkQueue

class LinkQ{
    public long dData; // data item
    public LinkQ next; // next node in list

    public LinkQ(long d){
        dData = d;
    } // constructor for node

    public void displayLink() {
        System.out.print(dData + " ");
    }

} // end class LinkQ

class FirstLastListQ{

    private LinkQ first; // ref to first item
    private LinkQ last; // ref to last item

    public FirstLastListQ(){
        first = null; // no items on list yet
        last = null;
    } // constructor for list

    public boolean isEmpty(){
        return (first == null);
    }

    public void insertLast(long dd){
        LinkQ newLink = new LinkQ(dd); // make new Link
        if( isEmpty() )
            first = newLink; // first --> newLink
        else
            last.next = newLink; // old last --> newLink
        last = newLink; // last --> newLink
    }

    public long deleteFirst(){
        long temp = first.dData;
        if(first.next==null) // if only one item
            last = null; // last --> null
        first = first.next; // first --> old next
        return temp;
    }

    public void displayList(){
        LinkQ current = first; // start at beginning
        while(current != null) {
            current.displayLink(); // print data
            current = current.next;// move to next link
        }
        System.out.println();
    }

} // end class FirstLastListQ

public class QueOnLinkList {
    public static void main(String[] args){

        LinkQueue theQueue = new LinkQueue();

        theQueue.insert(20); // insert items
        theQueue.insert(40);

        theQueue.displayQueue(); // display queue

        theQueue.insert(60); // insert items
        theQueue.insert(80);

        theQueue.displayQueue();// display queue

        theQueue.remove();          // remove items
        theQueue.remove();

        theQueue.displayQueue();    // display queue
    } // end main method
}
