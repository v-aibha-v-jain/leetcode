public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int m = 4, n = 6;
        int[][] guards = new int[][]{{0, 0}, {1, 1}, {2, 3}};
        int[][] walls = new int[][]{{0 , 1}, {2, 2}, {1, 4}};
        System.out.println(obj.countUnguarded(m, n, guards, walls));
    }
}
class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] arr = new int[m][n];
        for (int[] guard : guards) {
            int y = guard[0], x = guard[1];
            arr[y][x] = 1; // mark guard positions
        }
        for (int[] wall : walls) {
            int y = wall[0], x = wall[1];
            arr[y][x] = 2; // mark wall positions
        }
        final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // directions for movement
        int cnt = 0; // count of guarded cells
        for (int[] guard : guards) {
            for (int[] dir : dirs) {
                int y = guard[0], x = guard[1];
                while (true) {
                    y += dir[0];
                    x += dir[1];
                    if (y < 0 || x < 0 || y == m || x == n || arr[y][x] > 0) // boundary or obstacle check
                        break;
                    if (arr[y][x] == 0) 
                        cnt++; // increment count for unguarded cells
                    arr[y][x]--; // mark cell as guarded
                }
            }
        }
        return m * n - guards.length - walls.length - cnt; // calculate unguarded cells
    }
}