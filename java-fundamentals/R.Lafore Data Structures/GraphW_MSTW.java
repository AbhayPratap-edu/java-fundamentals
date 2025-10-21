package Lafor_Arrays;

public class GraphW_MSTW {
    public static void main(String[] args){
        Graph_MSW theGraph = new Graph_MSW();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addVertex('F');

        theGraph.addEdge(0,1,6); // AB 6
        theGraph.addEdge(0, 3, 4); // AD 4
        theGraph.addEdge(1, 2, 10); // BC 10
        theGraph.addEdge(1, 3, 7); // BD 7
        theGraph.addEdge(1, 4, 7); // BE 7
        theGraph.addEdge(2, 3, 8); // CD 8
        theGraph.addEdge(2, 4, 5); // CE 5
        theGraph.addEdge(2, 5, 6); // CF 6
        theGraph.addEdge(3, 4, 12); // DE 12
        theGraph.addEdge(4, 5, 7); // EF 7

        System.out.print("Minimum spanning tree: ");
        theGraph.mstw(); // minimum spanning tree
        System.out.println();
    }
}

class Graph_MSW{
    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private VertexMSW[] vertexList;
    private int[][] adjMat;
    private int nverts;
    private int currentVert;
    private PriorityQ_MST thePQ;
    private int nTree;

    public Graph_MSW(){
        vertexList = new VertexMSW[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nverts = 0;
        for(int j=0; j<MAX_VERTS; j++)
            for(int k=0; k<MAX_VERTS; k++)
                adjMat[j][k] = INFINITY;
        thePQ = new PriorityQ_MST();
    } // end constructor

    public void addVertex(char lab){
        vertexList[nverts++] = new VertexMSW(lab);
    }

    public void addEdge(int start,int end,int weight){
        adjMat[start][end] = weight;
        adjMat[end][start] = weight;
    }

    public void displayVertex(int v){
        System.out.print(vertexList[v].label);
    }

    public void mstw(){
        currentVert = 0;
        while(nTree<nverts-1) // while not all verts in tree
        {
            vertexList[currentVert].isInTree = true; // put currentVert in tree
            nTree++;

            // insert edges adjacent to currentVert into PQ
            for(int j=0; j<nverts; j++) // each vertex
            {
                if(j==currentVert) // skip if it's us
                    continue;
                if(vertexList[j].isInTree) // skip if in tree
                    continue;
                int distance = adjMat[currentVert][j];
                if(distance == INFINITY) // skip if node
                    continue;
                putInPQ(j,distance); // put in PQ (maybe)
            }
            if(thePQ.isEmpty() ) // no vertices in pq
            {
                System.out.println(" GRAPH NOT CONNECTED");
                return;
            }

            //remove edge with minimum distance,from PQ
            EdgeMS theEdge = thePQ.removeMin();
            int sourceVert = theEdge.srcVert;
            currentVert = theEdge.destVert;

            //display edge from source to current
            System.out.print(vertexList[sourceVert].label);
            System.out.print(vertexList[currentVert].label);
            System.out.print(" ");
        }// end while(not all verts in tree)

        //mst is complete
        for(int j=0; j<nverts; j++)
            vertexList[j].isInTree = false;
    } // end mstw

    public void putInPQ(int newVert, int newDist) {
        // is there another edge with same destination vertex?
        int queueIndex = thePQ.find(newVert);
        if(queueIndex != -1) // got edge's index
        {
            EdgeMS tempEdge = thePQ.peekN(queueIndex); //get edge
            int oldDist = tempEdge.distance;
            if(oldDist>newDist) // if new edge shorter,
            {
                thePQ.removeN(queueIndex);// remove old edge
                EdgeMS theEdge = new EdgeMS(currentVert,newVert,newDist);
                thePQ.insert(theEdge);// insert new edge
            }
            //else no action;just leave the old vertex there
        }//end if
        else// no edge with same destination vertex
        {
            EdgeMS theEdge = new EdgeMS(currentVert,newVert,newDist);
            thePQ.insert(theEdge);
        }
    }// end putInPQ()

}// end class Graph

class PriorityQ_MST{
    //array in sorted order,from max at 0 to min at size-1
    private final int SIZE = 20;
    private EdgeMS[] queArray;
    private int size;

    public PriorityQ_MST(){
        queArray = new EdgeMS[SIZE];
        size = 0;
    }

    public void insert(EdgeMS item){
        int j;

        for(j=0; j<size; j++) // find place to insert
            if(item.distance >= queArray[j].distance)
                break;

        for(int k=size-1; k>=j;k--) // move items up
            queArray[k+1] = queArray[k];

        queArray[j] = item;
        size++;
    }

    public EdgeMS removeMin(){
        return queArray[--size];
    } // remove minimum item

    public void removeN(int n){
        for(int j=n; j<size-1; j++)//move items down
            queArray[j] = queArray[j+1];
        size--;
    }

    public EdgeMS peekMin(){
        return queArray[size-1];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public EdgeMS peekN(int n){
        return queArray[n];
    }

    public int find(int findDex){
        for(int j=0; j<size; j++)
            if(queArray[j].destVert == findDex)
                return j;
        return -1;
    }

} // end class priorityQ

class VertexMSW{
    public char label;
    public boolean isInTree;

    public VertexMSW(char lab){
        label = lab;
        isInTree = false;
    }
}

class EdgeMS{
    public int srcVert; // index of vertex starting edge
    public int destVert; // index of a vertex ending edge
    public int distance; // distance from src to dest

    public EdgeMS(int sv,int dv,int d){
        srcVert = sv;
        destVert = d;
        distance = d;
    }
} // end class edge
