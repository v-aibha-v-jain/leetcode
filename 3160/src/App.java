import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int limit = 4;
        int queries[][] = {{1, 4}, {2, 5}, {1, 3}, {3, 4}};
        int result[] = obj.queryResults(limit, queries);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length; // number of queries
        int result[] = new int[n]; // array to store results
        Map<Integer, Integer> ColorMap = new HashMap<>(); // map to store color counts
        Map<Integer, Integer> ballMap = new HashMap<>(); // map to store ball-color mapping
        for (int i = 0; i < n; i++) {
            int ball = queries[i][0]; // current ball
            int color = queries[i][1]; // current color
            if (ballMap.containsKey(ball)) { // if ball already has a color
                int prevColor = ballMap.get(ball); // get previous color of the ball
                ColorMap.put(prevColor, ColorMap.get(prevColor) - 1); // decrement count of previous color
                if (ColorMap.get(prevColor) == 0) { // if no balls of previous color left
                    ColorMap.remove(prevColor); // remove previous color from map
                }
            }
            ballMap.put(ball, color); // update ball with new color
            ColorMap.put(color, ColorMap.getOrDefault(color, 0) + 1); // increment count of new color
            result[i] = ColorMap.size(); // store the number of unique colors
        }
        return result; // return the result array
    }
}