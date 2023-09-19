/* Code adopted from Advanced Data Structures by Robert Lafore */

public class QuickSort {

    static int[] ab = {90, 100, 20, 60, 80, 110, 120, 40, 10, 30, 50, 70};

    public static void main(String[] args) {
        printArray();
        quickSort(0, ab.length-1);        
        printArray();        
    }
    
    private static void quickSort(int left, int right) {

    }
    
    private static int partitionIt(int left, int right, int pivotValue) {
        int leftPtr = left;
        int rightPtr = right - 1;
        
        while (true) {
            while (ab[++leftPtr] < pivotValue) {};
            while (rightPtr >= 0 && ab[--rightPtr] > pivotValue){};
        
            if (rightPtr < leftPtr) {
                swap(leftPtr, right);
                break;
            }
            
            swap(leftPtr, rightPtr);
        }
        return -1;
    }

    private static void swap(int leftPtr, int rightPtr) {
        int temp = ab[leftPtr];
        ab[leftPtr] = ab[rightPtr];
        ab[rightPtr] = temp;
    }

    private static void printArray() {
        for (int i = 0; i < ab.length; i++) {
            System.out.print(ab[i] + " ");
        }
        System.out.println();
    }
}
