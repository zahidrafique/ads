/* Code adopted from Advanced Data Structures by Robert Lafore */

public class WeightedGraphTest {       
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();
        int a = graph.addVertex('A');
        int b = graph.addVertex('B');
        int c = graph.addVertex('C');
        int d = graph.addVertex('D');
        int e = graph.addVertex('E');
        int f = graph.addVertex('F');
        
        graph.addEdge(a, b, 6);
        graph.addEdge(a, d, 4);
        
        graph.addEdge(b, c, 10);
        graph.addEdge(b, d, 7);
        graph.addEdge(b, e, 7);
        
        graph.addEdge(c, d, 8);
        graph.addEdge(c, e, 5);
        graph.addEdge(c, f, 6);
        
        graph.addEdge(d, e, 12);
        
        graph.addEdge(e, f, 7);
        
        
        
        graph.displayAdjacencyMatrix();
        
        //graph.dfs(0);
        graph.mstw();
    }
}
