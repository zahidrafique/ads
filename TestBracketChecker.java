/* Code adopted from Advanced Data Structures by Robert Lafore */

import java.io.*;
import java.util.Scanner;

public class TestBracketChecker {
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);

        String input;
        while (true) {
            System.out.println("Enter string containing brackets: ");

            input = scnr.nextLine();     // read a string from input stream
            if (input.equals("")) // quit if empty string
            {
                break;
            }

            // create a BracketChecker object
            BracketChecker theChecker = new BracketChecker(input);
            theChecker.check();      // check brackets
        }  // end while
    }
}
