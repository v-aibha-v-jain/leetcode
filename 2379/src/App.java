public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String blocks = "BBBWW";
        int k = 3;
        int result = solution.minimumRecolors(blocks, k);
        System.out.println(result);
    }
}
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int cnt = 0; // Initialize the count of 'W' in the first window of size k
        for (int i = 0; i < k; i++) // Iterate over the first window of size k
            if (blocks.charAt(i) == 'W') // If the current block is 'W'
                cnt++; // Increment the count
        int min = cnt; // Initialize the minimum count with the count of the first window
        for (int i = k; i < blocks.length(); i++) { // Slide the window over the rest of the blocks
            if (blocks.charAt(i) == 'W') cnt++; // If the new block in the window is 'W', increment the count
            if (blocks.charAt(i - k) == 'W') cnt--; // If the block that is sliding out of the window is 'W', decrement the count
            min = Math.min(min, cnt); // Update the minimum count if the current window has fewer 'W's
        }
        return min; // Return the minimum number of recolors needed
    }
}