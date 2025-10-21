package Lafor_Arrays;

public class GraphN_BFS {
    public static void main(String[] args){
        GraphNB theGraph = new GraphNB();

        theGraph.addVertex('A'); // 0 (start for bfs)
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4

        theGraph.addEdge(0, 1); // AB
        theGraph.addEdge(1, 2); // BC
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(3, 4); // DE

        System.out.print("Visits: ");
        theGraph.bfs(); // depth-first search
        System.out.println();
    }// END MAIN
}

class GraphNB{
    private final int MAX_VERTS = 20;
    private VertexGD[] vertexList; // list of vertices
    private int[][] adjMat; // adjacency matrix
    private int nVerts; // current number of vertices
    private QueueGB theQueue;

    public GraphNB(){
        vertexList = new VertexGD[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;

        // set adjacency
        for(int j=0;j<MAX_VERTS;j++)
            for(int k=0;k<MAX_VERTS;k++)
                adjMat[j][k] = 0;
        theQueue = new QueueGB();
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

    public void bfs()// breadth-first search
    {
        vertexList[0].wasVisited = true; // mark it
        displayVertex(0); // display it
        theQueue.insert(0); // insert at tail
        int v2;

        while( !theQueue.isEmpty() ){
            int v1 = theQueue.reomve();// remove vertex at head
            //until it has no unvisited neighbours
            while( (v2 = getAdjUnvisitedVertex(v1)) != -1 ){
                vertexList[v2].wasVisited = true; // mark it
                displayVertex(v2); // display it
                theQueue.insert(v2); // insert it
            } // end while
        } // end while (queue not empty)

        //queue is empty , so we are done
        for(int j=0;j<nVerts;j++) // reset flags
            vertexList[j].wasVisited = false;
    } // end bfs

    // returns an unvisited vertex adjacent to v
    private int getAdjUnvisitedVertex(int v) {
        for(int j=0;j<nVerts;j++)
            if(adjMat[v][j] == 1 && !vertexList[j].wasVisited)
                return j;
        return -1;
    } // end getAdjUnvisitedVertex()

} // end class Graph

class VertexGB{
    public char label;
    public boolean wasVisited;

    public VertexGB(char lab){
        label = lab;
        wasVisited = false;
    }
} // end class VertexGD

class QueueGB{
    private final int SIZE = 20;
    private int[] queArray;
    private int front;
    private int rear;

    public QueueGB() {
        queArray = new int[SIZE];
        front =0;
        rear = -1;
    }

    public void insert(int j){
        if(rear == SIZE-1)
            rear = -1;
        queArray[++rear] = j;
    } // put item at rear of queue

    public int reomve(){
        int temp = queArray[front++];
        if(front == SIZE)
            front = 0;
        return temp;
    } // take item from front of queue

    public boolean isEmpty(){
        return (rear+1==front || (front+SIZE-1 == rear) );
    }

} // end class QueueGB



