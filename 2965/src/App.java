public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int grid[][] = {{1,3}, {2,2}};
        int ans[] = obj.findMissingAndRepeatedValues(grid);
        System.out.println("Repeated value: "+ans[0]);
    }
}
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int ans[] = new int[2]; // array to store the repeated and missing values
        int n = grid.length; // number of rows in the grid
        int m = grid[0].length; // number of columns in the grid
        int freq[] = new int[n*m+1]; // frequency array to count occurrences of each number
        for(int i=0;i<n;i++) // iterate through each row
            for(int j=0;j<m;j++) // iterate through each column
                freq[grid[i][j]]++; // increment the frequency of the current number
        for(int i=0;i<freq.length;i++){ // iterate through the frequency array
            if(freq[i]==2) ans[0] = i; // if a number appears twice, it is the repeated value
            else if(freq[i]==0) ans[1]=i; // if a number does not appear, it is the missing value
        }
        return ans; // return the array containing the repeated and missing values
    }
}