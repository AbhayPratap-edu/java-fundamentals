package Lafor_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class delimiter {
    public static void main(String[] args) throws IOException{
        String input;
        while(true){
            System.out.println("Enter the string containing delimiter: ");
            System.out.flush(); // flush() forces the buffer to empty immediately
            input = getString(); // read a string from keyboard
            if(input.isEmpty()) // quit if user hit only enter
                break;

            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check(); // check brackets

        } // end while loop
    } // end main method

    static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    } // end getString method

} // end delimiter class

class BracketChecker{

    private String input;

    public BracketChecker(String in){
        input = in;
    } // constructor

    public void check(){
        int stackSize = input.length();
        StackC theStack = new StackC(stackSize); // stack created

        for(int j=0; j<input.length(); j++){
            char ch = input.charAt(j); // get char from input string
            switch (ch){
                case '{': // opening symbol
                case '[':
                case '(':
                    theStack.push(ch);
                    break;

                case '}': // closing symbols
                case ']':
                case ')':
                    if(!theStack.isEmpty() ){
                        char chx = theStack.pop();
                        if( (ch=='}' && chx!='{') || (ch==']' && chx!='[') || (ch==')' && chx!='(') )
                            System.out.println("Error: " +ch+ " at " + j);
                    } // pop and check if stack not empty
                    else  // stack is empty but found a closing braces
                        System.out.println("Error: " +ch+ " at " + j);
                    break;

                default: // no action on other characters
                    break;
            } // end switch case

        } // end for loop

        if( !theStack.isEmpty() ) // in stack if there is [{( without )}]
            System.out.println("Error: missing right delimiter");


    } // end check
}

class StackC{
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackC(int s){
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    } // constructor

    public void push(char j){
        stackArray[++top] = j;
    } // insert elements in stack

    public char pop(){
        return stackArray[top--];
    } // access element from stack top , then removes it

    public char peek(){
        return stackArray[top];
    } // read the elements from stack top

    public boolean isEmpty(){
        return (top == -1);
    }
}
