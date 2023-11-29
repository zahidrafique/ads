/* Code adopted from Advanced Data Structures by Robert Lafore */

public class TopologicalSortTest {
    public static void main(String[] args) {
        ToplogicalSort toplogicalSortGraph = new ToplogicalSort();
        int a = toplogicalSortGraph.addVertex('A');
        int b = toplogicalSortGraph.addVertex('B');
        int c = toplogicalSortGraph.addVertex('C');
        int d = toplogicalSortGraph.addVertex('D');
        int e = toplogicalSortGraph.addVertex('E');
        int f = toplogicalSortGraph.addVertex('F');
        int g = toplogicalSortGraph.addVertex('G');
        int h = toplogicalSortGraph.addVertex('H');
        
        toplogicalSortGraph.addEdge(a, d);
        toplogicalSortGraph.addEdge(a, e);
        toplogicalSortGraph.addEdge(b, e);
        toplogicalSortGraph.addEdge(d, g);
        toplogicalSortGraph.addEdge(e, g);
        toplogicalSortGraph.addEdge(g, h);
        toplogicalSortGraph.addEdge(c, f);
        toplogicalSortGraph.addEdge(f, h);
        
        
        //graph.displayAdjacencyMatrix();
        
        System.out.print("Toplogical Sort: ");
        toplogicalSortGraph.topo();
    }
}
