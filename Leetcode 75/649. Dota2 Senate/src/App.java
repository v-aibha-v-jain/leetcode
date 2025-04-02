import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String senate = "RD";
        String result = solution.predictPartyVictory(senate);
        System.out.println(result);
    }
}
class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>(); // Queue to store indices of Radiant senators
        Queue<Integer> d = new LinkedList<>(); // Queue to store indices of Dire senators
        
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') r.add(i); // Add Radiant senator index to the queue
            else d.add(i); // Add Dire senator index to the queue
        }
    
        int senateLength = senate.length(); // Store the length of the senate string
        
        while (!r.isEmpty() && !d.isEmpty()) { // Continue until one party is eliminated
            if (r.peek() < d.peek()) { // Radiant senator acts first
                d.poll(); // Remove the Dire senator
                r.add(r.poll() + senateLength); // Radiant senator gets a new turn
            } else { // Dire senator acts first
                r.poll(); // Remove the Radiant senator
                d.add(d.poll() + senateLength); // Dire senator gets a new turn
            }
        }
        
        return (r.isEmpty() && !d.isEmpty()) ? "Dire" : "Radiant"; // Return the winning party
    }
}