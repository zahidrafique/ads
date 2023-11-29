/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Zahid
 */
public class Edge {
    public int srcVertex;
    public int destVertex;
    public int weight;
    
    public Edge(int srcVertex, int destVertex, int distance) {
        this.srcVertex = srcVertex;
        this.destVertex = destVertex;
        this.weight = distance;
    }
}
