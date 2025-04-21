import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] costs = {17,12,10,2,7,2,11,20,8};
        int k = 3;
        int candidates = 4;
        long result = solution.totalCost(costs, k, candidates);
        System.out.println("Total cost to hire " + k + " workers: " + result);
    }
}
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long cost = 0; // Initialize total cost to 0
        PriorityQueue<Integer> qLeft = new PriorityQueue<>(); // Min-heap for left candidates
        PriorityQueue<Integer> qRight = new PriorityQueue<>(); // Min-heap for right candidates
        int left = 0, right = costs.length - 1; // Pointers for left and right ends of the array

        for (int i = 0; i < k; i++) { // Iterate k times to hire k workers
            // Fill the left priority queue with up to 'candidates' elements
            while (qLeft.size() < candidates && left <= right) {
            qLeft.add(costs[left]); // Add cost from the left
            left++; // Move left pointer forward
            }
            // Fill the right priority queue with up to 'candidates' elements
            while (qRight.size() < candidates && left <= right) {
            qRight.add(costs[right]); // Add cost from the right
            right--; // Move right pointer backward
            }

            int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE; // Initialize min costs
            if (qLeft.size() > 0) first = qLeft.peek(); // Get the smallest cost from the left queue
            if (qRight.size() > 0) second = qRight.peek(); // Get the smallest cost from the right queue

            System.out.println(first); // Debug: print the smallest cost from the left queue
            System.out.println(second); // Debug: print the smallest cost from the right queue

            if (first <= second) { // If left cost is smaller or equal
            cost += first; // Add left cost to total cost
            qLeft.poll(); // Remove the smallest element from the left queue
            } else { // If right cost is smaller
            cost += second; // Add right cost to total cost
            qRight.poll(); // Remove the smallest element from the right queue
            }
        }
        return cost; // Return the total cost to hire k workers
    }
}