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
        
        //index = linearSearch(sortedArray, searchKey);
        //index = binarySearch(sortedArray, searchKey);
        index = binarySearch(sortedArray, searchKey, 0, sortedArray.length - 1);
        
        if (index < 0) {
            System.out.println("Search key " + searchKey + " not found!");
        } else {
            System.out.println("Search key " + searchKey + " found at index " + index);
        }
    }

    //  Todo: Implement linear search
    private int linearSearch(int[] sortedArray, int searchKey) {
        for(int i=0; i< sortedArray.length; i++) {
            if (searchKey == sortedArray[i]) {
                return i;
            }
        }
        
        return -1;
    }

    //  Todo: Implement binary search using iterative approach
    private int binarySearch(int[] sortedArray, int searchKey) {
        int lowerBound = 0;
        int upperBound = sortedArray.length - 1;
        int midPoint;
        
        while (upperBound >= lowerBound) {
            midPoint = (lowerBound + upperBound) / 2;
            
            if (searchKey == sortedArray[midPoint]) {   //Found it
                return midPoint;
            } else if (searchKey > sortedArray[midPoint]) { //searchKey is in upper half
                lowerBound = midPoint + 1;
            } else {    //searchKey is in lower half
                upperBound = midPoint - 1;
            }
        }
        
        return -1;
    }

    //  Todo: Implement binary search using recursion
    private int binarySearch(int[] sortedArray, int searchKey, int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {  //Base Case
            return -1;
        }
        
        int midPoint = (lowerBound + upperBound) / 2;
        
        int midPointValue = sortedArray[midPoint];
        if (searchKey == midPointValue) {
            return midPoint;
        } else if (searchKey > midPointValue) {
            return binarySearch(sortedArray, searchKey, midPoint + 1, upperBound); //Recursive call for upper half
        } else {
            return binarySearch(sortedArray, searchKey, lowerBound, midPoint - 1); //Recursive call for lower half
        }  
    }
}
