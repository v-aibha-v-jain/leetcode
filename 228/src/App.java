import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {0,1,2,4,5,7};
        List<String> result = obj.summaryRanges(nums);
        for(String s: result)
            System.out.println(s);
    }
}
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>(); // create a new list to store the ranges
        if(nums.length == 0) // if the array is empty
            return list; // return the empty list
        if(nums.length == 1){ // if the array has only one element
            list.add(nums[0]+""); // add the single element as a string to the list
            return list; // return the list
        }
        int x = nums[0], c = 0; // initialize x with the first element and c with 0
        for(int i = 1; i<nums.length; i++){ // iterate through the array starting from the second element
            if(nums[i] == nums[i-1]+1){ // if the current element is consecutive to the previous element
                c++; // increase the count
                continue; // continue to the next iteration
            }
            else{ // if the current element is not consecutive
                if(c>0) list.add(x+"->"+nums[i-1]); // if count is greater than 0, add the range to the list
                else list.add(x+""); // if count is 0, add the single element to the list
                c = 0; // reset the count
                x = nums[i]; // update x to the current element
            }
        }
        if(c>0) list.add(x+"->"+nums[nums.length-1]); // after the loop, if count is greater than 0, add the last range to the list
        else list.add(x+""); // if count is 0, add the last single element to the list
        return list; // return the list of ranges
    }
}