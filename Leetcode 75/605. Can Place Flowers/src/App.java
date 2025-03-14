public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] flowerbed = {1,0,0,0,1};
        int n = 1;
        boolean result = solution.canPlaceFlowers(flowerbed, n);
        System.out.println(result);
    }
}
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true; // If no flowers need to be placed, return true
        int len = flowerbed.length; // Get the length of the flowerbed array
        for(int i = 0; i < len; i++){ // Iterate through the flowerbed array
            if(flowerbed[i] == 0){ // Check if the current spot is empty
                boolean leftZero = (i == 0) || (flowerbed[i - 1] == 0); // Check if the left spot is empty or it's the first spot
                boolean rightZero= (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0); // Check if the right spot is empty or it's the last spot
                if(leftZero && rightZero){ // If both left and right spots are empty
                    flowerbed[i] = 1; // Place a flower at the current spot
                    n--; // Decrease the number of flowers to place
                    if(n == 0) return true; // If all flowers are placed, return true
                    i++; // Skip the next spot to avoid adjacent flowers
                }
            }
        }
        return n == 0; // Return true if all flowers are placed, otherwise false
    }
}