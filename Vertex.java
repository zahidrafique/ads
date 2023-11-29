/* Code adopted from Advanced Data Structures by Robert Lafore */

public class Vertex {
    public char label;
    private boolean visited;
    
    public Vertex(char label) {
        this.label = label;
    }
    
    public boolean wasVisited(){
        return visited;
    }
    
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
