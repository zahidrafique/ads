/* Code adopted from Advanced Data Structures by Robert Lafore */

public class StackX {
    //  Todo: Declare the array to store data for stack
    char[] data;
    
    //  Todo: Declare the variable to store the index of the top of stack
    int top;
    
    //  Todo: Implement the constructor 
    public StackX(int maxSize) {
        data = new char[maxSize];
        top = -1;
    }

    //  Todo: store the passed character on top of the stack
    public void push(char j) {
        if (top == data.length - 1)
            throw new IndexOutOfBoundsException();
        
        data[++top] = j;
    }

    //  Todo: remove the character from top of stack and return
    public char pop() {
        if (top == -1)
            throw new IndexOutOfBoundsException();
        
        char temp = data[top];
        --top;
        
        return temp;
    }

    //  Todo: return the character at the top of the stack without removing
    public char peek() {
        if (top == -1)
            throw new IndexOutOfBoundsException();
        
        return data[top];
    }

    //  Todo: Stack is empty if there is no valid data in array
    public boolean isEmpty() {
        return top == -1;
    }
    
    //  Todo: Stack is full when all elements of array have a valid value
    public boolean isFull() {
        return top == data.length - 1;
    }
}
