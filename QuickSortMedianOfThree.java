/* Code adopted from Advanced Data Structures by Robert Lafore */
package coc.cs282.quicksort_solution;

public class QuickSortMedianOfThree {
    static int copiesCount = 0;
    static int compareCount = 0;
    static int[] ab = {90, 100, 20, 60, 80, 110, 120, 40, 10, 30, 50, 70};

    public static void main(String[] args) {
        printArray();
        quickSort(0, ab.length-1);        
        printArray();        
    }
    
    private static void quickSort(int left, int right) {
        if (right-left + 1 <= 3)        //Base Case for Recursion
            manualSort(left, right);
        else {
            int pivotValue = medianOfThree(left, right);
            int part = partitionIt(left, right, pivotValue);
            
            quickSort(left, part - 1);
            quickSort(part + 1, right);
        }
    }
    
    private static void manualSort(int left, int right) {
        int size = right - left + 1;
        
        if (size == 1){
            compareCount++;
            return;
        } else if (size == 2) {
            if (ab[left] > ab[right])
                swap(left, right);
            
            compareCount += 3;
        } else {
            if (ab[left] > ab[right - 1])
                swap (left, right -1);
            if (ab[left] > ab[right])
                swap(left, right);
            if (ab[right-1] > ab[right])
                swap(right-1, right);
            
            compareCount += 5;
        }        
    }
    
    private static int medianOfThree(int left, int right) {
        int middle = (left + right) / 2;
        
        if (ab[left] > ab[middle])
            swap(left, middle);
        if (ab[left] > ab[right])
            swap(left, right);
        if (ab[middle] > ab[right])
            swap(middle, right);
        
        compareCount += 3;
        
        swap(middle, right);
        return ab[right];
    }
    
    private static int partitionIt(int left, int right, int pivotValue) {
        int leftPtr = left - 1;
        int rightPtr = right;
        
        while (true) {
            while (ab[++leftPtr] < pivotValue) { //No operation done in this while loop
                compareCount++;
            }
            while (ab[--rightPtr] > pivotValue) { //No operation
                compareCount++;
            }
            if (leftPtr >= rightPtr)
                break;
            else {
                swap(leftPtr, rightPtr);
            }
            compareCount++;
        }
        swap(leftPtr, right);
        
        return leftPtr;
    }

    private static void swap(int leftPtr, int rightPtr) {
        int temp = ab[leftPtr];
        ab[leftPtr] = ab[rightPtr];
        ab[rightPtr] = temp;
        
        copiesCount += 3;
    }

    private static void printArray() {
        for (int i = 0; i < ab.length; i++) {
            System.out.print(ab[i] + " ");
        }
        System.out.println();
        
        System.out.println("Copies Count: " + copiesCount + ", Comparisons Count: " + compareCount);
    }
}
