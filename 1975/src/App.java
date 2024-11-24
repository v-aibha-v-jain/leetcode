public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[][] matrix = {{1,2,3},{-1,-2,-3},{1,2,3}};
        long result = obj.maxMatrixSum(matrix);
        System.out.println(result);
    }
}
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length; // get the number of rows
        int m = matrix[0].length; // get the number of columns
        long ans = 0; // initialize the sum to 0
        int cnt = 0; // initialize the count of negative numbers to 0
        int min = Integer.MAX_VALUE; // initialize the minimum value to the maximum integer value
        for(int i = 0; i < n; i++) { // iterate over each row
            for(int j = 0; j < m; j++) { // iterate over each column
                int ele = Math.abs(matrix[i][j]); // get the absolute value of the current element
                ans += ele; // add the absolute value to the sum
                if(ele < min) // check if the current element is less than the minimum value
                    min = ele; // update the minimum value
                if(matrix[i][j] < 0) // check if the current element is negative
                    cnt += 1; // increment the count of negative numbers
            }
        }
        cnt = cnt % 2; // get the remainder when count is divided by 2
        if(cnt == 1) // check if the remainder is 1
            ans -= (2 * min); // subtract twice the minimum value from the sum
        return ans; // return the final sum
    }
}