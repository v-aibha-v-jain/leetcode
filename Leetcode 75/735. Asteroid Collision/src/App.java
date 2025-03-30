import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] asteroid = {5, 10, -5};
        int[] result = obj.asteroidCollision(asteroid);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of surviving asteroids
        for (int ass : asteroids) {
            if (ass > 0) {
                stack.push(ass); // Push positive asteroid to the stack
            } else {
                // Handle collision with positive asteroids in the stack
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -ass) stack.pop(); // Remove smaller positive asteroids
                if (stack.isEmpty() || stack.peek() < 0) stack.push(ass); // Push negative asteroid if no collision or all positive asteroids are destroyed
                if (stack.peek() == -ass) stack.pop(); // Remove both asteroids if they are equal in size
            }
        }

        int i = stack.size() - 1; // Index for the result array
        int[] res = new int[i+1]; // Create result array
        while(!stack.isEmpty()) {
            res[i--] = stack.pop(); // Populate result array with surviving asteroids
        }

        return res; // Return the final state of asteroids
    }
}