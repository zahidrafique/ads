
import java.util.HashSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zrafique
 */
public class Dijkstra {
    private final int INFINITY = Integer.MAX_VALUE;
    private final int MAX_VERTS = 20;
    private final Vertex[] vertexArray = new Vertex[MAX_VERTS];
    private final int[][] adjacentMatrix = new int[MAX_VERTS][MAX_VERTS];
    private int nVertices = 0;
    
    private final int[] costArray = new int[MAX_VERTS];
    private final int[] previousVertexArray = new int[MAX_VERTS];
    
     public Dijkstra() {
        for (int i=0; i<MAX_VERTS; i++) {
            for (int j=0; j<MAX_VERTS; j++) {
                adjacentMatrix[i][j] = INFINITY;
            }
        }
        
        for (int i=0; i < MAX_VERTS; i++) {
            costArray[i] = INFINITY;
        }
       
    }
     
    private void updatePathArrays(int current, boolean isStart) {
        for (int i=0; i < nVertices; i++) {
            if (adjacentMatrix[current][i] != INFINITY && !vertexArray[i].wasVisited()) {
                int currentCost = isStart ? 0 : costArray[current];
                int newCost = currentCost + adjacentMatrix[current][i];
                
                if (newCost < costArray[i]) {
                    costArray[i] = newCost;
                    previousVertexArray[i] = current;
                }
            }
        }   
    }
    
    private int findNextCheapestUnvisisted() {
        int cheapestIndex = -1;
        int cheapestCost = Integer.MAX_VALUE;
        
        for (int i=0; i<nVertices; i++) {
            if (!vertexArray[i].wasVisited() && costArray[i] < cheapestCost) {
                cheapestIndex = i;
                cheapestCost = costArray[i];
            }
        }
        
        return cheapestIndex;
    }
    
    private void runDijkstra(int start) {
        vertexArray[start].setVisited(true);
        updatePathArrays(start, true);
        previousVertexArray[start] = -1;
        
        while(true) {
            int current = findNextCheapestUnvisisted();
            if (current < 0) {
                break;
            }
            
            vertexArray[current].setVisited(true);
            updatePathArrays(current, false);            
        }
    }
    
    private void printShortestPath(int end) {
        String shortestPath = "" + vertexArray[end].label;
        int p = end;
        while (true) {
            p = previousVertexArray[p];
            if (p < 0) {
                break;
            }
            
            shortestPath = vertexArray[p].label + "->" + shortestPath;
        }
        
        System.out.println(shortestPath);
    }
    
    public void shortestPath(int start, int end) {
        runDijkstra(start);
        printShortestPath(end);
    }
    
    public int addVertex(char label) {
        Vertex v = new Vertex(label);
        int t = nVertices;
        vertexArray[nVertices++] = v;
        return t;
    }
    
    public void addEdge(int start, int end, int weight) {
        adjacentMatrix[start][end] = weight;
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
    
    public void displayPreviousVertexArray() {
        for (int i=0; i<nVertices; i++) {
            System.out.println(i + " <--> " + previousVertexArray[i]);
        }
    }
        
    public void displayCostArray() {
        for (int i=0; i<nVertices; i++) {
            System.out.print("    " + costArray[i]);
        }
        System.out.println();
    }
        
}
