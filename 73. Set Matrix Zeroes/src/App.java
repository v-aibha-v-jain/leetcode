import java.util.ArrayDeque;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        sol.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayDeque<int[]> cods = new ArrayDeque<>(); // store positions of zeros
        int n = matrix.length; // number of rows
        int m = matrix[0].length; // number of columns
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (matrix[i][j] == 0)
                    cods.add(new int[]{i, j}); // add zero position to queue
        while (!cods.isEmpty()) {
            int[] pos = cods.pop(); // get next zero position
            for (int i = 0; i < n; i++)
                matrix[i][pos[1]] = 0; // set entire column to zero
            for (int i = 0; i < m; i++)
                matrix[pos[0]][i] = 0; // set entire row to zero
        }
    }
}