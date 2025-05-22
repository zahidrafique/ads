/**
 *
 * @author zrafique
 */
public class DijkstraTest {
   public static void main(String[] args) {
        Dijkstra graph = new Dijkstra();
        
        int a = graph.addVertex('A');
        int b = graph.addVertex('B');
        int c = graph.addVertex('C');
        int d = graph.addVertex('D');
        int e = graph.addVertex('E');
        
        graph.addEdge(a, b, 50);
        graph.addEdge(a, d, 80);
        
        graph.addEdge(b, c, 60);
        graph.addEdge(b, d, 90);
        
        graph.addEdge(c, e, 40);

        graph.addEdge(d, c, 20);        
        graph.addEdge(d, e, 70);
        
        graph.addEdge(e, b, 50);
        
                
        graph.shortestPath(b, b);
        graph.displayCostArray();
        graph.displayPreviousVertexArray();
        
        
    } 
}
