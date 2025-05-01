import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] tasks = {3,2,1};
        int[] workers = {0,3,3};
        int pills = 1;
        int strength = 1;
        int result = solution.maxTaskAssign(tasks, workers, pills, strength);
        System.out.println(result);
    }
}
class Solution {
    private int[] tasks; // Array of task difficulties
    private int[] workers; // Array of worker strengths
    private int strength; // Additional strength provided by a pill
    private int pills; // Number of pills available
    private int m; // Number of workers
    private int n; // Number of tasks

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks); // Sort tasks in ascending order
        Arrays.sort(workers); // Sort workers in ascending order
        this.tasks = tasks;
        this.workers = workers;
        this.strength = strength;
        this.pills = pills;
        n = tasks.length; // Total number of tasks
        m = workers.length; // Total number of workers
        int left = 0, right = Math.min(m, n); // Binary search range
        while (left < right) {
            int mid = (left + right + 1) >> 1; // Calculate mid-point
            if (check(mid)) { // Check if 'mid' tasks can be assigned
                left = mid; // Move to the right half
            } else {
                right = mid - 1; // Move to the left half
            }
        }
        return left; // Return the maximum number of tasks that can be assigned
    }

    private boolean check(int x) {
        int i = 0; // Pointer for tasks
        Deque<Integer> q = new ArrayDeque<>(); // Deque to store tasks that can be assigned
        int p = pills; // Remaining pills
        for (int j = m - x; j < m; j++) { // Iterate over the last 'x' workers
            while (i < x && tasks[i] <= workers[j] + strength) q.offer(tasks[i++]); // Add tasks that can be assigned with or without a pill
            if (q.isEmpty()) return false; // If no tasks can be assigned, return false
            if (q.peekFirst() <= workers[j]) { // If the task can be assigned without a pill
                q.pollFirst(); // Assign the task
            } else if (p == 0) { // If no pills are left
                return false; // Return false
            } else {
                --p; // Use a pill
                q.pollLast(); // Assign the task with a pill
            }
        }
        return true; // All tasks can be assigned
    }
}