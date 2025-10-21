package Lafor_Arrays;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class ListIterator{
    private LinkIt current; // node we’re sitting on
    private LinkIt previous; // previous link
    private LinkListIt ourList; // our LinkedList

    public ListIterator(LinkListIt list){
        ourList = list;
        reset();
    }

    public void reset(){
        current = ourList.getFirst();  // current --> first
        previous = null; // null <-- prev
    } // set current to start at first

    public boolean atEnd() {
        return (current.next == null);
    }

    public void nextLink(){
        previous = current; // oldCurrent <-- prev
        current = current.next; // current --> oldCurrentNext
    }

    public LinkIt getCurrent(){
        return current;
    } // get current Link

    public void insertAfter(long dd){
        LinkIt newLink = new LinkIt(dd);

        if(ourList.isEmpty() ){
            ourList.setFirst(newLink);
            current = newLink;
        }
        else{
            newLink.next = current.next;  // NewLink --> old current next
            current.next = newLink; // old current  --> newLink
            nextLink(); // point current to newLink
        }
    } // insertAfter current link

    public void insertBefore(long dd){
        LinkIt newLink = new LinkIt(dd);

        if(previous==null){
            newLink.next = ourList.getFirst(); // newLink --> oldFirst
            ourList.setFirst(newLink); // first --> newLink
            reset(); // current --> first
        }
        else{
            newLink.next = previous.next; // newLink --> old current
            previous.next = newLink; // old current prev <-- newLInk
            current = newLink; // current --> newLink
        }

    }// insert before current link

    public long deleteCurrent(){
        long value = current.dData;

        if(previous==null){ // beginning of list
            ourList.setFirst(current.next); // first --> currentNext
            reset(); // current --> first
        }
        else{
            previous.next = current.next; // prevNext --> currentNext
            if( atEnd() )
                reset(); // if current points to end , current --> first
            else
                current = current.next; // current --> oldCurrentNext
        }
        return value;
    } // delete item at current

} // end class List iterator

class LinkIt{
    public long dData; // data item
    public LinkIt next; // self-reference → points to another node

    public LinkIt(long dd) {
        dData = dd;
    } // constructor for Link

    public void displayLink(){
        System.out.print(dData + " ");
    }

} // end class LinkIt

class LinkListIt{

    private LinkIt first; // ref to first item on list

    public LinkListIt(){
        first = null; // no items on list yet
    } // constructor to initialize list

    public LinkIt getFirst(){
        return first;
    }

    public void setFirst(LinkIt f){
        first = f; // set first to newLink f
    }

    public boolean isEmpty(){
        return  first==null;
    } // check if list is empty

    public ListIterator getIterator(){
        return new ListIterator(this) ; // initialized with this list
        //this is a reference to the same object now executing the method.
    }

    public void displayList(){
        LinkIt current = first; //
        while(current != null ){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
} // end class LinkListIt


public class interIteratorForList {
    public static void main(String[] args) throws IOException{

        LinkListIt theList = new LinkListIt(); // new list
        ListIterator iter1 = theList.getIterator(); // new iterator
        long value;

        iter1.insertAfter(20); // insert items
        iter1.insertAfter(40);
        iter1.insertAfter(80);
        iter1.insertBefore(60);

        while(true){
            System.out.print("Enter first letter of show, reset, ");
            System.out.print("next, get, before, after, delete: ");
            System.out.flush();

            char choice = getChar();

            switch (choice){
                case 's': // show the list
                    if(!theList.isEmpty())
                        theList.displayList();
                    else
                        System.out.println("List is empty");
                    break;

                case 'r': // reset the iter to first
                    iter1.reset();
                    break;

                case 'n': // advance to next item
                    if( !theList.isEmpty() && !iter1.atEnd() )
                        iter1.nextLink();
                    else
                        System.out.println("Can not go to next link");
                    break;

                case 'g': // get current item
                    if( !theList.isEmpty() ){
                        value = iter1.getCurrent().dData;
                        System.out.println("Returned " + value);
                    }
                    else
                        System.out.println("List is empty");
                    break;

                case 'b': // insert before current
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertBefore(value);
                    break;

                case 'a': // insert after current
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertAfter(value);
                    break;

                case 'd': // delete current item
                    if( !theList.isEmpty() ){
                        value = iter1.deleteCurrent();
                        System.out.println("Deleted " + value);
                    }
                    else
                        System.out.println("can not delete");
                    break;

                default:
                    System.out.println("Invalid entry");

            } // end switch

        } // end while loop

    } // end main() method

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


