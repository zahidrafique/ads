/* Code adopted from Advanced Data Structures by Robert Lafore */

public class HeapSortTest {
    public static void main (String[] args) {
        int[] array = {70, 20, 100, 55, 38, 99, 14, 45};
        
        displayArray(array);
        HeapSort heapSort = new HeapSort(array);
        displayArray(array);
    }
    
    public static void displayArray(int[] array) {
        for (int i=0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        
        System.out.println();
    }
}
