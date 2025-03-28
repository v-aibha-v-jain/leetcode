import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int[][] grid = {
            {3, 2, 1},
            {1, 7, 6},
            {2, 7, 7}
        };
        int result = sol.equalPairs(grid); 
        System.out.println("Number of equal row and column pairs: " + result); // Output: 3
    }
}
class Solution {
    public int equalPairs(int[][] grid) { 
        int n = grid.length; // size of the grid
        int count = 0; // to store the count of equal row and column pairs
        HashMap<List<Integer>, Integer> map = new HashMap<>(); // map to store rows as keys and their frequency as values
        
        // Iterate through each row in the grid
        for(int[] row : grid){
            List<Integer> list = new ArrayList<>(); // convert row to a list
            for(int num : row){
                list.add(num); // add each element of the row to the list
            }
            map.put(list, map.getOrDefault(list, 0) + 1); // update the frequency of the row in the map
        }
        
        // Iterate through each column in the grid
        for(int col = 0; col < n; col++){
            List<Integer> list2 = new ArrayList<>(); // convert column to a list
            for(int k = 0; k < n; k++){
                list2.add(grid[k][col]); // add each element of the column to the list
            }
            count += map.getOrDefault(list2, 0); // add the frequency of the column (if exists in map) to the count
        }
        
        return count; // return the total count of equal row and column pairs
    }
}