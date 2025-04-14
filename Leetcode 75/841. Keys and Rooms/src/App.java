import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        List<List<Integer>> rooms = List.of(
            List.of(1),
            List.of(2),
            List.of(3),
            List.of()
        );
        System.out.println(solution.canVisitAllRooms(rooms));
    }
}
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Create a visited array to track visited rooms
        boolean[] vis = new boolean[rooms.size()];
        // Create a queue for BFS traversal
        Queue<Integer> q = new LinkedList<>();
        // Start BFS from room 0
        bfs(rooms, 0, vis, q);
        // Check if all rooms have been visited
        for (int i = 0; i < rooms.size(); i++)
            if (vis[i] != true) // If any room is not visited, return false
                return false;
        return true; // All rooms are visited
    }

    public static void bfs(List<List<Integer>> rooms, int i, boolean[] vis, Queue<Integer> q) {
        vis[i] = true; // Mark the current room as visited
        q.add(i); // Add the current room to the queue
        while (!q.isEmpty()) { // Continue until the queue is empty
            int cur = q.remove(); // Remove the front room from the queue
            for (int j : rooms.get(cur)) { // Iterate through all keys in the current room
                if (!vis[j]) { // If the room corresponding to the key is not visited
                    vis[j] = true; // Mark it as visited
                    q.add(j); // Add it to the queue
                }
            }
        }
    }
}