/* Code adopted from Advanced Data Structures by Robert Lafore */

public class StackInt {
    //  Todo: Declare the array to store data for stack
    int[] data;
    
    //  Todo: Declare the variable to store the index of the top of stack
    int top;
    
    //  Todo: Implement the constructor   
    public StackInt(int maxSize) {
        data = new int[maxSize];
        top = -1;
    }

    //  Todo: store the passed character on top of the stack
    public void push(int j) {
        if (top == data.length - 1)
            throw new IndexOutOfBoundsException();
        
        data[++top] = j;
    }

    //  Todo: remove the character from top of stack and return
    public int pop() {
        if (top == -1)
            throw new IndexOutOfBoundsException();
        
        int temp = data[top];
        --top;
        return temp;
    }

    //  Todo: return the character at the top of the stack without removing
    public int peek() {
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
