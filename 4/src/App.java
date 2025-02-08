import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>(); // create a new ArrayList to store all elements
        for(int i=0; i<nums1.length; i++) { // iterate through the first array
            list.add(nums1[i]); // add each element of the first array to the list
        }
        for(int i=0; i<nums2.length; i++) { // iterate through the second array
            list.add(nums2[i]); // add each element of the second array to the list
        }
        Collections.sort(list); // sort the list in ascending order
        int n = list.size(); // get the size of the list
        if(n % 2 != 0) { // if the size of the list is odd
             return list.get(n / 2); // return the middle element
        } else { // if the size of the list is even
             return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0; // return the average of the two middle elements
        }
    }
}