package Lafor_Arrays;

public class Graph_TopoSorting {
    public static void main(String[] args){
        GraphTP theGraph = new GraphTP();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addVertex('F');
        theGraph.addVertex('G');
        theGraph.addVertex('H');

        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(0, 4); // AE
        theGraph.addEdge(1, 4); // BE
        theGraph.addEdge(2, 5); // CF
        theGraph.addEdge(3, 6); // DG
        theGraph.addEdge(4, 6); // EG
        theGraph.addEdge(5, 7); // FH
        theGraph.addEdge(6, 7); // GH

        theGraph.topo(); // do the sort

    }
}

class GraphTP{
    private final int MAX_VERTS = 20;
    private VertexTP[] vertexList;
    private int[][] adjMat;
    private int nVerts; // current number of vertices
    private char[] sortedArray;

    public GraphTP(){
        vertexList = new VertexTP[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int j=0; j<MAX_VERTS; j++)
            for(int k=0; k<MAX_VERTS; k++)
                adjMat[j][k] = 0;
        sortedArray = new char[MAX_VERTS]; // sorted vertex labels
    }// end constructor

    public void addVertex(char lab){
        vertexList[nVerts++] = new VertexTP(lab);
    }

    public void addEdge(int start,int end){
        adjMat[start][end] = 1;
    }

    public void displayVertex(int v){
        System.out.print(vertexList[v].label);
    }

    public void topo(){
        int orig_nVerts = nVerts; // remember how many verts

        while(nVerts>0) // while vertices remain
        {
            // get a vertex with no successors, or -1
            int currentVertex = noSuccessors();
            if(currentVertex == -1) // must be a cycle
            {
                System.out.println("ERROR: Graph has cycles");
                return;
            }
            // insert vertex label in sorted array(start at end)
            sortedArray[nVerts-1] = vertexList[currentVertex].label;

            deleteVertex(currentVertex);
        } // end while

        // vertices all gone; display sortedArray
        System.out.print("TopoLogically sorted order: ");
        for(int j=0; j<orig_nVerts; j++)
            System.out.print(sortedArray[j]);
        System.out.println();
    } // end topo

    private int noSuccessors() {
        boolean isEdge; // edge from row to column in adjMat

        for(int row=0; row<nVerts; row++) // for each vertex,
        {
            isEdge = false; // check edges
            for(int col=0; col<nVerts; col++){
                if(adjMat[row][col]>0) // if edge to another,
                {
                    isEdge = true;
                    break; // this vertex
                } // has a successor
            } // try another
            if( !isEdge ) // if no edges,
                return row; // has no successors
        }
        return -1; // no such vertex
    }

    private void deleteVertex(int delVert) {
        if(delVert != nVerts-1 ) // if not last vertex
        {
            for(int j=delVert; j<nVerts-1; j++) // delete from vertexList
                vertexList[j] = vertexList[j+1];

            for(int row=delVert; row<nVerts-1; row++) // delete row from adjMat
                moveRowUp(row,nVerts);

            for(int col=delVert; col<nVerts-1;col++)
                moveColLeft(col,nVerts-1);
        }
        nVerts--;
    }

    private void moveColLeft(int col, int length) {
        for(int row=0; row<length; row++)
            adjMat[row][col] = adjMat[row][col+1];
    }

    private void moveRowUp(int row, int length) {
        for(int col=0; col<length; col++)
            adjMat[row][col] = adjMat[row+1][col];
    }
}

class VertexTP{
    public char label;

    public VertexTP(char lab){
        label = lab;
    }
}