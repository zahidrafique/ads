/* Code adopted from Advanced Data Structures by Robert Lafore */

// Todo: Implement Link class with key (int) & data (floating point)
public class Link {
    //  Todo: Declare variables for key & data
    int key;
    double data;
    Link next;
    Link prev;
    
    //  Todo: Implement constructor
    public Link (int key, double data) {
        this.key = key;
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    
    //  Todo: Uncomment
    public void displayLink() {
        System.out.print("[key: " + key + ", data: " + data + "]");
    }
}
