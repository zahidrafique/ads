/* Code adopted from Advanced Data Structures by Robert Lafore */
import java.util.Scanner;
import java.util.Arrays;

/*
*   This program implements linear & binary array search
*/
public class BinarySearch {

    public static void main(String[] args) {
        int searchKey;
        int[] sortedArray = {1, 23, 34, 45, 51, 56, 67, 78, 87, 92};

        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a search key: ");
        searchKey = scnr.nextInt();
        
        /*
        *   Todo: Error handling - searchKey is limited by array indices
        */
        
        
        new BinarySearch().search(sortedArray, searchKey);
    }

    private void search(int[] sortedArray, int searchKey) {
        int index = 0;

        /*
        *   Todo: Call various array search implementations 
        */

        
        if (index < 0) {
            System.out.println("Search key " + searchKey + " not found!");
        } else {
            System.out.println("Search key " + searchKey + " found at index " + index);
        }
    }

    //  Todo: Implement linear search
    private int linearSearch(int[] sortedArray, int searchKey) {

        return -1;
    }

    //  Todo: Implement binary search using iterative approach
    private int binarySearch(int[] sortedArray, int searchKey) {

        return -1;
    }

    //  Todo: Implement binary search using recursion
    private int binarySearch(int[] sortedArray, int searchKey, int lowerBound, int upperBound) {
        return -1;
    }
}
