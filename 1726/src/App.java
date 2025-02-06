import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {2,3,4,6};
        System.out.println(obj.tupleSameProduct(nums));
    }
}
class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> productCount = new HashMap<>(); // map to store product counts
        int result = 0; // initialize result
        for(int i=0; i<nums.length; i++) { // iterate over each element
            for(int j=i+1; j<nums.length; j++) { // iterate over each pair of elements
                int product = nums[i] * nums[j]; // calculate product of the pair
                result = result + 8 * productCount.getOrDefault(product, 0); // update result based on previous counts
                productCount.put(product, productCount.getOrDefault(product, 0) + 1); // update product count in the map
            }
        }
        return result; // return the final result
    }
}