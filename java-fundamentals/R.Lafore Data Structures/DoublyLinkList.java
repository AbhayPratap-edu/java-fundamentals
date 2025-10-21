package Lafor_Arrays;

class LinkDb{
    public long dData; // data item
    public LinkDb next; // next link in list
    public LinkDb previous; // previous link in list

    public LinkDb(long d){
        dData = d;
    } // constructor

    public void displayLink(){
        System.out.print(dData + " ");
    } // display this link

} // end class LinkDouble

class DoublyLinkedList{
    private LinkDb first; // ref to first item
    private LinkDb last; // ref to last item

    public DoublyLinkedList(){
        first = null; // no items on list yet
        last = null;
    } // constructor for double link list

    public boolean isEmpty(){
        return first==null;
    } // check if list is empty

    public void insertFirst(long dd){

        LinkDb newLink = new LinkDb(dd); // make new link

        if( isEmpty() )
            last = newLink; // if empty list , last --> newLink
        else
            first.previous = newLink; // newLink <-- old first
        newLink.next = first; // newLink --> old first
        first = newLink ; // first --> newLink
    }

    public void insertLast(long dd){

        LinkDb newLink = new LinkDb(dd); // make new Link

        if ( isEmpty() )
            first = newLink; // if list is empty , first -->
        else{
            last.next = newLink; // old last --> new Link
            newLink.previous = last; // old last <-- newLink
        }
        last = newLink; // last --> newLink
    }

    public boolean insertAfter(long key,long dd){

        LinkDb current = first; // start at beginning
        while(current.dData != key){
            current = current.next; // move to next link
            if(current == null)
                return false; // did not find it
        }

        LinkDb newLink = new LinkDb(dd); // make new Link

        if(current==last){
            newLink.next = null; // if last link , new --> null
            last = newLink; // last --> newLink
        }
        else{
            newLink.next = current.next; // newLink --> old next
            current.next.previous = newLink; // newLink <-- old next
        }
        newLink.previous = current; // old current <-- newLink
        current.next = newLink; // old current --> newLink
        return true; // found it , did insertion
    }

    public LinkDb deleteFirst(){
        LinkDb temp = first;
        if(first.next==null)
            last = null; // if only one item, last --> null
        else
            first.next.previous = null; // null <-- old prev
        first = first.next; // first --> old next
        return temp;
    }

    //null ← [first] ⇄ [node2] ⇄ [node3] → null
    //first → reference to the first node.
    //first.next → moves to the second node (node2).
    //first.next.previous → moves back to the first node.

    public LinkDb deleteLast(){
        LinkDb temp = last; //

        if(first.next==null)
            first=null; // if only one item , first --> null
        else
            last.previous.next = null; // old previous --> null
        last = last.previous; // old previous <-- last
        return temp;
    }

    public LinkDb deleteKey(long key){
        LinkDb current = first; // start at beginning

        while( current.dData != key) {
            current = current.next; // move to next link
            if (current == null)
                return null; // did not find it
        }
        if(current==first)
            first = current.next; // first --> old next
        else
            current.previous.next = current.next; // old prev --> old next
        if(current==last)
            last = current.previous; // last --> old prev
        else
            current.next.previous = current.previous; // old prev <--- old next

        return current; // return value

    }

    public void displayForward(){
        System.out.print("List (first-->last): ");

        LinkDb current = first;  // start at beginning
        while(current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward(){
        System.out.print("List (last-->first): ");

        LinkDb current = last; // start at end
        while(current != null){
            current.displayLink();
            current = current.previous;
        }

        System.out.println();

    }

} // end class doubleLinked List

public class DoublyLinkList {
    public static void main(String[] args){

        DoublyLinkedList theList = new DoublyLinkedList(); // make new list

        theList.insertFirst(22); // insert at front
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11); // insert at rear
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayForward(); // display list forward
        theList.displayBackward(); // display list backward

        theList.deleteFirst(); // delete first item
        theList.deleteLast(); // delete last item
        theList.deleteKey(11); // delete item with key 11

        theList.displayForward(); // display list forward

        theList.insertAfter(22, 77); // insert 77 after 22
        theList.insertAfter(33, 88); // insert 88 after 33

        theList.displayForward(); // display list forward

    } // end main() method
}
