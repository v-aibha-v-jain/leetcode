import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
}

class RecentCounter {
    Queue<Integer> q; // Queue to store the timestamps of pings

    public RecentCounter() {
        q = new LinkedList(); // Initialize the queue
    }
    
    public int ping(int t) {
        q.add(t); // Add the current ping timestamp to the queue
        while (q.peek() < t - 3000) // Remove timestamps older than 3000ms
            q.poll(); // Remove the oldest timestamp from the queue
        return q.size(); // Return the count of timestamps within the last 3000ms
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */