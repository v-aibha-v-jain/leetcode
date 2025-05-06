import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(temperatures);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length; // Get the length of the temperatures array
        int[] answer = new int[n]; // Initialize the answer array with the same size as temperatures
        Stack<Integer> st = new Stack<>(); // Create a stack to store indices of temperatures

        for (int i = 0; i < n; i++) { // Iterate through each temperature
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) { 
                // While the stack is not empty and the current temperature is greater than the temperature at the index stored at the top of the stack
                int prevIndex = st.pop(); // Pop the index from the stack
                answer[prevIndex] = i - prevIndex; // Calculate the days until a warmer temperature
            }
            st.push(i); // Push the current index onto the stack
        }
        return answer; // Return the answer array
    }
}