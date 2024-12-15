import java.util.Comparator;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] classes = {{1,2},{3,5},{2,2}};
        int extraStudents = 2;
        double result = solution.maxAverageRatio(classes, extraStudents);
        System.out.println(result);
    }
}
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
            // Compare the potential increase in pass ratio if an extra student is added
            return Double.compare(
                (o2[0] + 1) / ((double) o2[1] + 1) - (o2[0] / (double) o2[1]),
                (o1[0] + 1) / ((double) o1[1] + 1) - (o1[0] / (double) o1[1]));
            }
        });
        for (int[] aClass : classes) {
            q.add(aClass); // Add each class to the priority queue
        }
        for (int i = 0; i < extraStudents; i++) {
            int[] min = q.poll(); // Get the class with the smallest potential increase
            min[0]++; // Increment the number of passes
            min[1]++; // Increment the number of students
            q.add(min); // Add the updated class back to the queue
        }
        // Calculate the average pass ratio
        return q.stream().mapToDouble(ints -> ints[0] / (double) ints[1]).average().getAsDouble();
    }
}