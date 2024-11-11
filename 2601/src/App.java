public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution(); 
        int[] nums = {4,9,6,10};
        System.out.println(obj.primeSubOperation(nums));
    }
}
class Solution {
    public boolean primeSubOperation(int[] nums) {
        int i = nums.length - 2; // start from the second last element
        while(i >= 0){
            if(nums[i] < nums[i + 1]){
                i--; // move to the previous element
                continue;
            }
            int n = nums[i] - nums[i + 1] + 1; // calculate the difference needed
            while(n < nums[i] && !optimusPrime(n)) 
                n++; // find the next prime number
            if(n == nums[i])
                return false; // if no prime number found, return false
            nums[i] -= n; // subtract the prime number
            i--; // move to the previous element
        }
        return true;
    }
    private boolean optimusPrime(int n){
        if(n <= 1)
            return false; // numbers less than or equal to 1 are not prime
        for(int i = 2; i<= Math.sqrt(n); i++)
            if(n % i == 0)
                return false; // if divisible by any number other than 1 and itself, not prime
        return true; // return true if the number is prime
    }
}