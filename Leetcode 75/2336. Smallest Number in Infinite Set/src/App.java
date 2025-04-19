import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);
        System.out.println(smallestInfiniteSet.popSmallest()); // 1
        System.out.println(smallestInfiniteSet.popSmallest()); // 2
        System.out.println(smallestInfiniteSet.popSmallest()); // 3
        smallestInfiniteSet.addBack(1);
        System.out.println(smallestInfiniteSet.popSmallest()); // 1
        System.out.println(smallestInfiniteSet.popSmallest()); // 4
        System.out.println(smallestInfiniteSet.popSmallest()); // 5
    }
}
class SmallestInfiniteSet {

    private Integer minNum; // Tracks the smallest number not yet popped
    private PriorityQueue<Integer> heap; // Min-heap to store numbers added back

    public SmallestInfiniteSet() {
        minNum = 1; // Initialize the smallest number to 1
        heap = new PriorityQueue<>(); // Initialize the min-heap
    }
    
    public int popSmallest() {
        if (!heap.isEmpty()) return heap.poll(); // Return and remove the smallest number from the heap if not empty
        minNum++; // Increment minNum to move to the next smallest number
        return minNum - 1; // Return the previous smallest number
    }

    public void addBack(int num) {
        if (minNum > num && !heap.contains(num)) // Add the number back only if it's smaller than minNum and not already in the heap
            heap.offer(num); // Add the number to the heap
    }
}