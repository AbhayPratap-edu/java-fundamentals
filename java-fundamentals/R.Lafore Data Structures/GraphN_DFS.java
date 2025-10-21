package Lafor_Arrays;

public class GraphN_DFS {
    public static void main(String[] args){
        GraphND theGraph = new GraphND();

        theGraph.addVertex('A'); // 0 (start for dfs)
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4

        theGraph.addEdge(0, 1); // AB
        theGraph.addEdge(1, 2); // BC
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(3, 4); // DE

        System.out.print("Visits: ");
        theGraph.dfs(); // depth-first search
        System.out.println();
    }// END MAIN
} //

class GraphND{
    private final int MAX_VERTS = 20;
    private VertexGD[] vertexList; // list of vertices
    private int[][] adjMat; // adjacency matrix
    private int nVerts; // current number of vertices
    private StackGD theStack;

    public GraphND(){
        vertexList = new VertexGD[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;

        // set adjacency
        for(int j=0;j<MAX_VERTS;j++)
            for(int k=0;k<MAX_VERTS;k++)
                adjMat[j][k] = 0;
        theStack = new StackGD();
    } // end constructor

    public void addVertex(char lab){
        vertexList[nVerts++] = new VertexGD(lab);
    }

    public void addEdge(int start,int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v){
        System.out.print(vertexList[v].label);
    }

    public void dfs()// depth first search
    {
        vertexList[0].wasVisited = true; // begin at vertex 0 , mark it
        displayVertex(0); // display it
        theStack.push(0);  // push it

        while( !theStack.isEmpty() ){
            // get an unvisited vertex adjacent to stack top
            int v = getAdjUnvisitedVertex(theStack.peek());
            if(v == -1) // if no such vertex
                theStack.pop();
            else // if it exists
            {
                vertexList[v].wasVisited = true; // mark it
                displayVertex(v); // display it
                theStack.push(v); // push it
            }
        } // end while

        // stack is empty , so searching is done
        // reset flags
        for(int j=0;j<nVerts;j++)
            vertexList[j].wasVisited = false;
    } // end dfs

    // returns an unvisited vertex adjacent to v
    private int getAdjUnvisitedVertex(int v) {
        for(int j=0;j<nVerts;j++)
            if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
                return j;
        return -1;
    } // end getAdjUnvisitedVertex()

} // end class Graph

class VertexGD{
    public char label;
    public boolean wasVisited;

    public VertexGD(char lab){
        label = lab;
        wasVisited = false;
    }
} // end class VertexGD

class StackGD{
    private final int SIZE = 20;
    private int[] stack;
    private int top;

    public StackGD(){
        stack = new int[SIZE];
        top = -1;
    }

    public void push(int j){
        stack[++top] = j;
    }

    public int pop(){
        return stack[top--];
    }

    public int peek(){
        return stack[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }
} // end class stackGD
