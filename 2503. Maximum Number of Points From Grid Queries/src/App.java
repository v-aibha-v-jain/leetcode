import java.util.Arrays;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int[][] grid = {
            {1, 2, 3},
            {2, 5, 7},
            {3, 5, 1}
        };
        int[] queries = {5, 6, 2};
        int[] result = sol.maxPoints(grid, queries);
        System.out.println(Arrays.toString(result)); // Output: [3, 5, 7]
    }
}
class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        Integer idx[] = new Integer[queries.length];
        for(int i = 0; i < queries.length; i++) idx[i] = i; // store indices of queries
        Arrays.sort(idx, (a, b) -> Integer.compare(queries[a], queries[b])); // sort indices based on query values
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(grid[a[0]][a[1]], grid[b[0]][b[1]])); // min-heap based on grid values
        int ans[] = new int[queries.length]; // result array
        int m = grid.length; // number of rows
        int n = grid[0].length; // number of columns
        boolean visit[][] = new boolean[m][n]; // visited cells tracker
        pq.add(new int[]{0, 0}); // start from the top-left corner
        visit[0][0] = true; // mark the starting cell as visited
        int cnt = 0; // counter for valid cells
        int moves[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // possible moves (up, left, down, right)
        for(int i = 0; i < queries.length; i++) {
            // process cells while the top of the heap has a value less than the current query
            for(; !pq.isEmpty() && queries[idx[i]] > grid[pq.peek()[0]][pq.peek()[1]];) {
                var a = pq.poll(); // get the cell with the smallest value
                cnt++; // increment the count of valid cells
                for(var mov : moves) {
                    int x = a[0] + mov[0]; // calculate new row
                    int y = a[1] + mov[1]; // calculate new column
                    // check bounds and if the cell is already visited
                    if(x < 0 || x >= m || y < 0 || y >= n || visit[x][y]) continue;
                    visit[x][y] = true; // mark the cell as visited
                    pq.add(new int[]{x, y}); // add the cell to the heap
                }
            }
            ans[idx[i]] = cnt; // store the count for the current query
        }
        return ans; // return the result array
    }
}