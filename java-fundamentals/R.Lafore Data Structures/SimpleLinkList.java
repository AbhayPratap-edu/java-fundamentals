package Lafor_Arrays;

class Link{
    public int iData; // data item(key)
    public double dData; // data item
    public Link next; // next Link in list . next is field of type Link
    // accessModifier, DataType-refersToCustomClass Link , nextField = variableName store ref to anotherLink

    public Link(int id, double dd){
        iData = id; // initialize data
        dData = dd; //  ('next' is automatically set to null because it’s an object reference
    } // constructor

    public void displayLink(){
        System.out.println("{"+iData+", "+dData+"} ");
    }
} // end class Link

//first = external reference (from the LinkedList object) → entry point into the list.
// next = internal reference (from inside a Link) → connects nodes together.

class LinkList{
    private Link first; // ref to first link on list
    // first is a reference variable of type Link.
    //  head pointer (entry to the chain)

    public LinkList(){
        first = null; // no items on list yet
    } // constructor

    public boolean isEmpty(){
        return (first==null);
    }

    public void insertFirst(int id,double dd){
        Link newLink = new Link(id , dd); // make new Link
        newLink.next = first; // newLink --> old first
        first = newLink; // first --> newLink
    } // insert item at start of list
    
    public Link deleteFirst(){
        Link temp = first; // save references to link
        first = first.next; // delete it: first--> old next
        return temp; // return deleted link
    } // delete first item on link

    public void displayList(){
        System.out.println("List (first-->last): ");
        Link current = first; // start at beginning of list
        while(current!=null){
            current.displayLink(); // print  data
            current = current.next; // move to next link
        }
    }

    public Link find(int key){
        Link current = first; //
        while( current.iData != key){
            if(current.next==null) // if end of list
                return null; // did not find it
            else
                current = current.next; // go to next link
        }
        return current; // found it
    } // find link with key

    public Link delete(int key) {
        Link current = first; // search for link
        Link previous = first;
        while(current.iData != key){
            if(current.next == null)
                return null; // didn't find it
            else {
                previous = current; // go to next link
                current = current.next;
            }
        } // found it
        if(current==first) // if first link,
            first = first.next; // change first
        else // otherwise ,
            previous.next = current.next; // bypass it
        return current;
    } // delete link with given key

} // end class LinkList

public class SimpleLinkList {
    public static void main(String[] args){
        LinkList theList = new LinkList(); // make new list

        theList.insertFirst(22, 2.99); // insert four items
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList(); // display list

        while( !theList.isEmpty() ){
            Link aLink = theList.deleteFirst(); // delete link
            System.out.print("Deleted "); // display it
            aLink.displayLink();
            System.out.println();
        }

        theList.displayList(); // display list

        Link f = theList.find(44);
        if(f != null )
            System.out.println("Found link with key " + f.iData);
        else
            System.out.println("Can't find link");

        Link d = theList.delete(66);
        if(d != null)
            System.out.println("Deleted link with key " + d.iData);
        else
            System.out.println("Can't delete link");

        theList.displayList();

    }// end main() method
}
