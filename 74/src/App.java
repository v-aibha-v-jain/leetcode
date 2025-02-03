public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(obj.searchMatrix(matrix, target));
    }
}
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int s1 = 0;
        int e1 = matrix.length - 1;
        while (e1 > s1) {
            int m = s1 + (e1 - s1) / 2; // find the middle row
            if (matrix[m][matrix[m].length - 1] == target) { // check if the last element of the middle row is the target
                return true;
            } else if (matrix[m][matrix[m].length - 1] > target) { // if the last element of the middle row is greater than the target
                e1 = m; // search in the upper half
            } else {
                s1 = m + 1; // search in the lower half
            }
        }
        int s2 = 0;
        int e2 = matrix[e1].length - 1;
        while (e2 >= s2) {
            int m = s2 + (e2 - s2) / 2; // find the middle element in the row
            if (matrix[e1][m] > target) { // if the middle element is greater than the target
                e2 = m - 1; // search in the left half
            } else if (matrix[e1][m] < target) { // if the middle element is less than the target
                s2 = m + 1; // search in the right half
            } else {
                return true; // if the middle element is the target
            }
        }
        return false; // if the target is not found
    }
}