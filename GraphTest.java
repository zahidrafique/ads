/* Code adopted from Advanced Data Structures by Robert Lafore */

public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph();
        int a = graph.addVertex('A');
        int b = graph.addVertex('B');
        int c = graph.addVertex('C');
        int d = graph.addVertex('D');
        int e = graph.addVertex('E');
        
        graph.addEdge(a, b);
        graph.addEdge(b, c);
        graph.addEdge(a, d);
        graph.addEdge(d, e);
        graph.addEdge(b, e);
        
        //graph.displayAdjacencyMatrix();
        
        //System.out.print("DFS Visits: ");
        //graph.dfs();
        graph.mst(0, 3);
    }
}
