import java.util.PriorityQueue;

public class App {

    public long maxKelements(int[] nums, int k) {
        // Create a max-heap (priority queue) to store the elements in descending order
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        // Add all elements from the array to the priority queue
        for (int x : nums)
            pq.offer(x);
        
        long score = 0; // Initialize the score to 0
        
        // Loop until the priority queue is empty or k elements have been selected
        while (!pq.isEmpty() && k > 0) {
            // Add the largest element to the score
            score += pq.peek();
            
            // Remove the largest element and add one-third of it back to the queue
            int x = (int) Math.ceil(pq.poll() / 3.0);
            pq.add(x);
            
            // Decrement the count of elements to be selected
            k--;
        }
        
        // Return the calculated score
        return score;
    }

    public static void main(String[] args) throws Exception {
        // Create an instance of the App class
        App app = new App();
        
        // Define an array of integers
        int[] nums = {1, 2, 3, 4, 5};
        
        // Define the number of elements to select
        int k = 3;
        
        // Print the result of the maxKelements method
        System.out.println(app.maxKelements(nums, k));
    }
}


// day 4 problems were very easy
// both 122 and 2530