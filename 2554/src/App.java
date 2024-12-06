import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj=new Solution();
        int[] banned={1,2,3,4,5,6,7};
        int n=8;
        int maxSum=6;
        System.out.println(obj.maxCount(banned, n, maxSum));
    }
}
class Solution {
    // Method to calculate the sum of elements in a HashSet
    public int sum(HashSet<Integer> set){
        int summ=0; // Initialize sum to 0
        for(int i:set) summ=summ+i; // Add each element to sum
        return summ; // Return the sum
    }
    
    // Method to find the maximum count of numbers not in banned array that sum up to maxSum
    public int maxCount(int[] banned, int n, int maxSum) {
        int count=0; // Initialize count to 0
        int cursum=0; // Initialize current sum to 0
        HashSet<Integer> set1=new HashSet<>(); // Create a HashSet to store banned numbers
        for(int i:banned){
            set1.add(i); // Add each banned number to the HashSet
        }
        for(int i=1;i<=n;i++){
            if(!set1.contains(i) && cursum+i<=maxSum){
                cursum+=i; // Add the number to current sum
                count++; // Increment the count
            }
        }
        return count; // Return the count
    }
}