package Lafor_Arrays;

class LinkSo{

    public long dData; // data item
    public LinkSo next; // next link in list

    public LinkSo(long dd){
        dData = dd;
    } // constructor for link

    public void displayLink(){
        System.out.print(dData + " ");
    }

} // end class LinkSo

class  SortedList{

    private LinkSo first; // ref to first item on list

    public SortedList(){
        first = null;
    } // constructor for sortedList

    public boolean isEmpty(){
        return (first==null);
    } // checks if link is empty

    public void insert(long key){
        LinkSo newLink = new LinkSo(key); // make new link

        LinkSo previous = null; // start at first
        LinkSo current = first; //
        while(current != null && key > current.dData){
            previous = current;
            current = current.next; // go to next item
        } // loop until end of list or key > current
        if(previous == null)        // at beginning of list
            first = newLink;        // first --> newLink
        else                        // if not at beginning
            previous.next = newLink; // old prev --> newLink
        newLink.next = current;      // newLink --> old current

    } // end sorted insert

    public LinkSo remove(){
        LinkSo temp = first; // save first
        first = first.next; // delete first
        return temp;        // return value
    } // return and delete first link

    public void displayList(){
        System.out.print("List (first--> last): ");

        LinkSo current = first; // start at beginning of list
        while(current != null){
            current.displayLink(); // print data
            current = current.next; // move to next link
        }
        System.out.println();
    }


} // end class sorted list

class SortedLinkList{
    public static void main(String[] args){

        SortedList theSortedList = new SortedList(); // create new list

        theSortedList.insert(20); // insert 2 items
        theSortedList.insert(40);

        theSortedList.displayList(); // display list

        theSortedList.insert(10); // insert 3 more items
        theSortedList.insert(30);
        theSortedList.insert(50);

        theSortedList.displayList(); // display list

        theSortedList.remove(); // remove an item

        theSortedList.displayList(); // display list

    } // end main() method
}

