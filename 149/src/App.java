import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] points = {{1,1},{2,2},{3,3}};
        System.out.println(solution.maxPoints(points));
    }
}
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length; // number of points
        int ans = 1; // initialize the answer to 1
        for (int i = 0; i < n; ++i) { // iterate through each point
            int x1 = points[i][0], y1 = points[i][1]; // coordinates of the first point
            Map<String, Integer> cnt = new HashMap<>(); // map to store the count of slopes
            for (int j = i + 1; j < n; ++j) { // iterate through the remaining points
                int x2 = points[j][0], y2 = points[j][1]; // coordinates of the second point
                int dx = x2 - x1, dy = y2 - y1; // differences in x and y coordinates
                int g = gcd(dx, dy); // calculate the greatest common divisor of dx and dy
                String slope = (dx / g) + "." + (dy / g); // normalize the slope
                cnt.put(slope, cnt.getOrDefault(slope, 0) + 1); // update the count of this slope
                ans = Math.max(ans, cnt.get(slope) + 1); // update the answer if needed
            }
        }
        return ans; // return the maximum number of points on a line
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b); // calculate the greatest common divisor
    }
}