/* Code adopted from Advanced Data Structures by Robert Lafore */

public class QuickSort {

    static int[] ab = {90, 100, 20, 60, 80, 110, 120, 40, 10, 30, 50, 70};

    public static void main(String[] args) {
        printArray();
        quickSort(0, ab.length-1);
        //partitionIt(0, ab.length-1, ab[ab.length-1]);
        printArray();        
    }
    
    private static void quickSort(int left, int right) {
        //base case for recursion
        //if (right - left <= 0) { //For right value as pivot
        if (right - left < 3) {    //For median of three as pviot
            manualSort(left, left+1, right);
        }  else {
            //int pivotValue = ab[right];   ////For right value as pivot
            int pivotValue = getMedianOfThree(left, right);
            
            int partitionIndex = partitionIt(left, right, pivotValue);
            quickSort(left, partitionIndex - 1);
            quickSort(partitionIndex + 1, right);
        }
    }
    
    private static int getMedianOfThree(int left, int right) {
        int middle = (left + right) / 2;
        manualSort(left, middle, right);
        
        swap(middle, right);
        return ab[right];
    }
    
    private static void manualSort(int left, int middle, int right) {
        if (ab[left] > ab[middle]) {
            swap(left, middle);
        }
        
        if (ab[left] > ab[right]) {
            swap(left, right);
        }
        
        if (ab[middle] > ab[right]) {
            swap(middle, right);
        }
    }
    
    private static int partitionIt(int left, int right, int pivotValue) {
        int leftPtr = left - 1;
        int rightPtr = right;
        
        while (true) {
            while (ab[++leftPtr] < pivotValue) {};
            while (rightPtr > 0 && ab[--rightPtr] > pivotValue){};
        
            if (rightPtr < leftPtr) {
                swap(leftPtr, right);
                break;
            }
            
            swap(leftPtr, rightPtr);
        }
        
        return leftPtr;
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
