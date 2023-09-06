/* Code adopted from Advanced Data Structures by Robert Lafore */

public class BracketChecker {

    private String input;                   // input string

    public BracketChecker(String in) {
        input = in;
    }

    /*
    *   Todo: Verify that for every opening bracket (paratheses, curly & square),
    *   there is a closing bracket
     */
    public void check() {
        StackX stackX = new StackX(input.length());

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            boolean bracketMatched = false;

            switch (c) {
                case '{':
                case '(':
                case '[':
                    stackX.push(c);
                    break;
                case '}':
                    bracketMatched = (!stackX.isEmpty()) && ('{' == stackX.peek());
                    if (!bracketMatched) {
                        printNotMatched(c, stackX);
                        return;
                    }
                    break;
                case ')':
                    bracketMatched = (!stackX.isEmpty()) && ('(' == stackX.peek());
                    if (!bracketMatched) {
                        printNotMatched(c, stackX);
                        return;
                    }                    
                    break;
                case ']':
                    bracketMatched = (!stackX.isEmpty()) && ('[' == stackX.peek());
                    if (!bracketMatched) {
                        printNotMatched(c, stackX);
                        return;
                    }
            }
            
            if (bracketMatched) {
                stackX.pop();
            }
        }

        if (!stackX.isEmpty()) {
            System.out.println("Error: Extra opening bracket: " + stackX.peek());
        }
    }  // end check()

    private void printNotMatched(char c, StackX stackX) {
        if (stackX.isEmpty()) {
            System.out.println("Error: Extra closing bracket: " + c);
        } else {
            System.out.println("Error: Brackets do not match: "
                + c + " , " + stackX.peek());
        }

    }
}
