import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int days = 10;
        int[][] meetings = {{5, 7}, {1, 3}, {9, 10}};
        int result = solution.countDays(days, meetings);
        System.out.println(result);
    }
}
class Solution {
    public int countDays(int days, int[][] meetings) {
        // Sort meetings by their start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        for (int[] meet : meetings) {
            // If no overlap, add the meeting to the merged list
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < meet[0]) {
                merged.add(meet);
            } else {
                // Merge overlapping meetings by updating the end time
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], meet[1]);
            }
        }

        int daywmeeting = 0; // Initialize days with meetings
        for (int[] meet : merged) {
            // Calculate total days with meetings
            daywmeeting += meet[1] - meet[0] + 1;
        }

        // Subtract days with meetings from total days
        return days - daywmeeting;
    }
}