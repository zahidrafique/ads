/* Code adopted from Advanced Data Structures by Robert Lafore */

public class MaxHeap {
    private int[] heapArray;
    private int currentSize;
    
    public MaxHeap() {
    }
    
    public MaxHeap(int maxSize) {
        heapArray = new int[maxSize];
        currentSize = 0;
    }
    
    public boolean isEmpty() {
        return currentSize == 0;
    }
    
    public void heapify(int[] array) {
        heapArray = array;
        currentSize = array.length;

        int i = heapArray.length / 2 - 1;
        for (; i >= 0; i--) 
            trickleDown(i);
        
    }
    
    public boolean insert(int key) {
        if (currentSize == heapArray.length)
            return false;
        
        heapArray[currentSize] = key;
        trickleUp(currentSize++);        
        return true;
    }
    
    public void trickleUp(int index) {
        int parent = (index - 1) / 2;
        int bottom = heapArray[index];
        
        while (index > 0 && heapArray[parent] < bottom) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (index - 1) / 2;
        }
        
        heapArray[index] = bottom;
    }
    
    public int remove() {
        if (isEmpty())
            return -1;
        
        int root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }
    
    public void trickleDown(int index) {
        int largerChild;
        int top = heapArray[index];
        
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            
            if (rightChild < currentSize && heapArray[leftChild] < heapArray[rightChild])
                largerChild = rightChild;
            else
                largerChild = leftChild;
            
            if (top >= heapArray[largerChild])
                break;
            
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        
        heapArray[index] = top;
    }
    
    public void displayHeap() {
        for (int i=0; i < currentSize; i++) {
            System.out.print(heapArray[i] + " ");
        }
        
        System.out.println();
    }
}