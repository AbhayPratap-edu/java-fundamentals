package Lafor_Arrays;

class Node{
    public long dData; // data item
    public Node next; // next link in list

    public Node(long d){
        dData = d;
    }//constructor

    public void displayNode(){
        System.out.print(dData+" "); // display this link
    }

} // end class link

class FirstLastList{
    private Node first; // ref to first link
    private Node last; // ref to last link

    public FirstLastList() {
        first = null; // no links on list yet
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(long dd){
        Node newNode = new Node(dd); // make new link

        if( isEmpty() )
            last = newNode; // if list is empty then last --> newNode
        newNode.next = first; // oldFirst --> newNode
        first = newNode; // first --> newNode
    }

    public void insertLast(long dd){
        Node newNode = new Node(dd); // make new link
        if( isEmpty() )
            first = newNode; // first --> newLink
        else
            last.next = newNode; // old last --> newNode
        last = newNode; // last --> newNode
    }

    public long deleteFirst(){
        long temp = first.dData;
        if(first.next == null) // if only one item
            last = null; // last --> null
        first = first.next; // first --> old next
        return temp;
    }

    public void displayList(){
        System.out.println("List(first --> last); ");
        Node current = first; // start at beginning
        while(current != null ){
            current.displayNode(); // print data
            current = current.next; // move to next link
        }
    }

} // end first last List

public class DoubleEndList {
    public void main(String[] args){

        FirstLastList theList = new FirstLastList(); // make new list

        theList.insertFirst(22); // insert at front
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11); // insert at rear
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayList(); // display the list

        theList.deleteFirst(); // delete first two items
        theList.deleteFirst();

        theList.displayList(); // display again

    } // end main method
}
