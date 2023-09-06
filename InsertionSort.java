/* Code adopted from Advanced Data Structures by Robert Lafore */

/*
*   This program implements insertion sort
*/
public class InsertionSort {
    public static void main(String[] args) {
        int[] data = {51, 23, 78, 45, 1, 92, 67, 34, 87, 56};
        
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(data);
        insertionSort.print(data);
    }
    
    //Todo: Implement insertion sort
    void sort(int[] data) {
        for(int rightPtr=1; rightPtr < data.length; rightPtr++) {
            int temp = data[rightPtr];
            
            int leftPtr = rightPtr;
            while(leftPtr > 0 && data[leftPtr-1] >= temp) {
                data[leftPtr] = data[leftPtr-1];
                leftPtr--;
            }
            
            data[leftPtr] = temp;
        }
    }
    
    //Todo: Implement print
    void print(int[] data) {
        System.out.print("[");
        for(int i=0; i<data.length; i++) {
            if (i>0) {
                System.out.print(", ");
            }
            System.out.print(data[i]);
        }
        System.out.println("]");
    }
}
