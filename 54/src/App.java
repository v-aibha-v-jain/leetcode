import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result = obj.spiralOrder(matrix);
        System.out.println(result);
    }
}
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int right = matrix[0].length; // number of columns
        int bottom = matrix.length; // number of rows
        List<Integer> result = new ArrayList<>(); // list to store the result
        int top = 0; // initialize top boundary
        int left = 0; // initialize left boundary
        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
            result.add(matrix[top][i]); // traverse from left to right
            }
            top++; // move top boundary down
            for (int i = top; i < bottom; i++) {
            result.add(matrix[i][right - 1]); // traverse from top to bottom
            }
            right--; // move right boundary left
            if (top < bottom) {
            for (int i = right - 1; i >= left; i--) {
                result.add(matrix[bottom - 1][i]); // traverse from right to left
            }
            bottom--; // move bottom boundary up
            }
            if (left < right) {
            for (int i = bottom - 1; i >= top; i--) {
                result.add(matrix[i][left]); // traverse from bottom to top
            }
            left++; // move left boundary right
            }
        }
        return result;
    }
}