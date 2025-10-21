package Lafor_Arrays;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tree234 {
    public static void main(String[] args) throws IOException{
        long value;
        Tree234F theTree = new Tree234F();

        theTree.insert(50);
        theTree.insert(40);
        theTree.insert(60);
        theTree.insert(30);
        theTree.insert(70);

        while(true){
            System.out.print("Enter first letter of ");
            System.out.print("show,insert or find: ");
            char choice = getChar();
            switch (choice){
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter the value to insert: ");
                    value = getInt();
                    theTree.insert(value);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    int found = theTree.find(value);
                    if(found != -1 )
                        System.out.println("Found "+value);
                    else
                        System.out.println("could not find the value:"+value);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }// end switch
        } // end while
    }

    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    private static long getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    private static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }
}

class Tree234F{
    //Methods - find,insert,split,getNextChild,recDisplayTree,

    private Node234 root = new Node234();

    public int find(long key){
        Node234 curNode = root;
        int childNumber;
        while(true){
            if((childNumber=curNode.findItem(key) ) != -1 )
                return childNumber; // found it
            else if(curNode.isLeaf())
                return -1; // can't find it search deeper
            else 
                curNode = getNextChild(curNode,key);
        }
    }// end find
    
    public void insert(long dValue){
        Node234 curNode = root;
        DataItem tempItem = new DataItem(dValue);
        
        while(true){
            if(curNode.isFull() ){
                split(curNode); //split it
                curNode = curNode.getParent(); // backup
                curNode = getNextChild(curNode,dValue);// search once
            } // end if ( node is full )
            else if(curNode.isLeaf() ) // if node is leaf go insert
                break;
            else // node is not full , not a leaf; go to lower level
                curNode = getNextChild(curNode,dValue);
        } // end while
        curNode.insertItem(tempItem); // insert new DataItem
    }// end insert
    
    public void split(Node234 thisNode){
        //assumes the node is full
        DataItem itemB,itemC;
        Node234 parent,child2,child3;
        int itemIndex;
        
        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();
        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);
        
        Node234 newRight = new Node234();
        
        if(thisNode == root){
            root = new Node234();
            parent = root;
            root.connectChild(0,thisNode);
        }
        else 
            parent = thisNode.getParent();
        // deal with parent
        itemIndex = parent.insertItem(itemB);// item B to parent
        int n = parent.getNumItems(); // total items
        
        for(int j=n-1;j>itemIndex;j--){
            Node234 temp = parent.disconnectChild(j);
            parent.connectChild(j+1,temp);
        }// move parents connections one child to the right
        
        //connect newRight to parent
        parent.connectChild(itemIndex+1,newRight);
        //deal with newRight
        newRight.insertItem(itemC); // item c to newRight
        newRight.connectChild(0,child2);// connect 0 and 1 on newRight
        newRight.connectChild(1,child3);
    }// end split

    //gets appropriate child of node during search for value
    public Node234 getNextChild(Node234 theNode,long theValue){
        int j;
        // assumes node is not empty , not full , not a leaf
        int numItems = theNode.getNumItems();
        for(j=0;j<numItems;j++){
            if( theValue<theNode.getItem(j).dData)
                return theNode.getChild(j);
        }// end for
        return theNode.getChild(j);
    }

    public void displayTree(){
        recDisplayTree(root,0,0);
    }

    private void recDisplayTree(Node234 thisNode, int level, int childNumber) {
        System.out.print("level="+level+"child="+childNumber+" ");
        thisNode.displayNode();

        //call ourselves for each child of this node
        int numItems = thisNode.getNumItems();
        for(int j=0;j<numItems+1;j++){
            Node234 nextNode = thisNode.getChild(j);
            if(nextNode != null )
                recDisplayTree(nextNode,level+1,j);
            else
                return;
        }
    } // end recDisplayTree()
}//end class Tree234F

class DataItem{
    public long dData;

    public DataItem(long dd){
        dData = dd;
    }

    public void displayItem(){
        System.out.print("/"+dData);
    }
}// end class DataItem

class Node234{

    // Methods - connectChild,disconnectChild,getChild,getParent,isLeaf,getNumItems,getItem,
    // isFull,findItem,insertItem,removeItem,displayNode .

    private static final int ORDER = 4;
    private int numItems;
    private Node234 parent;
    private Node234 childArray[] = new Node234[ORDER];
    private DataItem itemArray[] = new DataItem[ORDER-1];

    public void connectChild(int childNum,Node234 child){
        childArray[childNum] = child;
        if(child!=null)
            child.parent = this;
    }//connect child to this node

    public Node234 disconnectChild(int childNum){
        Node234 tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }//disconnect child from this node, return it

    public Node234 getChild(int childNum){
        return childArray[childNum];
    }

    public Node234 getParent(){
        return parent;
    }

    public boolean isLeaf(){
        return (childArray[0]==null)?true:false;
    }

    public int getNumItems(){
        return numItems;
    }

    public DataItem getItem(int index){
        return itemArray[index];
    }

    public boolean isFull(){
        return (numItems==ORDER-1)?true:false;
    }

    public int findItem(long key){
        for(int j=0;j<ORDER-1;j++){
            if(itemArray[j]==null)
                break;
            else if(itemArray[j].dData==key)
                return j;
        }
        return -1;
    }//return index of item(within node) if found, otherwise -1

    public int insertItem(DataItem newItem){
        //assumes node is not full
        numItems++;
        long newKey = newItem.dData; // key of new item

        for(int j=ORDER-1;j>=0;j--){
            if(itemArray[j]==null)
                continue;
            else{
                long itsKey = itemArray[j].dData;
                if(newKey<itsKey)
                    itemArray[j+1] = itemArray[j];
                else{
                    itemArray[j+1] = newItem;
                    return j+1;
                }
            }//end else(not Null)
        }// end for
        itemArray[0] = newItem;
        return 0;
    }// end insert item

    public DataItem removeItem(){
        //assumes node not empty
        DataItem temp = itemArray[numItems-1];
        itemArray[numItems-1] = null;
        numItems--;
        return temp;
    }//remove largest item

    public void displayNode(){
        for(int j=0;j<numItems;j++)
            itemArray[j].displayItem();
        System.out.println("/");
    }
}// end class node
