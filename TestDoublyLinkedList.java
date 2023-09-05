/* Code adopted from Advanced Data Structures by Robert Lafore */

public class TestDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        
        dll.insertFirst(1, 22);
        dll.insertFirst(2, 44);
        dll.insertFirst(3, 66);
        
        dll.insertLast(4, 11);
        dll.insertLast(5, 33);
        dll.insertLast(6, 55);
        
        System.out.println("Display Forward:");
        dll.displayForward();
        System.out.println("Display Backward:");
        dll.displayBackward();
        
        dll.deleteFirst();
        dll.deleteLast();
        dll.delete(1);
        
        System.out.println("Display after Delete:");        
        dll.displayForward();
        
        dll.insertAfter(2, 7, 88);
        dll.insertAfter(5, 8, 99);
        
        System.out.println("Display after insertAfter:");
        dll.displayForward();
    }
}
