package Lafor_Arrays;

/*
CLASS — ParDist
      Represents one entry in the shortest path table (sPath).
      Each vertex has a ParDist object,
      showing (who’s your parent, and what’s your shortest distance so far)

CLASS — VertexDW
        Represents one vertex in the graph.
        Purpose:Tracks which vertices are already finalized in Dijkstra’s process (so we don’t update them again).

//CLASS 4 — GraphDW
    It manages: The vertices and edges (using adjacency matrix)
                The shortest-path table (sPath)
                The algorithm logic itself (Dijkstra’s steps)
    METHODS -
              path(): The main Dijkstra algorithm.
              Step-by-step: 1.Start at vertex 0 (A).
                             -Mark A as “in tree” and initialize sPath[] using A’s adjacency matrix row.
                            2.Repeat until all vertices are processed:
                             -Find the unvisited vertex with the smallest tentative distance → getMin()
                             -Mark it “in tree”
                             -Update distances to its neighbors → adjust_sPath()
                            3.After all are processed, call displayPaths() to print results.
                     Purpose: Finds the shortest path from A to every other vertex.
            getMin():
                    Finds the vertex not yet in the tree that has the smallest current distance.
                    Purpose: Selects the next vertex to expand in Dijkstra’s algorithm
           adjust_sPath():
                         Updates distances in shortest-path array sPath[] based on vertex just added (currentVert).
                         Steps: 1.For every vertex not yet in tree:
                                    Find the distance from start → current → that vertex.
                                    If it’s shorter than the currently known distance → update it.
                        Purpose: Keeps the shortest-path table accurate as the algorithm progresses.
*/

public class GraphDW_SP {
    public static void main(String[] args){
        GraphDW theGraph = new GraphDW();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');

        theGraph.addEdge(0, 1, 50); // AB 50
        theGraph.addEdge(0, 3, 80); // AD 80
        theGraph.addEdge(1, 2, 60); // BC 60
        theGraph.addEdge(1, 3, 90); // BD 90
        theGraph.addEdge(2, 4, 40); // CE 40
        theGraph.addEdge(3, 2, 20); // DC 20
        theGraph.addEdge(3, 4, 70); // DE 70
        theGraph.addEdge(4, 1, 50); // EB 50

        System.out.println("Shortest paths");
        theGraph.path();
        System.out.println();
    }// end main
}

// Parent and Distance class , items stored is sPath array
class ParDist
{
    public int distance; // distance from start to this vertex
    public int parentVert; // current parent of this vertex

    public ParDist(int pv,int d){
        distance = d;
        parentVert = pv;
    }
} // end class ParDist

class VertexDW{
    public char label;
    public boolean isInTree;

    public VertexDW(char lab){
        label = lab;
        isInTree = false;
    }
}

class GraphDW{
    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;
    private VertexDW[] vertexList; // list of Vertices
    private int adjMat[][];
    private int nVerts; // current number of vertices
    private int nTree; // number of vertices in tree
    private ParDist[] sPath; // array for shortes-path data
    private int currentVert; // current vertex
    private int startToCurrent; // distance to currentVert
    
    public GraphDW(){
        vertexList = new VertexDW[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        nTree = 0;
        for(int j=0;j<MAX_VERTS; j++)
            for(int k=0; k<MAX_VERTS; k++)
                adjMat[j][k] = INFINITY;
        sPath = new ParDist[MAX_VERTS];
    }// end constructor
    
    public void addVertex(char lab){
        vertexList[nVerts++] = new VertexDW(lab);
    }
    
    public void addEdge(int start,int end,int weight){
        adjMat[start][end] = weight;
    }
    
    // find all shortest paths
    public void path() {
        int startTree = 0; // start at vertex 0
        vertexList[startTree].isInTree = true; // put it in tree
        nTree = 1;
        // transfer row of distances from adjMat to sPath
        for(int j=0; j<nVerts; j++){
            int tempDist = adjMat[startTree][j];
            sPath[j] = new ParDist(startTree,tempDist);
        }
        //until all vertices are in the tree
        while(nTree<nVerts){
            int indexMin = getMin();// get minimum from sPath
            int minDist = sPath[indexMin].distance;

            if( minDist == INFINITY ){
                System.out.println("There are unreachable vertices");
                break; // sPath is complete
            }
            else{
                currentVert = indexMin; // reset currentVert to closest vert
                startToCurrent = sPath[indexMin].distance;
                // minimum distance from startTree is to currentVert, and is startToCurrent
            }
            // put current vertex in Tree
            vertexList[currentVert].isInTree = true;
            nTree++;
            adjust_sPath(); // update sPath[] array
        } // end while(nTree<nVerts)

        displayPaths(); // display sPath[] contents

        nTree = 0; // clear tree
        for(int j=0; j<nVerts; j++)
            vertexList[j].isInTree = false;
    } // end path()

    // get entry from sPath with minimum distance and not yet added to tree
    private int getMin() {
        int minDist = INFINITY;
        int indexMin = 0;
        for(int j=1;j<nVerts;j++)//for each vertex
        {
            if( !vertexList[j].isInTree && sPath[j].distance<minDist )
            {
                minDist = sPath[j].distance;
                indexMin = j;
            }
        }//end for
        return indexMin;
    } // end getMin

    private void adjust_sPath() {
        // adjust values in shortest-path array sPath
        int column = 1; // skip starting vertex
        while(column < nVerts ){
            //if this column's vertex already in tree,skip it
            if(vertexList[column].isInTree){
                column++;
                continue;
            }
            //calculate distance for one sPath entry
            int currentToFringe = adjMat[currentVert][column];// get edge from currentVert to column
            int startToFringe = startToCurrent + currentToFringe;//add distance from start
            int sPathDist = sPath[column].distance;// get distance of current sPath entry

            // compare distance from start with sPath entry
            if(startToFringe < sPathDist ) // if shorter , update sPath
            {
                sPath[column].parentVert = currentVert;
                sPath[column].distance = startToFringe;
            }
            column++;
        }// end while( column < nVerts )
    } // end adjust path

    private void displayPaths() {
        for(int j=0; j<nVerts; j++){
            System.out.print(vertexList[j].label + "="); // B=
            if(sPath[j].distance == INFINITY)
                System.out.print("INF");
            else
                System.out.print(sPath[j].distance);
            char parent = vertexList[sPath[j].parentVert].label;
            System.out.print("(" + parent + ") ");
        }
        System.out.println();
    }
}// end class Graph