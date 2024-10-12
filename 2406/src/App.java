import java.util.Arrays;

class App {

    public static void main(String[] args) {
        int[][] intervals = {{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}}; // Initialize an array of intervals
        App solution = new App();
        int groups = solution.minGroups(intervals); // Call the minGroups method to find the minimum number of groups
        System.out.println(groups); // Print the result
    }

    public int minGroups(int[][] intervals) {
        int n = intervals.length; // Get the number of intervals
        int[] lefts = new int[n]; // Create an array to store the left endpoints of the intervals
        int[] rights = new int[n]; // Create an array to store the right endpoints of the intervals
        int right_point = 0; // Initialize a pointer to track the current right endpoint
        int groups = 0; // Initialize a variable to count the number of groups

        for (int i = 0; i < n; i++) {
            lefts[i] = intervals[i][0]; // Store the left endpoint of the current interval
            rights[i] = intervals[i][1]; // Store the right endpoint of the current interval
        }

        Arrays.sort(lefts); // Sort the left endpoints in ascending order
        Arrays.sort(rights); // Sort the right endpoints in ascending order

        for (int left_point : lefts) { // Iterate through the sorted left endpoints
            if (left_point > rights[right_point]) { // If the current left endpoint is greater than the current right endpoint
                right_point++; // Move the right endpoint pointer to the next right endpoint
            } else { // If the current left endpoint is less than or equal to the current right endpoint
                groups++; // Increment the group count
            }
        }

        return groups; // Return the total number of groups
    }
}