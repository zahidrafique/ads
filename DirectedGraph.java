/* Code adopted from Advanced Data Structures by Robert Lafore */

import java.util.ArrayList;

public class DirectedGraph {
    private final int MAX_VERTS = 20;
    final private Vertex[] vertexList = new Vertex[MAX_VERTS];
    final private int[][] adjacentMatrix = new int[MAX_VERTS][MAX_VERTS];
    final private int[][] connectivityMatrix = new int[MAX_VERTS][MAX_VERTS];
    private int nVertices = 0;
    
    private final ArrayList<String> edgeList = new ArrayList<>();    
    private final StackInt stack = new StackInt(MAX_VERTS);
    
    public int addVertex(char label) {
        Vertex vertex = new Vertex(label);
        int i = nVertices;
        vertexList[nVertices++] = vertex;
        return i;
    }
    
    public void addEdge(int start, int end) {
        adjacentMatrix[start][end] = 1;
    }
    
    private int getAdjacentUnvisitedVertex(int current) {
        for (int c=0; c<  MAX_VERTS; c++) {
            if (adjacentMatrix[current][c] == 1 && !vertexList[c].wasVisited())
                return c;
        }
        
        return -1;
    }
    
    public  boolean isConnected(int s, int e) {
        return connectivityMatrix[s][e] == 1;
    }
    
    public void updateConnectivityMatrix() {    //Warshall's Algorithm
        for (int r=0; r < MAX_VERTS; r++) {
            for (int c=0; c < MAX_VERTS; c++) {
                if (adjacentMatrix[r][c] == 1) {
                    for (int i=0; i < MAX_VERTS; i++) {
                        if (adjacentMatrix[i][r] == 1) {
                            connectivityMatrix[i][c] = 1;
                        }
                    }
                    
                    connectivityMatrix[r][c] = 1;
                }
            }
        }
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
        for (int i=0; i < nVertices; i++) {
            for (int j=0; j < nVertices; j++) {
                System.out.print(adjacentMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    public void displayConnectivityMatrix() {
        for (int i=0; i < nVertices; i++) {
            for (int j=0; j < nVertices; j++) {
                System.out.print(connectivityMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
