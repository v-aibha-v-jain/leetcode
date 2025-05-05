import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int result = solution.eraseOverlapIntervals(intervals);
        System.out.println(result);
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length; // get the number of intervals
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1])); // sort intervals by their end times
        int prev = 0; // index of the last non-overlapping interval
        int cnt = 1; // count of non-overlapping intervals, starting with the first one
        for (int i = 1; i < n; i++) { // iterate through the intervals
            if (intervals[i][0] >= intervals[prev][1]) { // check if the current interval does not overlap with the previous one
                prev = i; // update the last non-overlapping interval index
                cnt++; // increment the count of non-overlapping intervals
            }
        }
        return n - cnt; // return the number of intervals to remove to make the rest non-overlapping
    }
}