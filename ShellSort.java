/* Code adopted from Advanced Data Structures by Robert Lafore */

public class ShellSort {

    static int[] ab = {90, 100, 20, 60, 80, 110, 120, 40, 10, 30, 50, 70};

    public static void main(String[] args) {
        printArray();
        shellSort();
        printArray();
    }

    //Todo: Implement the ShellSort()
    private static void shellSort() {
        int h = 1;
        while (h < ab.length) {
            h = 3 * h + 1;
        }
        
        while (h >= 1) {
            insertionSort(h);
            h = (h - 1) / 3;
        }
    }

    /*
    Modified insertionSort to suit with Shell sort
    */
    private static void insertionSort(int h) {
        int inner, outer;
        int temp;
        if (h >= ab.length)
            return;
        
        // h-sort the file
        for (int i=0; i<h; i++) {
            for (outer = h+i; outer < ab.length; outer+=h) {
                temp = ab[outer];
                inner = outer;
                // one subpass (eg 0, 4, 8)
                while (inner > h - 1 && ab[inner - h] >= temp) {
                    ab[inner] = ab[inner - h];
                    inner -= h;
                }
                ab[inner] = temp;
            }
        }
    }

    private static void printArray() {
        for (int i = 0; i < ab.length; i++) {
            System.out.print(ab[i] + " ");
        }
        System.out.println();
    }
}
