package Lafor_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BinaryTree {
    public static void main(String[] args) throws IOException{

        int value;
        Tree theTree = new Tree();

        theTree.insert(50, 1.5);
        theTree.insert(25, 1.2);
        theTree.insert(75, 1.7);
        theTree.insert(12, 1.5);
        theTree.insert(37, 1.2);
        theTree.insert(43, 1.7);
        theTree.insert(30, 1.5);
        theTree.insert(33, 1.2);
        theTree.insert(87, 1.7);
        theTree.insert(93, 1.5);
        theTree.insert(97, 1.5);

        while(true){
            System.out.print("Enter first letter of show, ");
            System.out.print("insert, find, delete, or traverse: ");
            int choice = getChar();
            switch (choice){
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value,value+0.9);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    TreeNode found = theTree.find(value);
                    if(found != null ){
                        System.out.print("found: ");
                        found.displayNode();
                        System.out.print("\n");
                    }
                    else
                        System.out.print("could not find ");
                    System.out.print(value + '\n');
                    break;
                case 'd':
                    System.out.print("Enter to value to delete: ");
                    value = getInt();
                    boolean didDelete = theTree.delete(value);
                    if(didDelete)
                        System.out.print("Deleted " + value +'\n');
                    else
                        System.out.print("Could not delete ");
                    System.out.print(value + '\n');
                    break;
                case 't':
                    System.out.print("Enter type 1,2 or 3: ");
                    value = getInt();
                    theTree.traverse(value);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            } // end switch
        } // end while
    } // end main

    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public static int getInt() throws IOException{
        String s = getString();
        return Integer.parseInt(s);
    }

    public static char getChar() throws IOException{
        String s = getString();
        return s.charAt(0);
    }
}// end binary tree

class TreeNode{
    public int iData ;
    public double dData;
    public TreeNode leftChild;
    public TreeNode rightChild;

    public void displayNode(){
        System.out.print("{"+iData+", "+dData+"} ");
    }
} // End class TreeNode

class Tree{
    private TreeNode root; // first node of tree

    public Tree(){
        root = null;
    }// constructor , no nodes in tree yet

    public void insert(int id,double dd){

        TreeNode newNode = new TreeNode();// make new node
        newNode.iData = id;
        newNode.dData = dd;
        if(root==null)
            root=newNode;
        else{
            TreeNode current = root;
            TreeNode parent;
            while(true){
                parent = current;
                if(id<current.iData){// go left
                    current = current.leftChild;
                    if(current==null){ // end of the line
                        parent.leftChild = newNode;
                        return;
                    }
                }// end If- go left
                else{ // or go right
                    current = current.rightChild;
                    if(current==null){//if end of the line
                        parent.rightChild = newNode;
                        return;
                    }
                }// end else go right

            }// end while

        }// end else not root

    }// end insert

    public boolean delete(int key){

        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;

        while(current.iData != key ){
            parent = current;
            if(key < current.iData){
                isLeftChild = true;
                current = current.leftChild;
            }//go left
            else{
                isLeftChild = false;
                current = current.rightChild;
            }//go right
            if(current==null) // end of line
                return false; // did not find it
        }// end while loop

        //FOUND NODE TO BE DELETED

        //CASE-1 if no children,simply delete it
        if(current.leftChild==null && current.rightChild==null){
            if(current==root)
                root = null;
            else if(isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        } // end case-1
        //CASE-2A if no right child , replace with left subtree
        else if(current.rightChild==null) {
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        }// end case2A
        //CASE-2B if no left child , replace with right subtree
        else if(current.leftChild==null){
            if(current == root )
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        }//end case2B
        //CASE-3 two children , so replace with inorder successor
        else {
            // get successor of NOde to be deleted
            TreeNode successor = getSuccessor(current);

            //connect parent of current to successor instead
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;

            //connect successor to current's left child
            successor.leftChild = current.leftChild;
        }// end case3
        // successor cannot have left child

        return true;
    }// end delete(key)

    private TreeNode getSuccessor(TreeNode delNode){
        TreeNode successorParent = delNode;
        TreeNode successor = delNode.rightChild;
        TreeNode current = delNode.rightChild;

        while(current != null ){

            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if(successor != delNode.rightChild ){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;
    }// end getSuccessor

    public TreeNode find(int key){

        TreeNode current = root;
        while(current.iData != key){
            if(key<current.iData)
                current = current.leftChild;
            else
                current = current.rightChild;
            if(current==null)
                return null; // did not find it
        }
        return current; // found it
    } // end find()

    public void traverse(int traverseType){

        switch (traverseType)
        {
            case 1: System.out.print("\nPreorder traversal: ");
                    preOrder(root);
                    break;
            case 2: System.out.print("\nInorder traversal: ");
                    inOrder(root);
                    break;
            case 3: System.out.print("\nPostorder traversal: ");
                    postOrder(root);
                    break;
        }
        System.out.println();
    }




    private void preOrder(TreeNode localRoot) {
        if(localRoot != null){
            System.out.print(localRoot.iData +" ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(TreeNode localRoot) {
        if(localRoot != null ){
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(TreeNode localRoot) {
        if(localRoot != null ){
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

    public void displayTree(){

        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");

        while(isRowEmpty==false){
            Stack localStack = new Stack<>();
            isRowEmpty = true;

            for(int j=0;j<nBlanks;j++)
                System.out.print(' ');

            while(globalStack.isEmpty() == false ){

                TreeNode temp = (TreeNode)globalStack.pop();
                if(temp != null ){
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if(temp.leftChild != null || temp.rightChild != null )
                        isRowEmpty = false;
                }
                else{
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j<nBlanks*2-2; j++)
                    System.out.print(' ');
            } // end while global stack not empty
            System.out.println();
            nBlanks /=2;
            while(localStack.isEmpty()==false)
                globalStack.push(localStack.pop() );
        } // end while isRowEmpty is false
        System.out.println("......................................................");
    } // end display tree

} // end class tree

//tree as an array. For a node at index x in the array,
//• Its parent is (x-1) / 2.
//• Its left child is 2*x + 1.
//• Its right child is 2*x + 2.


