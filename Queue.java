/* Code adopted from Advanced Data Structures by Robert Lafore */

public class Queue {
    //  Todo: Declare the array to store data for queue
    long[] data;
    //  Todo: Declare the variables to maintain the queue
    int front;
    int back;
    int numValidValues;
    
    //  Todo: Impelment the constructor
    public Queue(int maxSize) {
        data = new long[maxSize];
        front = 0;
        back = -1;
        numValidValues = 0;
    }

    //  Todo: put item at rear of queue
    public void insert(long j) {
        if (isFull()) {
            throw new IndexOutOfBoundsException();
        }
        
        if (back == data.length - 1) {
            back = -1;
        }
        
        data[++back] = j;
        numValidValues++;
    }

    //  Todo: take item from front of queue
    public long remove() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        
        long temp = data[front];
        front++;
        numValidValues--;
        
        if (!isEmpty() && front == data.length) {
            front = 0;
        }
        //  Todo: Throw an exception since 0 could be a valid value
        return temp;       
    }

    //  Todo: return item from front of queue without removing
    public long peekFront() {
        return data[front - 1];
    }

    //  Todo: Implement
    public boolean isEmpty() {
        return numValidValues == 0;
    }

    //  Todo: Implement
    public boolean isFull() {
        return numValidValues == data.length;
    }

    //  Todo: Implement
    public int size() {
        return numValidValues;
    }
}
