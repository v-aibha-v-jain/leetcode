import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        List<Integer> robot = Arrays.asList(2, 4, 5);
        int[][] factory = {{4, 3}, {2, 2}, {8, 3}};
        long ans = solution.minimumTotalDistance(robot, factory);
        System.out.println(ans);
    }
}
class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0])); // sort by factory position
        int n = robot.size(); // number of robots
        int m = factory.length; // number of factories
        long[][] dp = new long[m + 1][n + 1]; // dp[i][j] is the minimum distance sum when using the first i factories to serve the first j robots
        for (long[] row : dp) Arrays.fill(row, Long.MAX_VALUE);
            dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            int factoryPos = factory[i - 1][0]; // position of the current factory
            int limit = factory[i - 1][1]; // limit of robots that the current factory can serve
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j]; // not using the current factory
                long distanceSum = 0;
                for (int k = 1; k <= limit && j - k >= 0; k++) {
                    distanceSum += Math.abs(robot.get(j - k) - factoryPos); // distance sum of serving the first j robots using the first i factories
                    if (dp[i - 1][j - k] != Long.MAX_VALUE) { // if the previous state is reachable then update the current state
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k] + distanceSum);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
