/* Code adopted from Advanced Data Structures by Robert Lafore */

public class HeapTest {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        
        maxHeap.insert(70);
        maxHeap.insert(40);
        maxHeap.insert(50);
        maxHeap.insert(20);
        maxHeap.insert(60);
        maxHeap.insert(100);
        maxHeap.insert(80);
        
        maxHeap.displayHeap();
        maxHeap.remove();
        maxHeap.displayHeap();
        maxHeap.insert(75);
        maxHeap.displayHeap();
    }
}



























