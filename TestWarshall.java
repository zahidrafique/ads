/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zahid
 */
public class TestWarshall {
    public static void main(String[] args) {
        DirectedGraph dg = new DirectedGraph();
        int a = dg.addVertex('A');
        int b = dg.addVertex('B');
        int c = dg.addVertex('C');
        int d = dg.addVertex('D');
        int e = dg.addVertex('E');
        
        dg.addEdge(a, c);
        dg.addEdge(b, a);
        dg.addEdge(b, e);
        dg.addEdge(e, c);
        dg.addEdge(d, e);
        
        System.out.println("Adjacent Matrix");
        dg.displayAdjacencyMatrix();
        System.out.println("Connectivity Matrix: ");
        dg.updateConnectivityMatrix();
        dg.displayConnectivityMatrix();
        
        System.out.print("Is B connected to C? ");
        System.out.println(dg.isConnected(b, c));
        System.out.print("Is A connected to D? ");
        System.out.println(dg.isConnected(a, d));
    }
}
