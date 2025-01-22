import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] isWater = {{0,1},{0,0}};
        int[][] result = solution.highestPeak(isWater);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length; // number of rows
        int m = isWater[0].length; // number of columns
        int[][] height = new int[n][m]; // initialize height matrix
        for (int[] temp : height) {
            Arrays.fill(temp, -1); // fill height matrix with -1
        }
        Queue<int[]> q = new LinkedList<>(); // queue for BFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
            if (isWater[i][j] == 1) { // if cell is water
                height[i][j] = 0; // set height to 0
                q.add(new int[] { i, j }); // add cell to queue
            }
            }
        }
        while (q.size() > 0) {
            int[] temp = q.remove(); // remove cell from queue
            int row = temp[0]; // current row
            int col = temp[1]; // current column
            int[] r = { 0, 1, 0, -1 }; // row direction vectors
            int[] c = { 1, 0, -1, 0 }; // column direction vectors
            for (int i = 0; i < 4; i++) {
            int nRow = row + r[i]; // new row
            int nCol = col + c[i]; // new column
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && height[nRow][nCol] == -1){
                height[nRow][nCol] = height[row][col] + 1; // set new cell height
                q.add(new int[]{nRow, nCol}); // add new cell to queue
            }
            }
        }
        return height; // return height matrix
    }
}