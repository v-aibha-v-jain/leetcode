import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        MinStack minStack = new MinStack();

        // Perform operations
        minStack.push(5);
        minStack.push(2);
        minStack.push(8);
        minStack.push(1);

        System.out.println("Top element: " + minStack.top()); 
        System.out.println("Minimum element: " + minStack.getMin());

        minStack.pop();
        System.out.println("Top element after pop: " + minStack.top());
        System.out.println("Minimum element after pop: " + minStack.getMin()); 

        minStack.pop();
        System.out.println("Top element after another pop: " + minStack.top()); 
        System.out.println("Minimum element after another pop: " + minStack.getMin()); 
    }
}
class MinStack {
    Stack<Integer> org; // Stack to store all elements
    Stack<Integer> personal; // Stack to store minimum elements

    public MinStack() {
        org = new Stack<Integer>(); // Initialize org stack
        personal = new Stack<Integer>(); // Initialize personal stack
    }
    
    public void push(int val) {
        org.push(val); // Push value onto org stack
        if(personal.isEmpty() || val <= personal.peek()) // If personal stack is empty or val is less than or equal to top of personal stack
            personal.push(val); // Push value onto personal stack
    }
    
    public void pop() {
        int element = org.pop(); // Pop element from org stack
        if(personal.peek() == element) // If top of personal stack is equal to popped element
            personal.pop(); // Pop from personal stack
    }
    
    public int top() {
        return org.peek(); // Return top element of org stack
    }
    
    public int getMin() {
        return personal.peek(); // Return top element of personal stack (minimum element)
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */