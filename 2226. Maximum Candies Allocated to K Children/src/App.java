public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
class Solution {
    public int maximumCandies(int[] candies, long k) {
        int maxPossible = 0;
        for(int candy : candies)
            maxPossible = maxPossible > candy ? maxPossible : candy; // find the maximum number of candies in any heap
        int start = 0;
        int end = maxPossible;
        int res = 0;
        while(start <= end){
            int mid = start + (end - start) / 2; // calculate the middle point
            int candiesGiven = mid;
            long kidsGiven = 0;
            for(int candiesInHeap : candies){
                if(candiesGiven == 0){
                    kidsGiven = k; // if no candies can be given, set kidsGiven to k to break the loop
                    break;
                }
                kidsGiven = kidsGiven + (candiesInHeap / candiesGiven); // calculate how many kids can be given candies
            }
            if(kidsGiven >= k) {
                res = candiesGiven; // update result if current mid can satisfy the condition
                start = mid + 1; // try for a larger number of candies
            }
            else end = mid - 1; // try for a smaller number of candies
        }   
        return res; // return the maximum number of candies that can be given to each child

    }
}