public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int n = 3;
        long result = solution.coloredCells(n);
        System.out.println(result);
    }
}
class Solution {
    public long coloredCells(int n) {
        long sum = 1; // Initialize sum with 1 for the first cell
        for (int i = 2; i <= n; i++) {
            sum += (i - 1) * 4; // Add the number of new cells added in the i-th layer
        }
        return sum; // Return the total number of colored cells
    }
}