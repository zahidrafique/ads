/* Code adopted from Advanced Data Structures by Robert Lafore */
import java.util.ArrayList;

public class ToplogicalSort {
    private final int MAX_VERTS = 20;
    final private Vertex[] vertexList = new Vertex[MAX_VERTS];
    final private int[][] adjacentMatrix = new int[MAX_VERTS][MAX_VERTS];
    private int nVertices = 0;
    
    private final ArrayList<String> edgeList = new ArrayList<>();    
    private final StackInt stack = new StackInt(MAX_VERTS);
    
    private final Vertex[] sortedVerticesList = new Vertex[MAX_VERTS];
    
    public int addVertex(char label) {
        Vertex vertex = new Vertex(label);
        int i = nVertices;
        vertexList[nVertices++] = vertex;
        return i;
    }
    
    public void addEdge(int start, int end) {
        adjacentMatrix[start][end] = 1;
    }
    
    private int vertexWithNoSuccessors() {
        boolean isEdge = false;
        for (int r=0; r <  nVertices; r++) {
            isEdge = false;
            for (int c=0; c < nVertices; c++) {
                if (adjacentMatrix[r][c] == 1) {
                    isEdge = true;
                    break;
                }
            }
            
            if (!isEdge)
                return r;
        }
        
        return -1;
    }
    
    private void deleteVertex(int v) {
        if (v != nVertices - 1) {
            for (int i=v; i < nVertices-1; i++) 
                vertexList[i] = vertexList[i+1];
            
            for (int r=v; r < nVertices -1; r++)
                for (int c = 0; c < nVertices; c++)
                    adjacentMatrix[r][c] = adjacentMatrix[r+1][c];
            
            for (int c=v; c < nVertices-1; c++)
                for (int r=0; r < nVertices; r++)
                    adjacentMatrix[r][c] = adjacentMatrix[r][c+1];
        }
        
        nVertices--;
    }
    
    public void topo() {
        int originalNVertices = nVertices;
        while (nVertices > 0) {
            int v = vertexWithNoSuccessors();
            if (v == -1) {
                System.out.println("A cycle is found. Stopping the operation.");
                break;
            } else {
                sortedVerticesList[nVertices - 1] = vertexList[v];
                deleteVertex(v);
            }
        }
        
        for (int i=0; i < originalNVertices; i++) {
            System.out.print(sortedVerticesList[i].label);
        }
        System.out.println();
    }
    
    private int getAdjacentUnvisitedVertex(int current) {
        for (int c=0; c<  MAX_VERTS; c++) {
            if (adjacentMatrix[current][c] == 1 && !vertexList[c].wasVisited())
                return c;
        }
        
        return -1;
    }
    
    private void processVertex(int v) {
        vertexList[v].setVisited(true);
        //displayVertex(v);
        stack.push(v); 
    }
    
    public void dfs() {
        processVertex(0);
        
        while (!stack.isEmpty()) {
            int a = getAdjacentUnvisitedVertex(stack.peek());
            
            if (a == -1) {
                stack.pop();
            } else {
                processVertex(a);
            }
        }
    }
    
    public void mst(int startIndex, int endIndex) {
        processVertex(startIndex);
        char beforeStart = '\0';
        char start = vertexList[startIndex].label;
        
        while (!stack.isEmpty()) {
            int t = stack.peek();
            
            int a = getAdjacentUnvisitedVertex(t);
            
            if (a == -1) {
                stack.pop();
                if (!stack.isEmpty())
                    start = vertexList[stack.peek()].label;
            } else {
                if (t == startIndex)
                    edgeList.removeAll(edgeList);
                else {
                    if (vertexList[t].label == beforeStart && edgeList.size() > 0)
                        edgeList.remove(edgeList.size() - 1);
                }
                
                processVertex(a);
                char end = vertexList[a].label;
                char[] s = {start, end};
                String edge = new String(s);
                edgeList.add(edge);
                beforeStart = start;
                start = end;
                
                if (a == endIndex) {
                    break;  
                }
            }
        }
        
        for (String edge : edgeList) {
            System.out.print(edge + " ");
        }
        System.out.println();
    }
    
    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }
    
    public void displayAdjacencyMatrix() {
        for (int i=0; i < MAX_VERTS; i++) {
            for (int j=0; j < MAX_VERTS; j++) {
                System.out.print(adjacentMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
