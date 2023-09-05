/* Code adopted from Advanced Data Structures by Robert Lafore */

public class DoublyLinkedListIterator {
    private Link previous, current, next;
    private DoublyLinkedList dll;
    
    //  Todo: initialized dll with passed linked list & next with first link
    public DoublyLinkedListIterator(DoublyLinkedList dll) {
        this.dll = dll;
        
    }
    
    //  Todo: return false if current is last link
    public boolean hasNext() {
        return false;
    }
    
    //  Todo: return next link and adjust references
    public Link next() {
        return null;
    }
    
    //  Todo: return false if current is last link
    public boolean hasPrevious() {
        return false;
    }
    
    //  Todo: return previous link and adjust references
    public Link previous() {
        return null;
    }
    
    //  Todo: remove the current link and adjust references
    public Link remove() {
        return null;        
    }
}
