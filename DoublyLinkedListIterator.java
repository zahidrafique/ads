/* Code adopted from Advanced Data Structures by Robert Lafore */

public class DoublyLinkedListIterator {
    private Link previous, current, next;
    private final DoublyLinkedList dll;
    
    //  Todo: initialized dll with passed linked list & next with first link
    public DoublyLinkedListIterator(DoublyLinkedList dll) {
        this.dll = dll;
        if (dll.isEmpty()) {
            next = null;
        } else {
            next = dll.first;
        }
    }
    
    //  Todo: return false if current is last link
    public boolean hasNext() {
        if (dll.isEmpty()){
            return false;
        }
        return next != null;
    }
    
    //  Todo: return next link and adjust references
    public Link next() {
        if (next == null) {
            return null;
        }
        previous = current;
        current = next;
        next = next.next;
        
        return current;
    }
    
    //  Todo: return false if current is last link
    public boolean hasPrevious() {
        if (dll.isEmpty()){
            return false;
        }
        return previous != null;
    }
    
    //  Todo: return previous link and adjust references
    public Link previous() {
        if (previous == null) {
            return null;
        }
        next = current;
        current = previous;
        previous = previous.prev;
        
        return current;
    }
    
    //  Todo: remove the current link and adjust references
    public Link remove() {
        if (current == null) {
            return null;
        }
             
        Link temp = current;
        dll.delete(current.key);
        
        if (current.prev == null && current.next == null) {
            current = null;
        }
        
        if (current.next == null) {
            current = previous;
        } else {
            current = next;
        }
        
        return temp;        
    }
}
