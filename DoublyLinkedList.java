/* Code adopted from Advanced Data Structures by Robert Lafore */

public class DoublyLinkedList {
    //  Todo: Declare object references for first & last link
    Link first = null;
    Link last = null;
    
    //  Todo: Implement
    public boolean isEmpty() {
        return first == null;
    }
    
    //  Todo: Implement
    public void insertFirst(int key, long data) {
        Link n = new Link(key, data);
        
        if (isEmpty()) {
            last = n;
        } else {
            n.next = first;
            first.prev = n;
        }
        
        first = n;
    }
    
    //  Todo: Implement
    public void insertLast(int key, long data) {
        Link n = new Link(key, data);
        
        if (isEmpty()) {
            first = n;
        } else {
            n.prev = last;
            last.next = n;
        }
        
        last = n;
    }
    
    //  Todo: Implement
    public boolean insertAfter(int lookupKey, int key, long data) {       
        Link current = first;
        while(current != null) {
            if (lookupKey == current.key) {
                break;
            }
            current = current.next;
        }
        
        if (current == null) {  //either linked list is empty or not found
            return false;   //Todo: Throw an exception to indicate linkedlist is empty
        }
        
        Link n = new Link(key, data);
        n.prev = current;
        n.next = current.next;
        if (current.next != null) { //not the very last value
            current.next.prev = n; 
        } else {    //Vary last value
            last = n;   
        }
        
        current.next = n;
        
        return true;
    }
    
    //  Todo: Implement
    public Link deleteFirst() {
        if (isEmpty()) {
            return null;
        } 
        
        Link temp = first;
        if (first == last) {
            first = null;
            last = null;
        } else {
            first.next.prev = null;
            first = first.next;
        }
        
        return temp;
    }
    
    //  Todo: Implement
    public Link deleteLast() {
        if (isEmpty()) {
            return null;
        }
        
        Link temp = last;
        if (first == last) {
            first = null;
            last = null;
        } else {
            last.prev.next = null;
            last = last.prev;
        }
        
        return temp;
    }
    
    //  Todo: Implement
    public Link delete(int lookupKey) {
        Link current = first;
        while(current != null) {
            if (lookupKey == current.key) {
                break;
            }
            current = current.next;
        }
        
        if (current == null) {  //either linked list is empty or not found
            return null;   //Todo: Throw an exception to indicate linkedlist is empty
        }   
        
        if (current.prev == null) { //current is first link
            first = current.next;
        } else {
            current.prev.next = current.next;
        }
        
        if (current.next == null) { //current is last link
            last = current.prev;
        } else {
            current.next.prev = current.prev;
        }
        
        return current;
    }
    
    //  Todo: Implement
    public void displayForward() {
        Link current = first;
        
        while(current != null) {
            current.displayLink();
            System.out.print("->");
            current = current.next;
        }
        
        System.out.println();
    }
    
    //  Todo: Implement
    public void displayBackward() {
        Link current = last;
        
        while(current != null) {
            current.displayLink();
            System.out.print("->");
            current = current.prev;
        }
        
        System.out.println();        
    }
    
    //  Todo: Implement
    public DoublyLinkedListIterator getIterator() {
        return new DoublyLinkedListIterator(this);
    }
}
