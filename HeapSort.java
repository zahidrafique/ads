/* Code adopted from Advanced Data Structures by Robert Lafore */
public class HeapSort {       
    public HeapSort(int[] array) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.heapify(array);
        
        for(int n=array.length-1; n >= 0; n--) {
            int r = maxHeap.remove();
            array[n] = r;
        }
    }
}
