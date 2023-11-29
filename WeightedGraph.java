/* Code adopted from Advanced Data Structures by Robert Lafore */

public class WeightedGraph {
    private final int INFINITY = 1000000;
    private final int MAX_VERTS = 20;
    private Vertex[] vertexArray = new Vertex[MAX_VERTS];
    private int[][] adjacentMatrix = new int[MAX_VERTS][MAX_VERTS];
    private int nVertices = 0;
    private int nVerticesInTree;
       
    private PriorityQGraph priorityQGraph = new PriorityQGraph(MAX_VERTS);
    
    public WeightedGraph() {
        for (int i=0; i<MAX_VERTS; i++) {
            for (int j=0; j<MAX_VERTS; j++) {
                adjacentMatrix[i][j] = INFINITY;
            }
        }
    }
    
    private void addToPriorityQ(Edge newEdge) {
        int found = priorityQGraph.find(newEdge.destVertex);
        
        if (found != -1) {
            Edge temp = priorityQGraph.peekN(found);
            if (newEdge.weight < temp.weight) {
                priorityQGraph.removeN(found);
                priorityQGraph.insert(newEdge);
            }
        } else {
            priorityQGraph.insert(newEdge);
        }        
    }
    
    public void mstw() {
        int currentVertex = 0;
        
        while (nVerticesInTree < nVertices - 1) {
            vertexArray[currentVertex].setVisited(true);   // We are resuing wasVisited for "inTree" flag
            nVerticesInTree++;
            
            for (int i=0; i<nVertices; i++) {
                if (i == currentVertex) //Ignore - self
                    continue;
                
                if (vertexArray[i].wasVisited())  //Ignore if already added to Tree
                    continue;
                
                int w = adjacentMatrix[currentVertex][i];
                if (w == INFINITY)  //Ignore if edge does not exist
                    continue;
                
                Edge e = new Edge(currentVertex, i, w);
                addToPriorityQ(e);
            }
            
            if (priorityQGraph.isEmpty()) {
                System.out.println("Possible a disconnected Graph!!!");
                return;
            }
            
            Edge minWeightEdge = priorityQGraph.remove();
            int srcVertex = minWeightEdge.srcVertex;
            currentVertex = minWeightEdge.destVertex;
            
            displayVertex(srcVertex);
            displayVertex(currentVertex);
            System.out.println();            
        }
        
    }
    
    public int addVertex(char label) {
        Vertex v = new Vertex(label);
        int t = nVertices;
        vertexArray[nVertices++] = v;
        return t;
    }
    
    public void addEdge(int start, int end, int weight) {
        adjacentMatrix[start][end] = weight;
        adjacentMatrix[end][start] =  weight;
    }
    
    public void displayVertex(int v) {
        System.out.print(vertexArray[v].label);
    }
    
    public void displayAdjacencyMatrix() {
        for (int i=0; i < nVertices; i++) {
            for (int j=0; j < nVertices; j++) {
                System.out.print(adjacentMatrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
