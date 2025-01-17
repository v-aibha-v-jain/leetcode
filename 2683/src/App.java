public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] derived = {1, 1, 0};
        boolean result = solution.doesValidArrayExist(derived);
        System.out.println(result);
    }
}
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int pi = 0; // Initialize pi to 0
        for (int i = 0; i < derived.length; i++) { // Loop through each element in the derived array
            if (derived[i] == 1) { // Check if the current element is 1
            if (pi == 0) { // If pi is 0, set it to 1
                pi = 1;
            } else { // If pi is 1, set it to 0
                pi = 0;
            }
            }
        }
        if (pi == 0) { // If pi is 0 after the loop, return true
            return true;
        } else { // Otherwise, return false
            return false;
        }
    }
}