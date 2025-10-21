package Lafor_Arrays;

public class StackOnArray {
    public static void main(String[] args){
        StackB theStack = new StackB(10); // create new stack

        theStack.push(20); // push items onto stack
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while( !theStack.isEmpty() ) // until it's empty , delete item from stack
        {
            long value = theStack.pop();
            System.out.print(value); // display the last accessed element
            System.out.print(" ");
        } // end while

        System.out.println();

    }
}

class StackB {
    private int maxSize; // size of stack array
    private long[] stackArray;
    private int top; // top of stack

    public StackB( int s){
        maxSize = s;  // set array size
        stackArray = new long[maxSize];  // create array
        top = -1; // no items yet
    } // constructor

    // push - insert item at top
    //pop - access element at top and remove
    // peek - read element from top

    public void push(long j){
        stackArray[++top] = j; // insert item , increment top
    } // put item on top of stack

    public long pop(){
        return stackArray[top--]; // first return current value of top then decrement top by 1
    } // take item from top of stack

    public long peek(){
        return stackArray[top];
    } // read the top element

    public boolean isEmpty(){
        return (top == maxSize -1);
    } // true if stack is empty

    public boolean isFull(){
        return ( top == maxSize -1 );
    } // true if stack is full

}

