import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int n = 5;
        int[][] rectangles = {{1,0,5,2}, {10,2,2,4}, {3,2,5,3}, {0,4,4,5}};
        boolean answer = solution.checkValidCuts(n, rectangles);
        System.out.println(answer);
    }
}
class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        // Check if valid cuts can be made along either dimension
        return boools(rectangles, 0) || boools(rectangles, 1);
    }

    private boolean boools(int[][] rectangles, int dim) {
        // Sort rectangles based on the starting position of the given dimension
        Arrays.sort(rectangles, (a, b) -> Integer.compare(a[dim], b[dim]));

        int gapCount = 0; // Count of gaps found
        int furthestEnd = rectangles[0][dim + 2]; // Track the furthest end of the current section

        for (int i = 1; i < rectangles.length; i++) {
            int[] rect = rectangles[i];
            // Check if there is a gap between the current rectangle and the previous section
            if (furthestEnd <= rect[dim]) gapCount++;
            // Update the furthest end to include the current rectangle
            furthestEnd = Math.max(furthestEnd, rect[dim + 2]);
        }

        // Return true if there are at least two gaps
        return gapCount >= 2;
    }
}