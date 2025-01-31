import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] grid = {{1, 0}, {0, 1}};
        System.out.println(solution.largestIsland(grid));
    }
}
class Solution {
    private int[] dir = {-1, 0, 1, 0, -1}; // direction vectors for traversing up, right, down, left

    private boolean isValid(int n, int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n); // check if coordinates are within grid bounds
    }

    private int markIsland(int[][] grid, int islandNumber, int n, int x, int y) {
        grid[x][y] = islandNumber; // mark the current cell with the island number
        int count = 1; // initialize island size count
        for (int i = 0; i < 4; ++i) { // traverse all 4 possible directions
            int newX = x + dir[i];
            int newY = y + dir[i + 1];
            if (isValid(n, newX, newY) && grid[newX][newY] == 1) { // if the new cell is valid and part of the island
                count += markIsland(grid, islandNumber, n, newX, newY); // recursively mark the island and count its size
            }
        }
        return count; // return the size of the island
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length; // size of the grid
        Map<Integer, Integer> islandSize = new HashMap<>(); // map to store island sizes
        int islandNumber = 2; // start island numbering from 2 to differentiate from water (0) and land (1)
        for (int x = 0; x < n; ++x) {
            for (int y = 0; y < n; ++y) {
                if (grid[x][y] == 1) { // if the cell is part of an island
                    int island = markIsland(grid, islandNumber, n, x, y); // mark the island and get its size
                    islandSize.put(islandNumber, island); // store the island size in the map
                    islandNumber++; // increment the island number for the next island
                }
            }
        }
        int maxSize = 0; // initialize the maximum island size
        for (int x = 0; x < n; ++x) {
            for (int y = 0; y < n; ++y) {
                if (grid[x][y] == 0) { // if the cell is water
                    Set<Integer> islands = new HashSet<>(); // set to store unique neighboring islands
                    for (int i = 0; i < 4; ++i) { // traverse all 4 possible directions
                        int newX = x + dir[i];
                        int newY = y + dir[i + 1];
                        if (isValid(n, newX, newY)) { // if the new cell is valid
                            islands.add(grid[newX][newY]); // add the island number to the set
                        }
                    }
                    int currIsland = 1; // initialize the current island size (1 for the water cell itself)
                    for (int key : islands) { // iterate over all unique neighboring islands
                        currIsland += islandSize.getOrDefault(key, 0); // add the size of each neighboring island
                    }
                    maxSize = Math.max(maxSize, currIsland); // update the maximum island size
                }
            }
        }
        return maxSize == 0 ? n * n : maxSize; // if no water cell was found, return the size of the entire grid, otherwise return the maximum island size
    }
}