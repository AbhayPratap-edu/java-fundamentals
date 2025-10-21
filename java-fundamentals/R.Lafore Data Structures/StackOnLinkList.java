//package java_fundamentals;
package Lafor_Arrays;

//LinkS = node.
//LinkListS = manages nodes.
//LinkStack = adapts linked list to work like a stack.
//StackOnLinkList = test drive

class LinkStack{

    private LinkListS theList; //

    public LinkStack(){
        theList = new LinkListS();
    } // constructor for List to use as stack

    public void push(long j){
        theList.insertFirst(j);
    } // put item on top of stack

    public long pop(){
        return theList.deleteFirst();
    } // take item from top of stack and remove it

    public boolean isEmpty(){
        return (theList.isEmpty());
    } // check if stack is empty

    public void displayStack(){
        System.out.print("Stack (top --> bottom): ");
        theList.displayList();
    }
} // end class Link Stack

class LinkS{

    public long dData; // data item
    public LinkS next; // next link in list

    public LinkS(long dd){
        dData = dd;
    } // Link constructor

    public void displayLink(){
        System.out.print(dData + " ");
    } // Link display ourselves

} // end class Link

class LinkListS{
    private LinkS first; // ref to first item on list

    public LinkListS(){
        first = null; // no items on list yet
    } // List constructor

    public boolean isEmpty(){
        return (first==null);
    }

    public void insertFirst(long dd){
        LinkS newLink = new LinkS(dd); // make new link
        newLink.next = first; // newLink --> old first
        first = newLink; // first --> newLink
    }

    public long deleteFirst(){
        LinkS temp = first; // save ref to link
        first = first.next; // delete it: first --> old next
        return temp.dData; // return deleted link
    }

    public void displayList(){
        LinkS current = first; // start at beginning of list
        while( current != null ){
            current.displayLink(); // print link data
            current = current.next; // move to next link
        }
        System.out.println();
    }

} // end class LinkList

public class StackOnLinkList {
    public static void main(String[] args){

        LinkStack theStack = new LinkStack(); // make stack

        theStack.push(20); // insert items to stack
        theStack.push(40);

        theStack.displayStack(); // display stack

        theStack.push(60); // push items
        theStack.push(80);

        theStack.displayStack(); // display stack

        theStack.pop(); // pop items
        theStack.pop();

        theStack.displayStack(); // display stack

    }// end main method

}
