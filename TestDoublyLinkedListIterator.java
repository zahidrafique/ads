/* Code adopted from Advanced Data Structures by Robert Lafore */

public class TestDoublyLinkedListIterator {
    public static void main(String args[]) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertFirst(1, 10);
        dll.insertLast(2, 20);
        dll.insertLast(3, 30);
        dll.insertLast(4, 40);
        
        DoublyLinkedListIterator it = dll.getIterator();
        System.out.println("Printing using Iterator:");
        while(it.hasNext()) {
            Link l = it.next();
            l.displayLink();
        }
        System.out.println();
        
        it.previous();
        it.remove();
        System.out.println("Printing:");
        dll.displayForward();
    }
}
