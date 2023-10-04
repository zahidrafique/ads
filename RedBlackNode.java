/* Code adopted from Advanced Data Structures by Robert Lafore */

public class RedBlackNode {
    int id;
    double data;
    RedBlackNode leftChild;
    RedBlackNode rightChild;
    
    boolean isRed;
    boolean isDeleted;
    
    public RedBlackNode(int id, double data) {
        this.id = id;
        this.data = data;
        this.isRed = true;
        this.isDeleted = false;
    }
    
    public void display() {
        String color = isRed ? "R" : "B";
        System.out.println("[" + id + ", " + data + ", " + color + "]");
    }
}
