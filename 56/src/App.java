import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] mergedIntervals = solution.merge(intervals);
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // sort intervals by start time
        List<int[]> merged = new ArrayList<>(); // list to store merged intervals
        int[] prev = intervals[0]; // initialize previous interval
        for (int i = 1; i < intervals.length; i++) { // iterate through intervals
            int[] interval = intervals[i]; // current interval
            if (interval[0] <= prev[1]) { // check if intervals overlap
                prev[1] = Math.max(prev[1], interval[1]); // merge intervals
            } else {
                merged.add(prev); // add previous interval to merged list
                prev = interval; // update previous interval
            }
        }
        merged.add(prev); // add last interval to merged list
        return merged.toArray(new int[merged.size()][]); // convert list to array and return
    }
}