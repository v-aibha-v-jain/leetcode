import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] board = {{1,2,3},{4,0,5}};
        System.out.println(solution.slidingPuzzle(board));
    }
}
class Solution {
    private final int[][] dir = { // directions for possible moves
            {1, 3},
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {3, 5, 1},
            {4, 2}
    };
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder(); // to store board state as string
        for (int i = 0; i < 2; i++) { // iterate over rows
            for (int j = 0; j < 3; j++) { // iterate over columns
                sb.append(board[i][j]); // append board value to string
            }
        }
        Map<String, Integer> visited = new HashMap<>(); // map to store visited states
        sol(sb.toString(), visited, sb.toString().indexOf("0"), 0); // start solving
        return visited.getOrDefault("123450", -1); // return result or -1 if not found
    }
    void sol(String state, Map<String, Integer> visited, int zeroidx, int moves) {
        if (visited.containsKey(state) && visited.get(state) <= moves) { // if state already visited with fewer moves
            return; // return early
        }
        visited.put(state, moves); // mark state as visited with current moves
        for (int p : dir[zeroidx]) { // iterate over possible moves
            String newState = swap(state, zeroidx, p); // swap to get new state
            sol(newState, visited, p, moves + 1); // recursively solve for new state
        }
    }
    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str); // create string builder from state
        sb.setCharAt(i, str.charAt(j)); // swap characters at positions i and j
        sb.setCharAt(j, str.charAt(i)); // swap characters at positions j and i
        return sb.toString(); // return new state as string
    }
}